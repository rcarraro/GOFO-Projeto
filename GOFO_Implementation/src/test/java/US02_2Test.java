import codigo.UI.SystemUI;
import codigo.System.Playground;
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

public class US02_2Test {

    private final InputStream originalSystemIn = System.in;
    private final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream systemIn = TextFromStandardInputStream.emptyStandardInputStream();

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    private SystemUI sistema;
    private Playground playground;
   
    @Before
    public void setUp() {
        sistema = new SystemUI();
        playground = new Playground();
        playground.setName("teste");
    }

    @Test
    public void testUS02_2Test() {
        exit.expectSystemExitWithStatus(0);
        systemIn.provideLines("2", "test", "Silva","123", "123456", "test@fei.br", "123456789", "SP", "playground owner", "10000", "123", "1", "test@fei.br", "123456", "1", "", "", "", "100", "", "available", "", "0", "", "7", "", "10", "8", "3");
        sistema.accountMenu();
    }
    
    @After
    public void restoreSystemInputOutput() {
        System.setIn(originalSystemIn);
    }
}
