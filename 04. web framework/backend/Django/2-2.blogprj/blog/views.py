from django.shortcuts import render
from django.views.generic import DetailView 
from django.contrib.auth.mixins import LoginRequiredMixin 
from django.views.generic.edit import CreateView 

from .models import Category, Post 

# Create your views here.
def index(request):
    post_latest = Post.objects.order_by("-createDate")[:6]
    context = {
        "post_latest": post_latest
    }

    return render(request, "index.html", context=context)

class PostDetailView(DetailView):
    model = Post 

class PostCreate(LoginRequiredMixin, CreateView):
    model = Post 
    fields = ["title", "title_image", "content", "category"]

