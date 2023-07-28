from django.shortcuts import render

# Create your views here.
def index(request):
    context = {
        'msg':'user 초기화면입니다.'
    }
    return render(request, "user/index.html", context)
