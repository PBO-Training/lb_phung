import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AssetType } from './Entity/assetType';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class AssetTypeService {
  private Url = ' http://localhost:8080/api/assetType';
  private updateUrl = '  http://localhost:8080/api/updateAssetType';
  private SearchNameUrl = 'http://localhost:8080/api/searchAssetType';
  constructor(private http: HttpClient) {}

  getAssetTypesList(): Observable<any> {
    return this.http.get(`${this.Url}`);
  }
  // searchByName(assetTypeName: String): Observable<any> {
  //   if (assetTypeName == '') {
  //      this.getAssetTypesList();
  //   } else {
  //     return this.http.get(`${this.SearchNameUrl}/${assetTypeName}`);
  //   }
  // }

  searchFollowCondition(body: AssetType): Observable<any> {
    return this.http.post<any>(`${this.SearchNameUrl}`, body);
  }

  deleteAssetType(assetTypeId: number): Observable<any> {
    return this.http.delete(`${this.Url}/${assetTypeId}`, {
      responseType: 'text',
    });
  }
  getAssetTypeId(assetTypeId: number): Observable<any> {
    return this.http.get(`${this.Url}/${assetTypeId}`, {
      // responseType: 'text',
    });
  }

  // tslint:disable-next-line: ban-types
  createAssetType(assetType: Object): Observable<Object> {
    return this.http.post(`${this.Url}`, assetType);
  }

  // tslint:disable-next-line: ban-types
  updateAssetType(value: AssetType): Observable<any> {
    return this.http.post<any>(`${this.updateUrl}`, value);
  }
}// end
