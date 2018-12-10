package model;
import java.io.Serializable;

public class Name implements Serializable
{
   /**
    * 
    */
   private static final long serialVersionUID = 6023543276453535628L;
   private String name;
   private String lastName;

   public Name(String name, String lastName)
   {
      this.name = name;
      this.lastName = lastName;
   }

   public String getName()
   {
      return name;
   }

   public String getLastName()
   {
      return lastName;
   }

   public void setLastName(String lastName)
   {
      this.lastName = lastName;
   }

   public void setName(String name)
   {
      this.name = name;
   }

   public boolean equals(Object obj)
   {
      if (!(obj instanceof Name))
      {
         return false;
      }
      Name other = (Name) obj;
      return name.equals(other.getName())
            && lastName.equals(other.getLastName());
   }

   public String toString()
   {
      return name + " " + lastName;
   }

}
