import { ExamPeriodStatus } from "./exam-period-status.model";

export interface ExamPeriod {
  id: number;
  name: string;
  startDate: Date;
  endDate: Date;
  examPeriodStatus: ExamPeriodStatus;
}
