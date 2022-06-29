import { City } from "./city.model";

export interface Student {
  id: number;
  firstname: string;
  lastname: string;
  indexNumber: string;
  indexYear: number;
  email: string;
  address: string;
  city: City;
  currentYearOfStudy: number;
}
