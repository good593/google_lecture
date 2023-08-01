# 학습목표 
1. [JWT(Json Web Token)](https://pyjwt.readthedocs.io/en/stable/) 
2. exception handler
3. creating tests
    ```shell
    # 테스트: python manage.py test <app name>.<file name>.<class name>.<function name>
    $ python manage.py test api.tests.AuthenticatorTestCase.test_login_return_jwt

    # 전체 테스트: python manage.py test <app name>.<file name>.<class name>
    $ python manage.py test api.tests.AuthenticatorTestCase
    ```

4. Generatiog Documentation     
    4-1. openapi-schema.yml 생성 
    ```shell
    # python manage.py generateschema --file <file name>.yml
    $ python manage.py generateschema --file openapi-schema.yml
    ```
    4-2. [SwaggerHub 적용](https://app.swaggerhub.com/home)
     - Create New 선택 
     - Import and Document API 선택  
     - Path or URL에 "openapi-schema.yml" 업로드 

# 참고문서 
## JWT
설치 모듈
- pip install djangorestframework
- pip install django-cors-headers
- pip install PyJWT
- pip install pyyaml uritemplate

### Youtube
- [Django API Authentication using JWT Tokens](https://www.youtube.com/watch?v=PUzgZrS_piQ&t=800s)
- [Django Login using Access & Refresh Tokens](https://www.youtube.com/watch?v=l6Pfu4L_y_k)
- [How to use JWT Authentication with Django Rest Framework](https://www.youtube.com/watch?v=BmOKr-cMhVA)
### Github: 
- [Django API Authentication using JWT Tokens](https://github.com/scalablescripts/django-auth)
- [Django Login using Access & Refresh Tokens](https://github.com/scalablescripts/django-auth-refresh)