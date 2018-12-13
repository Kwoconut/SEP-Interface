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

   public ArrayList<Analysis> getAnalysesByEmployee(Employee employee)
   {
      ArrayList<Analysis> list = new ArrayList<Analysis>();

      for (Analysis element : analyses)
      {
         Employee[] employees = element.getEmployees();
         for (int i = 0; i < employees.length; i++)
         {
            if(employees[i] != null)
            {
            if (employees[i].equals(employee))
            {
               list.add(element);
            }
            }
         }
      }
      return list;
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
   
   public Analysis getAnalysis(int index) 
   {
      return analyses.get(index);
   }
   
   public Analysis getAnalysis(Analysis analysis)
   {
      for (Analysis element : analyses)
      {
         if (element.equals(analysis));
         {
            return analysis;
         }
      }
      return null;
   }
   
   public int getSize()
   {
      return analyses.size();
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
