import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpAuthInterceptor } from './interceptors/http-auth.interceptor';
import { HTTP_INTERCEPTORS } from '@angular/common/http';



@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ], providers: [
    {provide: HTTP_INTERCEPTORS, useClass: HttpAuthInterceptor, multi: true}
  ]
})
export class CoreModule { }
