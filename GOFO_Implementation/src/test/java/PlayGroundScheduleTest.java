import codigo.System.PlayGroundSchedule;
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

public class PlayGroundScheduleTest {

    private final InputStream originalSystemIn = System.in;
    private final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream systemIn = TextFromStandardInputStream.emptyStandardInputStream();

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    PlayGroundSchedule playgrounds;
   
    @Before
    public void setUp() {
        playgrounds = new PlayGroundSchedule();
        assertEquals(5, playgrounds.getDayIndex("thursday"));
    }
    
    @Test
    public void testgetDayIndex1(){
        assertEquals(1, playgrounds.getDayIndex("sunday"));
    }
    @Test
    public void testgetDayIndex2(){
        assertEquals(2, playgrounds.getDayIndex("monday"));
    }
    @Test
    public void testgetDayIndex3(){
        assertEquals(3, playgrounds.getDayIndex("tuesday"));
    }
    @Test
    public void testgetDayIndex4(){
        assertEquals(4, playgrounds.getDayIndex("wendesday"));
    }
    @Test
    public void testgetDayIndex5(){
        assertEquals(5, playgrounds.getDayIndex("thursday"));
    }
    @Test
    public void testgetDayIndex6(){
        assertEquals(6, playgrounds.getDayIndex("friday"));
    }
    @Test
    public void testgetDayIndex7(){
        assertEquals(7, playgrounds.getDayIndex("saturday"));
    }
    @Test
    public void testgetDayIndexother(){
        assertEquals(-1, playgrounds.getDayIndex("asd"));
    }
    @Test
    public void testsetPrice(){
        systemIn.provideLines("50");
        playground.setPrice();
    }
    @Test
    public void testsetPricewrong(){
        systemIn.provideLines("asd");
        assertThrows(RuntimeException.class, () -> playground.setPrice());
    }
    @Test
    public void testsetPricewrongneg(){
        systemIn.provideLines("-10");
        assertThrows(RuntimeException.class, () -> playground.setPrice());
    }
    
    @Test
    public void testbookSlot(){
        playground.bookSlot("testuser", "0", "monday");
    }
    
    @Test
    public void testbookSlotother(){
        playground.bookSlot("testuser", "100", "monday");
    }
    
    @Test
    public void testbookSlototherday(){
        playground.bookSlot("testuser", "0", "asd");
    }

    @Test
    public void testupdateSlot(){
        playground.updateSlot("testuser", "0", "monday");
    }

    @Test
    public void testupdateSlotother(){
        playground.updateSlot("testuser", "100", "monday");
    }
    
    @Test
    public void testupdateSlototherday(){
        playground.updateSlot("testuser", "0", "asd");
    }

    @Test
    public void testsetschedule(){
        systemIn.provideLines("0");
        systemIn.provideLines("2");
        playground.setschedule();
    }

    @After
    public void restoreSystemInputOutput() {
        System.setIn(originalSystemIn);
    }
}
