import pandas as pd
from reportlab.lib.pagesizes import letter
from reportlab.lib import colors
from reportlab.lib.units import inch
from reportlab.platypus import SimpleDocTemplate, Table, TableStyle
from pathlib import Path
from datetime import datetime, timedelta

def read_excel(file_path):
    try:
        df = pd.read_excel(file_path)
        return df
    except Exception as e:
        print(f"Error reading Excel file: {e}")
        return None

def parse_week_header(week_header):
    try:
        date_str = week_header.split("Week of ")[1]
        return datetime.strptime(date_str, "%B %d, %Y")
    except Exception as e:
        print(f"Error parsing week header: {e}")
        return None

def filter_latest_weeks(df, weeks=4):
    latest_columns = ["Service Name", "Entity GUID", "Target"]
    week_columns = [col for col in df.columns if col.startswith("Week of")]

    # Parse week dates and sort them
    week_dates = [(col, parse_week_header(col)) for col in week_columns]
    week_dates = sorted(week_dates, key=lambda x: x[1], reverse=True)

    # Select the latest weeks
    for col, date in week_dates[:weeks]:
        if col in df.columns:
            latest_columns.append(col)

    return df[latest_columns]

def dataframe_to_pdf(df, pdf_file_path):
    try:
        doc = SimpleDocTemplate(str(pdf_file_path), pagesize=letter)
        elements = []

        data = [df.columns.tolist()] + df.values.tolist()
        page_width = letter[0] - 0.2 * inch
        column_widths = [0.15 * page_width] * len(df.columns)
        table = Table(data, colWidths=column_widths)

        style = TableStyle([
            ('BACKGROUND', (0,0), (-1,0), colors.grey),
            ('TEXTCOLOR', (0,0), (-1,0), colors.whitesmoke),
            ('FONTSIZE', (0,0), (-1,0), 8),
            ('FONTSIZE', (0,1), (-1,-1), 6),
            ('GRID', (0,0), (-1,-1), 1, colors.black)
        ])

        for i in range(1, len(data)):
            for j in range(3, len(data[i])):  # Start from the first week's compliance column
                value = data[i][j]  # Compliance value
                target = data[i][2]  # Target value
                if value == "No Data":
                    continue  # Skip cells with no data
                if value < target:
                    style.add('BACKGROUND', (j, i), (j, i), colors.yellow)
                else:
                    style.add('BACKGROUND', (j, i), (j, i), colors.green)

        table.setStyle(style)
        elements.append(table)
        doc.build(elements)
        print(f"PDF saved at {pdf_file_path}")
    except Exception as e:
        print(f"Error creating PDF: {e}")

def convert_excel_to_pdf(excel_file_path, pdf_file_path, weeks=4):
    df = read_excel(excel_file_path)
    if df is not None:
        latest_weeks_df = filter_latest_weeks(df, weeks)
        if not latest_weeks_df.empty:
            dataframe_to_pdf(latest_weeks_df, pdf_file_path)
        else:
            print("No data found for the latest weeks to convert to PDF.")
    else:
        print("No data found in Excel file.")

# Example usage
convert_excel_to_pdf(Path("/path/to/excel/file.xlsx"), Path("/path/to/output/file.pdf"), weeks=4)
