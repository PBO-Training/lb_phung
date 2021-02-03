import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css'],
})
export class SearchComponent implements OnInit {
  SearchText = '';

  @Output() SearchType = new EventEmitter<string>();

  constructor(private route: ActivatedRoute, private router: Router) {}
  ngOnInit(): void {}
  clickSearch() {
    this.SearchType.emit(this.SearchText);
  }
}
