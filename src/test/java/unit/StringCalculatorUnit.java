package unit;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import com.investec.assessment.StringCalculator;
import org.junit.rules.ExpectedException;

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

    @Test
    public void testAddForTwoCommaDelimitedNumbersInAString() throws StringCalculator.InvalidOutputException {
        int output = stringCalculator.Add("1,2");
        Assert.assertEquals(3, output);

        output = stringCalculator.Add("1,2,");
        Assert.assertEquals(3, output);
    }

    @Test
    public void testThatCalculatorAcceptsAnyAmountOfNumbers() throws StringCalculator.InvalidOutputException {
        int output = stringCalculator.Add("1,2,3");
        Assert.assertEquals(6, output);

        output = stringCalculator.Add("1,2,3,4,5,6");
        Assert.assertEquals(21, output);
    }

    @Test
    public void testAddForNewlineDelimitedInput() throws StringCalculator.InvalidOutputException {
        int output = stringCalculator.Add("1\n2\n3");
        Assert.assertEquals(6, output);
    }

    @Test
    public void testAddForNewlineAndCommaDelimitedInput() throws StringCalculator.InvalidOutputException {
        int output = stringCalculator.Add("1\n2,3\n4");
        Assert.assertEquals(10, output);

        output = stringCalculator.Add("1\n2,3");
        Assert.assertEquals(6,output);
    }

    @Test
    public void testChangingDelimeter() throws StringCalculator.InvalidOutputException {
        int output = stringCalculator.Add("//;\n1;2");
        Assert.assertEquals(3, output);

        output = stringCalculator.Add("//%\n1%2%6%7");
        Assert.assertEquals(16, output);
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void shouldThrowExceptionWhenNegativeNumbersPassedToAdd() throws Exception {
        expectedException.expect(StringCalculator.InvalidOutputException.class);
        expectedException.expectMessage("Negatives not allowed: -4");

        stringCalculator.Add("1,-4");
    }

    @Test
    public void shouldThrowExceptionWhenNegativeNumbersPassedToAdd1() throws Exception {
        expectedException.expect(StringCalculator.InvalidOutputException.class);
        expectedException.expectMessage("Negatives not allowed: -4");

        stringCalculator.Add("1\n-4");
    }

    @Test
    public void shouldThrowExceptionWhenNegativeNumbersPassedToAdd2() throws Exception {
        expectedException.expect(StringCalculator.InvalidOutputException.class);
        expectedException.expectMessage("Negatives not allowed: -4");

        stringCalculator.Add("//;\n1;-4");
    }

    @Test
    public void ignoreNumbersBiggerThanThousand() throws  Exception {
        int output = stringCalculator.Add("1,2,1001");
        Assert.assertEquals(3, output);

        output = stringCalculator.Add("2,1001");
        Assert.assertEquals(2, output);
    }

    @Test
    public void testAddCanTakeDelimeterOfAnyLength() throws Exception {
        int output = stringCalculator.Add("//[***]\n1***2***3");
        Assert.assertEquals(6, output);

        output = stringCalculator.Add("//[*****]\n2*****2*****3");
        Assert.assertEquals(7, output);
    }

    @Test
    public void testAddCanTakeMultipleDelimeters() throws Exception {
        int output = stringCalculator.Add("//[*][%]\n1*2%3");
        Assert.assertEquals(6, output);

        output = stringCalculator.Add("//[*][%][$]\n1*2%3$5");
        Assert.assertEquals(11, output);

    }
}
