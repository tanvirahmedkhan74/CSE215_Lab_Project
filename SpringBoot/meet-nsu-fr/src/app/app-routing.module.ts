import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './auth/login/login.component';
import { SignupComponent } from './auth/signup/signup.component';
import { HomeComponent } from './home/home.component';
import { CreateHashtagComponent } from './hashtag/create-hashtag/create-hashtag.component';
import { CreatePostComponent } from './post/create-post/create-post.component';
import { ListHashtagsComponent } from './hashtag/list-hashtags/list-hashtags.component';
import { ViewPostComponent } from './post/view-post/view-post.component';
import { UserProfileComponent } from './auth/user-profile/user-profile.component';

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'user-profile/:name', component: UserProfileComponent},
  {path:'sign-up', component: SignupComponent},
  {path: 'login', component: LoginComponent},
  {path: 'create-post', component: CreatePostComponent},
  {path: 'create-hashtag', component: CreateHashtagComponent},
  {path: 'list-hashtags', component: ListHashtagsComponent},
  {path: 'view-post/:id', component: ViewPostComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
