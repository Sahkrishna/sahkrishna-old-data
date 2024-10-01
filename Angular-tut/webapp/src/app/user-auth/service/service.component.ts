import { Component } from '@angular/core';

@Component({
  selector: 'app-service',
  templateUrl: './service.component.html',
  styleUrls: ['./service.component.css']
})
export class ServiceComponent {

  color="blue";

  displayVal:string='';
  getValue(val:string){

    console.warn(val);
    this.displayVal=val;
  }

}
