import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AssetTypeService {
  private Url = ' http://localhost:8080/api/assetType';
  constructor(private http: HttpClient) {}
  getAssetTypesList(): Observable<any> {
    return this.http.get(`${this.Url}`);
  }
  deleteAssetType(assetTypeId: number): Observable<any> {
    return this.http.delete(`${this.Url}/${assetTypeId}`, {
      responseType: 'text',
    });
  }
  getAssetType(assetTypeId: number): Observable<any> {
    return this.http.get(`${this.Url}/${assetTypeId}`);
  }

  // tslint:disable-next-line: ban-types
  createAssetType(assetType: Object): Observable<Object> {
    return this.http.post(`${this.Url}`, assetType);
  }

  // tslint:disable-next-line: ban-types
  updateAssetType(assetTypeId: number, value: any): Observable<Object> {
    return this.http.put(`${this.Url}/${assetTypeId}`, value);
  }
} // end
