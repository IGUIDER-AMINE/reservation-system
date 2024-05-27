import {Component, ViewChild} from '@angular/core';
import {MatPaginator} from "@angular/material/paginator";
import {MatSort} from "@angular/material/sort";
import {SessionServiceService} from "../services/session-service.service";
import {MatTableDataSource} from "@angular/material/table";

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrl: './users.component.css'
})
export class UsersComponent {
  public users : any;
  public dataSource : any;
  public displayedColumns = ['id','username','password','role','Options'];

  @ViewChild(MatPaginator) paginator! : MatPaginator;
  @ViewChild(MatSort) sort! : MatSort;
  constructor(private sessionService:SessionServiceService) {
  }

  ngOnInit(): void {
    this.sessionService.getAllUsers()
      .subscribe({
        next : data => {
          this.users = data;
          this.dataSource = new MatTableDataSource(this.users);
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
