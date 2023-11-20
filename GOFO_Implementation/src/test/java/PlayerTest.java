import codigo.System.Player;
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

public class PlayerTest {

     private final InputStream originalSystemIn = System.in;
     private final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

     @Rule
     public final TextFromStandardInputStream systemIn = TextFromStandardInputStream.emptyStandardInputStream();

     @Rule
     public final ExpectedSystemExit exit = ExpectedSystemExit.none();

     Player player;
   
     //@Before
     //public void setUp() {
     //    playgrounds = new PlayGroundSchedule();
     //    assertEquals(5, playgrounds.getDayIndex("thursday"));
     //}

     @Test
     public void testSetBalance(){
         player.setBalance(10);
         assertEquals(10, player.getBalance());
     }

}
