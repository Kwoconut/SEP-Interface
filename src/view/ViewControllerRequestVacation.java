package view;

public class ViewControllerRequestVacation
{

   private WorkPlanningToolGUI gui;
   
   public ViewControllerRequestVacation(WorkPlanningToolGUI gui)
   {
      this.gui = gui;
   }
   
   public void BacktoScheduleButton()
   {
      gui.BacktoScheduleButton();
   }
}
