import java.util.Date;
import java.util.HashMap;

public class Airman {

    private int ID;
    private int leave;
    private Date currentDate;
    private HashMap<Date, Boolean> openLeave;

    public Airman(int myID){
        ID = myID;
        leave = 30;
        currentDate = new Date(2020, 1, 1);
        openLeave = new HashMap<Date, Boolean>();
    }

    public int checkLeave() {
        return leave;
    }

    public void takeDayOff() {
        if (leave > 0){
            leave--;
        }
    }

    public String requestLeave(Date inputDate) {
        openLeave.put(inputDate, false);
        if(leave == 0){
            return "You have 0 days off remaining.";
        } else{
            return "Request has been submitted to admins.";
        }
    }

    public HashMap<Date, Boolean> viewOpenRequests() {
        return openLeave;
    }

    public Integer getID() {
        return ID;
    }
}
