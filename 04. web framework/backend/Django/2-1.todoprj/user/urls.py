from django.urls import path 
from .views import UserLogin, UserRegister
from django.contrib.auth.views import LogoutView

urlpatterns = [ 
    path('register/', UserRegister.as_view(), name='register'),
    path('login/', UserLogin.as_view(), name='login'),
    path('logout/', LogoutView.as_view(next_page='login'), name='logout'),
]