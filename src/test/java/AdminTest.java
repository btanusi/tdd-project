import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.*;

public class AdminTest {
    Admin admin;
    Airman airman1;
    Airman airman2;

    @BeforeEach
    void initialize() {
        admin = new Admin();
        airman1 = new Airman(1234);
        airman2 = new Airman(5678);
    }

    //Given I am an admin,
    // when I click on "All Users Remaining Days Off" button,
    // I expect to see all users (by ID or name) and the number of available days off they still have.
    @Test
    void allUsersRemainingDaysOffReturnsAllUsersAndNumOfAvailDaysOff() {
        airman1.takeDayOff();
        airman2.takeDayOff();
        airman2.takeDayOff();
        HashMap<Integer, Integer> expected = new HashMap<Integer, Integer>();
        expected.put(1234, 29);
        expected.put(5678, 28);
        admin.addAirman(airman1);
        admin.addAirman(airman2);
        HashMap<Integer, Integer> actual = admin.allUsersRemainingDaysOff();
        assertTrue(actual.equals(expected));
    }

    //Given I am an admin,
    // when I click the "Open Requests" button,
    // I expect to see a list of requests that show me
    // the ID or name of the Airman,
    // total # of days off remaining
    // and total # of days requested.

}