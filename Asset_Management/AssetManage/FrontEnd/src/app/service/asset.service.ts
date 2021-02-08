import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Asset } from '../entity/asset';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class AssetService {
  private getAllUrl = 'http://localhost:8080/api/asset/getall';
  private getIdUrl = 'http://localhost:8080/api/asset/getid';
  private updateUrl = 'http://localhost:8080/api/asset/update';
  private SearchNameUrl = 'http://localhost:8080/api/asset/searchname';
  private SearchCodeUrl = 'http://localhost:8080/api/asset/searchcode';
  private deleteUrl = 'http://localhost:8080/api/asset/delete';
  private createUrl = 'http://localhost:8080/api/asset/create';

  constructor(private http: HttpClient) {}
  getAssetList(): Observable<any> {
    return this.http.get(`${this.getAllUrl}`);
  }
  searchNameAsset(body: Asset): Observable<any> {
    return this.http.post<any>(`${this.SearchNameUrl}`, body);
  }
  searchCodeAsset(body: Asset): Observable<any> {
    return this.http.post<any>(`${this.SearchCodeUrl}`, body);
  }

  deleteAsset(body: Asset): Observable<any> {
    return this.http.post(`${this.deleteUrl}`, body);
  }
  getAssetId(body: Asset): Observable<any> {
    return this.http.post(`${this.getIdUrl}`, body);
  }

  createAsset(body: Asset): Observable<any> {
    return this.http.post(`${this.createUrl}`, body);
  }

  updateAsset(body: Asset): Observable<any> {
    return this.http.post(`${this.updateUrl}`, body);
  }
} // end
