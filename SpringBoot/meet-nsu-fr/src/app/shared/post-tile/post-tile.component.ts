import { Component, OnInit, Input } from '@angular/core';
import { PostModel } from '../post-model';
import { PostService } from '../post.service';
import {faArrowUp, faArrowDown, faComments} from '@fortawesome/free-solid-svg-icons'


@Component({
  selector: 'app-post-tile',
  templateUrl: './post-tile.component.html',
  styleUrls: ['./post-tile.component.css']
})
export class PostTileComponent implements OnInit {
  faArrowUp = faArrowUp;
  faArrowDown = faArrowDown;
  faComments = faComments;

  posts$ = new Array<PostModel>;

  @Input() data: Array<PostModel>;

  constructor(private postService: PostService) {
    this.postService.getAllPosts().subscribe(post =>{
      this.posts$ = post;
    })
   }

  ngOnInit(): void {
  }

}