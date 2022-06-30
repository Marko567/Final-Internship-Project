import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Marko-Manojlovic-FE';

  constructor() {
  }

  // onClick() {
  //   this.studentService.getStudents().subscribe({
  //       next: userLoginData => {
  //         console.log('response:', userLoginData);
  //       },
  //       error: error => {
  //         console.error('error', error.error);
  //       }
  //     })
  // }
}
