import codigo.UI.SystemUI;
import codigo.System.Playground;
import codigo.System.eWallet;
import codigo.System.PlaygroundOwner;
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

public class US03_2Test {

    private final InputStream originalSystemIn = System.in;
    private final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream systemIn = TextFromStandardInputStream.emptyStandardInputStream();

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    private SystemUI sistema;
    private Playground playground;
    private PlaygroundOwner playgroundo;
    eWallet serve;
   
    @Before
    public void setUp() {
        sistema = new SystemUI();
        serve = new eWallet();
        playground = new Playground();
        playgroundo = new PlaygroundOwner();
        playground.setName("teste");
        serve.setBalance(10000);
        playgroundo.setBalance(serve);
        playgroundo.setFName("Fname");
        playgroundo.setLName("lName");
        playgroundo.setPassword("password");
        playgroundo.setID(123);
        playgroundo.setRule("playground owner");
        playgroundo.setPhone(124356789);
        playgroundo.setEmail("test@fei.edu.br");
        playgroundo.setLocation("SP");
        playgroundo.addPlayground(playground);
        sistema.theOwners.add(playgroundo);
    }

    @Test
    public void testUS03_2Test() {
        exit.expectSystemExitWithStatus(0);
        systemIn.provideLines("2", "test", "Silva","123", "123456", "test@fei.br", "123456789", "SP", "player", "10000", "123", "1", "test@fei.br", "123456", "5", "teste", "0", "0", "monday", "0", "12", "3");
        sistema.accountMenu();
    }
    
    @After
    public void restoreSystemInputOutput() {
        System.setIn(originalSystemIn);
    }
}
