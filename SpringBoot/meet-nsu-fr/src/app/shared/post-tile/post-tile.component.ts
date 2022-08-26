import { Component, OnInit, Input } from '@angular/core';
import { PostModel } from '../post-model';
import { PostService } from '../post.service';
import {faArrowUp, faArrowDown, faComments} from '@fortawesome/free-solid-svg-icons'
import { Router } from '@angular/router';


@Component({
  selector: 'app-post-tile',
  templateUrl: './post-tile.component.html',
  styleUrls: ['./post-tile.component.css']
})
export class PostTileComponent implements OnInit {
  faArrowUp = faArrowUp;
  faArrowDown = faArrowDown;
  faComments = faComments;

  size: Number;
  posts$ = new Array<PostModel>;
  posts_reversed$ = new Array<PostModel>;

  @Input() data: Array<PostModel>;

  constructor(private postService: PostService, 
    private router: Router) {
    this.postService.getAllPosts().subscribe(post =>{
      this.posts$ = post;
    })
    size: this.posts$.length;
      
   }

  ngOnInit(): void {
  }

  goToPost(id: number): void{
    this.router.navigateByUrl('/view-post/' + id);
  }

}