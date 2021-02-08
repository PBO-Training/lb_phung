import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css'],
})
export class SearchComponent implements OnInit {
  SearchByName = '';
  SearchByCode = '';


  @Output() SearchName = new EventEmitter<string>();


  constructor(private route: ActivatedRoute, private router: Router) {}
  ngOnInit(): void {}
  clickSearch() {
    this.SearchName.emit(this.SearchByName);
    // this.SearchCode.emit(this.SearchByCode);
  }

}
