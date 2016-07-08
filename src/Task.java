/**
 * Created by Suryaraj Timsina on 6/28/16.
 */
public class Task {
    String  id ;
    String task;
    String status ;
    String startdate;
    String enddate ;

    public void setId(String id) {
        this.id = id;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getId() {
        return id;
    }

    public String getTask() {
        return task;
    }

    public String getStatus() {
        return status;
    }

    public String getStartdate() {
        return startdate;
    }

    public String getEnddate() {
        return enddate;
    }
}
