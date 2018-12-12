package view;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Vacation;
import model.MyDate;

public class ViewControllerRequestVacation
{

   @FXML
   private DatePicker startDatePicker;

   @FXML
   private DatePicker endDatePicker;

   @FXML
   private TextArea reasonTextField;

   private WorkPlanningToolGUI gui;

   public ViewControllerRequestVacation(WorkPlanningToolGUI gui)
   {
      this.gui = gui;
   }

   public void BacktoScheduleButton()
   {
      gui.BacktoScheduleButton();
   }

   public void requestVacationButtonPressed()
   {
      Vacation vacation = new Vacation(gui.getLoggedPerson(),
            reasonTextField.getText(),
            new MyDate(startDatePicker.getValue().getDayOfMonth(),
                  startDatePicker.getValue().getMonthValue(),
                  startDatePicker.getValue().getYear()),
            new MyDate(endDatePicker.getValue().getDayOfMonth(),
                  endDatePicker.getValue().getMonthValue(),
                  endDatePicker.getValue().getYear()));
      gui.getController().executeRequestVacation(vacation);
      gui.BacktoScheduleButton();
   }

}
