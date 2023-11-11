import UI.AdminUI;
import UI.SystemUI;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.junit.Assert.assertEquals;

public class AdminUITeste {

    private final InputStream originalSystemIn = System.in;
    private final String menuChoice1 = "1\n";
    private final String menuChoice2 = "2\n";
    private final String menuChoice3 = "3\n";
    private final String menuChoice4 = "4\n";
    private final String menuChoice5 = "5\n";
    private final String menuChoice6 = "6\n";
    private final String playgroundName = "PlaygroundName\n";

    @Before
    public void setUp() {
        SystemUI.admin = new Administrator();
    }

    @After
    public void restoreSystemIn() {
        System.setIn(originalSystemIn);
    }

    @Test
    public void testAdminMenuShowApproveRequests() {
        provideInput(menuChoice1);
        AdminUI.adminMenu();
        // Adicione verificações adequadas com base no comportamento esperado
    }

    @Test
    public void testAdminMenuSuspendPlayground() {
        provideInput(menuChoice2 + playgroundName);
        AdminUI.adminMenu();
        // Adicione verificações adequadas com base no comportamento esperado
    }

    @Test
    public void testAdminMenuUnSuspendPlayground() {
        provideInput(menuChoice3);
        AdminUI.adminMenu();
        // Adicione verificações adequadas com base no comportamento esperado
    }

    @Test
    public void testAdminMenuDeletePlayground() {
        provideInput(menuChoice4 + playgroundName);
        AdminUI.adminMenu();
        // Adicione verificações adequadas com base no comportamento esperado
    }

    @Test
    public void testAdminMenuShowComplaints() {
        provideInput(menuChoice5);
        AdminUI.adminMenu();
        // Adicione verificações adequadas com base no comportamento esperado
    }

    @Test
    public void testAdminMenuLogout() {
        provideInput(menuChoice6);
        AdminUI.adminMenu();
        // Adicione verificações adequadas com base no comportamento esperado
    }

    private void provideInput(String data) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data.getBytes());
        System.setIn(inputStream);
    }
}
