import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { NgbDropdownModule, NgbModalModule, NgbNavModule, NgbPaginationModule, NgbToastModule, NgbTooltipModule } from '@ng-bootstrap/ng-bootstrap';
import { HttpClientModule } from '@angular/common/http';
import { HeaderComponent } from './components/header/header.component';
import { BootstrapSetupIconsModule } from './bootstrap-setup-icons/bootstrap-setup-icons.module';


@NgModule({
  declarations: [
    HeaderComponent
  ],
  imports: [
    CommonModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule,

    NgbTooltipModule,
    NgbPaginationModule,
    NgbToastModule,
    NgbModalModule,
    NgbNavModule,
    NgbDropdownModule,

    BootstrapSetupIconsModule
  ], exports:[
    CommonModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule,

    NgbTooltipModule,
    NgbPaginationModule,
    NgbToastModule,
    NgbModalModule,
    NgbNavModule,
    NgbDropdownModule,

    HeaderComponent,
    BootstrapSetupIconsModule
  ]
})
export class SharedModule { }
