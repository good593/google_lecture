from django.shortcuts import render, redirect
from django.contrib.auth.models import User
from django.contrib.auth import authenticate, login, logout
from django.contrib import messages

# Create your views here.
def user_register(request):
    if request.user.is_authenticated:
        return redirect("todo-list")

    elif request.method == "POST":
        username = request.POST.get("username")
        email = request.POST.get("email")
        pwd = request.POST.get("password")

        if len(pwd) < 3:
            messages.error(request, "Password must be at least 3 characters")
            return redirect("user-register")

        get_all_users_by_username = User.objects.filter(username=username)
        if get_all_users_by_username:
            messages.error(request, "Error, username already exists, User another.")
            return redirect("user-register")

        new_user = User.objects.create_user(
            username=username, email=email, password=pwd
        )
        new_user.save()

        messages.success(request, "User successfully created, login now")
        return redirect("user-login")

    else:
        return render(request, "user/register.html", {})


def user_login(request):
    if request.user.is_authenticated:
        return redirect("todo-list")
    elif request.method == "POST":
        username = request.POST.get("uname")
        pwd = request.POST.get("pass")

        validate_user = authenticate(username=username, password=pwd)
        if validate_user is not None:
            login(request, validate_user)
            return redirect("todo-list")
        else:
            messages.error(request, "Erro, wrong user details or user does not exist")
            return redirect("user-login")
    else:
        return render(request, "user/login.html", {})


def user_logout(request):
    logout(request)
    return redirect("user-login")
