package model;

import java.util.ArrayList;

public interface WorkPlanningToolModel
{
   public EmployeeList readEmployeeListFile();

   public AnalysisList readAnalysisListFile();

   public VacationList readVacationListFile();

   public void updateEmployeeListFile();

   public void updateAnalysisListFile();

   public void updateVacationListFile();
   
   public void updateEmployeeSecurityFile();
   
   public String getEmployeeScheduleStatus(int index,MyDate date);

   public EmployeeList getEmployeeList();

   public AnalysisList getAnalysisList();

   public VacationList getVacationList();

   public void assignEmployee(Analysis analysis, Employee employee);

   public void addAnalysis(Analysis analysis);

   public void removeAnalysis(int index);

   public Analysis getAnalysis(String type);
   
   public Analysis getAnalysis(int index);
   
   public Analysis getAnalysis(Analysis analysis);
   
   public void updateAnalysis(Analysis analysis, String newType, String matrix, String week);
   
   public String getType(int index);
   
   public String getMatrix(int index);

   public void addEmployee(Employee employee);

   public void removeEmployee(int index);

   public Employee getEmployee(Employee employee);

   public void updateEmployee(Employee employee, String name, String lastName,String preferences);

   public void setEmployeeToHired(Employee employee);

   public void setEmployeeToFired(Employee employee);

   public void setEmployeeAvailable(Employee employee);

   public void setEmployeeUnavailable(Employee employee);

   public void trainEmployee(Employee employee, String type);

   public ArrayList<Employee> getHiredEmployees();

   public ArrayList<Employee> getFiredEmployees();

   public void requestVacation(Vacation vacation);

   public void approveVacation(int index);
   
   public String validateLogin(String username,String password);
   
   public boolean validateID(String id);
}
