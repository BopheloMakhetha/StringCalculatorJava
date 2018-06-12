package unit;

import org.junit.Assert;
import org.junit.Test;
import com.investec.assessment.StringCalculator;

public class StringCalculatorUnit {

    private StringCalculator stringCalculator = new StringCalculator();

    @Test
    public void testAddForEmptyString() throws StringCalculator.InvalidOutputException {
        int output = stringCalculator.Add("");
        Assert.assertEquals(output, 0);
    }

    @Test
    public void testAddForSingleNumber() throws StringCalculator.InvalidOutputException {
        int output = stringCalculator.Add("11");
        Assert.assertEquals(output, 11);
    }

    @Test(expected = NumberFormatException.class)
    public void testAddForNonNumericString() throws StringCalculator.InvalidOutputException {
        int output = stringCalculator.Add("test string");
    }

    @Test
    public void testAddForTwoCommaDelimitedNumbersInAString() throws StringCalculator.InvalidOutputException {
        int output = stringCalculator.Add("1,2");
        Assert.assertEquals(3, output);

        output = stringCalculator.Add("1,2,");
        Assert.assertEquals(3, output);
    }

    @Test (expected = StringCalculator.InvalidOutputException.class)
    public void testThatCalculatorAcceptsMaxTwoNumbers() throws StringCalculator.InvalidOutputException {
        int output = stringCalculator.Add("1,2,3");
    }

    @Test (expected = StringCalculator.InvalidOutputException.class)
    public void testThatCalculatorDoesNotBreakWhenNullStringPassedIn() throws StringCalculator.InvalidOutputException {
        int output = stringCalculator.Add(null);

    }
}
