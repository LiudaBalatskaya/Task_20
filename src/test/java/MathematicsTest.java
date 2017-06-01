import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by LiudaBalatskaya on 5/8/2017.
 */
public class MathematicsTest {
    public int result;
    public Mathematics calculator;

    @BeforeClass
    public static void beforeClass(){
        Mathematics.logger.info("In beforeClass method");
    }
    @BeforeMethod
    public void initializerTest() {
        calculator = new Mathematics();
        calculator.setResult(0);
    }
    @AfterClass
    public static void finishedClass(){
        Mathematics.logger.info("Testing is finished");
    }
    @Test(groups = {"smoke", "fast"})
    public void addCheck() {
        calculator.add(2,2);
        result = calculator.getResult();
        assertTrue(result==4);
    }
    @Test(groups = {"fast"})
    public void deductCheck(){
        calculator.setResult(1);
        calculator.deduct(15,5);
        result = calculator.getResult();
        assertTrue(result==10);
    }
    @Test(groups = {"fast"})
    public void multiplyCheck(){
        calculator.multiply(5,5);
        result = calculator.getResult();
        assertTrue(result==25);
    }
    @Test(groups = {"fast"})
    public void divideCheck(){
        calculator.divide(25,5);
        result = calculator.getResult();
        assertTrue(result==5);
    }
    @Test(timeOut = 1000)
    public void deductCheckFalse() throws InterruptedException {
        Thread.sleep(5*60*10);
        assertTrue(result>0);
        Assert.assertFalse(result>0);
        calculator.deduct(15,5);
        result = calculator.getResult();
        Assert.assertFalse(result==10);
    }
}
