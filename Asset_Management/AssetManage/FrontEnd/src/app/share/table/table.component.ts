import {
  Component,
  EventEmitter,
  Input,
  OnChanges,
  OnInit,
  Output,
  SimpleChanges,
  ViewChild,
} from '@angular/core';


@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css'],
})
export class TableComponent implements OnInit, OnChanges {
  @Input() data: [];
  @Input() columnTitle: [];
  @Input() fieldName: [];
  @Input() fieldId: string;
  @Input() details = true;
  @Input() deletee = true;
  @Input() update = true;

  @Output() buttonValue = new EventEmitter<any>();

  constructor() {}
  ngOnChanges(changes: SimpleChanges): void {}
  ngOnInit(): void {}

  onClick(value: string, action: string): void {
    this.buttonValue.emit({ value, action });
  }

}
