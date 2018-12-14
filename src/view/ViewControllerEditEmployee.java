package view;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Employee;
import model.Name;

public class ViewControllerEditEmployee
{
   @FXML
   private TextField employeeName;
   @FXML
   private TextField employeeLastName;
   @FXML
   private TextField ELastNameField;
   @FXML
   private TextField PreferenceField;
   @FXML
   private WorkPlanningToolGUI gui;
   @FXML
   private Label changeLabel;
   
   String variable1;
   String variable2;
   String variable3;
   String variable4;
   String variable5;

   public ViewControllerEditEmployee(WorkPlanningToolGUI gui)
   {
      this.gui = gui;
   }
   public void init2()
   {
      employeeName.setText(gui.getController().getName(gui.getIndex()));
      employeeLastName.setText(gui.getController().getLastName(gui.getIndex()));
   }
   @FXML public void editEmployeeButtonPressed()
   {
      gui.getController().setName(gui.getIndex(), employeeName.getText());;
      gui.getController().setLastName(gui.getIndex(), employeeLastName.getText());
      
      if (changeLabel.getText().equals(variable4))
      {
         gui.getController().setStatusUnavailable(gui.getIndex());     
         gui.getController().HideButtonPressed(gui.getIndex());
      }
      
      if (changeLabel.getText().equals(variable1))
      {
         gui.getController().setStatusAvailable(gui.getIndex());     
         gui.getController().UnHideButtonPressed(gui.getIndex());
      }
      
      if (changeLabel.getText().equals(variable2))
      {
         gui.getController().setStatusUnavailable(gui.getIndex());   
         gui.getController().UnHideButtonPressed(gui.getIndex());
      }
      
      if (changeLabel.getText().equals(variable3))
      {
         gui.getController().OnTrainingButtonPressed(gui.getIndex());
         gui.getController().UnHideButtonPressed(gui.getIndex());
      }
      
      if (changeLabel.getText().equals(variable5))
            {
         gui.getController().setStatusAvailable(gui.getIndex());
         gui.getController().UnHideButtonPressed(gui.getIndex());
            }
      
      gui.getController().executeUpdateEmployeeList();
      gui.openManageEmployeeWindow();
   }
   
   @FXML public void AvailableButtonPressed()
   {
      changeLabel.setText(gui.getController().getName(gui.getIndex()) +" "+  gui.getController().getLastName(gui.getIndex()) + " is now set to Available");
      variable1 = changeLabel.getText();
   }
   @FXML public void UnAvailableButtonPressed()
   {
      changeLabel.setText(gui.getController().getName(gui.getIndex()) +" "+  gui.getController().getLastName(gui.getIndex()) + " is now set to UnAvailable");
      variable2 = changeLabel.getText();
   }
   @FXML public void OnTrainingButtonPressed()
   {
      changeLabel.setText(gui.getController().getName(gui.getIndex()) +" "+  gui.getController().getLastName(gui.getIndex()) + " is now on training");
      variable3 = changeLabel.getText();
   }
   @FXML public void HideButtonPressed()
   {
      changeLabel.setText(gui.getController().getName(gui.getIndex()) +" "+ gui.getController().getLastName(gui.getIndex()) + " is now Hidden");
      variable4 = changeLabel.getText();
   }
   @FXML public void UnHideButtonPressed()
   {
      changeLabel.setText(gui.getController().getName(gui.getIndex()) +" "+  gui.getController().getLastName(gui.getIndex()) + " is now Shown");
      variable5 = changeLabel.getText();
   }
   
   
}
