import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css'],
})
export class SearchComponent implements OnInit {
  SearchText = '';

  @Output() SearchType = new EventEmitter<string>();
  constructor() {}
  ngOnInit(): void {}
  // tslint:disable-next-line: typedef
  clickSearch() {
    this.SearchType.emit(this.SearchText);

  }
}
