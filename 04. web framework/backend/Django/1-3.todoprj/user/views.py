from django.shortcuts import render, redirect
from django.contrib.auth.forms import UserCreationForm 
from django.contrib.auth.models import User 
from django.contrib.auth import authenticate, login
from django.contrib import messages
from .forms import UserForm

# Create your views here.
def user_login(request):
    if request.method == 'POST':
        username = request.POST.get("username")
        pwd = request.POST.get("password")
        validate_user = authenticate(username=username, password=pwd)
        if validate_user is not None:
            login(request, validate_user)
            return redirect('task-list')
        else:
            messages.info(request, 'Try again! username or password is incorrect')
            return redirect("login")

    template_name = 'user/login.html' 
    context={'form':UserForm()}
    return render(request, template_name, context)  

def user_register(request):
    if request.method == "POST":
        form = UserCreationForm(request.POST)
        if form.is_valid():
            form.save()
            return redirect('login') 
        else:
            messages.info(request, 'Try again!')
            return redirect("register")
    
    template_name = 'user/register.html'
    context={'form':UserCreationForm()}
    return render(request, template_name, context)  

