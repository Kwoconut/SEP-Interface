package controller;

import java.util.ArrayList;

import model.Employee;
import model.MyDate;
import model.WorkPlanningToolModel;
import view.WorkPlanningToolView;

public class WorkPlanningToolController
{
       WorkPlanningToolModel model;
       WorkPlanningToolView view;
       
       public WorkPlanningToolController(WorkPlanningToolModel model,WorkPlanningToolView view)
       {
          this.model = model;
          this.view = view;
       }
       
       public ArrayList<Object[]> executeGetHiredEmployeesScheduleStatus()
       {
          ArrayList<Object[]> all = new ArrayList<>();

          for (int i = 0; i < model.getEmployeeList().size(); i++)
          {
             if(model.getEmployeeList().getEmployee(i).getState() == false)
             {
                MyDate date = MyDate.now();
                Object[] oneEmployee = new Object[8];
                oneEmployee[0] = model.getEmployeeList().getEmployee(i).getID();
                oneEmployee[1] = model.getEmployeeList().getEmployee(i).getName().toString();
                oneEmployee[2] = model.getEmployeeScheduleStatus(i,date);
                date.stepForwardOneDay();
                oneEmployee[3] = model.getEmployeeScheduleStatus(i,date);
                date.stepForwardOneDay();
                oneEmployee[4] = model.getEmployeeScheduleStatus(i,date);
                date.stepForwardOneDay();
                oneEmployee[5] = model.getEmployeeScheduleStatus(i,date);
                date.stepForwardOneDay();
                oneEmployee[6] = model.getEmployeeScheduleStatus(i,date);
                date.stepForwardOneDay();
                oneEmployee[7] = model.getEmployeeScheduleStatus(i,date);
                
                
                all.add(oneEmployee);
                
             }
          }
          return all;
       }
       
       public ArrayList<Object[]> executeGetHiredEmployees()
       {
          ArrayList<Object[]> all = new ArrayList<>();

          for (int i = 0; i < model.getEmployeeList().size(); i++)
          {
             if(model.getEmployeeList().getEmployee(i).getState() == false)
             {
 
                Object[] oneEmployee = new Object[8];
                oneEmployee[0] = model.getEmployeeList().getEmployee(i).getID();
                oneEmployee[1] = model.getEmployeeList().getEmployee(i).getName().toString();
                
                
                all.add(oneEmployee);
                
             }
          }
          return all;
       }
       
       public ArrayList<Object[]> executeGetMatrix() {
          ArrayList<Object[]> analysis = new ArrayList<>();

          for (int i = 0; i < model.getAnalysisList().getSize(); i++)
          {
                Object[] colData = new Object[1];
                colData[0] = model.getMatrix(i);
                
                analysis.add(colData);
                
             
          }
          return analysis;
       }
       
       
       
       public void executeAddEmployee()
       {
          
       }
       
       public void executeAddAnalysis()
       {
          
       }
       
       public void executeRequestVacation()
       {
          
       }
       
       public String validateLogin(String username,String password)
       {
          return model.validateLogin(username, password);
       }
       
       public ArrayList<Object[]> executeGetVacations()
       {
          ArrayList<Object[]> all = new ArrayList<>();

          for (int i = 0; i < model.getVacationList().size(); i++)
          {

                Object[] oneVacation = new Object[6];
                oneVacation[0] = model.getVacationList().getVacation(i).getEmployee().getName().toString();
                oneVacation[1] = model.getVacationList().getVacation(i).getEmployee().getID();
                oneVacation[2] = model.getVacationList().getVacation(i).getStartDate().toString();
                oneVacation[3] = model.getVacationList().getVacation(i).getEndDate().toString();
                oneVacation[4] = model.getVacationList().getVacation(i).getReason();
                oneVacation[5] = model.getVacationList().getVacation(i).vacationChecked();
                
                all.add(oneVacation);

          }
          return all;
       }

 public void executeApproveVacation(int index)
       {
          for (int i = 0; i < model.getVacationList().size(); i++)
          {
           model.getVacationList().approveVacation(index);; 
           model.updateVacationListFile();
          }
       }

  public void executeDeclineVacation(int index)
       {
          model.getVacationList().declineVacation(index);;
          model.updateVacationListFile();
       }
}
