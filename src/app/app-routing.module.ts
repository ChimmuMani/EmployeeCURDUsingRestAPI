import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import {EmployeeDetailsComponent} from './employee-details/employee-details.component';
import{ CreateEmployeeComponent } from './create-employee/create-employee.component';
import {UpdateEmployeeComponent } from './update-employee/update-employee.component';
import { from } from 'rxjs';

const routes: Routes = [
  { path: '', redirectTo: '', pathMatch: 'full' },
  { path: 'employees', component:  EmployeeListComponent  },
  { path: 'add', component:   CreateEmployeeComponent  },
  { path: 'employeeDetails/:id', component:  EmployeeDetailsComponent },
  { path: 'updateDetails/:id', component:  UpdateEmployeeComponent  },
  
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

 
 }
