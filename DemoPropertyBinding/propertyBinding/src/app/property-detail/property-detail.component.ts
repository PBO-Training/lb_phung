import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-property-detail',
  templateUrl: './property-detail.component.html',
  styleUrls: ['./property-detail.component.css']
})
export class PropertyDetailComponent implements OnInit {
  @Input() childItem: string;
  constructor() { }

  ngOnInit(): void {
  }

}
