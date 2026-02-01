from sqlalchemy import Table, Column, Integer, String, Float
from app.database import metadata

items = Table(
    "items",
    metadata,
    Column("id", Integer, primary_key=True, index=True),
    Column("name", String, index=True),
    Column("description", String, index=True),
    Column("price", Float),
    Column("tax", Float, nullable=True),
)
