from django import forms
from .models import Task


class TaskForm(forms.ModelForm):
    class Meta:
        model = Task  # 사용할 모델
        fields = ['title', 'description', 'complete']