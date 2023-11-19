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
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class US01Test {

    private final InputStream originalSystemIn = System.in;
    private final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream systemIn = TextFromStandardInputStream.emptyStandardInputStream();

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    private SystemUI sistema;
   
    @Before
    public void setUp() {
        sistema = new SystemUI();
    }

    @Test
    public void testaccountMenu() {
        exit.expectSystemExitWithStatus(0);
        systemIn.provideLines("2","Kleber","Silva","123","123456","teste@fei.edu.br", "123456789", "SP", "player", "123", "3");
        sistema.accountMenu();
    }
    
    @Test
    public void testaccountMenuERRO() {
        exit.expectSystemExitWithStatus(0);
        systemIn.provideLines("2","123","123","123","#####","testefei.edu.br", "asd", "1d12f1ad2", "player", "123", "3");
        sistema.accountMenu();
    }
    
    @After
    public void restoreSystemInputOutput() {
        System.setIn(originalSystemIn);
    }
}
