import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import static org.testng.AssertJUnit.assertEquals;

public class DataProviderIteratorTest {
    private static String FILE_NAME1 ="src+ File.separator +main+ File.separator +resources+ File.separator + param_1.txt";
    public static String FILE_PATH1 = System.getProperty("user.dir") + File.separator + FILE_NAME1;
    public int result;
    public Mathematics calculator;
    public final static Logger LOGGER = Logger.getLogger(String.valueOf(ParametersTextTest.class));


    @DataProvider(name = "")
    public Iterator<Object[]> testData()
            throws IOException
    {
        List<Object[]> list = new ArrayList<Object[]>();
        BufferedReader br = new BufferedReader(new FileReader(FILE_PATH1));
        String sCurrentLine;
        int i=0;
        while ((sCurrentLine = br.readLine()) != null) {
            String[] keyValue = sCurrentLine.split(" ");
            while (keyValue != null) {
                list.add(i,keyValue);
                i++;
                keyValue = sCurrentLine.split(" ");
            }
        }
        return list.iterator();
    }

    @BeforeMethod
    public void initializerTest() {
        calculator = new Mathematics();
        calculator.setResult(0);
    }


    @Test(dataProvider = "" )
    public void addCheck(int x, int y) {
        calculator.add(x,y);
        result = calculator.getResult();
        assertEquals(result, x+y);
        LOGGER.info("added result="+result );

    }


}
