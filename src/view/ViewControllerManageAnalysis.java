package view;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.MyDate;

public class ViewControllerManageAnalysis
{
   @FXML
   private TableView<TableRowData> AnalysisListTable;
   @FXML
   private TableColumn<TableRowData, String> matrix;
   @FXML
   private TableColumn<TableRowData, String> week;
   @FXML
   private TableColumn<TableRowData, String> analysis;
   @FXML
   private TableColumn<TableRowData, String> day1;
   @FXML
   private TableColumn<TableRowData, String> day2;
   @FXML
   private TableColumn<TableRowData, String> day3;
   @FXML
   private TableColumn<TableRowData, String> day4;
   @FXML
   private TableColumn<TableRowData, String> day5;
   @FXML
   private TableColumn<TableRowData, String> day6;

   private WorkPlanningToolGUI gui;

   public ViewControllerManageAnalysis(WorkPlanningToolGUI gui)
   {
      this.gui = gui;
   }

   public void init()
   {
      matrix.setCellValueFactory(
            cellData -> cellData.getValue().getStringProperty(0));
/*      week.setCellValueFactory(
            cellData -> cellData.getValue().getStringProperty(1));
      analysis.setCellValueFactory(
            cellData -> cellData.getValue().getStringProperty(2));*/

      MyDate todayDate = MyDate.now();
      day1.setText(todayDate.toString());
      todayDate.stepForwardOneDay();
      day2.setText(todayDate.toString());
      todayDate.stepForwardOneDay();
      day3.setText(todayDate.toString());
      todayDate.stepForwardOneDay();
      day4.setText(todayDate.toString());
      todayDate.stepForwardOneDay();
      day5.setText(todayDate.toString());
      todayDate.stepForwardOneDay();
      day6.setText(todayDate.toString());

      ArrayList<Object[]> employees = gui.getController().executeGetMatrix();
      ObservableList<TableRowData> tableData = FXCollections
            .observableArrayList();

      for (int i = 0; i < employees.size(); i++)
      {
         tableData.add(new TableRowData(employees.get(i)));
      }
      AnalysisListTable.setItems(tableData);
      ((TableView<TableRowData>) tableData).getSelectionModel().setCellSelectionEnabled(true);
      
   }
   

   @FXML
   public void BacktoScheduleBtt()
   {
      gui.BacktoScheduleBtt();
   }

}
