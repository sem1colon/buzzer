import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {

  constructor(private router: Router) {}


  public create() {
    this.router.navigate(['/create']);
  }

  public join() {
    this.router.navigate(['/join']);
  }

}
