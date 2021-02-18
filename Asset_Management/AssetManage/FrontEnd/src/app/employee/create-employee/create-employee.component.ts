import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../../service/employee.service';
import { Employee } from '../../Entity/employee';
import { Router } from '@angular/router';
import { FormGroup, FormControl } from '@angular/forms';
@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css'],
})
export class CreateEmployeeComponent implements OnInit {
  employeeId: number;
  employee: Employee;
  submitted = false;
  employeeForm = new FormGroup({
    employeeCode: new FormControl(),
    employeeName: new FormControl(),
  });

  constructor(
    private employeeService: EmployeeService,
    private router: Router
  ) {}

  ngOnInit(): void {}
  newAssetType(): void {
    this.submitted = false;
  }
  // create employee
  onSubmit() {
    console.log('value form', this.employeeForm.value);
    this.employee = {
      employeeId: this.employeeId,
      employeeCode: this.employeeForm.value.employeeCode,
      employeeName: this.employeeForm.value.employeeName,
    };
    this.employeeService.createEmployee(this.employee).subscribe(
      (data) => {
        console.log(data);
        this.gotoList();
      },
      (error) => console.log(error)
    );
  }
  // go to list-employee component
  gotoList() {
    this.router.navigate(['/listEmployee']);
  }
}
