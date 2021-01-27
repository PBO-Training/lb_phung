import { Component, OnInit } from '@angular/core';
import { Item } from './item';
@Component({
  selector: 'app-app-root',
  templateUrl: './app-root.component.html',
  styleUrls: ['./app-root.component.css'],
})
export class AppRootComponent implements OnInit {
  constructor() {}
  item: Item; 

  items: Item[];

  currentItem: Item;
 

  ngOnInit(): void {}
}
