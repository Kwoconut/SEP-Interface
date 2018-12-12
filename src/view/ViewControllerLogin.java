package view;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
   
   @FXML public void loginButtonPressed()
   {
      if (gui.getController().validateLogin(usernameField.getText(), passwordField.getText()).equals("employee"))
      {
         gui.closeWindowEmployee();
      }
      else if (gui.getController().validateLogin(usernameField.getText(), passwordField.getText()).equals("teamLeader"))
      {
         gui.closeWindowTeamLeader();
      }
         errorLabel.setText(gui.getController().validateLogin(usernameField.getText(), passwordField.getText()));
   }
   
   @FXML public void cancelButtonPressed()
   {
      Platform.exit();
   }
}
