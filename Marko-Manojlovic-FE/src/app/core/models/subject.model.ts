import { Semester } from "./semester.model";

export interface Subject {
  subjectId: number;
  name: string;
  description: string;
  noOfEsp: number;
  yearOfStudy: number;
  semester: Semester;
}
