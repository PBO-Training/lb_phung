import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css'],
})
export class SearchComponent implements OnInit {
  // searchAsset: string;
  @Input() SearchText: any;
  @Output() SearchType = new EventEmitter();
  constructor() {}
  ngOnInit(): void {}
  clickSearch(value: string) {
    this.SearchType.emit(value);
  }
} //end
