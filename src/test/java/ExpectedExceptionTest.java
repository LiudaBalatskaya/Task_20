import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by LiudaBalatskaya on 5/8/2017.
 */
public class ExpectedExceptionTest {
    public int result;
    public Mathematics calculator;

    @BeforeMethod
    public void initializerTest() {
        calculator = new Mathematics();
        calculator.setResult(0);
    }
    @Test(expectedExceptions = ArithmeticException.class)
    public void divideTest()throws InterruptedException {
        Mathematics.logger.info("It was a trying to divide on zero");
        calculator.divide(25,0);
        result = calculator.getResult();
    }
}
