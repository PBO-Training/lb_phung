import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pipes',
  templateUrl: './pipes.component.html',
  styleUrls: ['./pipes.component.css']
})
export class PipesComponent implements OnInit {

  formatday = new Date(2020, 1, 15); // April 15, 2020 -- since month parameter is zero-based
  toggle = true; // start with true == shortDate

  get format()   { return this.toggle ? 'shortDate' : 'fullDate'; }
  toggleFormat() { this.toggle = !this.toggle;
  console.log("sad");}

  constructor() { }

  ngOnInit(): void {
  }

}
