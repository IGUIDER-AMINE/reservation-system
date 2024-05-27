import {Component, ViewChild} from '@angular/core';
import {MatPaginator} from "@angular/material/paginator";
import {MatSort} from "@angular/material/sort";
import {SessionServiceService} from "../services/session-service.service";
import {MatTableDataSource} from "@angular/material/table";

@Component({
  selector: 'app-sessions',
  templateUrl: './sessions.component.html',
  styleUrl: './sessions.component.css'
})
export class SessionsComponent {
  public sesssions : any;
  public dataSource : any;
  public displayedColumns = ['id','startTime','endTime','maxReservations','Options'];

  @ViewChild(MatPaginator) paginator! : MatPaginator;
  @ViewChild(MatSort) sort! : MatSort;
  constructor(private sessionService:SessionServiceService) {
  }

  ngOnInit(): void {
    this.sessionService.getAllSessions()
      .subscribe({
        next : data => {
          this.sesssions = data;
          this.dataSource = new MatTableDataSource(this.sesssions);
          this.dataSource.paginator = this.paginator;
          this.dataSource.sort = this.sort;
        },
        error : err => {
          console.log(err);
        }
      })
  }

  handleDelete(element: any) {

  }

  handleEdit(element: any) {

  }
}
