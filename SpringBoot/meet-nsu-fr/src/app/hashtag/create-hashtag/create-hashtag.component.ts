import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { HashtagModel } from '../hashtag-response';
import { HashtagService } from '../hashtag.service';


@Component({
  selector: 'app-create-hashtag',
  templateUrl: './create-hashtag.component.html',
  styleUrls: ['./create-hashtag.component.css']
})
export class CreateHashtagComponent implements OnInit {
  createHashtagForm: FormGroup;
  hashtagModel: HashtagModel;
  title = new FormControl('');
  description = new FormControl('');

  constructor(private router: Router, private hashtagService: HashtagService) {
    this.createHashtagForm = new FormGroup({
      title: new FormControl('', Validators.required),
      description: new FormControl('', Validators.required)
    });
    this.hashtagModel = {
      name: '',
      description: ''
    }
  }

  ngOnInit() {
  }

  discard() {
    this.router.navigateByUrl('/');
  }

  createHashtag() {
    this.hashtagModel.name = this.createHashtagForm.get('title').value;
    this.hashtagModel.description = this.createHashtagForm.get('description').value;
    this.hashtagService.createHashtag(this.hashtagModel).subscribe(data => {
      this.router.navigateByUrl('/list-hashtags');
    }, error => {
      console.log('Error occurred');
    })
  }

}
