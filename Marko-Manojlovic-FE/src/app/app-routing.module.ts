import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserRoles } from './core/enums';
import { AuthRolesGuard } from './core/guards/auth-roles.guard';
import { LoginComponent } from './pages/login/login.component';

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {
    path: 'home',
    loadChildren: () => import('./features/home/home.module').then((m) => m.HomeModule),
    canActivate: [AuthRolesGuard],
    data: { roles: [UserRoles.ROLE_USER, UserRoles.ROLE_ADMIN]},
  },
  {
    path: 'student',
    loadChildren: () => import('./features/student/student.module').then((m) => m.StudentModule),
    canActivate: [AuthRolesGuard],
    data: { roles: [UserRoles.ROLE_ADMIN]}
  },
  {
    path: 'professor',
    loadChildren: () => import('./features/professor/professor.module').then((m) => m.ProfessorModule),
    canActivate: [AuthRolesGuard],
    data: { roles: [UserRoles.ROLE_ADMIN]}
  },
  {
    path: 'subject',
    loadChildren: () => import('./features/subject/subject.module').then((m) => m.SubjectModule),
    canActivate: [AuthRolesGuard],
    data: { roles: [UserRoles.ROLE_ADMIN]}
  },
  {path: '', pathMatch:"full", redirectTo:'/login'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
