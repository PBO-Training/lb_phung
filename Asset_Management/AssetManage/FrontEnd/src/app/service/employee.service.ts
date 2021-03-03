import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Employee } from '../entity/employee';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class EmployeeService {
  private getAllUrl = 'http://192.168.20.115:8080/api/employee/getall';
  private getIdUrl = 'http://192.168.20.115:8080/api/employee/getid';
  private updateUrl = 'http://192.168.20.115:8080/api/employee/update';
  private SearchNameUrl = 'http://192.168.20.115:8080/api/employee/searchname';
  private SearchCodeUrl = 'http://192.168.20.115:8080/api/employee/searchcode';
  private deleteUrl = 'http://192.168.20.115:8080/api/employee/delete';
  private createUrl = 'http://192.168.20.115:8080/api/employee/create';
  private empInfoUrl = 'http://localhost:8080/api/assetemployee/employeeinfo';

  constructor(private http: HttpClient) {}
  getEmployeeList(): Observable<any> {
    return this.http.get(`${this.getAllUrl}`);
  }
  searchNameEmployee(body: Employee): Observable<any> {
    return this.http.post<any>(`${this.SearchNameUrl}`, body);
  }
  searchCodeEmployee(body: Employee): Observable<any> {
    return this.http.post<any>(`${this.SearchCodeUrl}`, body);
  }

  deleteEmployee(body: Employee): Observable<any> {
    return this.http.post(`${this.deleteUrl}`, body);
  }
  getEmployeeId(body: Employee): Observable<any> {
    return this.http.post(`${this.getIdUrl}`, body);
  }

  createEmployee(body: Employee): Observable<any> {
    return this.http.post(`${this.createUrl}`, body);
  }

  updateEmployee(body: Employee): Observable<any> {
    return this.http.post(`${this.updateUrl}`, body);
  }
  employeeInfo(body: Employee): Observable<any> {
    return this.http.post(`${this.empInfoUrl}`, body);
  }
} // end
