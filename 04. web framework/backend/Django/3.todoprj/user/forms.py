from django import forms
from django.contrib.auth.models import User 


class UserForm(forms.ModelForm):
    class Meta:
        model = User  # 사용할 모델
        fields = ['username', 'password']
        widgets = {
            'password': forms.PasswordInput(),
        }