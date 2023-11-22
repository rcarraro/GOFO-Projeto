import codigo.UI.SystemUI;
import codigo.System.Playground;
import codigo.System.Administrator;
import codigo.System.Player;
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

public class US04_1Test {

    private final InputStream originalSystemIn = System.in;
    private final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream systemIn = TextFromStandardInputStream.emptyStandardInputStream();

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    private SystemUI sistema;
    private Playground playground1;
    private Playground playground2;
    private Administrator administrator;
    Player player;
   
    @Before
    public void setUp() {
        sistema = new SystemUI();
        administrator = new Administrator();
        playground1 = new Playground();
        playground2 = new Playground();
        administrator.playgroundRequests(playground1);
        administrator.playgroundRequests(playground2);
        
        //locais
        systemIn.provideLines("SP");
        playground1.setLocation();
        systemIn.provideLines("RJ");
        playground2.setLocation();
        //aprovar
        systemIn.provideLines("yes","yes");
        administrator.approvePlayground();
        //Nomes
        playground1.setName("ateste");
        playground2.setName("bteste");
        //Preço
        systemIn.provideLines("100");
        playground1.setPrice();
        systemIn.provideLines("200");
        playground2.setPrice();
        //status
        systemIn.provideLines("available");
        playground1.setStatus();
        systemIn.provideLines("not available");
        playground2.setStatus();
    }
    
    @Test
    public void testaccountMenu() {
        exit.expectSystemExitWithStatus(0);
        systemIn.provideLines("2", "test", "Silva","123", "123456", "test@fei.br", "123456789", "SP", "player", "10000", "123", "1", "test@fei.br", "123456", "10"); 
        // systemIn.provideLines("2", "test", "Silva","123", "123456", "test@fei.br", "123456789", "SP", "player", "10000", "123", "1", "test@fei.br", "123456", "10", "ateste","3","2", "ateste", "0", "0", "asd", "sunday"); 
        sistema.accountMenu();
    }
    
    @After
    public void restoreSystemInputOutput() {
        System.setIn(originalSystemIn);
    }
}
