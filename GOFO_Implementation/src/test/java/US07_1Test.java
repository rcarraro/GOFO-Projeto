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
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

@Execution(ExecutionMode.SAME_THREAD)
public class US07_1Test {

    private final InputStream originalSystemIn = System.in;
    private final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream systemIn71 = TextFromStandardInputStream.emptyStandardInputStream();

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    private SystemUI sistema;
    private Playground playground1;
    private Administrator administrator;
    PlaygroundOwner playown;
   
    @Before
    public void setUp() {

        sistema = new SystemUI();
        administrator = new Administrator();
        playground1 = new Playground();
        playown = new PlaygroundOwner();
        administrator.playgroundRequests(playground1);
        
        //locais
        systemIn71.provideLines("SP");
        playground1.setLocation();
        //aprovar
        systemIn71.provideLines("yes");
        administrator.approvePlayground();
        //Nomes
        playground1.setName("ateste");
        //Preço
        systemIn71.provideLines("100");
        playground1.setPrice();
        //status
        systemIn71.provideLines("available");
        playground1.setStatus();
        systemIn71.provideLines("0","10");
        playground1.setBooking();
        playown.setEmail("testepla@fei.br");
        playown.setPassword("123456");
        playown.addPlayground(playground1);
        sistema.theOwners.add(playown);
    }
    
    @Test
    public void testUS07_1Test() {
        exit.expectSystemExitWithStatus(0);
        systemIn71.provideLines("2", "test", "Silva","123", "123", "test@fei.br", "123456789", "SP", "player", "10000", "123", "1", "test@fei.br", "123", "7", "playground owner", "testepla@fei.br", "tem um problema com o playground ateste", "12","1", "admin@gmail.com", "123", "5", "2", "ateste", "3", "ateste","yes","6", "3"); 
        sistema.accountMenu();
    }
    @After
    public void restoreSystemInputOutput() {
        System.setIn(originalSystemIn);
        systemIn71.provideLines("");
    }    
}
