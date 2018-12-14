package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Employee;
import model.Name;

public class ViewControllerHireEmployee
{
   @FXML
   private TextField IDField;
   @FXML
   private TextField ENameField;
   @FXML
   private TextField ELastNameField;
   @FXML
   private TextField PreferenceField;
   @FXML
   private WorkPlanningToolGUI gui;
   @FXML
   private Label errorLabel;

   public ViewControllerHireEmployee(WorkPlanningToolGUI gui)
   {
      this.gui = gui;
   }
   
   @FXML public void addEmployeeButtonPressed()
   {
     if (gui.getController().validateID(IDField.getText()) == false)
      {
         errorLabel.setText("Employee already in system");
      }
     else if (IDField.getText().equals("") || ENameField.getText().equals("") || ELastNameField.getText().equals(""))
     {
        errorLabel.setText("You must enter an ID, Name and Last Name");
     }
      else
      {
         Name name= new Name(ENameField.getText(), ELastNameField.getText());
         Employee employee = new Employee(name,IDField.getText(),PreferenceField.getText());
         
         gui.getController().executeAddEmployee(employee); 
         gui.getController().executeUpdateEmployeeList();
         gui.IDPassed();
      }
   }
   @FXML public void cancelButtonPressed()
   {
      gui.openManageEmployeeWindow();
   }
   
}
