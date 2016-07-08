import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Suryaraj Timsina on 6/28/16.
 */
@WebServlet(name = "EditServlet")
public class EditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String id = request.getParameter("id");

        DatabaseConnection databaseConnection = new DatabaseConnection();

        request.setAttribute("task",databaseConnection.edit(id));
        request.getRequestDispatcher("/edit.jsp").forward(request,response);
    }
}
