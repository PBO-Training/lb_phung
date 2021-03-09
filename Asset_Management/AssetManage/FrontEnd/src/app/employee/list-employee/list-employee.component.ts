import {
  Component,
  OnChanges,
  OnInit,
  Output,
  SimpleChanges,
} from '@angular/core';
import { Employee } from '../../Entity/employee';
import { EmployeeService } from '../../service/employee.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
@Component({
  selector: 'app-list-employee',
  templateUrl: './list-employee.component.html',
  styleUrls: ['./list-employee.component.css'],
})
export class ListEmployeeComponent implements OnInit, OnChanges {
  employeeTable: Employee[];
  employeeReq: Employee;
  columnTables = [ 'Code','Name'];
  fieldName = ['employeeCode', 'employeeName'];
  employeeId = 'employeeId';
  employee: any;

  constructor(
    private route: ActivatedRoute,
    private employeeService: EmployeeService,
    private router: Router
  ) {}

  ngOnChanges(changes: SimpleChanges): void {
    throw new Error('Method not implemented.');
  }

  ngOnInit() {
    this.reloadData();
  }
  // Refresh table get all api
  reloadData(): void {
    this.employeeService.getEmployeeList().subscribe(
      (list) => {
        console.log(list);

        this.employeeTable = list;
      },
      (error) => console.log(error)
    );
  }
  // search name employee
  searchByName(value: string): void {
    this.employeeReq = {
      ...this.employeeReq,
      employeeName: value,
    };
    this.employeeService.searchNameEmployee(this.employeeReq).subscribe(
      (search) => {
        this.employeeTable = search;
      },
      (error) => console.log(error)
    );
  }

  searchByCode(value: string): void {
    this.employeeReq = {
      ...this.employeeReq,
      employeeCode: value,
    };
    this.employeeService.searchCodeEmployee(this.employeeReq).subscribe(
      (search) => {
        this.employeeTable = search;
      },
      (error) => console.log(error)
    );
  }
  // Delete employee
  employeeDelete(value: any) {
    console.log(value);
    if (value.action === 'delete') {
      this.employee = {
        employeeId: value.value,
      };
      this.employeeService.deleteEmployee(this.employee).subscribe(
        (value) => {
          this.reloadData();
        },
        (error) => console.log(error)
      );
    }
  }
  // navigate detail employee component
  employeeDetails(value: any) {
    if (value.action === 'details') {
      this.router.navigate(['detailsEmployee', value.value]);
    }
  }
  // navigate update employee component
  employeeUpdate(value: any) {
    if (value.action === 'update') {
      this.router.navigate(['updateEmployee', value.value]);
    }
  }
  // go to create-employee component
  link() {
    this.router.navigate(['addEmployee']);
  }
}
