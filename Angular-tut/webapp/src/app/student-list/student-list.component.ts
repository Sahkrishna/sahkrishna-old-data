import { Component } from '@angular/core';

@Component({
  selector: 'app-student-list',
  template: `
    <h2 class="custom">
      student-list works!
</h2>
<button (click)="getValue()">Read me</button>
<br><br>
<button (click)="getCounter('add')">increment</button><br>
<p> value is: {{counter}}</p>
<button (click)="getCounter('minus')">decrement</button>

  `,
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent {

  getValue(){
    alert("Button is clicked")
  }

  counter=0;
  getCounter(type:string){

    type==='add'?this.counter++:this.counter--;
  }

}
