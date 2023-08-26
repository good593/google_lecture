from django.urls import path

from .views import index, userInfo

urlpatterns = [
    path("", index, name="user-index"),
    path("userInfo/", userInfo, name="user-info")
]