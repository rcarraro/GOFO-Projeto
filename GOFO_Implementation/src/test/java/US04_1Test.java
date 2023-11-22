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
    private Playground playground3;
    private Administrator administrator;
    Player player;
   
    @Before
    public void setUp() {
        sistema = new SystemUI();
        administrator = new Administrator();
        playground1 = new Playground();
        playground2 = new Playground();
        playground3 = new Playground();
        player = new Player();
        administrator.playgroundRequests(playground1);
        administrator.playgroundRequests(playground2);
        administrator.playgroundRequests(playground3);
        
        //locais
        systemIn.provideLines("SP");
        playground1.setLocation();
        systemIn.provideLines("RJ");
        playground2.setLocation();
        systemIn.provideLines("MT");
        playground2.setLocation();
        //aprovar
        systemIn.provideLines("yes","yes", "yes");
        administrator.approvePlayground();
        //Nomes
        playground1.setName("ateste");
        playground2.setName("bteste");
        playground3.setName("cteste");
        //Preço
        systemIn.provideLines("100");
        playground1.setPrice();
        systemIn.provideLines("200");
        playground2.setPrice();
        systemIn.provideLines("250");
        playground3.setPrice();
        //status
        systemIn.provideLines("available");
        playground1.setStatus();
        systemIn.provideLines("not available");
        playground2.setStatus();
        systemIn.provideLines("available");
        playground3.setStatus();
        systemIn.provideLines("0","10");
        playground1.setBooking();
    }
    
    @Test
    public void testaccountMenu() {
        
        exit.expectSystemExitWithStatus(0);
        systemIn.provideLines("2", "test", "Silva","123", "123456", "test@fei.br", "123456789", "SP", "player", "10000", "123", "1", "test@fei.br", "123456", "10", "ateste", "3", "2", "ateste", "3", "5", "monday", "8", "12", "3"); 
        player.addInbox("Você foi convidado para o playground ateste");
        sistema.accountMenu();
        // systemIn.provideLines("2", "test", "Silva","123", "123456", "test@fei.br", "123456789", "SP", "player", "10000", "123", "1", "test@fei.br", "123456", "10", "ateste","3","2", "ateste", "0", "0", "asd", "sunday"); 
    }
    
    @After
    public void restoreSystemInputOutput() {
        System.setIn(originalSystemIn);
    }
}
