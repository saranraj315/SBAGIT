import { Component, OnInit } from '@angular/core';
import { Customer } from '../../model/customer';
import { ActivatedRoute, Router } from '@angular/router';
import { CustomerService } from '../../service/customer.service';

@Component({
  selector: 'app-customer-form',
  templateUrl: './customer-form.component.html',
  styleUrls: ['./customer-form.component.css']
})
export class CustomerFormComponent implements OnInit {

  
  employee:Customer;
  isEditing: boolean;
  pkgId: string;
  today: Date = new Date();

  constructor(
    private activatedRoute: ActivatedRoute,
    private empService:CustomerService,
    private router: Router
  ) { }

  ngOnInit() {
    this.employee = new Customer();
    this.isEditing = false;

    this.activatedRoute.params.subscribe(
      (params) => {
        let pkgId = params['id'];
        if (pkgId) {
          this.pkgId = pkgId;
          this.employee.planId = pkgId;
          this.employee.orderDate = (new Date(this.today.getFullYear(), this.today.getMonth(), this.today.getDate() + 4));
        }
      }
    );
  }


  save() {
    this.empService.addEmployee(this.employee).subscribe(
      (data) => {
        this.router.navigateByUrl("/plans");
      },
      (error) => { alert("Error adding customer"); }
    );
  }

}