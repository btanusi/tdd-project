import java.util.HashMap;

public class Admin {
    private HashMap<Integer, Integer> airmenDaysOff;

    public Admin(){
        airmenDaysOff = new HashMap<Integer, Integer>();
    }

    public void addAirman(Airman airman) {
        airmenDaysOff.put(airman.getID(), airman.checkLeave());
    }

    public HashMap<Integer, Integer> allUsersRemainingDaysOff() {
        return airmenDaysOff;
    }
}
