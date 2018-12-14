package view;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Employee;
import model.Name;

public class ViewControllerSetTraining
{
   private WorkPlanningToolGUI gui;
   @FXML
   private Label Type1Label;
   @FXML
   private Label Type2Label;
   @FXML
   private Label Type3Label;
   @FXML
   private Label Type4Label;
   @FXML
   private Label Type5Label;
   @FXML
   private Label Type6Label;
   @FXML
   private Label Type7Label;
   @FXML
   private Label Type8Label;
   @FXML
   private Label Type9Label;
   @FXML
   private Label textLabel;
   private int index;

   public ViewControllerSetTraining(WorkPlanningToolGUI gui)
   {
      this.gui = gui;
   }
   public void init(int index)
   {
      this.index = index;
      textLabel.setText("Setting trainings for "+ gui.getController().getName(index)+ " " + gui.getController().getLastName(index));
   }
   @FXML public void ApproveButtonPressed()
   {
      gui.getController().executeUpdateEmployeeList();
      gui.openManageEmployeeWindow();
   }
   @FXML public void TrainedButtonPressed1()
   {
      gui.getController().TrainedButtonPressed1(index);
      Type1Label.setText("Trained");
   }
   @FXML public void TrainedButtonPressed2()
   {
      gui.getController().TrainedButtonPressed2(index);
      Type2Label.setText("Trained");
   }
   @FXML public void TrainedButtonPressed3()
   {
      gui.getController().TrainedButtonPressed3(index);
      Type3Label.setText("Trained");
   }
   @FXML public void TrainedButtonPressed4()
   {
      gui.getController().TrainedButtonPressed4(index);
      Type4Label.setText("Trained");
   }
   @FXML public void TrainedButtonPressed5()
   {
      gui.getController().TrainedButtonPressed5(index);
      Type5Label.setText("Trained");
   }
   @FXML public void TrainedButtonPressed6()
   {
      gui.getController().TrainedButtonPressed6(index);
      Type6Label.setText("Trained");
   }
   @FXML public void TrainedButtonPressed7()
   {
      gui.getController().TrainedButtonPressed7(index);
      Type7Label.setText("Trained");
   }
   @FXML public void TrainedButtonPressed8()
   {
      gui.getController().TrainedButtonPressed8(index);
      Type8Label.setText("Trained");
   }
   @FXML public void TrainedButtonPressed9()
   {
      gui.getController().TrainedButtonPressed9(index);
      Type9Label.setText("Trained");
   }
   @FXML public void NotTrainedButtonPressed1()
   {
      gui.getController().NotTrainedButtonPressed1(index);
      Type1Label.setText("Not Trained");
   }
   @FXML public void NotTrainedButtonPressed2()
   {
      gui.getController().NotTrainedButtonPressed2(index);
      Type2Label.setText("Not Trained");
   }
   @FXML public void NotTrainedButtonPressed3()
   {
      gui.getController().NotTrainedButtonPressed3(index);
      Type3Label.setText("Not Trained");
   }
   @FXML public void NotTrainedButtonPressed4()
   {
      gui.getController().NotTrainedButtonPressed4(index);
      Type4Label.setText("Not Trained");
   }
   @FXML public void NotTrainedButtonPressed5()
   {
      gui.getController().NotTrainedButtonPressed5(index);
      Type5Label.setText("Not Trained");
   }
   @FXML public void NotTrainedButtonPressed6()
   {
      gui.getController().NotTrainedButtonPressed6(index);
      Type6Label.setText("Not Trained");
   }
   @FXML public void NotTrainedButtonPressed7()
   {
      gui.getController().NotTrainedButtonPressed7(index);
      Type7Label.setText("Not Trained");
   }
   @FXML public void NotTrainedButtonPressed8()
   {
      gui.getController().NotTrainedButtonPressed8(index);
      Type8Label.setText("Not Trained");
   }
   @FXML public void NotTrainedButtonPressed9()
   {
      gui.getController().NotTrainedButtonPressed9(index);
      Type9Label.setText("Not Trained");
   }


   
   
}
