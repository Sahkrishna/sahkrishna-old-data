from django.http import HttpResponse
from django.shortcuts import render
from django.views import View

class homePage(View):

    def get(self,request):
        return render(request,'index.html')
    
class clientStay(View):
    def get(self, request):
        return render(request,'clientstay.html')
    
class featuredPage(View):
    def get(self,request):
        return render(request,'featured.html')
    
class brandPage(View):
    def get(self,request):
        return render(request,'brand.html')

class latestPage(View):
    def get(self,request):
        return render(request,'latest.html')
    
class servicePage(View):
    def get(self,request):
        return render(request,'service.html')
    
