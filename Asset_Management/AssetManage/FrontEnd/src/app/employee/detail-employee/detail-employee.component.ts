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
// get id employee
  ngOnInit(): void {
    this.employeeId = {
      employeeId: this.route.snapshot.params.employeeId,
    };
    this.employeeService.getEmployeeId(this.employeeId).subscribe(
      (data) => {
        this.employeeForm.patchValue({
          employeeCode: data.employeeCode,
          employeeName: data.employeeName,
        });
      },
      (error) => console.log(error)
    );
  }
// go to list-employee component
  list() {
    this.router.navigate(['listEmployee']);
  }
}
