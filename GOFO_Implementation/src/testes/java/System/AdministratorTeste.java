import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class AdministratorTeste {

    private Administrator admin;

    @Before
    public void setUp() {
        admin = new Administrator();
    }

    @Test
    public void testApprovePlayground() {
        Playground playground = new Playground(/* informe os parâmetros necessários */);
        Administrator.Requested.add(playground);
        admin.approvePlayground();
        assertEquals(1, Administrator.Approved.size());
    }
}
