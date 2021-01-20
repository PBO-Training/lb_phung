import { Component, OnInit, Input } from '@angular/core';
import { ITEMS } from '../mock-items';
import { Item } from '../item';
@Component({
  selector: 'app-property-list',
  templateUrl: './property-list.component.html',
  styleUrls: ['./property-list.component.css']
})
export class PropertyListComponent implements OnInit {
listItems = ITEMS;

  @Input() items: Item[];

  constructor() { }

  ngOnInit(): void {
  }

}
