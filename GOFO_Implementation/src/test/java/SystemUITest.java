import codigo.UI.SystemUI;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import java.io.InputStream;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SystemUITest {

    private final InputStream originalSystemIn = System.in;
    private final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
    private SystemUI sistema;

    @Before
    public void setUp() {
        sistema = new SystemUI();
    }

    @Rule
    public final TextFromStandardInputStream systemIn = TextFromStandardInputStream.emptyStandardInputStream();

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void testaccountMenuLoginsemcadastro() {
        exit.expectSystemExitWithStatus(0);
        systemIn.provideLines("1", "rafael@fei.com.br", "123456","2", "Rafael", "Martins", "123", "123456", "rafael@fei.com.br", "12345678", "SP", "player","1234" ,"123", "1", "rafael@fei.com.br", "123456", "12", "3");
        sistema.accountMenu();
        String actualOutput = systemOutRule.getLog();
        // assertTrue("Verificação", actualOutput.contains("Logout"));
    }

    @After
    public void restoreSystemInputOutput() {
        System.setIn(originalSystemIn);
    }
}
