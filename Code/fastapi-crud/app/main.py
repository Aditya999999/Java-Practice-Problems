from fastapi import FastAPI, HTTPException
from typing import List

from app.database import database, metadata, engine
from app.schemas import Item
from app.crud import create_item, get_items, get_item, update_item, delete_item

app = FastAPI()

metadata.create_all(engine)

@app.on_event("startup")
async def startup():
    await database.connect()

@app.on_event("shutdown")
async def shutdown():
    await database.disconnect()

@app.post("/items/", response_model=Item)
async def create_item_api(item: Item):
    return await create_item(item)

@app.get("/items/", response_model=List[Item])
async def read_items_api():
    return await get_items()

@app.get("/items/{item_id}", response_model=Item)
async def read_item_api(item_id: int):
    item = await get_item(item_id)
    if item is None:
        raise HTTPException(status_code=404, detail="Item not found")
    return item

@app.put("/items/{item_id}", response_model=Item)
async def update_item_api(item_id: int, item: Item):
    updated_item = await update_item(item_id, item)
    if updated_item is None:
        raise HTTPException(status_code=404, detail="Item not found")
    return updated_item

@app.delete("/items/{item_id}", response_model=Item)
async def delete_item_api(item_id: int):
    deleted_item = await delete_item(item_id)
    if deleted_item is None:
        raise HTTPException(status_code=404, detail="Item not found")
    return deleted_item
