from django.urls import path

from .views import index, todolist

urlpatterns = [
    path("", index, name="todolist-index"),
    path("todolist/", todolist, name="todolist-todolist"),
    path("todolist/<option>", todolist, name="todolist-option")
]