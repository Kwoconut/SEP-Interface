package model;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.Random;
import java.util.Scanner;

public class Employee implements Serializable
{
   /**
    * 
    */
   private static final long serialVersionUID = 3411966551174277815L;
   private TrainingList training;
   private Name name;
   private String ID;
   private boolean state;
   private String status;
   private String username;
   private String password;
   private String preference;
   public static String status_available = "Available";
   public static String status_unavailable = "Unavailable";
   public static String status_vacation = "Vacation";
   public static String status_vacationPending = "Vacation Pending";
   public static String status_ontraining = "Training";

   public Employee(Name name, String ID,String preference)
   {
      this.name = name;
      this.ID = ID;
      this.preference = preference;
      status = Employee.status_available;
      training = WorkPlanningToolFile.readTrainingTypes();
      generateUsername();
      generatePassword();
   }
   
   private void generateUsername()
   {
      int x = new Random().nextInt(10000);
      username = name.getName().substring(0, 1) + name.getLastName().substring(0, 1) + String.format("%04d", x);
      String filename = "employeeSecurity.txt";
      try
      {
         File file = new File(filename);
         Scanner in = new Scanner(file);
         while (in.hasNext())
         {
            String line = in.nextLine();
            String[] token = line.split(",");
            String readUser = token[0].trim();
            if (readUser.equals(username))
            {
               x++;
            }
         }
         username = name.getName().substring(0, 1) + name.getLastName().substring(0, 1) + String.format("%04d", x);
      }
      catch (FileNotFoundException e)
      {
         e.printStackTrace();
      }
      
   }
   
   private void generatePassword()
   {  
      password = "";
      String passwordCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
      for (int i = 0; i < 6;i++)
      {
         int index = new Random().nextInt(passwordCharacters.length());
         password += passwordCharacters.charAt(index);
      }
   }

   public String getUsername()
   {
      return username;
   }
   
   public String getPassword()
   {
      return password;
   }
   
   public Name getName()
   {
      return name;
   }

   public String getID()
   {
      return ID;
   }

   public boolean getState()
   {
      return state;
   }
   
   public String getPreference()
   {
      return preference;
   }

   public void train(String type)
   {
      training.getTraining(type).train();
      setStatusTraining();
   }

   public TrainingList getTrainingList()
   {
      return training;
   }
   
   public void setPreferences(String preferences)
   {
      this.preference = preferences;
   }

   public void setToFired()
   {
      state = true;
   }

   public void setToHired()
   {
      state = false;
   }

   public void setStatusAvailable()
   {
      status = Employee.status_available;
   }

   public void setStatusUnavailable()
   {
      status = Employee.status_unavailable;
   }

   public void setStatusVacation()
   {
      status = Employee.status_vacation;
   }

   public void setStatusTraining()
   {
      status = Employee.status_ontraining;
   }

   public void setStatusVacationPending()
   {
      status = status_vacationPending;
   }

   public String getStatus()
   {
      return status;
   }

   public boolean equals(Object obj)
   {
      if (!(obj instanceof Employee))
      {
         return false;
      }
      Employee other = (Employee) obj;
      return name.equals(other.getName()) && ID.equals(other.getID());
   }

   public String toString()
   {
      String s = "";
      s += name + "\n";
      s += ID + "\n";
      s += status + "\n\n";
      s += preference + "\n\n";
      s += "Trainings:\n" + training.toString() + "\n";
      s += "Fired?" + " " + state +"\n";

      return s;
   }
}
