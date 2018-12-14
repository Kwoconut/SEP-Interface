package view;

import java.util.ArrayList;
import java.util.Optional;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.EmployeeList;
import javafx.scene.control.Alert.AlertType;

public class ViewControllerManageEmployee
{
   @FXML
   private TableView<TableRowData> ListTable;
   @FXML
   private TableColumn<TableRowData, String> columnID;
   @FXML
   private TableColumn<TableRowData, String> columnName;
   @FXML
   private TableColumn<TableRowData, String> columnTrainingStatus;
   @FXML
   private TableColumn<TableRowData, String> columnType1;
   @FXML
   private TableColumn<TableRowData, String> columnType2;
   @FXML
   private TableColumn<TableRowData, String> columnType3;
   @FXML
   private TableColumn<TableRowData, String> columnType4;
   @FXML
   private TableColumn<TableRowData, String> columnType5;
   @FXML
   private TableColumn<TableRowData, String> columnType6;
   @FXML
   private TableColumn<TableRowData, String> columnType7;
   @FXML
   private TableColumn<TableRowData, String> columnType8;
   @FXML
   private TableColumn<TableRowData, String> columnType9;
   @FXML
   private Label changeLabel;
   


   private WorkPlanningToolGUI gui;

   public ViewControllerManageEmployee(WorkPlanningToolGUI gui)
   {
      this.gui = gui;
   }

   public void init()
   {
      columnID.setCellValueFactory(
            cellData -> cellData.getValue().getStringProperty(0));
      columnName.setCellValueFactory(
            cellData -> cellData.getValue().getStringProperty(1));
      columnType1.setCellValueFactory(
            cellData -> cellData.getValue().getStringProperty(2));
      columnType2.setCellValueFactory(
            cellData -> cellData.getValue().getStringProperty(3));
      columnType3.setCellValueFactory(
            cellData -> cellData.getValue().getStringProperty(4));
      columnType4.setCellValueFactory(
            cellData -> cellData.getValue().getStringProperty(5));
      columnType5.setCellValueFactory(
            cellData -> cellData.getValue().getStringProperty(6));
      columnType6.setCellValueFactory(
            cellData -> cellData.getValue().getStringProperty(7));
      columnType7.setCellValueFactory(
            cellData -> cellData.getValue().getStringProperty(8));
      columnType8.setCellValueFactory(
            cellData -> cellData.getValue().getStringProperty(9));
      columnType9.setCellValueFactory(
            cellData -> cellData.getValue().getStringProperty(10));

      ArrayList<Object[]> employees = gui.getController()
            .executeGetHiredEmployees();
      
      ObservableList<TableRowData> tableData = FXCollections
            .observableArrayList();

      for (int i = 0; i < employees.size(); i++)
      {
         tableData.add(new TableRowData(employees.get(i)));
      }
      ListTable.setItems(tableData);

   }
   
   public void clearTable()
   {
      ListTable.getItems().clear();
   }
   
   public void init2()
   {

      
      columnID.setCellValueFactory(
            cellData -> cellData.getValue().getStringProperty(0));
      columnName.setCellValueFactory(
            cellData -> cellData.getValue().getStringProperty(1));
      columnType1.setCellValueFactory(
            cellData -> cellData.getValue().getStringProperty(2));
      columnType2.setCellValueFactory(
            cellData -> cellData.getValue().getStringProperty(3));
      columnType3.setCellValueFactory(
            cellData -> cellData.getValue().getStringProperty(4));
      columnType4.setCellValueFactory(
            cellData -> cellData.getValue().getStringProperty(5));
      columnType5.setCellValueFactory(
            cellData -> cellData.getValue().getStringProperty(6));
      columnType6.setCellValueFactory(
            cellData -> cellData.getValue().getStringProperty(7));
      columnType7.setCellValueFactory(
            cellData -> cellData.getValue().getStringProperty(8));
      columnType8.setCellValueFactory(
            cellData -> cellData.getValue().getStringProperty(9));
      columnType9.setCellValueFactory(
            cellData -> cellData.getValue().getStringProperty(10));

      ArrayList<Object[]> hiddenEmployees = gui.getController()
            .executeShowHiddenEmployees();
      
      ObservableList<TableRowData> tableData = FXCollections
            .observableArrayList();

      for (int i = 0; i < hiddenEmployees.size(); i++)
      {
         tableData.add(new TableRowData(hiddenEmployees.get(i)));
      }
      
      ListTable.setItems(tableData);

   }
   @FXML public void backToScheduleButtonPressed()
   {   
      gui.BacktoScheduleBtt();
   }
   @FXML public void hireEmployeeButtonPressed()
   {   
      gui.openHireEmployeeWindow();
   }
   @FXML
   private void removeEmployeeButtonPressed()
   {
      int index;
      index=ListTable.getSelectionModel().getSelectedIndex();
      if (index == -1)
      {
         changeLabel.setText("Please select the employee");
         return;
      }
      Alert alert = new Alert(AlertType.CONFIRMATION, "Remove Employee " + ListTable.getSelectionModel().getSelectedItem().getData(1) + " ?", ButtonType.YES, ButtonType.CANCEL);
      alert.showAndWait();

      if (alert.getResult() == ButtonType.YES) 
      {
         
         gui.getController().executeRemoveEmployee(index);
         gui.getController().executeUpdateEmployeeList();
         gui.openManageEmployeeWindow();
      }
   }
   @FXML
   private void editEmployeeButtonPressed()
   {
      int index2;
      index2=ListTable.getSelectionModel().getSelectedIndex();
      if (index2 == -1)
      {
         changeLabel.setText("Please select the employee");
         return;
      }
      int index = ListTable.getSelectionModel().getSelectedIndex();
      gui.rememberIndex(index);
      
      gui.editEmployeeButtonPressed();
   }

   @FXML
   private void showHiddenButtonPressed()
   {
      gui.openManageEmployeeShowHiddenWindow();
   }
   @FXML
   private void setTrainingButtonPressed()
   {
      int index;
      index=ListTable.getSelectionModel().getSelectedIndex();
      if (index == -1)
      {
         changeLabel.setText("Please select the employee");
         return;
      }
      gui.setTrainingButtonPressed(index);
   }
   

   
}