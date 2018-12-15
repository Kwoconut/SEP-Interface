package controller;

import java.util.ArrayList;

import model.Analysis;
import model.Employee;
import model.EmployeeList;
import model.MyDate;
import model.Vacation;
import model.WorkPlanningToolFile;
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
       
       public ArrayList<Employee> executeGetEmployees()
       {
             ArrayList<Employee> all = new ArrayList<>();

             for (int i = 0; i < model.getEmployeeList().size(); i++)
             {
                if(model.getEmployeeList().getEmployee(i).getState() == false)
                {
                    all.add(model.getEmployeeList().getEmployee(i));
                   
                }
             }
             return all;
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
 
                Object[] oneEmployee = new Object[11];
                oneEmployee[0] = model.getEmployeeList().getEmployee(i).getID();
                oneEmployee[1] = model.getEmployeeList().getEmployee(i).getName().toString();
                if (model.getEmployeeList().getEmployee(i).getTrainingList().getTraining(0).getTraining() == false)
                {
                   oneEmployee[2] = "Not Trained";
                }
                else
                {
                   oneEmployee[2] = "Trained";
                }
                if (model.getEmployeeList().getEmployee(i).getTrainingList().getTraining(1).getTraining() == false)
                {
                   oneEmployee[3] = "Not Trained";
                }
                else
                {
                   oneEmployee[3] = "Trained";
                }
                if (model.getEmployeeList().getEmployee(i).getTrainingList().getTraining(2).getTraining() == false)
                {
                   oneEmployee[4] = "Not Trained";
                }
                else
                {
                   oneEmployee[4] = "Trained";
                }
                if (model.getEmployeeList().getEmployee(i).getTrainingList().getTraining(3).getTraining() == false)
                {
                   oneEmployee[5] = "Not Trained";
                }
                else
                {
                   oneEmployee[5] = "Trained";
                }
                if (model.getEmployeeList().getEmployee(i).getTrainingList().getTraining(4).getTraining() == false)
                {
                   oneEmployee[6] = "Not Trained";
                }
                else
                {
                   oneEmployee[6] = "Trained";
                }
                if (model.getEmployeeList().getEmployee(i).getTrainingList().getTraining(5).getTraining() == false)
                {
                   oneEmployee[7] = "Not Trained";
                }
                else
                {
                   oneEmployee[7] = "Trained";
                }
                if (model.getEmployeeList().getEmployee(i).getTrainingList().getTraining(6).getTraining() == false)
                {
                   oneEmployee[8] = "Not Trained";
                }
                else
                {
                   oneEmployee[8] = "Trained";
                }
                if (model.getEmployeeList().getEmployee(i).getTrainingList().getTraining(7).getTraining() == false)
                {
                   oneEmployee[9] = "Not Trained";
                }
                else
                {
                   oneEmployee[9] = "Trained";
                }
                if (model.getEmployeeList().getEmployee(i).getTrainingList().getTraining(8).getTraining() == false)
                {
                   oneEmployee[10] = "Not Trained";
                }
                else
                {
                   oneEmployee[10] = "Trained";
                }
                
                
                all.add(oneEmployee);
                
             }
          }
          return all;
       }
       
       public EmployeeList sortEmployees()
       {
             EmployeeList sortedEmployeeList = new EmployeeList();
          
          ArrayList<Employee> hiredEmployees = model.getHiredEmployees();
          ArrayList<Employee> firedEmployees = model.getFiredEmployees();
          
          for (int i=0;i<hiredEmployees.size();i++)
          {
             sortedEmployeeList.addEmployee(hiredEmployees.get(i));
          }
          for (int i=0;i<firedEmployees.size();i++)
          {
             sortedEmployeeList.addEmployee(firedEmployees.get(i));
          }
          
          return sortedEmployeeList;
       }
       
       public ArrayList<Object[]> executeShowHiddenEmployees()
       {
          ArrayList<Object[]> all = new ArrayList<>();
          
          EmployeeList sortedEmployeeList = new EmployeeList();
          
          ArrayList<Employee> hiredEmployees = model.getHiredEmployees();
          ArrayList<Employee> firedEmployees = model.getFiredEmployees();
          
          for (int i=0;i<hiredEmployees.size();i++)
          {
             sortedEmployeeList.addEmployee(hiredEmployees.get(i));
          }
          for (int i=0;i<firedEmployees.size();i++)
          {
             sortedEmployeeList.addEmployee(firedEmployees.get(i));
          }
          

          for (int i = 0; i < sortedEmployeeList.size(); i++)
          {
 
                Object[] oneEmployee = new Object[11];
                oneEmployee[0] = sortedEmployeeList.getEmployee(i).getID();
                oneEmployee[1] = sortedEmployeeList.getEmployee(i).getName().toString();
                if (sortedEmployeeList.getEmployee(i).getTrainingList().getTraining(0).getTraining() == false)
                {
                   oneEmployee[2] = "Not Trained";
                }
                else
                {
                   oneEmployee[2] = "Trained";
                }
                if (sortedEmployeeList.getEmployee(i).getTrainingList().getTraining(1).getTraining() == false)
                {
                   oneEmployee[3] = "Not Trained";
                }
                else
                {
                   oneEmployee[3] = "Trained";
                }
                if (sortedEmployeeList.getEmployee(i).getTrainingList().getTraining(2).getTraining() == false)
                {
                   oneEmployee[4] = "Not Trained";
                }
                else
                {
                   oneEmployee[4] = "Trained";
                }
                if (sortedEmployeeList.getEmployee(i).getTrainingList().getTraining(3).getTraining() == false)
                {
                   oneEmployee[5] = "Not Trained";
                }
                else
                {
                   oneEmployee[5] = "Trained";
                }
                if (sortedEmployeeList.getEmployee(i).getTrainingList().getTraining(4).getTraining() == false)
                {
                   oneEmployee[6] = "Not Trained";
                }
                else
                {
                   oneEmployee[6] = "Trained";
                }
                if (sortedEmployeeList.getEmployee(i).getTrainingList().getTraining(5).getTraining() == false)
                {
                   oneEmployee[7] = "Not Trained";
                }
                else
                {
                   oneEmployee[7] = "Trained";
                }
                if (sortedEmployeeList.getEmployee(i).getTrainingList().getTraining(6).getTraining() == false)
                {
                   oneEmployee[8] = "Not Trained";
                }
                else
                {
                   oneEmployee[8] = "Trained";
                }
                if (sortedEmployeeList.getEmployee(i).getTrainingList().getTraining(7).getTraining() == false)
                {
                   oneEmployee[9] = "Not Trained";
                }
                else
                {
                   oneEmployee[9] = "Trained";
                }
                if (sortedEmployeeList.getEmployee(i).getTrainingList().getTraining(8).getTraining() == false)
                {
                   oneEmployee[10] = "Not Trained";
                }
                else
                {
                   oneEmployee[10] = "Trained";
                }
                
                
                all.add(oneEmployee);
                
          }
          return all;
       }
       
       
       public ArrayList<Object[]> executeGetAnalysisData() {
          ArrayList<Object[]> analysis = new ArrayList<>();
          
          for (int i = 0; i < model.getAnalysisList().getSize(); i++)
          {
               
                Object[] colData = new Object[6];
                colData[0] = model.getMatrix(i);
                colData[1] = model.getAnalysisList().getAnalysis(i).getType();
                colData[2] = model.getAnalysisList().getAnalysis(i).getWeek();
                colData[3] = model.getAnalysisList().getAnalysis(i).getMaxNumberOfEmployees();
                colData[4] = model.getAnalysisList().getAnalysis(i).getDate();
                colData[5] = model.getAnalysisList().getAnalysis(i).StringEmployee();
                analysis.add(colData);
          }
          return analysis;
       }
       
       public String executeValidateAnalysisDate(Analysis analysis)
       {
          return model.validateAnalysisDate(analysis);
       }
       
       public ArrayList<Object[]> executeGetEmployeesTrained(String type)
       {
          ArrayList<Object[]> all = new ArrayList<>();

          for (int i = 0; i < model.getEmployeeList().size(); i++)
          {
           if (model.getEmployeeList().getEmployee(i).getTrainingList().getTraining(type).getTraining() == true)
           {
             Object[] oneEmployee = new Object[2];
             oneEmployee[0] = model.getEmployeeList().getEmployee(i).getName().toString();
             oneEmployee[1] = model.getEmployeeList().getEmployee(i).getPreference();
             all.add(oneEmployee);
          }
          }
          return all;
       }
       
       public ArrayList<Employee> executeGetTrainedEmployees(String type)
       {
          ArrayList<Employee> all = new ArrayList<>();

          for (int i = 0; i < model.getEmployeeList().size(); i++)
          {
           if (model.getEmployeeList().getEmployee(i).getTrainingList().getTraining(type).getTraining() == true)
           {
             all.add(model.getEmployeeList().getEmployee(i));
          }
         
          }
          return all;
       }
    
       
       public void executeAssignEmployee(Analysis analysis, Employee employee) {
          model.assignEmployee(analysis, employee);
       }
       
              
       public void executeAddAnalysis(Analysis analysis)
       {
          model.addAnalysis(analysis);
       }
       
       public void executeUpdateAnalysis() 
       {
          WorkPlanningToolFile.updateAnalysisListFile(model.getAnalysisList());
       }
       
       public void executeEditAnalysis(Analysis analysis, String newType, String matrix, String week) {
          model.updateAnalysis(analysis, newType, matrix, week);
       }
       
       public void executeRemoveAnalysis(int index)
       {
       model.removeAnalysis(index);
       }
       
       
       public ArrayList<Analysis> executeGetAnalysis()
       {
          ArrayList<Analysis> all = new ArrayList<>();
          
          for (int i = 0; i < model.getAnalysisList().getSize();i++)
          {
             all.add(model.getAnalysis(i));
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
       
       
       public void executeAddEmployee(Employee employee)
       {
          model.addEmployee(employee);
       }
       
       public void executeUpdateEmployeeList()
       {
          WorkPlanningToolFile.updateEmployeeListFile(model.getEmployeeList());
          WorkPlanningToolFile.updateEmployeeSecurityFile(model.getEmployeeList());
       }
       public void executeRemoveEmployee(int index)
       {
          model.removeEmployee(index);
          executeUpdateEmployeeList();
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
           WorkPlanningToolFile.updateVacationListFile(model.getVacationList());
          }
       }

  public void executeDeclineVacation(int index)
       {
          model.getVacationList().declineVacation(index);;
          WorkPlanningToolFile.updateVacationListFile(model.getVacationList());
       }
  
  public void executeRequestVacation(Vacation vacation)
  {
         model.requestVacation(vacation);
         WorkPlanningToolFile.updateVacationListFile(model.getVacationList());
  }
  
  public boolean validateID(String id)
  {
     return model.validateID(id);
  }
  public String getName(int index)
  {
     return sortEmployees().getEmployee(index).getName().getName();
  }
  public String getLastName(int index)
  {
     return sortEmployees().getEmployee(index).getName().getLastName();
  }
  public void setName(int index, String name)
  {
     sortEmployees().getEmployee(index).getName().setName(name);
  }
  public void setLastName(int index, String lastName)
  {
     sortEmployees().getEmployee(index).getName().setLastName(lastName);
  }
  public void setStatusAvailable(int index)
  {
     sortEmployees().getEmployee(index).setStatusAvailable();
  }
  public void setStatusUnavailable(int index)
  {
     sortEmployees().getEmployee(index).setStatusUnavailable();
  }
  public void HideButtonPressed(int index)
  {
     sortEmployees().getEmployee(index).setToFired();
  }
  public void UnHideButtonPressed(int index)
  {
     sortEmployees().getEmployee(index).setToHired();
  }
  public void OnTrainingButtonPressed(int index)
  {
     sortEmployees().getEmployee(index).setStatusTraining();
  }
  public void TrainedButtonPressed1(int index)
  {
     sortEmployees().getEmployee(index).getTrainingList().getTraining(0).train();
  }
  public void TrainedButtonPressed2(int index)
  {
     sortEmployees().getEmployee(index).getTrainingList().getTraining(1).train();
  }
  public void TrainedButtonPressed3(int index)
  {
     sortEmployees().getEmployee(index).getTrainingList().getTraining(2).train();
  }
  public void TrainedButtonPressed4(int index)
  {
     sortEmployees().getEmployee(index).getTrainingList().getTraining(3).train();
  }
  public void TrainedButtonPressed5(int index)
  {
     sortEmployees().getEmployee(index).getTrainingList().getTraining(4).train();
  }
  public void TrainedButtonPressed6(int index)
  {
     sortEmployees().getEmployee(index).getTrainingList().getTraining(5).train();
  }
  public void TrainedButtonPressed7(int index)
  {
     sortEmployees().getEmployee(index).getTrainingList().getTraining(6).train();
  }
  public void TrainedButtonPressed8(int index)
  {
     sortEmployees().getEmployee(index).getTrainingList().getTraining(7).train();
  }
  public void TrainedButtonPressed9(int index)
  {
     sortEmployees().getEmployee(index).getTrainingList().getTraining(8).train();
  }
  public void NotTrainedButtonPressed1(int index)
  {
     sortEmployees().getEmployee(index).getTrainingList().getTraining(0).untrain();
  }
  public void NotTrainedButtonPressed2(int index)
  {
     sortEmployees().getEmployee(index).getTrainingList().getTraining(1).untrain();
  }
  public void NotTrainedButtonPressed3(int index)
  {
     sortEmployees().getEmployee(index).getTrainingList().getTraining(2).untrain();
  }
  public void NotTrainedButtonPressed4(int index)
  {
     sortEmployees().getEmployee(index).getTrainingList().getTraining(3).untrain();
  }
  public void NotTrainedButtonPressed5(int index)
  {
     sortEmployees().getEmployee(index).getTrainingList().getTraining(4).untrain();
  }
  public void NotTrainedButtonPressed6(int index)
  {
     sortEmployees().getEmployee(index).getTrainingList().getTraining(5).untrain();
  }
  public void NotTrainedButtonPressed7(int index)
  {
     sortEmployees().getEmployee(index).getTrainingList().getTraining(6).untrain();
  }
  public void NotTrainedButtonPressed8(int index)
  {
     sortEmployees().getEmployee(index).getTrainingList().getTraining(7).untrain();
  }
  public void NotTrainedButtonPressed9(int index)
  {
     sortEmployees().getEmployee(index).getTrainingList().getTraining(8).untrain();
  }
  
}
