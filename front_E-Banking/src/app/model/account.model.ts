import {Customer} from "./customer.model";

export interface AccountDetails {
  accountId:            string;
  balance:              number;
  currentPage:          number;
  totalPages:           number;
  pageSize:             number;
  accountOperationDTOS: AccountOperation[];
}



export interface BankAccount {
  id:            string;
  type:                 string;
  date_createdAt:                 Date;
  balance:              number;
  status:               string;
  overDraft :           number;
  interestRate:         number;


}


export interface AccountOperation {
  id:            number;
  operationDate: Date;
  amount:        number;
  type:          string;
  description:   string;
}
