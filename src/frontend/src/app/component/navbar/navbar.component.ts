import {Component, Input} from '@angular/core';
import {User} from "../../interface/user";
import {Router} from "@angular/router";
import {UserService} from "../../service/user.service";
import {Observable} from "rxjs";
import {State} from "../../interface/state";
import {CustomHttpResponse, Profile} from "../../interface/appstates";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {
@Input() user: User;
  profileState$: Observable<State<CustomHttpResponse<Profile>>>;

constructor(private router: Router, private userService: UserService) {
}
logOut(): void {
  this.userService.logOut();
  this.router.navigate(['/login'])
}
}
