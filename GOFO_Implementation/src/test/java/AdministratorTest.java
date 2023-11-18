import codigo.System.Administrator;
import codigo.System.Playground;
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
        administrator.playgroundRequests(playground1);
        administrator.playgroundRequests(playground2);
        
        //locais
        systemIn.provideLines("SP");
        playground1.setLocation();
        systemIn.provideLines("RJ");
        playground2.setLocation();
        //aprovar
        systemIn.provideLines("yes","yes");
        
        administrator.approvePlayground();
        //Nomes
        playground1.setName("teste1");
        playground2.setName("teste2");
        //Preço
        systemIn.provideLines("100");
        playground1.setPrice();
        systemIn.provideLines("200");
        playground2.setPrice();
        //status
        systemIn.provideLines("available");
        playground1.setStatus();
        systemIn.provideLines("available");
        playground2.setStatus();
        //schedule
        systemIn.provideLines("0","30");
        playground1.setBooking();
        systemIn.provideLines("0","30");
        playground2.setBooking();
    }
    
    // @Test
    // public void testsearchByName() {
    //     administrator.searchByName("teste1");
    // }
    
    // @Test
    // public void testsearchByLocation() {
    //     administrator.searchByName("SP");
    // }
    
    // @Test
    // public void testdisplayAllavailablePlaygroundsLocations() {
    //     administrator.displayAllavailablePlaygroundsLocations();
    // }
    
    // @Test
    // public void testdisplayAllPlaygroundsLocations() {
    //     administrator.displayAllavailablePlaygroundsLocations();
    // }
    
    // @Test
    // public void testdisplayAllavailablePlaygroundsNames() {
    //     administrator.displayAllavailablePlaygroundsNames();
    // }
    
    @Test 
    public void testbookBy_wrongLocation_wronguser() {
        systemIn.provideLines("SP", "1", "1", "10", "10");
        administrator.bookByLocation("OS", "testuser", 123);
        //input temp errado
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
