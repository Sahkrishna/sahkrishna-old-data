from django.http import HttpResponse
from django.shortcuts import render 
from django.views import View

class index(View):

    def get(self, request):
        return render(request, 'index.html')

class firstPage(View):
    def get(self,request):

        return render(request,'firstpage.html')
    
class aboutPage(View):

    def get(self,request):
        return render(request,'aboutpage.html')
    
class contactPage(View):
    def get(self,request):
        return render(request,'contactpage.html')


# def index(request):
#    return render(request,'index.html')

# def firstPage(request):
#    return render(request,'firstpage.html')

# def aboutPage(request):
#    return render(request,'aboutpage.html')

# def contactPage(request):
#    return render(request,'contactpage.html')


