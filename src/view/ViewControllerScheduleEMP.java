package view;

import java.util.ArrayList;

import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import model.Employee;
import model.MyDate;

public class ViewControllerScheduleEMP
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

   public ViewControllerScheduleEMP(WorkPlanningToolGUI gui)
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
      
      
      columnData1.setCellFactory(new Callback<TableColumn<TableRowData, String>, 
            TableCell<TableRowData, String>>()
            {
                @Override
                public TableCell<TableRowData, String> call(
                        TableColumn<TableRowData, String> param)
                {
                    return new TableCell<TableRowData, String>()
                    {
                        @Override
                        protected void updateItem(String item, boolean empty)
                        {
                            if (!empty)
                            {
                                int currentIndex = indexProperty()
                                        .getValue() < 0 ? 0
                                        : indexProperty().getValue();
                                StringProperty type = param
                                        .getTableView().getItems()
                                        .get(currentIndex).getStringProperty(2);
                                if (type.get().equals(Employee.status_available))
                                {
                                   setStyle("-fx-background-color: green");
                                   setText(type.get());
                                }
                                else if (type.get().equals(Employee.status_unavailable))
                                {
                                   setStyle("-fx-background-color: red");
                                   setText(type.get());
                                }
                                else if (type.get().equals(Employee.status_vacationPending))
                                {
                                   setStyle("-fx-background-color: yellow");
                                   setText(type.get());
                                }
                                else if (type.get().equals(Employee.status_vacation))
                                {
                                   setStyle("-fx-background-color: orange");
                                   setText(type.get());
                                }
                                else if (type.get().equals(Employee.status_ontraining))
                                {
                                   setStyle("-fx-background-color: purple");
                                   setText(type.get());
                                }
                                else
                                {
                                   setStyle("-fx-background-color: blue");
                                   setText(type.get());
                                }
                                
                            }
                        }
                    };
                }
            });

      
      /////////////////////////
      columnData2.setCellFactory(new Callback<TableColumn<TableRowData, String>, 
            TableCell<TableRowData, String>>()
            {
                @Override
                public TableCell<TableRowData, String> call(
                        TableColumn<TableRowData, String> param)
                {
                    return new TableCell<TableRowData, String>()
                    {
                        @Override
                        protected void updateItem(String item, boolean empty)
                        {
                            if (!empty)
                            {
                                int currentIndex = indexProperty()
                                        .getValue() < 0 ? 0
                                        : indexProperty().getValue();
                                StringProperty type = param
                                        .getTableView().getItems()
                                        .get(currentIndex).getStringProperty(3);
                                if (type.get().equals(Employee.status_available))
                                {
                                   setStyle("-fx-background-color: green");
                                   setText(type.get());
                                }
                                else if (type.get().equals(Employee.status_unavailable))
                                {
                                   setStyle("-fx-background-color: red");
                                   setText(type.get());
                                }
                                else if (type.get().equals(Employee.status_vacationPending))
                                {
                                   setStyle("-fx-background-color: yellow");
                                   setText(type.get());
                                }
                                else if (type.get().equals(Employee.status_vacation))
                                {
                                   setStyle("-fx-background-color: orange");
                                   setText(type.get());
                                }
                                else if (type.get().equals(Employee.status_ontraining))
                                {
                                   setStyle("-fx-background-color: purple");
                                   setText(type.get());
                                }
                                else
                                {
                                   setStyle("-fx-background-color: blue");
                                   setText(type.get());
                                }
                                
                            }
                        }
                    };
                }
            });
      
        
      /////////////////////////
      columnData3.setCellFactory(new Callback<TableColumn<TableRowData, String>, 
            TableCell<TableRowData, String>>()
            {
                @Override
                public TableCell<TableRowData, String> call(
                        TableColumn<TableRowData, String> param)
                {
                    return new TableCell<TableRowData, String>()
                    {
                        @Override
                        protected void updateItem(String item, boolean empty)
                        {
                            if (!empty)
                            {
                                int currentIndex = indexProperty()
                                        .getValue() < 0 ? 0
                                        : indexProperty().getValue();
                                StringProperty type = param
                                        .getTableView().getItems()
                                        .get(currentIndex).getStringProperty(4);
                                if (type.get().equals(Employee.status_available))
                                {
                                   setStyle("-fx-background-color: green");
                                   setText(type.get());
                                }
                                else if (type.get().equals(Employee.status_unavailable))
                                {
                                   setStyle("-fx-background-color: red");
                                   setText(type.get());
                                }
                                else if (type.get().equals(Employee.status_vacationPending))
                                {
                                   setStyle("-fx-background-color: yellow");
                                   setText(type.get());
                                }
                                else if (type.get().equals(Employee.status_vacation))
                                {
                                   setStyle("-fx-background-color: orange");
                                   setText(type.get());
                                }
                                else if (type.get().equals(Employee.status_ontraining))
                                {
                                   setStyle("-fx-background-color: purple");
                                   setText(type.get());
                                }
                                else
                                {
                                   setStyle("-fx-background-color: blue");
                                   setText(type.get());
                                }
                                
                            }
                        }
                    };
                }
            });
      
      
      /////////////////////////
      columnData4.setCellFactory(new Callback<TableColumn<TableRowData, String>, 
            TableCell<TableRowData, String>>()
            {
                @Override
                public TableCell<TableRowData, String> call(
                        TableColumn<TableRowData, String> param)
                {
                    return new TableCell<TableRowData, String>()
                    {
                        @Override
                        protected void updateItem(String item, boolean empty)
                        {
                            if (!empty)
                            {
                                int currentIndex = indexProperty()
                                        .getValue() < 0 ? 0
                                        : indexProperty().getValue();
                                StringProperty type = param
                                        .getTableView().getItems()
                                        .get(currentIndex).getStringProperty(5);
                                if (type.get().equals(Employee.status_available))
                                {
                                   setStyle("-fx-background-color: green");
                                   setText(type.get());
                                }
                                else if (type.get().equals(Employee.status_unavailable))
                                {
                                   setStyle("-fx-background-color: red");
                                   setText(type.get());
                                }
                                else if (type.get().equals(Employee.status_vacationPending))
                                {
                                   setStyle("-fx-background-color: yellow");
                                   setText(type.get());
                                }
                                else if (type.get().equals(Employee.status_vacation))
                                {
                                   setStyle("-fx-background-color: orange");
                                   setText(type.get());
                                }
                                else if (type.get().equals(Employee.status_ontraining))
                                {
                                   setStyle("-fx-background-color: purple");
                                   setText(type.get());
                                }
                                else
                                {
                                   setStyle("-fx-background-color: blue");
                                   setText(type.get());
                                }
                                
                            }
                        }
                    };
                }
            });

      
      /////////////////////////
      columnData5.setCellFactory(new Callback<TableColumn<TableRowData, String>, 
            TableCell<TableRowData, String>>()
            {
                @Override
                public TableCell<TableRowData, String> call(
                        TableColumn<TableRowData, String> param)
                {
                    return new TableCell<TableRowData, String>()
                    {
                        @Override
                        protected void updateItem(String item, boolean empty)
                        {
                            if (!empty)
                            {
                                int currentIndex = indexProperty()
                                        .getValue() < 0 ? 0
                                        : indexProperty().getValue();
                                StringProperty type = param
                                        .getTableView().getItems()
                                        .get(currentIndex).getStringProperty(6);
                                if (type.get().equals(Employee.status_available))
                                {
                                   setStyle("-fx-background-color: green");
                                   setText(type.get());
                                }
                                else if (type.get().equals(Employee.status_unavailable))
                                {
                                   setStyle("-fx-background-color: red");
                                   setText(type.get());
                                }
                                else if (type.get().equals(Employee.status_vacationPending))
                                {
                                   setStyle("-fx-background-color: yellow");
                                   setText(type.get());
                                }
                                else if (type.get().equals(Employee.status_vacation))
                                {
                                   setStyle("-fx-background-color: orange");
                                   setText(type.get());
                                }
                                else if (type.get().equals(Employee.status_ontraining))
                                {
                                   setStyle("-fx-background-color: purple");
                                   setText(type.get());
                                }
                                else
                                {
                                   setStyle("-fx-background-color: blue");
                                   setText(type.get());
                                }
                                
                            }
                        }
                    };
                }
            });
   
      
      //////////////////////////
      columnData6.setCellFactory(new Callback<TableColumn<TableRowData, String>, 
            TableCell<TableRowData, String>>()
            {
                @Override
                public TableCell<TableRowData, String> call(
                        TableColumn<TableRowData, String> param)
                {
                    return new TableCell<TableRowData, String>()
                    {
                        @Override
                        protected void updateItem(String item, boolean empty)
                        {
                            if (!empty)
                            {
                                int currentIndex = indexProperty()
                                        .getValue() < 0 ? 0
                                        : indexProperty().getValue();
                                StringProperty type = param
                                        .getTableView().getItems()
                                        .get(currentIndex).getStringProperty(7);
                                if (type.get().equals(Employee.status_available))
                                {
                                   setStyle("-fx-background-color: green");
                                   setText(type.get());
                                }
                                else if (type.get().equals(Employee.status_unavailable))
                                {
                                   setStyle("-fx-background-color: red");
                                   setText(type.get());
                                }
                                else if (type.get().equals(Employee.status_vacationPending))
                                {
                                   setStyle("-fx-background-color: yellow");
                                   setText(type.get());
                                }
                                else if (type.get().equals(Employee.status_vacation))
                                {
                                   setStyle("-fx-background-color: orange");
                                   setText(type.get());
                                }
                                else if (type.get().equals(Employee.status_ontraining))
                                {
                                   setStyle("-fx-background-color: purple");
                                   setText(type.get());
                                }
                                else
                                {
                                   setStyle("-fx-background-color: blue");
                                   setText(type.get());
                                }
                                
                            }
                        }
                    };
                }
            });
   }
   
   @FXML
   public void requestVacationButtonPressed()
   {
      gui.openRequestVacationWindow();
   }
}