from django.urls import path
from .views import index, PostDetailView, PostCreate

urlpatterns = [
    path("", index, name="index"),
    path("post/<int:pk>", PostDetailView.as_view(), name="post"),
    path("post/create", PostCreate.as_view(), name="post_create")
]