import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TvShowComponent } from './tvshow/tvshow.component';
import { MovieComponent } from './movie/movie.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';




const routes: Routes = [ 
  {path: 'movies', component: MovieComponent}, 
  {path: 'tvshows', component: TvShowComponent},
  {path: 'home', component: HomeComponent},
  {path: 'login', component: LoginComponent},
  {path: 'signup', component: SignupComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routComp = [TvShowComponent, MovieComponent, HomeComponent, LoginComponent, SignupComponent]