package model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class EmployeeList implements Serializable
{
   /**
    * 
    */
   private static final long serialVersionUID = -4618209267650882147L;
   private ArrayList<Employee> list;

   public EmployeeList()
   {
      list = new ArrayList<Employee>();
   }

   public int size()
   {
      return list.size();
   }

   public void addEmployee(Employee employee)
   {
      list.add(employee);
   }

   public void removeEmployee(int index)
   {
      list.remove(index);
   }

   public Employee getEmployee(Employee employee)
   {
      for (Employee element : list)
      {
         if (element.equals(employee))
         {
            return element;
         }
      }
      return null;
   }
   
   public Employee getEmployee(int index)
   {
       return list.get(index);
   }

   public ArrayList<Employee> getHiredEmployees()
   {
      ArrayList<Employee> hiredEmployees = new ArrayList<Employee>();
      for (int i = 0; i < list.size(); i++)
      {
         if (list.get(i).getState() == false)
         {
            hiredEmployees.add(list.get(i));
         }
      }
      return hiredEmployees;
   }

   public ArrayList<Employee> getFiredEmployees()
   {
      ArrayList<Employee> firedEmployees = new ArrayList<Employee>();
      for (int i = 0; i < list.size(); i++)
      {
         if (list.get(i).getState() == true)
         {
            firedEmployees.add(list.get(i));
         }
      }
      return firedEmployees;
   }

   public void setToHired(int index)
   {
      list.get(index).setToHired();
   }

   public void setToFired(int index)
   {
      list.get(index).setToFired();
   }

   public Name getName(int index)
   {
      return list.get(index).getName();
   }

   public String getID(int index)
   {
      return list.get(index).getID();
   }

   public boolean getState(int index)
   {
      return list.get(index).getState();
   }
   
   public String getPreference(int index)
   {
      return list.get(index).getPreference();
   }

   public void train(String type, int index)
   {
      list.get(index).train(type);
   }

   public TrainingList getTrainingList(int index)
   {
      return list.get(index).getTrainingList();
   }

   public void setStatusAvailable(int index)
   {
      list.get(index).setStatusAvailable();
   }

   public void setStatusUnavailable(int index)
   {
      list.get(index).setStatusUnavailable();
   }

   public void setStatusVacation(int index)
   {
      list.get(index).setStatusVacation();
   }

   public void setStatusTraining(int index)
   {
      list.get(index).setStatusTraining();
   }

   public String getStatus(int index)
   {
      return list.get(index).getStatus();
   }

   public String toString()
   {
      String s = "";
      for (Employee element : list)
      {
         s += "\n";
         s += element.toString();
      }
      return s;
   }
}
