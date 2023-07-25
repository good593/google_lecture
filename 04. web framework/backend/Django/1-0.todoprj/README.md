# 가상환경 만들자
1. cd 프로젝트폴더
2. py -3.11 -m venv .venv 
3. .venv/Script/activate 
4. (.venv) python -m pip install --upgrade pip 
5. (.venv) pip install django
6. (.venv) pip install django-cors-headers
7. (.venv) pip install djangorestframework

# 장고 프로젝트 생성
1. (.venv) mkdir 프로젝트명 
2. (.venv) cd 프로젝트명 
3. (.venv) django-admin startproject config . 

# 장고 앱 생성 
1. (.venv) cd 프로젝트명 
2. (.venv) python manage.py startapp 앱명 
3. config/settings.py에 앱 설정 추가 
```python
INSTALLED_APPS = [
    "django.contrib.admin",
    "django.contrib.auth",
    "django.contrib.contenttypes",
    "django.contrib.sessions",
    "django.contrib.messages",
    "django.contrib.staticfiles",
    "todolist",
    "user"
]
```

# templates 설정
1. (.venv) cd 프로젝트명 
2. (.venv) mkdir templates 
3. (.venv) cd templates
4. (.venv) mkdir 앱명
5. config/settings.py에 templates path 설정 추가 
```python
TEMPLATES = [
    {
        "BACKEND": "django.template.backends.django.DjangoTemplates",
        "DIRS": ["templates"],
        "APP_DIRS": True,
        "OPTIONS": {
            "context_processors": [
                "django.template.context_processors.debug",
                "django.template.context_processors.request",
                "django.contrib.auth.context_processors.auth",
                "django.contrib.messages.context_processors.messages",
            ],
        },
    },
]
```

# static 설정
1. (.venv) cd 프로젝트명 
2. (.venv) mkdir static 
3. (.venv) cd static
4. (.venv) mkdir css
```html
{% load static %}
    <link rel="stylesheet" href="{% static 'css/index.css' %}">
```
5. (.venv) mkdir js
```html
{% load static %}
    <script type="text/javascript" src="{% static 'js/index.js' %}"></script>
```
6. config/settings.py에 static path 설정 추가 
```python
import os 

STATIC_PATH = os.path.join(
    BASE_DIR, "static"
)  # concatena a pasta static a variavel instanciada base_dir que aponta para a raiz do projeto

STATICFILES_DIRS = (STATIC_PATH,)
```

# models 적용 및 서버 기동 
```shell
$ python manage.py makemigrations 
$ python manage.py migrate
$ python manage.py runserver
```