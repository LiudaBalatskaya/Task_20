import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class ParameterXMLTest {

    public int result;
    public Mathematics calculator;

    @Parameters({"figure_one"})
    @Test
    public void addCheckParameter(int figure_one) {
        calculator = new Mathematics();
        calculator.setResult(0);
        calculator.add(figure_one, figure_one+1);
        result = calculator.getResult();
        assertTrue(result == figure_one + figure_one+1);
        Mathematics.logger.info("added result=" + result);
    }
}
