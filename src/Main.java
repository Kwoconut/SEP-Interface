import controller.WorkPlanningToolController;
import model.Employee;
import model.Name;
import model.WorkPlanningToolModel;
import model.WorkPlanningToolModelManager;
import view.WorkPlanningToolGUI;
import view.WorkPlanningToolView;

public class Main
{
   public static void main(String[] args)
   {
        WorkPlanningToolView view = new WorkPlanningToolGUI();  
        WorkPlanningToolModel model = new WorkPlanningToolModelManager();
        WorkPlanningToolController controller = new WorkPlanningToolController(model,view);
        
        
        
        view.start(controller);
   }

}
