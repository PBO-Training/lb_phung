import { Component, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { Employee } from '../../Entity/employee';
import { EmployeeService } from '../../service/employee.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.css'],
})
export class UpdateEmployeeComponent implements OnInit {
  employeeId: any;
  employee: Employee;
  employeeForm = new FormGroup({
    employeeCode: new FormControl(),
    employeeName: new FormControl(),
  });
  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private employeeService: EmployeeService
  ) {}

  // update employee
  onSubmit() {
    this.employee = {
      employeeId: this.route.snapshot.params.employeeId,
      employeeCode: this.employeeForm.value.employeeCode,
      employeeName: this.employeeForm.value.employeeName,
    };
    this.employeeService.updateEmployee(this.employee).subscribe(
      (data) => {
        console.log(data);
        this.gotoList();
      },
      (error) => console.log(error)
    );
  }
  //get id employee and use id to update
  ngOnInit(): void {
    this.employeeId = {
      employeeId: this.route.snapshot.params.employeeId,
    };
    this.employeeService.getEmployeeId(this.employeeId).subscribe(
      (data) => {
        console.log(data);

        this.employeeForm.patchValue({
          employeeCode: data.employeeCode,
          employeeName: data.employeeName,
        });
      },
      (error) => console.log(error)
    );
  }
  // go to employee list
  gotoList() {
    this.router.navigate(['/listEmployee']);
  }
}
