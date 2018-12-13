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
import model.Employee;
import model.EmployeeList;
import model.WorkPlanningToolModelManager;

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

      ArrayList<Object[]> analysis = gui.getController()
            .executeGetEmployeesData();
      ObservableList<TableRowData> tableData = FXCollections
            .observableArrayList();

      for (int i = 0; i < analysis.size(); i++)
      {
         tableData.add(new TableRowData(analysis.get(i)));
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
            
/*            index = employeeAvailable.getSelectionModel().getSelectedIndex();
            WorkPlanningToolModelManager ws = new WorkPlanningToolModelManager();
            EmployeeList employees = ws.readEmployeeListFile();
            Employee e = new Employee();
            System.out.println(employeeAvailable.getSelectionModel().getSelectedItem().getData(0).toString());
            System.out.println(gui.getRememberData());
            for(int i = 0; i< employees.size() ; i++) {
               if(employees.getEmployee(i).getName().equals(employeeAvailable.getSelectionModel().getSelectedItem().getData(0))){
               e = employees.getEmployee(i);
               System.out.println(e.toString());
               }
            
            }*/
            
            ArrayList<Employee> list = gui.getController().executeGetEmployees();
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