from django.shortcuts import render

# Create your views here.
def index(request):
    context = {
        'msg':'todolist 초기화면입니다.'
    }
    return render(request, "todolist/index.html", context)


def todolist(request, option=None):
    context = {
        'msg':'todolist 2번째 화면입니다.'
    }

    if option is not None:
        context['todolist'] = [
            {
                'title':'title1',
                'color':'red'
            },
            {
                'title':'title2',
                'color':'blue'
            }
        ]

    return render(request, "todolist/todolist.html", context)


