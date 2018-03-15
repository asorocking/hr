import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

/**
 *
 * @author Samsung
 */
@RunWith(Parameterized.class)
public class ParamPrepareTextTest {

    @Parameter
    public String str;

    @Parameters
    public static Collection getParameters() {
        return Arrays.asList(new Object[]{
            "!qwerty,",
            ".qwerty@",
            "#qwerty%",
            "^qwerty&",
            "*qwerty-",
            "_qwerty=",
            "`qwerty+",
            "~qwerty1",
            "2qwerty3",
            "4qwerty5",
            "6qwerty7",
            "8qwerty9",
            "0qwerty/",
            "(qwErty)"
        });
    }

    @Test
    public void testPrepareTextParam() {
        TextTools textTools = new TextTools();
        assertEquals("not equals" + str, "qwerty", textTools.prepareText(str));
    }

}
