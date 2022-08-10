import { Component, OnInit } from '@angular/core';
import { HashtagModel } from 'src/app/hashtag/hashtag-response';
import { HashtagService } from 'src/app/hashtag/hashtag.service';

@Component({
  selector: 'app-hashtag-side-bar',
  templateUrl: './hashtag-side-bar.component.html',
  styleUrls: ['./hashtag-side-bar.component.css']
})
export class HashtagSideBarComponent implements OnInit {

  hashtags: Array<HashtagModel>;
  displayViewAll: boolean;

  constructor(private hashtagService: HashtagService) { 
    this.hashtagService.getAllHashtags().subscribe(data =>{
      if(data.length >= 4){
        this.hashtags = data.splice(0, 3);
        this.displayViewAll = true;
      }else{
        this.hashtags = data;
      }
    })
  }

  ngOnInit(): void {
  }

}
