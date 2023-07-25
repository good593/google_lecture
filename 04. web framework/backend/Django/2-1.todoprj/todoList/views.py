from typing import Any, Dict
from django.forms.models import BaseModelForm
from django.http import HttpResponse
from django.views.generic.list import ListView
from django.views.generic.detail import DetailView
from django.views.generic.edit import CreateView, UpdateView, DeleteView
from django.urls import reverse_lazy

from django.contrib.auth.mixins import LoginRequiredMixin

from .models import Task 

# Create your views here.
class TaskList(LoginRequiredMixin, ListView):
    model = Task 
    fields = ['title', 'complete']
    template_name = 'todoList/task_list.html'
    context_object_name = 'taskList'

    def get_context_data(self, **kwargs: Any) -> Dict[str, Any]:
        context = super().get_context_data(**kwargs)
        context['taskList'] = context['taskList'].filter(user=self.request.user)
        context['count'] = context['taskList'].filter(complete=False).count()

        search_input = self.request.GET.get('search-area') or ''
        if search_input:
            context['taskList'] = context['taskList'].filter(title__startswith=search_input)

        context['search_input'] = search_input
        return context 

class TaskDetail(LoginRequiredMixin, UpdateView):
    model = Task 
    fields = ['title', 'description', 'complete']
    template_name = 'todoList/task_detail.html'

class TaskCreate(LoginRequiredMixin, CreateView):
    model = Task 
    fields = ['title', 'description', 'complete']
    template_name = 'todoList/task_form.html'
    success_url = reverse_lazy('task-list')

    def form_valid(self, form: BaseModelForm) -> HttpResponse:
        form.instance.user = self.request.user 
        return super().form_valid(form)

class TaskUpdate(LoginRequiredMixin, UpdateView):
    model = Task 
    fields = ['title', 'description', 'complete']
    template_name = 'todoList/task_form.html'
    success_url = reverse_lazy('task-list')

class TaskDelete(LoginRequiredMixin, DeleteView):
    model = Task 
    context_object_name = 'task'
    template_name = 'todoList/task_delete.html'
    success_url = reverse_lazy('task-list')
