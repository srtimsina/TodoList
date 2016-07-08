import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Suryaraj Timsina on 6/28/16.
 */
public class DatabaseConnection {

    private String url = "jdbc:mysql://localhost:3306/todolist";
    private String userName = "root";
    private String password = "";
    private String driver = "com.mysql.jdbc.Driver";
    public Connection connection = null;


    public DatabaseConnection(){

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, userName, password);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean DatabaseConnect(Task tasks)
    {

        try
        {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, userName, password);

            PreparedStatement preparedStatement = connection.prepareStatement("insert into tasklist(task,startdate,duedate,status) values(?,?,?,?)");

            preparedStatement.setString(1,tasks.getTask());
            preparedStatement.setString(2,tasks.getStartdate());
            preparedStatement.setString(3,tasks.getEnddate());
            preparedStatement.setString(4,tasks.getStatus());

            if(preparedStatement.executeUpdate()>0){
                return true;
            }


        }catch(Exception ex)
        {
            ex.printStackTrace();
        }

        return false;
    }

    public List<Task> getTaskList() throws Exception {

        PreparedStatement preparedStatement = connection.prepareStatement("select * from tasklist");
        ResultSet rs = preparedStatement.executeQuery();

        List<Task> taskList = new LinkedList<Task>();
        while (rs.next()){

            Task tasks = new Task();

            tasks.setId(rs.getString("id"));
            tasks.setStatus(rs.getString("status"));
            tasks.setStartdate(rs.getString("startdate"));
            tasks.setEnddate(rs.getString("duedate"));
            tasks.setTask(rs.getString("task"));

            taskList.add(tasks);

        }

        return taskList;
    }

    public boolean delete(String id){

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from tasklist where id = ?");

            preparedStatement.setString(1,id);

            if(preparedStatement.executeUpdate() > 0){
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }


    public Task edit(String id){

        Task task = new Task();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select from tasklist where id = ?");

            preparedStatement.setString(1,id);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                task.setId(rs.getString("id"));
                task.setTask(rs.getString("task"));
                task.setStartdate(rs.getString("startdate"));
                task.setEnddate(rs.getString("duedate"));
                task.setStatus(rs.getString("status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return task;
    }

    public boolean auth(String username,String password){

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select *from user where username= ? and password = ?");

            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);

            if(preparedStatement.executeQuery().next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

}
