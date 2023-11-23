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
import org.omg.PortableInterceptor.PolicyFactoryOperations;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import java.io.InputStream;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class US07_2Test {

    private final InputStream originalSystemIn = System.in;
    private final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream systemIn;

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    private SystemUI sistema;
    private Playground playground1;
    private Administrator administrator;
    PlaygroundOwner playown;
   
    @Before
    public void setUp() {
        systemIn = TextFromStandardInputStream.emptyStandardInputStream();
        sistema = new SystemUI();
        administrator = new Administrator();
        playground1 = new Playground();
        playown = new PlaygroundOwner();
        administrator.playgroundRequests(playground1);
        
        //locais
        systemIn.provideLines("SP");
        playground1.setLocation();
        //aprovar
        systemIn.provideLines("yes");
        administrator.approvePlayground();
        //Nomes
        playground1.setName("ateste");
        //Preço
        systemIn.provideLines("100");
        playground1.setPrice();
        //status
        systemIn.provideLines("available");
        playground1.setStatus();
        systemIn.provideLines("0","10");
        playground1.setBooking();
        playown.setEmail("testepla@fei.br");
        playown.setPassword("123456");
        playown.addPlayground(playground1);
        sistema.theOwners.add(playown);
    }
    
    @Test
    public void testUS07_2Test() {
        systemIn = TextFromStandardInputStream.emptyStandardInputStream();
        // systemIn.provideLines("2", "test", "Silva","123", "123", "test@fei.br", "123456789", "SP", "player", "10000", "123", "1", "test@fei.br", "123", "7", "playground owner", "testepla@fei.br", "tem um problema com o playground ateste", "12","1", "admin@gmail.com", "123", "5", "4", "ateste", "6"); 
        systemIn.provideLines("2"); 
        assertThrows(NoSuchElementException.class, () -> {
            sistema.accountMenu();
        });
    }
    
    @After
    public void restoreSystemInputOutput() {
        System.setIn(originalSystemIn);
    }
}
