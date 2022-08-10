import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HashtagModel } from './hashtag-response';

@Injectable({
  providedIn: 'root'
})
export class HashtagService {

  constructor(private http: HttpClient) { }

  getAllHashtags(): Observable<Array<HashtagModel>>{
    return this.http.get<Array<HashtagModel>>('http://localhost:8080/api/hashtag');
  }

  createHashtag(hashtagModel: HashtagModel): Observable<HashtagModel> {
    return this.http.post<HashtagModel>('http://localhost:8080/api/hashtag',
      hashtagModel);
  }
}
