import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {Customer} from "../model/customer.model";
import {BankAccount} from "../model/account.model";
import {AccountsService} from "../services/accounts.service";
import {catchError, map, Observable, throwError} from "rxjs";

@Component({
  selector: 'app-customer-accounts',
  templateUrl: './customer-accounts.component.html',
  styleUrls: ['./customer-accounts.component.css']
})
export class CustomerAccountsComponent implements OnInit {
  customerId! : string ;
  customer! : Customer;

  name!: string;
  customerAccount! : Observable<Array<BankAccount>>;
  errorMessage!: object;
  constructor(private accountsService : AccountsService, private route : ActivatedRoute, private router :Router) {
    this.customer=this.router.getCurrentNavigation()?.extras.state as Customer;

  }

  ngOnInit(): void {
    this.customerId = this.route.snapshot.params['id'];
    this.customerAccount= this.handleCustomerAccounts2();
    this.name= this.customer.name;

  }
  //retourner les comptes d'un customer
 public handleCustomerAccounts2() : Observable<Array<BankAccount>>   {
    this.customerAccount = this.accountsService.getAccountCustomer(this.customerId).pipe(
      catchError(err => {

        this.errorMessage = err.message;

        return throwError(err);
      })
    );
    return this.customerAccount;
  }



}
