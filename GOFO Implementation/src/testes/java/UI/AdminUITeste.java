package teste.java.UI;

import codigo.UI.AdminUI;
import codigo.UI.SystemUI;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class AdminUITeste {

    private final InputStream originalSystemIn = System.in;
    private final PrintStream originalSystemOut = System.out;

    private final ByteArrayOutputStream saida = new ByteArrayOutputStream();
    private final String menu1 = "1\n";

    // @Before
    // public void setUp() {
    //     SystemUI.admin = new Administrator();
    //     System.setOut(new PrintStream(saida));
    // }

    // @After
    // public void restoreSystemInAndOut() {
    //     System.setIn(originalSystemIn);
    //     System.setOut(originalSystemOut);
    // }

    @Test 
    public void testAdminMenuShowApproveRequests() {
        provideInput(menu1); 

        ByteArrayOutputStream saida = new ByteArrayOutputStream();
        System.setOut(new PrintStream(saida));

        AdminUI.adminMenu(); 

        restoreSystemInAndOut();

        String expectedOutput = "Welcome to admin menu, please choose from the following\n" +
                "1- show approve requests for playground\n" +
                "2- suspend Playground\n" +
                "3- unSuspend playground\n" +
                "4- delete Playground\n" +
                "5- show complaints\n" +
                "6- Logout\n";
        assertEquals(expectedOutput, saida.toString());
    }

    private void provideInput(String data) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data.getBytes());
        System.setIn(inputStream);
    }
}