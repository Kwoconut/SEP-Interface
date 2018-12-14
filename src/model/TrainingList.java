package model;
import java.io.Serializable;
import java.util.ArrayList;

public class TrainingList implements Serializable
{
   /**
    * 
    */
   private static final long serialVersionUID = -5717175273516458357L;
   private ArrayList<Training> trainings;

   public TrainingList()
   {
      trainings = new ArrayList<Training>();
   }

   public void addTraining(Training training)
   {
      trainings.add(training);
   }

   public void removeTraining(int index)
   {
      trainings.remove(index);
   }

   public Training getTraining(String type)
   {
      for (Training element : trainings)
      {
         if (element.getType().equals(type))
            return element;
      }
      return null;
   }
   
   public Training getTraining(int index)
   {
     return trainings.get(index);
   }

   public String toString()
   {
      String s = "";

      for (Training element : trainings)
      {
         s += element.toString() + "\n";
      }

      return s;
   }
}
