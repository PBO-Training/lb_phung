import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'propertyBinding';
  isUnchanged= true;
  classes='special';
  parentItem = 'lamp';

  currentItems = [{
    id: 21,
    name: 'phone'
  }];
}
