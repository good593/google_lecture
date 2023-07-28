from rest_framework.authentication import get_authorization_header
from rest_framework.views import APIView 
from rest_framework.response import Response 
from rest_framework.exceptions import AuthenticationFailed , APIException

from django.contrib.auth.models import User 

from .serializers import UserSerializer
from .authentication import create_access_token, create_refresh_token, decode_access_token, decode_refresh_token


# Create your views here.
class Register(APIView):
    def post(self, request):
        serializer = UserSerializer(data=request.data)
        serializer.is_valid(raise_exception=True)
        serializer.save() 
        return Response(serializer.data)
    
class LoginView(APIView):
    def post(self, request):
        username = request.data['username']
        password = request.data['password']

        user = User.objects.filter(username=username).first()
        if user is None:
            raise APIException('User not found')
        elif not user.check_password(password):
            raise APIException('Incorrect password')
        
        access_token = create_access_token(user.id)
        refresh_token = create_refresh_token(user.id)
        
        response = Response()
        response.set_cookie(key='refreshToken', value=refresh_token, httponly=True)
        response.data = {
            'token': access_token
        }
        
        return response
    
class HelloWorldView(APIView):
    def get(self, request):
        auth = get_authorization_header(request).split()
        if auth and len(auth) == 2:
            token = auth[1].decode('utf-8')
            _ = decode_access_token(token)

            content = {
                "message": "Hello World"
            }
            return Response(content)
        
        raise AuthenticationFailed('unauthenticated')
            
    
class RefreshView(APIView):
    def post(self, request):
        refresh_token = request.COOKIES.get('refreshToken')
        id = decode_refresh_token(refresh_token)
        access_token = create_access_token(id)
        return Response({
            'token': access_token 
        })

class Logoutview(APIView):
    def post(self, _):
        response = Response()
        response.delete_cookie(key='refreshToken')
        response.data = {
            'message': 'success'
        }
        return response
