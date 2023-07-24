from django.shortcuts import render

# Create your views here.
def index(request):
    context = {
        'msg':'todolist 초기화면입니다.'
    }
    return render(request, "todolist/index.html", context)

