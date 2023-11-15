import codigo.System.Administrator;
import codigo.System.Player;
import codigo.System.PlaygroundOwner;
import codigo.System.PlaygroundOwner;
import codigo.UI.SystemUI;
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
    SystemUI sistema = new SystemUI();
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

        sistema.thePlayers = players;

        String simulatedInput = "john.doe@example.com\npassword\n";
        provideInput(simulatedInput);

        sistema.Login();

        assertEquals("Logged in successfully\n", outputStream.toString());
    }

    @Test
    public void testComplaintForm() {
        Administrator admin = new Administrator();
        sistema.admin = admin;

        PlaygroundOwner owner = new PlaygroundOwner();
        owner.setEmail("owner@example.com");
        ArrayList<PlaygroundOwner> owners = new ArrayList<>();
        owners.add(owner);
        sistema.theOwners = owners;

        String simulatedInput = "playground owner\nowner@example.com\nComplaint about the owner\n";
        provideInput(simulatedInput);

        sistema.complaintForm();

        assertEquals("User found!!\n", outputStream.toString());
    }

    private void provideInput(String data) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data.getBytes());
        System.setIn(inputStream);
        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace(); 
        }
    }
}
