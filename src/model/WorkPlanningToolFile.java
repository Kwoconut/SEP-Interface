package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class WorkPlanningToolFile
{
     public static File employeeListFile = new File("employeeList.bin");
     public static File employeeSecurityFile = new File("employeeSecurity.txt");
     public static File analysisListFile = new File("analysisList.bin");
     public static File vacationListFile = new File("vacationList.bin");
     public static File employeeTrainingListFile = new File("analysisTypes.txt");
     
     public static EmployeeList readEmployeeListFile()
     {
        EmployeeList list = new EmployeeList();
        ObjectInputStream in = null;

        try
        {
           if (!employeeListFile.exists())
           {
              return new EmployeeList();
           }
           FileInputStream fis = new FileInputStream(employeeListFile);
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
     
     public static AnalysisList readAnalysisListFile()
     {
        AnalysisList list = new AnalysisList();
        ObjectInputStream in = null;

        try
        {
           if (!analysisListFile.exists())
           {
              return new AnalysisList();
           }
           FileInputStream fis = new FileInputStream(analysisListFile);
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

     public static VacationList readVacationListFile()
     {
        VacationList list = new VacationList();
        ObjectInputStream in = null;

        try
        {
           if (!vacationListFile.exists())
           {
              return new VacationList();
           }
           FileInputStream fis = new FileInputStream(vacationListFile);
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
     
     public static TrainingList readTrainingTypes()
     {
        TrainingList list = new TrainingList();
        try
        {
           Scanner in = new Scanner(employeeTrainingListFile);
           while (in.hasNext())
           {
              String line = in.nextLine();
              list.addTraining(new Training(line));
           }
        }
        catch (FileNotFoundException e)
        {
           e.printStackTrace();
        }
        
        return list;
     }
     
     public static void updateEmployeeListFile(EmployeeList list)
     {
        ObjectOutputStream out = null;
        try
        {
           FileOutputStream fos = new FileOutputStream(employeeListFile);
           out = new ObjectOutputStream(fos);
           out.writeObject(list);
        }
        catch (IOException e)
        {
           System.out.println("Exception:employeeList.bin");
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
     
     public static void updateAnalysisListFile(AnalysisList list)
     {
        ObjectOutputStream out = null;

        try
        {
           FileOutputStream fos = new FileOutputStream(analysisListFile);
           out = new ObjectOutputStream(fos);
           out.writeObject(list);
        }
        catch (IOException e)
        {
           System.out.println("Exception:analysisList.bin");
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

     public static void updateVacationListFile(VacationList list)
     {
        ObjectOutputStream out = null;

        try
        {
           FileOutputStream fos = new FileOutputStream(vacationListFile);
           out = new ObjectOutputStream(fos);
           out.writeObject(list);
        }
        catch (IOException e)
        {
           System.out.println("Exception:vacationList.bin");
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
     
     public static void updateEmployeeSecurityFile(EmployeeList list)
     {

        try
        {
           PrintWriter out = new PrintWriter(employeeSecurityFile);
           for (int i = 0; i < list.size(); i++)
           {
              out.println(list.getEmployee(i).getUsername() + ","
                    + list.getEmployee(i).getPassword());
              out.flush();
           }
           out.close();
        }
        catch (FileNotFoundException e)
        {
           e.printStackTrace();
        }

     }
}
