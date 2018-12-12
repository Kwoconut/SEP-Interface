package view;

import controller.WorkPlanningToolController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class WorkPlanningToolGUI extends Application
      implements WorkPlanningToolView
{
   private WorkPlanningToolController controller;
   private ViewControllerLogin viewControllerLogin;
   private ViewControllerScheduleTL viewControllerScheduleTL;
   private ViewControllerManageVacation viewControllerManageVacation;
   private ViewControllerManageEmployee viewControllerManageEmployee;
   private ViewControllerHireEmployee viewControllerHireEmployee;
   private Stage primaryStage;
   private Scene primaryScene;
   private ViewControllerManageAnalysis viewControllerManageAnalysis;
   private ViewControllerScheduleEMP viewControllerScheduleEMP;
   private static WorkPlanningToolGUI me;

   public WorkPlanningToolGUI()
   {
      if (me == null)
      {
         me = this;
      }
   }

   public void start(WorkPlanningToolController controller)
   {
      this.controller = controller;

      new Thread(new Runnable()
      {
         public void run()
         {
            Application.launch(WorkPlanningToolGUI.class);
         }
      }).start();
   }

   public void start(Stage primaryStage)
   {
      if (this != me)
      {
         me.start(primaryStage);
         return;
      }
      me.viewControllerManageVacation = null;
      me.primaryStage = primaryStage;
      me.viewControllerLogin = new ViewControllerLogin(me);
      openWindow(primaryStage, "WindowLogin.fxml", this.viewControllerLogin,
            600, 400, "Login");
      this.primaryScene = primaryStage.getScene();

   }

   private void openWindow(Stage primaryStage, String fxmlFile,
         Object viewController, int width, int height, String title)
   {
      try
      {
         FXMLLoader loader = new FXMLLoader();
         loader.setLocation(WorkPlanningToolGUI.class.getResource(fxmlFile));
         loader.setController(viewController);
         Pane root = (Pane) loader.load();
         Scene scene = new Scene(root, width, height);
         scene.getStylesheets()
               .add(getClass().getResource("application.css").toExternalForm());
         primaryStage.setScene(scene);
         primaryStage.setTitle(title);
         primaryStage.show();
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }
   
   public void openManageVacationWindow()
   {
         this.viewControllerManageVacation = new ViewControllerManageVacation(this);
         openWindow(primaryStage, "WindowManageVacation.fxml", viewControllerManageVacation,
               600, 400, "Grade list");
   }
   
   
   public void closeWindowTeamLeader()
   {
      if (this.viewControllerScheduleTL == null)
      {
         this.viewControllerScheduleTL = new ViewControllerScheduleTL(this);
         openWindow(primaryStage, "WindowScheduleTL.fxml",
         this.viewControllerScheduleTL, 1000, 500, "Schedule");
         this.viewControllerScheduleTL.init();
         this.primaryScene = primaryStage.getScene();         
      }
      else
      {
         primaryStage.getScene().getWindow().hide();
         primaryStage.setScene(primaryScene);
         primaryStage.show();
         me.viewControllerLogin = null;
      }
   }
   
   public void closeWindowEmployee()
   {
      if (this.viewControllerScheduleEMP == null)
      {
         this.viewControllerScheduleEMP = new ViewControllerScheduleEMP(this);
         openWindow(primaryStage, "WindowScheduleEMP.fxml",
         this.viewControllerScheduleEMP, 1000, 500, "Schedule");
         this.viewControllerScheduleEMP.init();
         this.primaryScene = primaryStage.getScene();         
      }
      else
      {
         primaryStage.getScene().getWindow().hide();
         primaryStage.setScene(primaryScene);
         primaryStage.show();
         me.viewControllerLogin = null;
      }
   }
   
   public void openManageEmployeeWindow()
   {
         this.viewControllerManageEmployee = new ViewControllerManageEmployee(this);
         openWindow(primaryStage, "WindowManageEmployee.fxml",
         this.viewControllerManageEmployee, 1280, 400, "WindowManageEmployee");
         this.viewControllerManageEmployee.init();
         this.primaryScene = primaryStage.getScene();         
   }
   
   public void openHireEmployeeWindow()
   {
         this.viewControllerHireEmployee = new ViewControllerHireEmployee(this);
         openWindow(primaryStage, "WindowHireEmployee.fxml",
         this.viewControllerHireEmployee, 800, 400, "WindowHireEmployee");
         this.primaryScene = primaryStage.getScene();         
   }
   
   
   public void BacktoScheduleBtt()
   {
      this.viewControllerScheduleTL = new ViewControllerScheduleTL(this);
      openWindow(primaryStage, "WindowScheduleTL.fxml",
      this.viewControllerScheduleTL, 1000, 500, "Schedule");
      this.viewControllerScheduleTL.init();
      this.primaryScene = primaryStage.getScene();  
   }
   
   public void ManageATButtonPressed()
   {
      this.viewControllerManageAnalysis = new ViewControllerManageAnalysis(this);
      openWindow(primaryStage, "WindowManageAnalysis.fxml", viewControllerManageAnalysis,
            1000, 500, "Manage Analysis");
      this.viewControllerManageAnalysis.init();
   }
   

   public String[] getInput(String type)
   {
      return null;
   }

   public void showOutput(String... output)
   {

   }

   public void showError(String error)
   {

   }
   
   public WorkPlanningToolController getController()
   {
      return controller;
   }

}
