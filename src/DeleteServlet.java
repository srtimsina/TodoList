import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Suryaraj Timsina on 6/28/16.
 */
@WebServlet(name = "DeleteServlet")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");

        System.out.println(id);
        DatabaseConnection databaseConnection = new DatabaseConnection();

        if(databaseConnection.delete(id)){
            try {
                request.setAttribute("taskList", databaseConnection.getTaskList());
                request.getRequestDispatcher("Output.jsp").forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
