import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './auth/login/login.component';
import { SignupComponent } from './auth/signup/signup.component';
import { HomeComponent } from './home/home.component';
import { CreateHashtagComponent } from './hashtag/create-hashtag/create-hashtag.component';
import { CreatePostComponent } from './post/create-post/create-post.component';
import { ListHashtagsComponent } from './hashtag/list-hashtags/list-hashtags.component';

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path:'sign-up', component: SignupComponent},
  {path: 'login', component: LoginComponent},
  {path: 'create-post', component: CreatePostComponent},
  {path: 'create-hashtag', component: CreateHashtagComponent},
  {path: 'list-hashtags', component: ListHashtagsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
