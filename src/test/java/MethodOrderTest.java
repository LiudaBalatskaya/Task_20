import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;


/**
 * Created by LiudaBalatskaya on 5/8/2017.
 */

public class MethodOrderTest {
    public int result;
    public Mathematics calculator;

    @BeforeClass
    public static void beforeClass(){
        Mathematics.logger.info("In beforeClass method");
    }

    @BeforeMethod
    public void initializerTest() {
        Mathematics.logger.info("In before the test");
        calculator = new Mathematics();
        calculator.setResult(0);
    }

    @Test(priority = 3)
    public void multiply(){
        calculator.multiply(5,5);
        result = calculator.getResult();
        assertTrue(result==25);
        System.out.println("multiply test");
        Mathematics.logger.info("multiply test");
    }

    @Test(priority = 2)
    public void divide(){
        calculator.divide(25,5);
        result = calculator.getResult();
        assertTrue(result==5);
        Mathematics.logger.info("divide test");
    }

    @Test(priority = 1)
    public void add(){
        calculator.add(2,2);
        result = calculator.getResult();
        assertTrue(result==4);
        Mathematics.logger.info("add test");
    }

    @Test(priority = 4)
    public void deduct(){
        calculator.setResult(1);
        calculator.deduct(15,5);
        result = calculator.getResult();
        assertTrue(result==10);
        Mathematics.logger.info("deduct test");
    }

}
