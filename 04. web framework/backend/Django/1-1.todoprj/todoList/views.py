from django.shortcuts import render, redirect
from django.contrib.auth.models import User
from django.contrib.auth.decorators import login_required
from django.contrib.auth import authenticate, login, logout
from django.contrib import messages

from .models import todo


@login_required(login_url="/user/login/")
def todo_list(request):
    if request.method == "POST":
        task = request.POST.get("task")
        todo_obj = todo.objects.filter(user=request.user, todo_name=task)
        if todo_obj:
            messages.error(request, f"Error, {task} is aleady exited.")
        elif not len(task):
            messages.error(request, f"Error, task name's length: {len(task)}")
        else:
            new_todo = todo(user=request.user, todo_name=task)
            new_todo.save()
            
    all_todos = todo.objects.filter(user=request.user)
    context = {"todos": all_todos}
    return render(request, "todoList/todo.html", context)


@login_required(login_url="/user/login/")
def delete_task(request, task):
    get_todo = todo.objects.get(user=request.user, todo_name=task)
    get_todo.delete()
    return redirect("todo-list")


@login_required(login_url="/user/login/")
def update_task(request, task):
    get_todo = todo.objects.get(user=request.user, todo_name=task)
    get_todo.status = True
    get_todo.save()
    return redirect("todo-list")

