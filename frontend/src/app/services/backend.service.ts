import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { DanceClass} from "../../models/danceclass.model";

@Injectable({
  providedIn: 'root'
})
export class BackendService {
  private apiUrl = 'http://localhost:8080';
  constructor(private http: HttpClient) { }
  getDanceClasses(): Observable<DanceClass[]> {
    return this.http.get<DanceClass[]>(`${this.apiUrl}/course/all`);
  }

  convertTimeStringToDate(timeString: string): Date {
    const arbitraryDate = '1970-01-01';
    const dateTimeString = `${arbitraryDate}T${timeString}`;
    return new Date(dateTimeString);
  }
}
