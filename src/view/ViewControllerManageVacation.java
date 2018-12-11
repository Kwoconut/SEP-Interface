package view;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.MyDate;

public class ViewControllerManageVacation
{
   @FXML
   private TableView<TableRowData> scheduleListTable;
   @FXML
   private TableColumn<TableRowData, String> columnID;
   @FXML
   private TableColumn<TableRowData, String> columnName;
   @FXML
   private TableColumn<TableRowData, String> columnStartDate;
   @FXML
   private TableColumn<TableRowData, String> columnEndDate;
   
   private WorkPlanningToolGUI gui;

   public ViewControllerManageVacation(WorkPlanningToolGUI gui)
   {
      this.gui = gui;
   }
   
   public void init()
   {
      columnName.setCellValueFactory(
            cellData -> cellData.getValue().getStringProperty(1));
      columnID.setCellValueFactory(
            cellData -> cellData.getValue().getStringProperty(0));
      MyDate startDate = MyDate.now();
      MyDate endDate = MyDate.now();
      columnStartDate.setText(startDate.toString());
      columnEndDate.setText(endDate.toString());


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
   
   @FXML public void backToScheduleButoonPressed()
   {   
      gui.BacktoScheduleBtt();
   }
}