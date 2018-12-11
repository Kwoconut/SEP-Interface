package view;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ViewControllerManageEmployee
{
   @FXML
   private TableView<TableRowData> scheduleListTable;
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


      ArrayList<Object[]> employees = gui.getController()
            .executeGetHiredEmployees();
      ObservableList<TableRowData> tableData = FXCollections
            .observableArrayList();

      for (int i = 0; i < employees.size(); i++)
      {
         tableData.add(new TableRowData(employees.get(i)));
      }
      scheduleListTable.setItems(tableData);

   }
   @FXML public void backToScheduleButtonPressed()
   {   
      gui.BacktoScheduleBtt();
   }
   @FXML public void hireEmployeeButtonPressed()
   {   
      gui.openHireEmployeeWindow();
   }
}