import { Component } from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {SessionServiceService} from "../services/session-service.service";
import moment from "moment/moment";
import {RoleType} from "../model/Reservations.model";

@Component({
  selector: 'app-new-user',
  templateUrl: './new-user.component.html',
  styleUrl: './new-user.component.css'
})
export class NewUserComponent {
  sessionFormGroup!: FormGroup;
  showProgress: boolean = false;
  roleType: string[]=[];

  constructor(private fb: FormBuilder, private sessionService: SessionServiceService) {}

  ngOnInit(): void {
    for(let elt in RoleType){
      let value = RoleType[elt]
      if(typeof value === 'string' )
        this.roleType.push(value);
    }
    this.sessionFormGroup = this.fb.group({
      username: this.fb.control(''),
      password: this.fb.control(''),
      role: this.fb.control(''),
    });
  }

  saveSession() {
    this.showProgress = true;

    const username = this.sessionFormGroup.value.username;
    const password = this.sessionFormGroup.value.password;


    const formData = {
      username: username,
      password: password,
      role: this.sessionFormGroup.value.role
    };

    this.sessionService.saveeUser(formData).subscribe({
      next: value => {
        this.showProgress = false;
        alert('User Saved successfully!');
      },
      error: err => {
        console.log(err);
        this.showProgress = false;
      }
    });
  }
}
