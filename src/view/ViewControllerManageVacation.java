package view;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.MyDate;

public class ViewControllerManageVacation
{
   @FXML
   private TableView<TableRowData> vacationListTable;
   @FXML
   private TableColumn<TableRowData, String> columnID;
   @FXML
   private TableColumn<TableRowData, String> columnName;
   @FXML
   private TableColumn<TableRowData, String> columnStartDate;
   @FXML
   private TableColumn<TableRowData, String> columnEndDate;
   @FXML
   private TableColumn<TableRowData, String> columnReason;
   @FXML
   private TableColumn<TableRowData, String> columnChecked;
   
   private WorkPlanningToolGUI gui;

   public ViewControllerManageVacation(WorkPlanningToolGUI gui)
   {
      this.gui = gui;
   }
   
   public void init()
   {
      columnName.setCellValueFactory(
            cellData -> cellData.getValue().getStringProperty(0));
      columnID.setCellValueFactory(
            cellData -> cellData.getValue().getStringProperty(1));
      columnStartDate.setCellValueFactory(
            cellData -> cellData.getValue().getStringProperty(2));
      columnEndDate.setCellValueFactory(
            cellData -> cellData.getValue().getStringProperty(3));
      columnReason.setCellValueFactory(
            cellData -> cellData.getValue().getStringProperty(4));
      columnChecked.setCellValueFactory(
            cellData -> cellData.getValue().getStringProperty(5));


      ArrayList<Object[]> vacations = gui.getController()
            .executeGetVacations(); 
      ObservableList<TableRowData> tableData = FXCollections
            .observableArrayList();
      
      
      for (int i = 0; i < vacations.size(); i++)
      {
         tableData.add(new TableRowData(vacations.get(i)));
      }
      vacationListTable.setItems(tableData);

   }
   
   @FXML public void BacktoScheduleBtt()
   {
      gui.BacktoScheduleBtt();
   }
   
   @FXML public void approveVacationButoonPressed()
   {
      Alert alert = new Alert(AlertType.CONFIRMATION, "Approve Vacation " + vacationListTable.getSelectionModel().getSelectedItem().getData(1) + " ?", ButtonType.YES, ButtonType.CANCEL);
      alert.showAndWait();
      
      if (alert.getResult() == ButtonType.YES)
      {
         int index;
         index=vacationListTable.getSelectionModel().getSelectedIndex();
         gui.getController().executeApproveVacation(index);;
         gui.openManageVacationWindow();
      }
   }
   
   @FXML
   private void declineVacationButoonPressed()
   {
      Alert alert = new Alert(AlertType.CONFIRMATION, "Decline Vacation " + vacationListTable.getSelectionModel().getSelectedItem().getData(1) + " ?", ButtonType.YES, ButtonType.CANCEL);
      alert.showAndWait();

      if (alert.getResult() == ButtonType.YES) 
      {
         int index;
         index=vacationListTable.getSelectionModel().getSelectedIndex();
         gui.getController().executeDeclineVacation(index);
         gui.openManageVacationWindow();
      }
   }
}