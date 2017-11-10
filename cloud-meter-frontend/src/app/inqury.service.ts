/**
 * New typescript file
 */
import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { catchError, map, tap } from 'rxjs/operators';

import { TestElementNode } from './testplan/testelement'

@Injectable()
export class InquryService {

  constructor(private http: HttpClient) { }

  getTestElement (type: string) {
    //
    // console.log("using queryparams", queryParams);

    return this.http.get<TestElementNode>(
      "http://localhost:8080/api/v1/testelement",
       { params: new HttpParams().set("type", type),
         observe: 'response' }
       ).subscribe(
         resp => {
           console.log(resp.body);
         }
       );

//     http.get<ItemsResponse>('/api/items').subscribe(data => {
//   // data is now an instance of type ItemsResponse, so you can do this:
//   this.results = data.results;
// });


  }

}
