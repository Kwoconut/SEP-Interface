package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class WorkPlanningToolModelManager implements WorkPlanningToolModel
{
   private AnalysisList analysisList;
   private EmployeeList employeeList;
   private VacationList vacationList;

   public WorkPlanningToolModelManager()
   {
      analysisList = readAnalysisListFile();
      employeeList = readEmployeeListFile();
      vacationList = readVacationListFile();
   }

   public EmployeeList readEmployeeListFile()
   {
      EmployeeList list = new EmployeeList();
      String filename = "employeeList.bin";
      ObjectInputStream in = null;

      try
      {
         File file = new File(filename);
         if (!file.exists())
         {
            return new EmployeeList();
         }
         FileInputStream fis = new FileInputStream(file);
         in = new ObjectInputStream(fis);
         list = (EmployeeList) in.readObject();
         in.close();

      }
      catch (IOException | ClassNotFoundException e)
      {
         e.printStackTrace();
      }

      return list;

   }

   public AnalysisList readAnalysisListFile()
   {
      AnalysisList list = new AnalysisList();
      String filename = "analysisList.bin";
      ObjectInputStream in = null;

      try
      {
         File file = new File(filename);
         if (!file.exists())
         {
            return new AnalysisList();
         }
         FileInputStream fis = new FileInputStream(file);
         in = new ObjectInputStream(fis);
         list = (AnalysisList) in.readObject();
         in.close();

      }
      catch (IOException | ClassNotFoundException e)
      {
         e.printStackTrace();
      }

      return list;

   }

   public VacationList readVacationListFile()
   {
      VacationList list = new VacationList();
      String filename = "vacationList.bin";
      ObjectInputStream in = null;

      try
      {
         File file = new File(filename);
         if (!file.exists())
         {
            return new VacationList();
         }
         FileInputStream fis = new FileInputStream(file);
         in = new ObjectInputStream(fis);
         list = (VacationList) in.readObject();
         in.close();

      }
      catch (IOException | ClassNotFoundException e)
      {
         e.printStackTrace();
      }

      return list;

   }

   public void updateEmployeeListFile()
   {
      String filename = "employeeList.bin";
      ObjectOutputStream out = null;

      try
      {
         File file = new File(filename);
         FileOutputStream fos = new FileOutputStream(file);
         out = new ObjectOutputStream(fos);
         out.writeObject(employeeList);
      }
      catch (IOException e)
      {
         System.out.println("Exception:" + filename);
      }
      finally
      {
         try
         {
            out.close();
         }
         catch (IOException e)
         {
            e.printStackTrace();
         }
      }

   }

   public void updateAnalysisListFile()
   {
      String filename = "employeeList.bin";
      ObjectOutputStream out = null;

      try
      {
         File file = new File(filename);
         FileOutputStream fos = new FileOutputStream(file);
         out = new ObjectOutputStream(fos);
         out.writeObject(analysisList);
      }
      catch (IOException e)
      {
         System.out.println("Exception:" + filename);
      }
      finally
      {
         try
         {
            out.close();
         }
         catch (IOException e)
         {
            e.printStackTrace();
         }
      }
   }

   public void updateVacationListFile()
   {
      String filename = "employeeList.bin";
      ObjectOutputStream out = null;

      try
      {
         File file = new File(filename);
         FileOutputStream fos = new FileOutputStream(file);
         out = new ObjectOutputStream(fos);
         out.writeObject(vacationList);
      }
      catch (IOException e)
      {
         System.out.println("Exception:" + filename);
      }
      finally
      {
         try
         {
            out.close();
         }
         catch (IOException e)
         {
            e.printStackTrace();
         }
      }

   }

   public void updateEmployeeSecurityFile()
   {
      String filename = "employeeSecurity.txt";
      File file = new File(filename);
      
      try
      {
         PrintWriter out = new PrintWriter(file);
         for (int i = 0;i < employeeList.size();i++)
         {
            out.println(employeeList.getEmployee(i).getUsername() + "," + employeeList.getEmployee(i).getPassword());
            out.flush();
         }
         out.close();
      }
      catch (FileNotFoundException e)
      {
         e.printStackTrace();
      }

   }
   
   public AnalysisList getAnalysisList()
   {
      return analysisList;
   }

   public EmployeeList getEmployeeList()
   {
      return employeeList;
   }

   public VacationList getVacationList()
   {
      return vacationList;
   }

   public void assignEmployee(Analysis analysis, Employee employee)
   {
      switch (employeeList.getEmployee(employee).getStatus())
      {
         case "Vacation":
         {
            MyDate date = analysis.getDate();
            if (vacationList.getVacationByEmployee(employee) != null)
            {
               MyDate startDate = vacationList.getVacationByEmployee(employee)
                     .getStartDate();
               MyDate endDate = vacationList.getVacationByEmployee(employee)
                     .getEndDate();

               if ((date.isBefore(startDate)) || (date.isAfter(endDate)))
               {
                  analysisList.getAnalysis(analysis.getType())
                        .assignEmployee(employeeList.getEmployee(employee));
               }
            }
            break;
         }

         case "Unavailable":
         {
            break;
         }
         case "Training":
         {
            break;
         }
         case "Vacation Pending":
         {
            analysisList.getAnalysis(analysis.getType())
                  .assignEmployee(employeeList.getEmployee(employee));
            break;
         }
         case "Available":
         {
            analysisList.getAnalysis(analysis.getType())
                  .assignEmployee(employeeList.getEmployee(employee));
            break;
         }
      }
   }

   public void addAnalysis(Analysis analysis)
   {
      analysisList.addAnalysis(analysis);
   }

   public void removeAnalysis(int index)
   {
      analysisList.removeAnalysis(index);
   }

   public Analysis getAnalysis(String type)
   {
      return analysisList.getAnalysis(type);
   }

   public void updateAnalysis(String type, String newType, String matrix,
         int numberOfEmployees)
   {
      analysisList.getAnalysis(type).setType(newType);
      analysisList.getAnalysis(type).setMatrix(matrix);
      analysisList.getAnalysis(type).setNumberOfEmployees(numberOfEmployees);
   }

   public void addEmployee(Employee employee)
   {
      employeeList.addEmployee(employee);
   }

   public void removeEmployee(int index)
   {
      employeeList.removeEmployee(index);
   }

   public Employee getEmployee(Employee employee)
   {
      return employeeList.getEmployee(employee);
   }

   public void updateEmployee(Employee employee, String name, String lastName)
   {
      employeeList.getEmployee(employee).getName().setName(name);
      employeeList.getEmployee(employee).getName().setLastName(lastName);
   }

   public void setEmployeeToHired(Employee employee)
   {
      employeeList.getEmployee(employee).setToHired();
   }

   public void setEmployeeToFired(Employee employee)
   {
      employeeList.getEmployee(employee).setToFired();
   }

   public void setEmployeeAvailable(Employee employee)
   {
      employeeList.getEmployee(employee).setStatusAvailable();
   }

   public void setEmployeeUnavailable(Employee employee)
   {
      employeeList.getEmployee(employee).setStatusUnavailable();
   }

   public void trainEmployee(Employee employee, String type)
   {
      employeeList.getEmployee(employee).train(type);
   }

   public ArrayList<Employee> getHiredEmployees()
   {
      return employeeList.getHiredEmployees();
   }

   public ArrayList<Employee> getFiredEmployees()
   {
      return employeeList.getFiredEmployees();
   }

   public void requestVacation(Vacation vacation)
   {
      vacationList.requestVacaction(vacation);
   }

   public void approveVacation(int index)
   {
      vacationList.approveVacation(index);
   }
   
   public String validateLogin(String user, String password)
   {
      if (user == null || user.isEmpty())
      {
         return "Username cannot be empty";
      }
      if (password == null || password.length() < 6)
      {
         return "Password must contain at least 6 letters";
      }
      String filename = "employeeSecurity.txt";
      File file = new File(filename);
      try
      {
        Scanner in = new Scanner(file);
         while (in.hasNext())
         {
            String line = in.nextLine();
            String[] token = line.split(",");
            String readUser = token[0].trim();
            String readPassword = token[1].trim();

            if (user.equals(readUser) && password.equals(readPassword))
            {
               
               return null;
            }
         }
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
      
      return "Username or password is invalid";
      
   }

}
