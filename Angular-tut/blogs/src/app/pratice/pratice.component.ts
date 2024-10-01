import { Component } from '@angular/core';
import {NgbDropdownMenu} from '@ng-bootstrap/ng-bootstrap'

@Component({
  selector: 'app-pratice',
  standalone:true,
  templateUrl: './pratice.component.html',
  imports:[NgbDropdownMenu],
  styleUrls: ['./pratice.component.css']
})
export class PraticeComponent {

  color='blue';
  bgColor='red';
  changeColor(){
    this.color='yellow'
    this.bgColor='skyblue'
  }

  counter=0;
  getValue(type:string){
    type==='add'?this.counter++:this.counter--;
  }

  user=['krishna','balram','sarfaraz','Ganpat'];
  userDetails=[
    {name:'krishna',address:'kathmandu',phone:'9814754214'},
    {name:'Balram',address:'bhaktapur',phone:'89756789'},
    {name:'sarfaraj',address:'janakpur',phone:'234r4323'},
    {name:'ganpat',address:'lahan',phone:'5678767'},
  ]

  userDet=[
    {name:'krishna',address:'kathmandu',phone:'9814754214',socialAccount:['facebook','insta','twitter']},
    {name:'Balram',address:'bhaktapur',phone:'89756789',socialAccount:['isnta','fb','twits']},
    {name:'sarfaraj',address:'janakpur',phone:'234r4323',socialAccount:['facebook','insta','twitter']},
    {name:'ganpat',address:'lahan',phone:'5678767',socialAccount:['facebook','insta','twitter']},
  ]

}
