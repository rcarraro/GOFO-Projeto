import codigo.System.Administrator;
import codigo.System.Playground;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AdministratorTest {

    private Administrator administrator;

    @Before
    public void setUp() {
        administrator = new Administrator();
    }

    @Test
    public void testapprovePlayground() {
        Playground playground1 = new Playground();
        Playground playground2 = new Playground();
        administrator.Approved.add(playground1);
        administrator.Approved.add(playground2);

        administrator.displayAllPlaygrounds();
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
