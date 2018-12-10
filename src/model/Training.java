package model;
import java.io.Serializable;

public class Training implements Serializable
{
   /**
    * 
    */
   private static final long serialVersionUID = 4973032025769344053L;
   private String type;
   private boolean training;

   public Training(String type)
   {
      this.type = type;
   }

   public boolean getTraining()
   {
      return training;
   }

   public String getType()
   {
      return type;
   }

   public void train()
   {
      training = true;
   }

   public void untrain()
   {
      training = false;
   }

   public String toString()
   {
      return type + ":" + training;
   }
}