import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LoginComponent} from "./login/login.component";
import {AdminTemplateComponent} from "./admin-template/admin-template.component";
import {ReservationsComponent} from "./reservations/reservations.component";
import {AuthenticationGuard} from "./guards/authentication.guard";

const routes: Routes = [
  {path:"login",component:LoginComponent},
  {path:"admin",component:AdminTemplateComponent,canActivate:[AuthenticationGuard],children:[
      {path:"reservations",component:ReservationsComponent},
    ]},
  {path:"",redirectTo:"login",pathMatch:'full'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
