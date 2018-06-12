package unit;

import org.junit.Assert;
import org.junit.Test;
import com.investec.assessment.StringCalculator;

public class StringCalculatorUnit {

    private StringCalculator stringCalculator = new StringCalculator();

    @Test
    public void testAddForEmptyString(){
        int output = stringCalculator.Add("");
        Assert.assertEquals(output, 0);
    }
}
