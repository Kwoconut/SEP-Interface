package view;

import java.util.ArrayList;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Employee;

public class ViewControllerLogin
{
   @FXML
   private TextField usernameField;
   @FXML
   private PasswordField passwordField;
   @FXML
   private Label errorLabel;
   private WorkPlanningToolGUI gui;

   public ViewControllerLogin(WorkPlanningToolGUI gui)
   {
      this.gui = gui;
   }

   @FXML
   public void loginButtonPressed()
   {
      if (gui.getController()
            .validateLogin(usernameField.getText(), passwordField.getText())
            .equals("employee"))
      {
         ArrayList<Employee> list = gui.getController()
               .executeGetEmployees();
         for (int i = 0; i < list.size(); i++)
         {
            if (list.get(i).getUsername().equals(usernameField.getText()))
                  {
               gui.setLoggedPerson(list.get(i));
                  }
         }
            gui.closeWindowEmployee();
      }
      else if (gui.getController()
            .validateLogin(usernameField.getText(), passwordField.getText())
            .equals("teamLeader"))
      {
         gui.closeWindowTeamLeader();
      }
      errorLabel.setText(gui.getController()
            .validateLogin(usernameField.getText(), passwordField.getText()));
   }

   @FXML
   public void cancelButtonPressed()
   {
      Platform.exit();
   }
}
