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
        
        
/*        model.addEmployee(new Employee(new Name("Valeriu","Marandici"),"VM777","Hates ma-ta"));
        model.addEmployee(new Employee(new Name("Gheorge","Romanciuc"),"GR210","Loves dick"));
        model.addEmployee(new Employee(new Name("Angel","Somicu"),"AS350","Loves redheads"));
        model.addEmployee(new Employee(new Name("Andrei","Abalasei"),"AB560","Sluga"));
        model.updateEmployeeListFile();
        model.updateEmployeeSecurityFile();
        
        Analysis analysis = new Analysis("Fat","Fat",2,MyDate.now());
        Analysis analysis2 = new Analysis("Sugar","Sugar",3,new MyDate(13,12,2018));
        
        model.addAnalysis(analysis);
        model.addAnalysis(analysis2);
        model.assignEmployee(analysis, model.getEmployeeList().getEmployee(1));
        model.assignEmployee(analysis, model.getEmployeeList().getEmployee(2));
        model.assignEmployee(analysis2, model.getEmployeeList().getEmployee(3));
        model.assignEmployee(analysis2, model.getEmployeeList().getEmployee(0));
        model.updateAnalysisListFile();
        
        model.requestVacation(new Vacation(model.getEmployeeList().getEmployee(2),"Reason",new MyDate(13,12,2018),new MyDate(14,12,2018)));
        model.updateVacationListFile();*/
        
/*        model.requestVacation(new Vacation(model.getEmployeeList().getEmployee(1),"Reason",new MyDate(15,12,2018),new MyDate(15,12,2018)));
        model.approveVacation(0);
        model.updateVacationListFile();*/
        
        
        
        view.start(controller);
   }
}