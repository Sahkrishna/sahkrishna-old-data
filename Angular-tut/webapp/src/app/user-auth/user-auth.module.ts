import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { ServiceComponent } from './service/service.component';



@NgModule({
  declarations: [
    LoginComponent,
    SignupComponent,
    ServiceComponent
  ],
  imports: [
    CommonModule
  ],
  exports:[
    LoginComponent,
    SignupComponent,
    ServiceComponent
    
  ]
})
export class UserAuthModule { }
