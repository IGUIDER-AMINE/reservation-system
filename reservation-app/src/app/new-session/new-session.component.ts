import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {SessionServiceService} from "../services/session-service.service";
import moment from "moment";
@Component({
  selector: 'app-new-session',
  templateUrl: './new-session.component.html',
  styleUrl: './new-session.component.css'
})
export class NewSessionComponent implements OnInit {
  sessionFormGroup!: FormGroup;
  showProgress: boolean = false;

  constructor(private fb: FormBuilder, private sessionService: SessionServiceService) {}

  ngOnInit(): void {
    this.sessionFormGroup = this.fb.group({
      date: this.fb.control(''),
      startTime: this.fb.control(''),
      endTime: this.fb.control(''),
      maxReservation: this.fb.control('')
    });
  }

  saveSession() {
    this.showProgress = true;

    // Combine date with start time and end time
    const date = this.sessionFormGroup.value.date;
    const startTime = this.sessionFormGroup.value.startTime;
    const endTime = this.sessionFormGroup.value.endTime;

    const startDateTime = moment(date).format('YYYY-MM-DD') + 'T' + startTime + ':00';
    const endDateTime = moment(date).format('YYYY-MM-DD') + 'T' + endTime + ':00';

    const formData = {
      startTime: startDateTime,
      endTime: endDateTime,
      maxReservations: this.sessionFormGroup.value.maxReservation
    };

    this.sessionService.saveSession(formData).subscribe({
      next: value => {
        this.showProgress = false;
        alert('Session Saved successfully!');
      },
      error: err => {
        console.log(err);
        this.showProgress = false;
      }
    });
  }
}
