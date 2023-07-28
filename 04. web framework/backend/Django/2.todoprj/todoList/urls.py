from django.urls import path
from .views import todo_list, delete_task, update_task

urlpatterns = [
    path("", todo_list, name="todo-list"),
    path("delete-task/<str:task>", delete_task, name="delete-task"),
    path("update-task/<str:task>", update_task, name="update-task"),
]
