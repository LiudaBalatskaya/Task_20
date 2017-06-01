import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by LiudaBalatskaya on 5/10/2017.
 */
public class ParametersTextTest {
    public static String FILE_PATH = System.getProperty("user.dir") + "\\src\\main\\resources\\param.txt";
    public int result;
    public Mathematics calculator;


    @DataProvider(name = "provideData")
    public Object[][] provideData() {
        int i = 0;
        int one;
        int two;
        Object[][] provideData;
        provideData = new  Integer [7][2];
        try {
            BufferedReader br = new BufferedReader(new FileReader(FILE_PATH));
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                String[] keyValue = sCurrentLine.split(" ");
                one = Integer.parseInt(keyValue[0]);
                two = Integer.parseInt(keyValue[1]);
                provideData[i][0] = one;
                provideData[i][1] = two;
                i++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return provideData;
    }

    @BeforeMethod
    public void initializerTest() {
        System.out.println("In before the test");
        calculator = new Mathematics();
        calculator.setResult(0);
    }

    @Test(dataProvider = "provideData")
    public void addCheck(int x, int y) {
        calculator.add(x,y);
        result = calculator.getResult();
        assertTrue(result==x+y);
        System.out.println("added result=" + result);
    }

}
