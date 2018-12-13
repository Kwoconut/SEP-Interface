package view;

import java.time.format.DateTimeFormatter;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import model.Analysis;
import model.MyDate;

public class ViewControllerCreateAnalysis
{
   @FXML
   private TextField MatrixTextField;

   @FXML
   private TextField AnalysisTextField;
   
   @FXML
   private TextField WeekTextField;

   @FXML
   private TextField NrOfEmployeeTextField;

   @FXML
   private DatePicker DateDatePicker;

   @FXML
   private WorkPlanningToolGUI gui;

   public ViewControllerCreateAnalysis(WorkPlanningToolGUI gui)
   {
      this.gui = gui;
   }

   @FXML
   private void CreateAnalysis()
   {

      Analysis analysis = new Analysis(AnalysisTextField.getText(),
            MatrixTextField.getText(), WeekTextField.getText(),
            Integer.parseInt(NrOfEmployeeTextField.getText()),
            new MyDate(DateDatePicker.getValue().getDayOfMonth(),
                  DateDatePicker.getValue().getMonthValue(),
                  DateDatePicker.getValue().getYear()));
      gui.getController().executeAddAnalysis(analysis);
      gui.getController().executeUpdateAnalysis();
      gui.ManageATButtonPressed();
   }

   @FXML
   private void CancelOperation()
   {
      gui.CloseCreateAnalysisWindow();
   }

}
