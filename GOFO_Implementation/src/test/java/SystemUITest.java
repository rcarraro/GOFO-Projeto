import codigo.System.Administrator;
import codigo.System.Player;
import codigo.System.PlaygroundOwner;
import codigo.UI.SystemUI;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class SystemUITest {
    
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Test
    public void testRegisterPlayer() {
        // IntegerAsker asker = mock(IntegerAsker.class);
        SystemUI sistema = new SystemUI();
        sistema.register();
        when(asker.ask(anyString())).thenReturn("Rafael");
        when(asker.ask(anyString())).thenReturn("Martins");
        when(asker.ask(anyString())).thenReturn(123);
        when(asker.ask(anyString())).thenReturn("teste123");
        when(asker.ask(anyString())).thenReturn("carrarorafa@gmail.com");
        when(asker.ask(anyString())).thenReturn(123456789);
        when(asker.ask(anyString())).thenReturn("SP");
        when(asker.ask(anyString())).thenReturn("player");
        when(asker.ask(anyString())).thenReturn(123);
        String capturedOutput = outputStream.toString();
        assertEquals("Successfully verified!\n", capturedOutput);
    }

   
}
