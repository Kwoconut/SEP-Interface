package view;

import javafx.beans.property.*;

public class TableRowData
{
   private final Object[] row;

   public TableRowData(Object... row)
   {
      if (row == null)
      {
         throw new IllegalArgumentException("Wrong format: data == null");
      }
      this.row = new Object[row.length];
      for (int i = 0; i < row.length; i++)
      {
         this.row[i] = row[i];
      }
   }

   public int size()
   {
      return row.length;
   }

   public Object getData(int index)
   {
      return row[index];
   }

   public StringProperty getStringProperty(int index)
   {
      return new SimpleStringProperty("" + row[index]);
   }

   public IntegerProperty getIntegerProperty(int index)
   {
      try
      {
         int value = Integer.parseInt("" + row[index]);
         return new SimpleIntegerProperty(value);
      }
      catch (Exception e)
      {
         return null;
      }
   }

   public DoubleProperty getDoubleProperty(int index)
   {
      try
      {
         double value = Double.parseDouble("" + row[index]);
         return new SimpleDoubleProperty(value);
      }
      catch (Exception e)
      {
         return null;
      }
   }

   public FloatProperty getFloatProperty(int index)
   {
      try
      {
         float value = Float.parseFloat("" + row[index]);
         return new SimpleFloatProperty(value);
      }
      catch (Exception e)
      {
         return null;
      }
   }

   public LongProperty getLongProperty(int index)
   {
      try
      {
         long value = Long.parseLong("" + row[index]);
         return new SimpleLongProperty(value);
      }
      catch (Exception e)
      {
         return null;
      }
   }

   public BooleanProperty getBooleanProperty(int index)
   {
      try
      {
         boolean value = Boolean.parseBoolean("" + row[index]);
         return new SimpleBooleanProperty(value);
      }
      catch (Exception e)
      {
         return null;
      }
   }

   public String toString()
   {
      String s = "{";
      for (int i = 0; i < row.length; i++)
      {
         s += "{" + i + ": " + row[i] + "}";
         if (i < row.length - 1)
         {
            s += ", ";
         }
      }
      return s + "}";
   }
}
