import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
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
public class ParamDeleteRepeTest {

    @Parameter
    public List<String> testWords; 

    @Parameters
    public static Collection getParameters() {
        return Arrays.asList(new String[][]{
            {"crazy", "crazy", "angels"},
            {"crazy", "crazy", "angels", "angels"},
            {"crazy", "crazy", "angels", "crazy"},
            {"crazy", "angels", "crazy", "angels"}
        });
    }

    @Test
    public void testDeleteRepeatsParam() {
        System.out.println();
        for (int i = 0; i < testWords.size(); i++) {
            System.out.print(testWords.get(i) + " ");
        }
        List<String> words = new ArrayList<String>();
        words.add("crazy");
        words.add("angels");
        TextTools textTools = new TextTools();
        assertEquals("not equals", words, textTools.deleteRepeats(testWords));
    }

}
