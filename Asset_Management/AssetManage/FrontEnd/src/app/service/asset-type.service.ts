import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AssetType } from '../entity/assetType';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class AssetTypeService {
  private getAllUrl = 'http://192.168.20.115:8080/api/assettype/getall';
  private getIdUrl = 'http://192.168.20.115:8080/api/assettype/getid';
  private updateUrl = 'http://192.168.20.115:8080/api/assettype/update';
  private SearchNameUrl = 'http://192.168.20.115:8080/api/assettype/searchname';
  private SearchCodeUrl = 'http://192.168.20.115:8080/api/assettype/searchcode';
  private deleteUrl = 'http://192.168.20.115:8080/api/assettype/delete';
  private createUrl = 'http://192.168.20.115:8080/api/assettype/create';

  constructor(private http: HttpClient) {}
  getAssetTypesList(): Observable<any> {
    return this.http.get(`${this.getAllUrl}`);
  }
  searchNameAssetType(body: AssetType): Observable<any> {
    return this.http.post<any>(`${this.SearchNameUrl}`, body);
  }
  searchCodeAssetType(body: AssetType): Observable<any> {
    return this.http.post<any>(`${this.SearchCodeUrl}`, body);
  }

  deleteAssetType(body: AssetType): Observable<any> {
    return this.http.post(`${this.deleteUrl}`, body);
  }
  getAssetTypeId(body: AssetType): Observable<any> {
    return this.http.post(`${this.getIdUrl}`, body);
  }

  createAssetType(body: AssetType): Observable<any> {
    return this.http.post(`${this.createUrl}`, body);
  }

  updateAssetType(body: AssetType): Observable<any> {
    return this.http.post(`${this.updateUrl}`, body);
  }
} // end
