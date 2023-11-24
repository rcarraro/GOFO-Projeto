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
import java.io.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class AdministratorTest {

    private final InputStream originalSystemIn = System.in;
    private final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Rule
    public final TextFromStandardInputStream systemIn = TextFromStandardInputStream.emptyStandardInputStream();

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    private Administrator administrator;
    Playground playground1;
    Playground playground2;
   
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
        //complaints
        administrator.addComplaints("Bla bla bla");
    }
    
    @Test
    public void testsearchByName() {
        System.setOut(new PrintStream(outContent));
        administrator.searchByName("teste1");
        System.out.println(outContent.toString());
        assertEquals(true, systemOutRule.getLog().contains("Allowed cancellation time till 0 Before the booked time"));
    }
    
    // @Test
    // public void testsearchByLocation() {
    //     administrator.searchByName("SP");
    // }
    
    // @Test
    // public void testdisplayAllavailablePlaygroundsLocations() {
    //     administrator.displayAllavailablePlaygroundsLocations();
    // }
    
    // @Test
    // public void testdisplayAllavailablePlaygroundsNames() {
    //     administrator.displayAllavailablePlaygroundsNames();
    // }
    
    // @Test 
    // public void testbookByLocation() {
    //     systemIn.provideLines("SP", "1", "1", "10", "sunday"); // dias: sunday, monday, tuesday, wendesday, thursday, friday, saturday
    //     administrator.bookByLocation("OS", "testuser", 123);
    // }

    // @Test 
    // public void testbookByName() {
    //     systemIn.provideLines("10", "10", "monday"); // dias: sunday, monday, tuesday, wendesday, thursday, friday, saturday
    //     administrator.bookByName("teste1", "testuser", 123456);
    // }
    
    // @Test 
    // public void testsuspendPlayground() {
    //         administrator.suspendPlayground("teste1");
    //     }
        
    // @Test 
    // public void testsuspendPlayground_wrongname() {
    //     systemIn.provideLines("teste1");
    //     administrator.suspendPlayground("teste1321");
    // }
    
    // @Test 
    // public void testsuspendPlayground2x() {
    //     administrator.suspendPlayground("teste1");
    //     assertThrows(RuntimeException.class, () -> administrator.suspendPlayground("teste1"));
    // }
        
    // @Test 
    // public void testdeletePlayground() {
    //     administrator.deletePlayground("teste1");
    // }
        
    // @Test 
    // public void testdeletePlayground_wrongname() {
    //     systemIn.provideLines("teste1");
    //     administrator.deletePlayground("teste123123");
    // }

    // @Test
    // public void testdeletePlayground2x() {
    //     administrator.deletePlayground("teste1");
        
    //     assertThrows(RuntimeException.class, () -> administrator.deletePlayground("teste1"));
    // }

    // @Test
    // public void testunSuspendPlaygroundyes() {
    //     administrator.suspendPlayground("teste1");
    //     systemIn.provideLines("yes");
    //     administrator.unSuspendPlayground();
    // }
    
    // @Test
    // public void testunSuspendPlaygroundno() {
    //     administrator.suspendPlayground("teste2");
    //     systemIn.provideLines("no");
    //     administrator.unSuspendPlayground();
    // }

    
    // @Test
    // public void testshowComplaints() {
    //     administrator.showComplaints();
    // }


    @After
    public void restoreSystemInputOutput() {
        System.setIn(originalSystemIn);
    }
}
