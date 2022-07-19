import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { HttpAuthService } from 'src/app/core/services/http-auth.service';
import { UserLoginDataService } from 'src/app/core/services/user-login-data.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm?: FormGroup;
  badCredentials = false;

  constructor(
    private fb: FormBuilder,
    private router: Router,
    private httpAuth: HttpAuthService,
    private userLoginData: UserLoginDataService) {
  }

  ngOnInit(): void {
    this.buildForm();
  }

  buildForm() {
    this.loginForm = this.fb.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

  onLogin() {
    const loginData = this.loginForm?.getRawValue();
    if (loginData) {
      this.httpAuth.login(loginData)
      .subscribe(
        {
          next: userLoginData => {
            console.log('response:', userLoginData);
            this.userLoginData.token = 'Basic ' + btoa(`${loginData.username}:${loginData.password}`);
            this.userLoginData.userLoginData = userLoginData;
            console.log('user login data:', this.userLoginData.userLoginData);
            this.router.navigate(['/home/test/general-overview']);
          },
          error: error=> {
            this.badCredentials = true;
            console.error('error:', error.error);
          }
        }
      );
    }
    console.log('End of onLogin method');
  }
}
