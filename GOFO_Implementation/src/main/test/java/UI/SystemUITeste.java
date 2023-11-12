import codigo.System.Administrator;
import codigo.System.Player;
import codigo.System.PlaygroundOwner;
import codigo.UI.SystemUI;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.junit.Assert.assertEquals;

public class SystemUITeste {

    private final InputStream originalSystemIn = System.in;
    private final PrintStream originalSystemOut = System.out;
    private static final Logger LOGGER = LoggerFactory.getLogger(SystemUI.class);

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    @Rule
    public final TextFromStandardInputStream systemInMock = TextFromStandardInputStream.emptyStandardInputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @After
    public void restoreSystemInAndOut() {
        System.setIn(originalSystemIn);
        System.setOut(originalSystemOut);
    }

    @Test
    public void testRegisterPlayer() {
        SystemUI sistema = new SystemUI();
        
        LOGGER.info("This is a log message.");
        System.out.println("This is a log message.");
        sistema.register();

        systemInMock.provideText("Rafael");
        systemInMock.provideText("Martins");
        systemInMock.provideText("123");
        systemInMock.provideText("teste123");
        systemInMock.provideText("carrarorafa@gmail.com");
        systemInMock.provideText("123456789");
        systemInMock.provideText("SP");
        systemInMock.provideText("player");
        systemInMock.provideText("123");
        
        assertEquals("Successfully verified!\n", outputStream.toString());
    } 

    // @Test
    // public void testRegisterPlayer() {
    //     IntegerAsker asker = mock(IntegerAsker.class);
    //     when(asker.ask(anyString())).thenReturn("Rafael");
    //     when(asker.ask(anyString())).thenReturn("Martins");
    //     when(asker.ask(anyString())).thenReturn(123);
    //     when(asker.ask(anyString())).thenReturn("teste123");
    //     when(asker.ask(anyString())).thenReturn("carrarorafa@gmail.com");
    //     when(asker.ask(anyString())).thenReturn(123456789);
    //     when(asker.ask(anyString())).thenReturn("SP");
    //     when(asker.ask(anyString())).thenReturn("player");
    //     when(asker.ask(anyString())).thenReturn(123);

    //     assertEquals("Successfully verified!\n", outputStream.toString());
    // }

    // @Test
    // public void testLoginPlayer() {
    //     Player player = new Player();
    //     player.setEmail("john.doe@example.com");
    //     player.setPassword("password");
    //     ArrayList<Player> players = new ArrayList<>();
    //     players.add(player);

    //     SystemUI.thePlayers = players;

    //     String simulatedInput = "john.doe@example.com\npassword\n";
    //     provideInput(simulatedInput);

    //     SystemUI.Login();

    //     assertEquals("Logged in successfully\n", outputStream.toString());
    // }

    // @Test
    // public void testComplaintForm() {
    //     Administrator admin = new Administrator();
    //     SystemUI.admin = admin;

    //     PlaygroundOwner owner = new PlaygroundOwner();
    //     owner.setEmail("owner@example.com");
    //     ArrayList<PlaygroundOwner> owners = new ArrayList<>();
    //     owners.add(owner);
    //     SystemUI.theOwners = owners;

    //     String simulatedInput = "playground owner\nowner@example.com\nComplaint about the owner\n";
    //     provideInput(simulatedInput);

    //     SystemUI.complaintForm();

    //     assertEquals("User found!!\n", outputStream.toString());
    // }

    // private void provideInput(String data) {
    //     ByteArrayInputStream inputStream = new ByteArrayInputStream(data.getBytes());
    //     System.setIn(inputStream);
    // }
}
