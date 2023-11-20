import codigo.System.Player;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
//import java.io.ByteArrayOutputStream;
//import java.io.InputStream;
import java.io.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class PlayerTest {

     private final InputStream originalSystemIn = System.in;
     private final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
     final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

     @Rule
     public final TextFromStandardInputStream systemIn = TextFromStandardInputStream.emptyStandardInputStream();

     @Rule
     public final ExpectedSystemExit exit = ExpectedSystemExit.none();

     Player player;
   
     @Before
     public void setUp() {
         player = new Player();
     }

     @Test
     public void testSetBalance(){
         player.setBalance(10);
         assertEquals(10, player.getBalance());
     }

     @Test
     public void testGetMoney(){
         player.setBalance(10);
         player.getMoney(10);
         assertEquals(20, player.getBalance());
     }

     @Test
     public void testViewInboxEmpty(){
          System.setOut(new PrintStream(outContent));
          player.viewInbox();
          assertEquals("Your Inbox is Empty\n", outContent.toString());
     }

     @Test
     public void testViewInbox(){
          System.setOut(new PrintStream(outContent));
          player.addInbox("Oi");
          player.viewInbox();
          assertEquals("Message No.1: Oi\n", outContent.toString());
     }

     @Test
     public void testEditPlayerInfoName(){
          systemIn.provideLines("1", "Amanda");
          player.editPlayerinfo();
     }

     @Test
     public void testEditPlayerInfoSurname(){
          systemIn.provideLines("2", "Martins");
          player.editPlayerinfo();
     }

     @Test
     public void testEditPlayerInfoId(){
          systemIn.provideLines("3", "1111111111");
          player.editPlayerinfo();
     }

     @Test
     public void testEditPlayerInfoEmail(){
          systemIn.provideLines("4", "teste@email.com");
          player.editPlayerinfo();
     }

     @Test
     public void testEditPlayerInfoPhone(){
          systemIn.provideLines("5", "1111111111");
          player.editPlayerinfo();
     }

     @Test
     public void testEditPlayerInfoLocal(){
          systemIn.provideLines("6", "São Bernardo do Campo");
          player.editPlayerinfo();
     }

     @Test
     public void testEditPlayerInfoPassword(){
          systemIn.provideLines("7", "senhateste");
          player.editPlayerinfo();
     }

}
