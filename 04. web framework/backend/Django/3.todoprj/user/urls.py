from django.urls import path
from django.contrib.auth.views import LogoutView

from .views import user_login, user_register

urlpatterns = [
    path('login/', user_login, name='login'),
    path('register/', user_register, name='register'),
    path('logout/', LogoutView.as_view(next_page='login'), name='logout'),
]