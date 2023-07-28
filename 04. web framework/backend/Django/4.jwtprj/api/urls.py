from django.urls import path
from .views import Register, LoginView, HelloWorldView, RefreshView, Logoutview

urlpatterns = [
    path('register/', Register.as_view(), name='register'),
    path('login/', LoginView.as_view(), name='login'),
    path('hello-world/', HelloWorldView.as_view(), name='hello-world'),
    path('refresh/', RefreshView.as_view(), name='refresh'),
    path('logout/', Logoutview.as_view(), name='logout')
]