package view;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.MyDate;

public class ViewControllerScheduleTL
{
   @FXML
   private TableView<TableRowData> scheduleListTable;
   @FXML
   private TableColumn<TableRowData, String> columnID;
   @FXML
   private TableColumn<TableRowData, String> columnName;
   @FXML
   private TableColumn<TableRowData, String> columnData1;
   @FXML
   private TableColumn<TableRowData, String> columnData2;
   @FXML
   private TableColumn<TableRowData, String> columnData3;
   @FXML
   private TableColumn<TableRowData, String> columnData4;
   @FXML
   private TableColumn<TableRowData, String> columnData5;
   @FXML
   private TableColumn<TableRowData, String> columnData6;


   private WorkPlanningToolGUI gui;

   public ViewControllerScheduleTL(WorkPlanningToolGUI gui)
   {
      this.gui = gui;
   }

   public void init()
   {
      columnID.setCellValueFactory(
            cellData -> cellData.getValue().getStringProperty(0));
      columnName.setCellValueFactory(
            cellData -> cellData.getValue().getStringProperty(1));
      MyDate todayDate = MyDate.now();
      columnData1.setText(todayDate.toString());
      todayDate.stepForwardOneDay();
      columnData2.setText(todayDate.toString());
      todayDate.stepForwardOneDay();
      columnData3.setText(todayDate.toString());
      todayDate.stepForwardOneDay();
      columnData4.setText(todayDate.toString());
      todayDate.stepForwardOneDay();
      columnData5.setText(todayDate.toString());
      todayDate.stepForwardOneDay();
      columnData6.setText(todayDate.toString());
      columnData1.setCellValueFactory(
            cellData -> cellData.getValue().getStringProperty(2));
      columnData2.setCellValueFactory(
            cellData -> cellData.getValue().getStringProperty(3));
      columnData3.setCellValueFactory(
            cellData -> cellData.getValue().getStringProperty(4));
      columnData4.setCellValueFactory(
            cellData -> cellData.getValue().getStringProperty(5));
      columnData5.setCellValueFactory(
            cellData -> cellData.getValue().getStringProperty(6));
      columnData6.setCellValueFactory(
            cellData -> cellData.getValue().getStringProperty(7));
      

      ArrayList<Object[]> employees = gui.getController()
            .executeGetHiredEmployeesScheduleStatus();
      ObservableList<TableRowData> tableData = FXCollections
            .observableArrayList();

      for (int i = 0; i < employees.size(); i++)
      {
         tableData.add(new TableRowData(employees.get(i)));
      }
      scheduleListTable.setItems(tableData);

   }
}