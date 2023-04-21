import { Component, OnInit } from '@angular/core';
import { DanceClass } from "../../models/danceclass.model";
import { BackendService } from "../services/backend.service";

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css'],

})
export class TableComponent implements OnInit {
  danceClasses: DanceClass[] = [];
  weekDays = ['Montag', 'Dienstag', 'Mittwoch', 'Donnerstag', 'Freitag', 'Samstag', 'Sonntag']
  danceClassDict: { [key: string]: DanceClass[] } = {}; // initialize an empty object


  constructor(private backendService: BackendService) { }

  ngOnInit() {
    this.backendService.getDanceClasses().subscribe({
      next: (response) => {
        this.danceClasses = response.map((danceClass) => {
          // @ts-ignore
          danceClass.start_time = this.backendService.convertTimeStringToDate(danceClass.start_time);
          // @ts-ignore
          danceClass.end_time = this.backendService.convertTimeStringToDate(danceClass.end_time);
          return danceClass;
        });

        // loop through weekDays and add each day as a key to danceClassDict
        for (const day of this.weekDays) {
          this.danceClassDict[day] = []// assign any value you want for this key
        }

        // loop through danceClasses and add each danceClass to the corresponding day
        for (const danceClass of this.danceClasses) {
          const day = danceClass.weekday;
          this.danceClassDict[day].push(danceClass);
        }

        // loop through every key in danceClassDict and sort the danceClasses by start time
        for (const day in this.danceClassDict) {
          this.danceClassDict[day].sort((a, b) => a.start_time.getTime() - b.start_time.getTime());
        }

        // sort by start time
        this.danceClasses.sort((a, b) => a.start_time.getTime() - b.start_time.getTime());
        console.log(response);
      },
    });
  }

  protected readonly encodeURIComponent = encodeURIComponent;
}

