from sqlalchemy import select, insert, update, delete
from app.models import items
from app.schemas import Item
from app.database import database

async def create_item(item: Item):
    query = insert(items).values(
        name=item.name,
        description=item.description,
        price=item.price,
        tax=item.tax
    )
    last_record_id = await database.execute(query)
    return {**item.dict(), "id": last_record_id}

async def get_items():
    query = select(items)  # Updated line
    return await database.fetch_all(query)

async def get_item(item_id: int):
    query = select(items).where(items.c.id == item_id)
    return await database.fetch_one(query)

async def update_item(item_id: int, item: Item):
    query = (
        update(items)
        .where(items.c.id == item_id)
        .values(
            name=item.name,
            description=item.description,
            price=item.price,
            tax=item.tax
        )
    )
    await database.execute(query)
    return {**item.dict(), "id": item_id}

async def delete_item(item_id: int):
    query = delete(items).where(items.c.id == item_id)
    await database.execute(query)
    return {"id": item_id}
