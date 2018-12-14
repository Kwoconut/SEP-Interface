package view;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import model.Analysis;
import model.Employee;


public class ViewControllerAssignEmployee
{
   @FXML
   private TableView<TableRowData> employeeAvailable;
   @FXML
   private TableColumn<TableRowData, String> AvailableEmployeeList;
   @FXML
   private TableColumn<TableRowData, String> preferences;

   private WorkPlanningToolGUI gui;


   public ViewControllerAssignEmployee(WorkPlanningToolGUI gui)
   {
      this.gui = gui;
   }

   public void init()
   {
      AvailableEmployeeList.setCellValueFactory(
            cellData -> cellData.getValue().getStringProperty(0));
      preferences.setCellValueFactory(
            cellData -> cellData.getValue().getStringProperty(1));
      

      ArrayList<Object[]> employees = gui.getController()
            .executeGetEmployeesTrained(gui.getRememberData().getType());
      ObservableList<TableRowData> tableData = FXCollections
            .observableArrayList();

      for (int i = 0; i < employees.size(); i++)
      {
         tableData.add(new TableRowData(employees.get(i)));
      }
      employeeAvailable.setItems(tableData);
   }

   @FXML
      private void assignEmployeeButton()
      {
         Alert alert = new Alert(AlertType.CONFIRMATION, "Assign Employee " + employeeAvailable.getSelectionModel().getSelectedItem().getData(0) + " ?", ButtonType.YES, ButtonType.CANCEL);
         alert.showAndWait();

         if (alert.getResult() == ButtonType.YES) 
         {
           
           ArrayList<Employee> list = gui.getController().executeGetTrainedEmployees(gui.getRememberData().getType());
            for (int i = 0;i < list.size();i++)
            {
               if (i == employeeAvailable.getSelectionModel().getSelectedIndex())
               {
                  gui.getController().executeAssignEmployee(gui.getRememberData(),list.get(i));
                  gui.getController().executeUpdateAnalysis();
                  gui.CloseAssignEmployeeWindow();                  
               }
            }
         }
      }

   

   @FXML
   private void CancelOperation()
   {
      gui.CloseAssignEmployeeWindow();
   }
}