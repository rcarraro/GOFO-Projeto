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

public class US01_1Test {

    private final InputStream originalSystemIn = System.in;
    private final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream systemIn = TextFromStandardInputStream.emptyStandardInputStream();

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    private SystemUI sistema;
   
    @Test
    public void testUS01_1Test() {
        sistema = new SystemUI();
        exit.expectSystemExitWithStatus(0);
        systemIn.provideLines("2","Kleber","Silva","123","123456","teste@fei.edu.br", "123456789", "SP", "player", "123", "3", "3");
        sistema.accountMenu();
    }
    
    @Test
    public void US01_1Test_resultados(){
        System.out.println("entrou");
        assertEquals("teste@fei.edu.br", sistema.thePlayers.get(0).getEmail());
        assertEquals("123456789", sistema.thePlayers.get(0).getPhone());
        assertEquals("123456", sistema.thePlayers.get(0).getPassword());
    }

    @After
    public void restoreSystemInputOutput() {
        System.setIn(originalSystemIn);
    }
}
