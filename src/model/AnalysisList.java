package model;
import java.io.Serializable;
import java.util.ArrayList;

public class AnalysisList implements Serializable
{
   /**
    * 
    */
   private static final long serialVersionUID = -2929306778931561175L;
   private ArrayList<Analysis> analyses;

   public AnalysisList()
   {
      analyses = new ArrayList<Analysis>();
   }

   public void addAnalysis(Analysis analysis)
   {
      analyses.add(analysis);
   }

   public void removeAnalysis(int index)
   {
      analyses.remove(index);
   }

   public Analysis getAnalysis(String type)
   {
      for (Analysis element : analyses)
      {
         if (element.getType().equals(type))
            return element;
      }
      return null;
   }

   public String toString()
   {
      String s = "";

      for (Analysis element : analyses)
      {
         s += element.toString() + "\n";
      }

      return s;
   }
}
