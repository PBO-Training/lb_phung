import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-two-way-bin-ding',
  templateUrl: './two-way-bin-ding.component.html',
  styleUrls: ['./two-way-bin-ding.component.css']
})
export class TwoWayBinDingComponent implements OnInit {
  name = 'phung';
  xanh =true;
  constructor() { }

  ngOnInit(): void {
  }

}
