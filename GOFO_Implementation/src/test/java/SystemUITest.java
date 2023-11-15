import codigo.System.Administrator;
import codigo.System.Player;
import codigo.System.PlaygroundOwner;
import codigo.System.PlaygroundOwner;
import codigo.UI.SystemUI;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class SystemUITest {

    private final InputStream originalSystemIn = System.in;
    private final PrintStream originalSystemOut = System.out;
    private SystemUI sistema;
    @Before
    public void setUp(){
        sistema = new SystemUI();
    }

    @Rule
    public final TextFromStandardInputStream systemIn = TextFromStandardInputStream.emptyStandardInputStream();

    @Test
    public void testRegisterPlayer() {
        systemIn.provideLines("John","Doe","123","password","john.doe@example.com","456","City","player");
        sistema.register(); 
    }

    // @Test
    // public void testLoginPlayer() {
    //     Player player = new Player();
    //     player.setEmail("john.doe@example.com");
    //     player.setPassword("password");
    //     ArrayList<Player> players = new ArrayList<>();
    //     players.add(player);

    //     sistema.thePlayers = players;

    //     String simulatedInput = "john.doe@example.com\npassword\n";
    //     provideInput(simulatedInput);

    //     sistema.Login();

    //     assertEquals("Logged in successfully\n", outputStream.toString());
    // }

    // @Test
    // public void testComplaintForm() {
    //     Administrator admin = new Administrator();
    //     sistema.admin = admin;

    //     PlaygroundOwner owner = new PlaygroundOwner();
    //     owner.setEmail("owner@example.com");
    //     ArrayList<PlaygroundOwner> owners = new ArrayList<>();
    //     owners.add(owner);
    //     sistema.theOwners = owners;

    //     String simulatedInput = "playground owner\nowner@example.com\nComplaint about the owner\n";
    //     provideInput(simulatedInput);

    //     sistema.complaintForm();

    //     assertEquals("User found!!\n", outputStream.toString());
    // }

    // private void provideInput(String data) {
    //     ByteArrayInputStream inputStream = new ByteArrayInputStream(data.getBytes());
    //     System.setIn(inputStream);
    // }
}
