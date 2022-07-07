import { Component, OnInit } from '@angular/core';
import { UserLoginDataService } from 'src/app/core/services/user-login-data.service';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  constructor(public userLoginData: UserLoginDataService) { }

  ngOnInit(): void {
  }

}
