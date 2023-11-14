from fastapi import FastAPI
import db 
from datetime import datetime
from pydantic import BaseModel

class Board(BaseModel):
    num: int | None = None
    title: str 
    writer: str
    content: str | None = None
    reg_date: datetime  | None = None
    cnt: int  | None = None

app = FastAPI()

@app.get("/board_table/{num}")
async def read_item(num: int):
    if num:
        sql = """
            select * from board_table where num >= %s;
        """
        
    else:
        sql = "select * from board_table"

    return db.select_datas(sql, num)

@app.post("/board_table/")
async def update_item(board: Board):
    params = [board.title, board.writer, board.content]

    sql = '''
        INSERT INTO board_table (title, writer, content) 
        VALUES (%s, %s, %s);
    '''

    return db.insert_data(sql, params)

@app.put("/board_table/{num}/{cnt}")
async def update_item(num: int, cnt: int):
    sql = '''
        UPDATE board_table
        SET cnt = %s
        WHERE num = %s;
    '''
    params = [cnt, num]

    return db.update_data(sql, params)


