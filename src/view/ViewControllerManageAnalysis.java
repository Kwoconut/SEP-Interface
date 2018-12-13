package view;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Analysis;
import model.MyDate;

public class ViewControllerManageAnalysis
{
   @FXML
   private TableView<TableRowData> AnalysisListTable;
   @FXML
   private TableColumn<TableRowData, String> matrix;
   @FXML
   private TableColumn<TableRowData, String> analysis;
   @FXML
   private TableColumn<TableRowData, String> week;
   @FXML
   private TableColumn<TableRowData, Number> nrOfEmployee;
   @FXML
   private TableColumn<TableRowData, String> date;
   @FXML
   private TableColumn<TableRowData, String> PersonsAssigned;

   private WorkPlanningToolGUI gui;

   public ViewControllerManageAnalysis(WorkPlanningToolGUI gui)
   {
      this.gui = gui;
   }

   public void init()
   {
      matrix.setCellValueFactory(
            cellData -> cellData.getValue().getStringProperty(0));
      analysis.setCellValueFactory(
            cellData -> cellData.getValue().getStringProperty(1));
      week.setCellValueFactory(
            cellData -> cellData.getValue().getStringProperty(2));
      nrOfEmployee.setCellValueFactory(
            cellData -> cellData.getValue().getIntegerProperty(3));

      MyDate todayDate = MyDate.now();
      date.setText(todayDate.toString());
      todayDate.stepForwardOneDay();

      date.setCellValueFactory(
            cellData -> cellData.getValue().getStringProperty(4));

      PersonsAssigned.setCellValueFactory(
            cellData -> cellData.getValue().getStringProperty(5));

      ArrayList<Object[]> analysis = gui.getController()
            .executeGetAnalysisData();
      ObservableList<TableRowData> tableData = FXCollections
            .observableArrayList();

      for (int i = 0; i < analysis.size(); i++)
      {
         tableData.add(new TableRowData(analysis.get(i)));
      }
      AnalysisListTable.setItems(tableData);
   }

   @FXML
   public void BacktoScheduleBtt()
   {
      gui.BacktoScheduleBtt();
   }

   @FXML
   public void CreateAnalysisWinodw()
   {
      gui.openCreateAnalysisWindow();
   }

   @FXML
   public void AssignEmployeeBtt()
   {
      ArrayList<Analysis> list = gui.getController().executeGetAnalysis();
      int index = AnalysisListTable.getSelectionModel().getSelectedIndex();
      for (int i = 0; i < list.size(); i++)
      {
           if (i == index)
           {
              gui.SetRememberData(list.get(i));
           }
      }
      gui.openAssignEmployeeWindow();
   }

   @FXML
   private void DeleteAnalysisButtonPressed()
   {
      Alert alert = new Alert(AlertType.CONFIRMATION,
            "Remove Analysis " + AnalysisListTable.getSelectionModel()
                  .getSelectedItem().getData(1) + " ?",
            ButtonType.YES, ButtonType.CANCEL);
      alert.showAndWait();

      if (alert.getResult() == ButtonType.YES)
      {
         int index;
         index = AnalysisListTable.getSelectionModel().getSelectedIndex();
         gui.getController().executeRemoveAnalysis(index);
         gui.getController().executeUpdateAnalysis();
         gui.ManageATButtonPressed();
      }
   }

   public void getDataFromTable1()
   {
      ArrayList<Analysis> list = gui.getController().executeGetAnalysis();
      int index = AnalysisListTable.getSelectionModel().getSelectedIndex();
      for (int i = 0; i < list.size(); i++)
      {
           if (i == index)
           {
              gui.SetRememberData(list.get(i));
           }
      }
   }

}
