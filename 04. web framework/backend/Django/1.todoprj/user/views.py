from django.shortcuts import render

# Create your views here.
def index(request):
    context = {
        'msg1':'user 초기화면입니다.',
        'msg2':'django 화이팅!!'
    }
    return render(request, "user/index.html", context)

def userInfo(request):
    context = {
        'info1':'좋아하는 과일',
        'fruits':['사과','수박','복숭아'],
        'info2':'좋아하는 나라',
        'countries':['호주','캐나다','영국']
    }
    return render(request, "user/userInfo.html", context)

