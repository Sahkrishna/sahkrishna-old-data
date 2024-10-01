import { Component } from '@angular/core';
import { reduce } from 'rxjs';
import {NgForm} from '@angular/forms'
import { NgbDropdownMenu } from '@ng-bootstrap/ng-bootstrap';


@Component({
  selector: 'app-root',
  
  templateUrl: './app.component.html',
  
  styleUrls: ['./app.component.css'],
 
})
export class AppComponent {
  title = 'blogs';

  getData(data:NgForm){
    console.warn(data);

  }
  display=true;
  getValue(){
    this.display=!this.display
  }

 
}
