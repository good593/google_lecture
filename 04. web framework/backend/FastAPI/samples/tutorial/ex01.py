from fastapi import FastAPI
from enum import Enum

app = FastAPI()

######################################
# 타입이 있는 매개변수
@app.get("/items/{item_id}")
async def read_item(item_id: int):
    return {"item_id": item_id}

######################################
# 순서문제 
# 경로 동작은 순차적으로 평가되기 때문에 /users/{user_id} 이전에 /users/me를 먼저 선언해야 합니다
@app.get("/users/me")
async def read_user_me():
    return {"user_id": "the current user"}

@app.get("/users/{user_id}")
async def read_user(user_id: str):
    return {"user_id": user_id}

######################################
# 사전정의 값
# 만약 경로 매개변수를 받는 경로 동작이 있지만, 
# 유효하고 미리 정의할 수 있는 경로 매개변수 값을 원한다면 파이썬 표준 Enum을 사용할 수 있습니다.
class ModelName(str, Enum):
    alexnet = "alexnet"
    resnet = "resnet"
    lenet = "lenet"

@app.get("/models/{model_name}")
async def get_model(model_name: ModelName):
    if model_name is ModelName.alexnet:
        return {"model_name": model_name, "message": "Deep Learning FTW!"}

    if model_name.value == "lenet":
        return {"model_name": model_name, "message": "LeCNN all the images"}

    return {"model_name": model_name, "message": "Have some residuals"}