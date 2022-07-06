import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserRoles } from './core/enums';
import { LoginComponent } from './pages/login/login.component';

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {
    path: 'home',
    loadChildren: () => import('./features/home/home.module').then((m) => m.HomeModule),
    data: { roles: [UserRoles.ROLE_USER, UserRoles.ROLE_ADMIN]}
  },
  {
    path: 'student',
    loadChildren: () => import('./features/home/student/student.module').then((m) => m.StudentModule),
    data: { roles: [UserRoles.ROLE_ADMIN]}
  },
  {
    path: 'professor',
    loadChildren: () => import('./features/home/professor/professor.module').then((m) => m.ProfessorModule),
    data: { roles: [UserRoles.ROLE_ADMIN]}
  },
  {
    path: 'subject',
    loadChildren: () => import('./features/home/subject/subject.module').then((m) => m.SubjectModule),
    data: { roles: [UserRoles.ROLE_ADMIN]}
  },
  {path: '', pathMatch:"full", redirectTo:'/login'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
