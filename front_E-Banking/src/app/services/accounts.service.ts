import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";
import {AccountDetails, BankAccount} from "../model/account.model";
import {Customer} from "../model/customer.model";

@Injectable({
  providedIn: 'root'
})
export class AccountsService {

  constructor(private http : HttpClient) { }

  //méthode qui retourne le compte selon son id
  public getAccount(accountId : string, page : number, size : number):Observable<AccountDetails>{
    return this.http.get<AccountDetails>(environment.backendHost+"/accounts/"+accountId+"/pageOperations?page="+page+"&size="+size);
  }

  //opération de débit
  public debit(accountId : string, amount : number, description:string){
    let data={accountId : accountId, amount : amount, description : description}
    return this.http.post(environment.backendHost+"/accounts/debit",data);
  }

  //opération de crédit
  public credit(accountId : string, amount : number, description:string){
    let data={accountId : accountId, amount : amount, description : description}
    return this.http.post(environment.backendHost+"/accounts/credit",data);
  }
  //opération de transfert d'argent
  public transfer(accountSource: string,accountDestination: string, amount : number, description:string){
    let data={accountSource, accountDestination, amount, description }
    return this.http.post(environment.backendHost+"/accounts/transfer",data);
  }

  //retourner les comptes d'un customer
  public getAccountCustomer(accountId : string):Observable<Array<BankAccount>>{
    return this.http.get<Array<BankAccount>>(environment.backendHost+"/accounts/customer/"+accountId);
  }


}
