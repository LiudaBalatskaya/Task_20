import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by LiudaBalatskaya on 5/10/2017.
 */
public class ParameterizedXmlTest {
    public int result;
    public Mathematics calculator;

    @BeforeMethod
    public void initializerTest() {
        System.out.println("In before the test");
        calculator = new Mathematics();
        calculator.setResult(0);
    }

    @Parameters({"figure1", "figure2"})
    @Test
    public void addCheck(int figure1, int figure2) {
        calculator.add(figure1,figure2);
        result = calculator.getResult();
        assertTrue(result==figure1+figure2);
        System.out.println("added result=" + result);
    }
}
