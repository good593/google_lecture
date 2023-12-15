# fastapi: 파이썬 비동기 통신을 지원하는 라이브러리 
from fastapi import FastAPI
# Cross-Origin Resource Sharing (CORS)
from fastapi.middleware.cors import CORSMiddleware



app = FastAPI()

# 해당 host가 접근을 해도 허락해줌..
origins = [
    "http://localhost",
    "http://localhost:8080",
    "http://localhost:8000"
]

app.add_middleware(
    CORSMiddleware,
    allow_origins=origins,
    allow_credentials=True,
    allow_methods=["*"],
    allow_headers=["*"]
)

@app.get("/api/index")
def index():
    return {
        "msg":"Python에서 왔어요~"
    }

@app.get("/api/number")
def number(num:int):
    params = {
        "num":num
    }
    params["msg"] = "Python에서 왔어요~"
    return params
