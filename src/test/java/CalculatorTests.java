import com.michau.selenium.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTests {

    private static Calculator calculator;

    @BeforeAll
    public static void calculatorSetup(){
        calculator=new Calculator();
    }

    @Test
    public void test1(){
        Assertions.assertEquals(calculator.add(5,5),10);
    }

    @Test
    public void test2(){
        Assertions.assertTrue(calculator.add(5,5)==10);
    }

    @Test
    public void test3(){
        Assertions.assertFalse(calculator.add(5,5)==11);
    }

}
