export interface Session {
  id: number;
  startTime: Date;
  endTime: Date;
  maxReservations: number;
}

export interface User {
  id: number;
  startTime: Date;
  endTime: Date;
  maxReservations: number;
}

export enum RoleType {
  ADMIN,USER
}

/*export interface Payment {
  id : number,
  date : string,
  amount:number,
  type:string,
  status:string,
  file:string,
  student:Student
}



export enum PaymentStatus {
  CREATED, VALIDATED, REJECTED
}*/
