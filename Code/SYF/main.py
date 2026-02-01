import os
from dotenv import load_dotenv
from pathlib import Path
from service_levels_weekly_snapshot import generate_service_levels_snapshot
from excel_to_pdf_conversion import convert_excel_to_pdf

load_dotenv()

API_KEY = os.getenv("API_KEY")
ACCOUNT_ID = os.getenv("ACCOUNT_ID")

FILE_NAME = f"{ACCOUNT_ID}_SLA-weekly-snapshot.xlsx"
FILE_PATH = Path(r"D:/Users/5435435/Desktop/SYF/PythonScripts/output/excels")
PDF_FILE_NAME = f"{ACCOUNT_ID}_SLA-weekly-snapshot.pdf"
PDF_FILE_PATH = Path(r"D:/Users/5435435/Desktop/SYF/PythonScripts/output/pdfs")

if __name__ == '__main__':
    generate_service_levels_snapshot(API_KEY, ACCOUNT_ID, FILE_PATH, FILE_NAME)
    convert_excel_to_pdf(FILE_PATH / FILE_NAME, PDF_FILE_PATH / PDF_FILE_NAME)
