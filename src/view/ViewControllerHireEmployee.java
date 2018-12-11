package view;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ViewControllerHireEmployee
{
   @FXML
   private TextField usernameField;
   private WorkPlanningToolGUI gui;

   public ViewControllerHireEmployee(WorkPlanningToolGUI gui)
   {
      this.gui = gui;
   }
   
}
