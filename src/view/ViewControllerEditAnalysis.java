package view;
   import java.util.ArrayList;
   import javafx.collections.FXCollections;
   import javafx.collections.ObservableList;
   import javafx.fxml.FXML;
   import javafx.scene.control.Alert;
   import javafx.scene.control.ButtonType;
   import javafx.scene.control.TableColumn;
   import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import model.Analysis;
import model.Employee;
   import model.EmployeeList;
import model.MyDate;
import model.WorkPlanningToolModelManager;

   public class ViewControllerEditAnalysis
   {
      @FXML
      private TextField MatrixTextField;

      @FXML
      private TextField AnalysisTextField;
      
      @FXML
      private TextField WeekTextField;


      private WorkPlanningToolGUI gui;

      public ViewControllerEditAnalysis(WorkPlanningToolGUI gui)
      {
         this.gui = gui;
      }
      
      public void init()
      {
         MatrixTextField.setText(gui.getRememberData().getMatrix());
         AnalysisTextField.setText(gui.getRememberData().getType());
         WeekTextField.setText(gui.getRememberData().getWeek());
      }


      @FXML
      private void EditAnalysis()
      {
         gui.getController().executeEditAnalysis(gui.getRememberData(), AnalysisTextField.getText(), MatrixTextField.getText(), WeekTextField.getText());
         gui.getController().executeUpdateAnalysis();
         gui.ManageATButtonPressed();
      }

      

      @FXML
      private void CancelOperation()
      {
         gui.closeEditAnalysisWindow();
      }
   }  


