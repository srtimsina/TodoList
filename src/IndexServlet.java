import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Suryaraj Timsina on 6/28/16.
 */
public class IndexServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        Task task = new Task();

        String tasks = request.getParameter("task");
        String sdate = request.getParameter("sdate");
        String edate = request.getParameter("edate");
        String status = request.getParameter("status");

        task.setTask(tasks);
        task.setStatus(status);
        task.setStartdate(sdate);
        task.setEnddate(edate);


        DatabaseConnection databaseConnection = new DatabaseConnection();
        databaseConnection.DatabaseConnect(task);

        try {
            request.setAttribute("taskList", databaseConnection.getTaskList());
            request.getRequestDispatcher("Output.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        HttpSession session = request.getSession();

        if(session.getAttribute("username")!=null){
            DatabaseConnection databaseConnection = new DatabaseConnection();
            try {
                request.setAttribute("taskList", databaseConnection.getTaskList());
            } catch (Exception e) {
                e.printStackTrace();
            }
            request.getRequestDispatcher("Output.jsp").forward(request, response);
        }
        else {
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    }
}
