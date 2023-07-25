from django.shortcuts import redirect

from django.contrib.auth.views import LoginView
from django.contrib.auth.forms import UserCreationForm 
from django.contrib.auth import login

from django.http import HttpResponse 

from django.views.generic.edit import FormView 
from django.urls import reverse_lazy

# Create your views here.
class UserLogin(LoginView):
    template_name = 'user/login.html' 
    fields = '__all__'
    redirect_authenticated_user = True

    def get_success_url(self) -> str:
        return reverse_lazy('task-list')

class UserRegister(FormView):
    template_name = 'user/register.html'
    form_class = UserCreationForm
    success_url = reverse_lazy('task-list')
    

    def form_valid(self, form) -> HttpResponse:
        user = form.save()
        if user is not None: 
            login(self.request, user)
        return super().form_valid(form)

    def get(self, *args, **kwargs):
        if self.request.user.is_authenticated:
            return redirect('task-list')
        return super().get(*args, **kwargs)

