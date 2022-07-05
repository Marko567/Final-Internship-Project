import { City } from "./city.model";
import { Title } from "./title.model";

export interface Professor {
  professorId: number;
  firstname: string;
  lastname: string;
  email: string;
  address: string;
  postalCode: City;
  phone: string;
  reelectionDate: Date;
  title: Title;
}
