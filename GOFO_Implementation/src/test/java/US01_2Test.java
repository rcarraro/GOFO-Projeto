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

public class US01_2Test {

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
    public void testUS01_2Test() {
        exit.expectSystemExitWithStatus(0);
        systemIn.provideLines("2","123","teste","123","Silva","123","#####","testefei.edu.br","teste@fei.edu.br", "asd","123456789","1d12f1ad2", "player", "123", "3", "3");
        sistema.accountMenu();
    }
    
    @Test
    public void US01_2Test_resultados(){
        assertEquals("teste@fei.edu.br", sistema.thePlayers.get(0).getEmail());
        assertEquals("123456789", sistema.thePlayers.get(0).getPhone());
        assertEquals("#####", sistema.thePlayers.get(0).getPassword());
    }

    @After
    public void restoreSystemInputOutput() {
        System.setIn(originalSystemIn);
    }
}
