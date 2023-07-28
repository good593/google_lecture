# mysql 적용
- mysql 드라이버 설치
```shell
$ (.venv) pip install mysqlclient
```
- config/settings.py에 mysql 설정 추가 
```python
DATABASES = {
    "default": {
        "ENGINE": "django.db.backends.mysql",
        "NAME": "django_db", # 데이터베이스 이름 
        "USER": "django_root", # 유저 아이디
        "PASSWORD": "django_root1!", # 유저 비번
        "HOST": "localhost", # host 주소
        "PORT": "3306" # port 번호 
    }
}
```

# root 사용자 생성 
```shell
python manage.py createsuperuser
```




# 참고문서 
### 유튜브 동영상
- https://www.youtube.com/watch?v=EpqVtxTyTT8&list=PL8Loxdz4U5rqhjG3xAeE5SAmeeJJ5zQY0&index=2
### github
- https://github.com/deji12/todo_tutorial

