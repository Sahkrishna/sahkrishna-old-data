import { Component } from '@angular/core';

@Component({
  selector: 'app-country-list',
  template: `
    <h2 class="custom">
      country-list works!
</h2>

<h2>Switch Case</h2>
<div [ngSwitch]="color"]>
  <h2 *ngSwitchCase="'green'" style="color: green;">Green color</h2>
  <h2 *ngSwitchCase="'blue'" style="color: blue;">Blue color</h2>
  <h2 *ngSwitchCase="'red'" style="color: red;">Red color</h2>
  <h2 *ngSwitchCase="'blue'" style="color: blue;">Blue color</h2>
  <h2 *ngSwitchCase="'skyblue'" style="color: skyblue;">skyblue color</h2>
  <h2 *ngSwitchCase="'Yellow'" style="color: yellow;">Yellow color</h2>
  <h2 *ngSwitchDefault>Unknown color</h2>

</div>
  `,
  styles: [
  '.custom{color:blue}'
  ]
})
export class CountryListComponent {
  color="blue";

}
