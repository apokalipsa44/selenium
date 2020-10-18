import com.michau.selenium.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTests {

    private static Calculator calculator;

    //entry data
    private int firstVal = 5;
    private int secondVal = 5;


    //expected data
    private int correctExpectedValue = 10;
    private int wrongExpectedValue = 102;

    @BeforeAll
    public static void calculatorSetup() {
        calculator = new Calculator();
    }

    @Test
    public void test1() {
        int result = calculator.add(firstVal, secondVal);
        Assertions.assertEquals(result, correctExpectedValue);
    }

    @Test
    public void test2() {
        int result = calculator.add(firstVal, secondVal);
        Assertions.assertTrue(result == correctExpectedValue);
    }

    @Test
    public void test3() {
        int result = calculator.add(secondVal, secondVal);
        Assertions.assertFalse(result == wrongExpectedValue);
    }

}
