import { City } from "./city.model";

export interface Student {
  studentId: number;
  firstname: string;
  lastname: string;
  indexNumber: string;
  indexYear: number;
  email: string;
  address: string;
  postalCode: City;
  currentYearOfStudy: number;
}
