import codigo.System.Administrator;
import codigo.System.Playground;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AdministratorTest {

    private Administrator administrator;
    Playground playground1 = new Playground();
    Playground playground2 = new Playground();
   
    @Before
    public void setUp() {
        administrator = new Administrator();
        playground1 = new Playground();
        playground2 = new Playground();
    }

    @Test
    public void testplaygroundRequests() {
        administrator.playgroundRequests(playground1);
        administrator.playgroundRequests(playground2);
        assertTrue(administrator.Requested.contains(playground1));
        assertTrue(administrator.Requested.contains(playground2));
    }
    
    @Test
    public void testapprovePlayground() {
        systemIn.provideLines("yes","yes");
        administrator.approvePlayground();
        assertTrue(administrator.Approved.contains(playground1));
        assertTrue(administrator.Approved.contains(playground2));
    }


    // @Test
    // public void testAddComplaints() {
    //     String complaint = "Test complaint";
    //     administrator.addComplaints(complaint);

    //     assertTrue(administrator.complaints.contains(complaint));
    // }

    // @Test
    // public void testSuspendPlayground() {
    //     Playground playground = new Playground();
    //     Administrator.Approved.add(playground);

    //     administrator.suspendPlayground(playground.getName());

    //     assertTrue(administrator.suspended.contains(playground));
    //     assertTrue(!Administrator.Approved.contains(playground));
    // }

}
