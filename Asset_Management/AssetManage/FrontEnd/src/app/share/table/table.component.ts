import { Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges } from '@angular/core';


@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css'],
})
export class TableComponent implements OnInit, OnChanges {
  @Input() data: any[];
  @Input() columnTitle: any[];
  @Input() fieldName: any[];
  @Input() Id: number;

  @Output() buttonValue = new EventEmitter<any>();

  constructor() {}
  ngOnChanges(changes: SimpleChanges): void {
    console.log(this.data);
  }
  ngOnInit(): void {}

  onClick(value: string, action: string): void {
    this.buttonValue.emit({value, action});
  }
}
