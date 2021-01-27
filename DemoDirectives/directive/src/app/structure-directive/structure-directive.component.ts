import { NgIf } from '@angular/common';
import { Component, Input, OnInit,EventEmitter } from '@angular/core';

@Component({
  selector: 'app-structure-directive',
  templateUrl: './structure-directive.component.html',
  styleUrls: ['./structure-directive.component.css'],
})
export class StructureDirectiveComponent implements OnInit {
  constructor() {}
  @Input() age: string;
  user = {
    name: 'phung',
    age: 10,
  };

  ngOnInit(): void {}
  check(){

  }
}
