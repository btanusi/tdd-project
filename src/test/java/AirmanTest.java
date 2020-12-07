import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.*;

public class AirmanTest {
    Airman airman;

    @BeforeEach
    void initialize(){
        airman = new Airman(1234);
    }
    //Given I am an Airman,
    // when I check my leave availability on January 1,
    // I expect that I have 30 days of leave available.
    @Test
    void checkLeaveOnJan1Returns30Days() {
        int expected = 30;
        int actual = airman.checkLeave();
        assertEquals(expected, actual);
    }
    //Given I am an Airman who has taken at least 1 day off,
    // when I click to check my available # of days off remaining,
    // I expect to see a number of days less than 30.
    @Test
    void takeDayOffCausesLeaveToDecrease(){
        airman.takeDayOff();
        assertTrue(airman.checkLeave() < 30);
    }

    //Given I am an Airman,
    // when I submit a request for leave,
    // I expect to see a message confirming my request has been submitted to the admins.
    @Test
    void requestLeaveReturnsMessageConfirmingThatRequestIsSubmittedToAdmins(){
        String msg = airman.requestLeave(new Date(2020, 1, 1));
        assertEquals("Request has been submitted to admins.",msg);
    }

    //Given I am an Airman,
    // when I submit a request for leave but have NO leave remaining,
    // I expect to see a message indicating that I have 0 days off remaining.
    @Test
    void requestLeaveWithNoRemainingLeaveReturnsMessageToNotify(){
        int currentLeave = 30;
        while(currentLeave > 0){
            currentLeave--;
            airman.takeDayOff();
        }
        String msg = airman.requestLeave(new Date(2020, 1, 1));
        assertEquals("You have 0 days off remaining.", msg);
    }

    //Given I am an Airman,
    // when I click on my OPEN REQUESTS,
    // I can view my own leave requests to see if they have been updated.
    @Test
    void viewOpenRequestsReturnsLeaveRequests(){
        Date day1 = new Date(2020, 1, 1);
        Date day2 = new Date(2020, 2, 2);
        airman.requestLeave(day1);
        airman.requestLeave(day2);
        HashMap<Date, Boolean> expected = new HashMap<Date, Boolean>();
        expected.put(day1, false);
        expected.put(day2, false);
        HashMap<Date, Boolean> actual = airman.viewOpenRequests();

        assertTrue(actual.equals(expected));
    }

}