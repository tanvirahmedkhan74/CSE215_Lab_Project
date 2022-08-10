import { Component, OnInit } from '@angular/core';
import { throwError } from 'rxjs';
import { HashtagModel } from '../hashtag-response';
import { HashtagService } from '../hashtag.service';

@Component({
  selector: 'app-list-hashtags',
  templateUrl: './list-hashtags.component.html',
  styleUrls: ['./list-hashtags.component.css']
})
export class ListHashtagsComponent implements OnInit {

  hashtags: Array<HashtagModel>;
  constructor(private hashtagService: HashtagService) { }

  ngOnInit() {
    this.hashtagService.getAllHashtags().subscribe(data => {
      this.hashtags = data;
    }, error => {
      throwError(error);
    })
  }
}
