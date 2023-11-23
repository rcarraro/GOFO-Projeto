import codigo.System.eWallet;
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

public class eWalletTest {

    @Rule
    public final TextFromStandardInputStream systemIn = TextFromStandardInputStream.emptyStandardInputStream();

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    EWallet ewallet;
  
    @Before
    public void setUp() {
        ewallet = new EWallet();
        systemIn.provideLines(10);
        ewallet.setBalance();
    }

    @Test
    public void testdeposit(){
        ewallet.deposit(2);
    }

  @Test
    public void testwithdraw(){
        ewallet.withdraw(2);
    }

    @Test
    public void testgetBalance(){
        assertEquals(10, ewallet.getBalance());
    }
}
