import requests
import pandas as pd
from pathlib import Path
import os
from dotenv import load_dotenv
from datetime import datetime

load_dotenv()

API_KEY = os.getenv("API_KEY")
ACCOUNT_ID = os.getenv("ACCOUNT_ID")

SERVICE_LEVELS_QUERY = """
{
    actor {
        nrql(
            accounts: ACCOUNT_ID,
            query: "FROM ServiceLevelSnapshot SELECT latest(entity.guid) FACET entity.name LIMIT MAX"
        ) {
            results
        }
    }
}
"""

SLO_COMPLIANCE_QUERY = """
{
    actor {
        nrql(
            accounts: ACCOUNT_ID,
            query: "FROM Metric SELECT clamp_max(sum(newrelic.sli.good) / sum(newrelic.sli.valid) * 100, 100) AS 'SLO compliance (%)' WHERE entity.guid = 'ENTITY_GUID' FACET weekOf(timestamp) SINCE 4 weeks ago"
        ) {
            results
        }
    }
}
"""

TARGET_QUERY = """
{
    actor {
        nrql(
            accounts: ACCOUNT_ID,
            query: "FROM ServiceLevelSnapshot SELECT latest(target) FACET entity.name"
        ) {
            results
        }
    }
}
"""

def fetch_service_levels(api_key, account_id):
    url = "https://api.newrelic.com/graphql"
    headers = {
        "API-Key": api_key,
        "Content-Type": "application/json",
    }
    payload = {
        "query": SERVICE_LEVELS_QUERY.replace("ACCOUNT_ID", str(account_id))
    }
    response = requests.post(url, headers=headers, json=payload)
    data = response.json()
    
    if response.status_code != 200:
        raise Exception(f"Query failed to run with status code {response.status_code}: {response.text}")
    
    service_levels = [
        {"name": result["entity.name"], "entityGuid": result["latest.entity.guid"]}
        for result in data["data"]["actor"]["nrql"]["results"]
    ]
    return service_levels

def fetch_slo_compliance(api_key, account_id, entity_guid):
    url = "https://api.newrelic.com/graphql"
    headers = {
        "API-Key": api_key,
        "Content-Type": "application/json",
    }
    query = SLO_COMPLIANCE_QUERY.replace("ACCOUNT_ID", str(account_id)).replace("ENTITY_GUID", entity_guid)
    payload = {"query": query}
    response = requests.post(url, headers=headers, json=payload)
    
    if response.status_code != 200:
        raise Exception(f"Query failed to run with status code {response.status_code}: {response.text}")
    
    data = response.json()
    results = data.get("data", {}).get("actor", {}).get("nrql", {}).get("results", [])
    
    if not results:
        print(f"No data found for the entity GUID: {entity_guid}")
    
    return results

def fetch_target_values(api_key, account_id):
    url = "https://api.newrelic.com/graphql"
    headers = {
        "API-Key": api_key,
        "Content-Type": "application/json",
    }
    payload = {
        "query": TARGET_QUERY.replace("ACCOUNT_ID", str(account_id))
    }
    response = requests.post(url, headers=headers, json=payload)
    data = response.json()
    
    if response.status_code != 200:
        raise Exception(f"Query failed to run with status code {response.status_code}: {response.text}")
    
    targets = {
        result["entity.name"]: result["latest.target"]
        for result in data["data"]["actor"]["nrql"]["results"]
    }
    return targets

def store_data(service_levels, targets, api_key, account_id, file_path, file_name):
    try:
        file_path.mkdir(parents=True, exist_ok=True)
        master_file = file_path / file_name
        
        if master_file.exists():
            existing_df = pd.read_excel(master_file)
        else:
            existing_df = pd.DataFrame(columns=["Service Name", "Entity GUID", "Target"])

        # Organize data by service name with each week in separate columns
        organized_data = {}
        for service in service_levels:
            service_name = service["name"]
            if service_name not in organized_data:
                organized_data[service_name] = {
                    "Service Name": service_name,
                    "Entity GUID": service["entityGuid"],
                    "Target": targets.get(service_name, "N/A")
                }

            slo_compliance = fetch_slo_compliance(api_key, account_id, service["entityGuid"])
            for compliance in slo_compliance:
                week_str = f"Week - [{compliance['weekOf.timestamp']}]"
                organized_data[service_name][week_str] = compliance["SLO compliance (%)"]

        df_new = pd.DataFrame.from_dict(organized_data, orient='index').reset_index(drop=True)

        # Merge new data with existing data
        if not existing_df.empty:
            df = pd.concat([existing_df, df_new]).drop_duplicates(subset=["Service Name", "Entity GUID"], keep="last").reset_index(drop=True)
        else:
            df = df_new

        df.to_excel(master_file, index=False)
        print(f"Data successfully written to {master_file}")
    except Exception as e:
        print(f"An error occurred while writing to the file: {e}")

def generate_service_levels_snapshot(api_key, account_id, file_path, file_name):
    service_levels = fetch_service_levels(api_key, account_id)
    targets = fetch_target_values(api_key, account_id)
    
    store_data(service_levels, targets, api_key, account_id, file_path, file_name)
