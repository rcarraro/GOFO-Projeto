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
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class PlaygroundTest {

    private final InputStream originalSystemIn = System.in;
    private final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream systemIn = TextFromStandardInputStream.emptyStandardInputStream();

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    Playground playground;
   
    @Before
    public void setUp() {
        playground = new Playground();
        systemIn.provideLines("available");
        playground.setStatus();
        playground.setName("playgroundtest");
        playground.setOwner("testeuser");
    }
    
    @Test
    public void testsetCancellationPeriod(){
        playground.setCancellationPeriod(123);
    }
    
    @Test
    public void testsetStatusanotvailable(){
        systemIn.provideLines("not available");
        playground.setStatus();
    }

    @Test
    public void testsetPricenormal(){
        systemIn.provideLines("250");
        playground.setPrice();
    }

    @Test
    public void testsetPricenotnormal(){
        systemIn.provideLines("asd");
        assertThrows(RuntimeException.class, () -> playground.setPrice());
    }

    @Test
    public void testsetPricenotnormal2(){
        systemIn.provideLines("-10");
        assertThrows(RuntimeException.class, () -> playground.setPrice());
    }

    @Test
    public void testsetLocation(){
        systemIn.provideLines("SP");
        playground.setLocation();
    }

    @Test
    public void testsetBooking(){
        systemIn.provideLines("0", "10");
        playground.setBooking();
    }

    @Test
    public void testbookingTheSlot(){
        playground.bookingTheSlot("testuser", "10", "sunday");
    }
    
    @Test
    public void testcancelBooking(){
        playground.bookingTheSlot("testuser", "10", "sunday");
        playground.cancelBooking("sunday", "10");
    }

    @After
    public void restoreSystemInputOutput() {
        System.setIn(originalSystemIn);
    }
}
