from django.urls import path
from .views import Register, LoginView, UserView, RefreshView, Logoutview

urlpatterns = [
    path('register/', Register.as_view(), name='register'),
    path('login/', LoginView.as_view(), name='login'),
    path('user/', UserView.as_view(), name='user'),
    path('refresh/', RefreshView.as_view(), name='refresh'),
    path('logout/', Logoutview.as_view(), name='logout')
]