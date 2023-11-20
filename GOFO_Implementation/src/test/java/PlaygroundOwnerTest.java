// import codigo.System.PlaygroundOwner;
// import org.junit.After;
// import org.junit.Before;
// import org.junit.Test;
// import org.junit.Rule;
// import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
// import org.junit.contrib.java.lang.system.SystemOutRule;
// import org.junit.contrib.java.lang.system.ExpectedSystemExit;
// import java.io.InputStream;
// import static org.junit.Assert.assertEquals;
// import static org.junit.Assert.assertThrows;
// import static org.junit.Assert.assertTrue;

// public class PlaygroundOwnerTest {

//     @Rule
//     public final TextFromStandardInputStream systemIn = TextFromStandardInputStream.emptyStandardInputStream();

//     @Rule
//     public final ExpectedSystemExit exit = ExpectedSystemExit.none();

//     PlaygroundOwner playgroundowner;
//     Playground playground;
  
//     @Before
//     public void setUp() {
//         playground = new Playground();
//         playgroundowner = new PlaygroundOwner();

//     }

//     @Test
//     public void testaddPlayground(){
//         playgroundowner.addPlayground(playground);
//     }

//     @Test
//     public void testexistPlayground(){
//         assertEquals(false, playgroundowner.existPlayground("name"));
//     }


// }
