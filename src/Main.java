import controller.WorkPlanningToolController;
import model.Analysis;
import model.Employee;
import model.MyDate;
import model.Name;
import model.Vacation;
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
        
        
        
        System.out.println(model.getVacationList().getVacationByEmployee(model.getEmployeeList().getEmployee(0)));
        
        view.start(controller);
   }

}
