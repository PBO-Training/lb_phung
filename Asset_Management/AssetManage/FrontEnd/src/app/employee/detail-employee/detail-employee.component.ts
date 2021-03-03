import { Component, OnInit, Input } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { EmployeeService } from '../../service/employee.service';
import { error } from '@angular/compiler/src/util';
import { Employee } from 'src/app/Entity/employee';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-detail-employee',
  templateUrl: './detail-employee.component.html',
  styleUrls: ['./detail-employee.component.css'],
})
export class DetailEmployeeComponent implements OnInit {
  employeeId: any;
  employeeTable: Employee[];
  employee: Employee;
  columnTables = ['Employee Name', 'Asset Name', 'Date range'];
  fieldName = ['employeeName', 'assetName', 'assetEmployeDateRange'];

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private employeeService: EmployeeService
  ) {}
  // get id employee
  ngOnInit(): void {


    this.employeeId = {
      employeeId: this.route.snapshot.params.employeeId,
    };
    this.employeeService.employeeInfo(this.employeeId).subscribe(
      (search) => {
        console.log('sss', search);
        this.employeeTable = search;
      },

      (error) => console.log(error)
    );
  }
  // go to list-employee component
  list() {
    this.router.navigate(['listEmployee']);
  }
}
