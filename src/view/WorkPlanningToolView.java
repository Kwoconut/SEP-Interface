package view;

import controller.WorkPlanningToolController;

public interface WorkPlanningToolView
{
   public void start(WorkPlanningToolController controller);
   public String[] getInput(String type);
   public void showOutput(String... output);
   public void showError(String error);
}
