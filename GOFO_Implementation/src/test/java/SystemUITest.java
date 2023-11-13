import System.Administrator;
import System.Player;
import System.PlaygroundOwner;
import System.PlaygroundOwner;
import UI.SystemUI;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class SystemUITest {

    private final InputStream originalSystemIn = System.in;
    private final PrintStream originalSystemOut = System.out;

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

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
        String simulatedInput = "John\nDoe\n123\npassword\njohn.doe@example.com\n456\nCity\nplayer\n";
        provideInput(simulatedInput);
        SystemUI sistema = new SystemUI();
        sistema.register();

        assertEquals("Successfully verified!\n", outputStream.toString());
    }

    @Test
    public void testLoginPlayer() {
        Player player = new Player();
        player.setEmail("john.doe@example.com");
        player.setPassword("password");
        ArrayList<Player> players = new ArrayList<>();
        players.add(player);

        SystemUI.thePlayers = players;

        String simulatedInput = "john.doe@example.com\npassword\n";
        provideInput(simulatedInput);

        SystemUI.Login();

        assertEquals("Logged in successfully\n", outputStream.toString());
    }

    @Test
    public void testComplaintForm() {
        Administrator admin = new Administrator();
        SystemUI.admin = admin;

        PlaygroundOwner owner = new PlaygroundOwner();
        owner.setEmail("owner@example.com");
        ArrayList<PlaygroundOwner> owners = new ArrayList<>();
        owners.add(owner);
        SystemUI.theOwners = owners;

        String simulatedInput = "playground owner\nowner@example.com\nComplaint about the owner\n";
        provideInput(simulatedInput);

        SystemUI.complaintForm();

        assertEquals("User found!!\n", outputStream.toString());
    }

    private void provideInput(String data) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data.getBytes());
        System.setIn(inputStream);
    }
}
