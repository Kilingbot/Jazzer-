import com.pholser.junit.quickcheck.From;
import edu.berkeley.cs.jqf.examples.common.ArbitraryLengthStringGenerator;
import edu.berkeley.cs.jqf.fuzz.Fuzz;
import edu.berkeley.cs.jqf.fuzz.JQF;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.runner.RunWith;

@RunWith(JQF.class)
public class MathTest {

    @Fuzz
    public void fuzzCreateNumber(@From(ArbitraryLengthStringGenerator.class) String input) throws NumberFormatException {
        NumberUtils.createNumber(input);
    }
}
