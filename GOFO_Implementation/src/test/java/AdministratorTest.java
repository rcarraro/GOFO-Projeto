import codigo.UI.SystemUI;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import java.io.InputStream;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AdministratorTest {

    private final InputStream originalSystemIn = System.in;
    private final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream systemIn = TextFromStandardInputStream.emptyStandardInputStream();

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

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
    public void searchByName() {
        administrator.playgroundRequests(playground1);
        administrator.playgroundRequests(playground2);

        systemIn.provideLines("yes","yes");
        
        administrator.approvePlayground();
        playground1.setName("teste1");
        administrator.searchByName("teste1");

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
    @After
    public void restoreSystemInputOutput() {
        System.setIn(originalSystemIn);
    }
}
