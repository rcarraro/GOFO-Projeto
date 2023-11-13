import codigo.System.Administrator;
import codigo.System.Player;
import codigo.System.PlaygroundOwner;
import codigo.UI.SystemUI;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;

import static org.junit.Assert.assertEquals;

public class SystemUITest {


    @Test
    public void testRegisterPlayer() {
        assertEquals("","");
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
