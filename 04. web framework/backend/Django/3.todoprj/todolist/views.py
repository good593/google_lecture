from django.shortcuts import render, redirect
from django.contrib.auth.decorators import login_required
from django.forms.models import model_to_dict

from .models import Task
from .forms import TaskForm

# Create your views here.
@login_required
def task_list(request):
    template_name = 'todoList/task_list.html' 
    context = {}

    search_input = request.GET.get('search-area') or ''
    if search_input:
        context['taskList'] = Task.objects.filter(title__startswith=search_input)
    else:
        context['taskList'] = Task.objects.filter(user=request.user)

    context['search_input'] = search_input
    context['cnt'] = Task.objects.filter(complete=False).count()

    return render(request, template_name, context)

@login_required
def task_detail(request, pk):
    template_name = 'todoList/task_detail.html'
    get_task = Task.objects.get(id=pk)
    context={
        'form':TaskForm(instance=get_task),
        'task':get_task
    }

    return render(request, template_name, context) 

@login_required
def task_create(request):
    if request.method == "POST":
        form = TaskForm(request.POST)
        if form.is_valid():
            task = form.save(commit=False)
            task.user = request.user 
            task.save()
            return redirect('task-list')
    else:
        template_name = 'todoList/task_form.html'
        context={'form':TaskForm()}

        return render(request, template_name, context) 

@login_required
def task_update(request, pk):
    get_task = Task.objects.get(id=pk)

    if request.method == "POST":
        form = TaskForm(request.POST, instance=get_task)
        if form.is_valid():
            task = form.save(commit=False)
            task.pk = pk
            task.save()
            return redirect('task-list')
    else:
        template_name = 'todoList/task_form.html'
        context={
            'form':TaskForm(instance=get_task),
            'task':get_task
        }

        return render(request, template_name, context) 

@login_required
def task_delete(request, pk):
    get_task = Task.objects.get(id=pk)
    if request.method == "POST":
        get_task.delete()
        return redirect('task-list')
    else:
        template_name = 'todoList/task_delete.html'
        context={
            'form':TaskForm(instance=get_task),
            'task':get_task
        }
        return render(request, template_name, context)  

