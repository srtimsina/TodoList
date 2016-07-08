import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Suryaraj Timsina on 7/8/16.
 */
@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String username = request.getParameter("username");
        String password = request.getParameter("pwd");

        DatabaseConnection databaseConnection = new DatabaseConnection();

        if(databaseConnection.auth(username,password)){

            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("username", username.toUpperCase());
            try {
                request.setAttribute("taskList", databaseConnection.getTaskList());
            } catch (Exception e) {
                e.printStackTrace();
            }
            request.getRequestDispatcher("Output.jsp").forward(request, response);

        }else {
            request.setAttribute("message",true);
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        session.invalidate();

        request.getRequestDispatcher("/login.jsp").forward(request,response);
    }
}
