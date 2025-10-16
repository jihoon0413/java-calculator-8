package calculator.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    public void givenBaseDelimiterStrWhenCorrectStrThenAnswer() {
        String str = "1,2:3";

        int ans = calculator.calc(str);

        assertEquals(6, ans);
    }

    @Test
    public void givenBaseDelimiterWhenOverTenNumberThenAnswer() {
        String str = "12,13:12";

        int ans = calculator.calc(str);

        assertEquals(37, ans);
    }

    @Test
    public void givenBaseDelimiterWhenIncludeNotNumberThenIllegalArgumentException() {
        String str = "1,2,a:3";

        assertThrows(IllegalArgumentException.class, () -> calculator.calc(str));
    }

    @Test
    public void givenNullStringWhenThenAnswer0() {
        String str = "";

        int ans = calculator.calc(str);

        assertEquals(0, ans);
    }

    @Test
    public void givenCustomDelimiterWhenCorrectThenAnswer() {
        String str = "//^\\n1^31,6";

        int ans = calculator.calc(str);

        assertEquals(38, ans);
    }

    @Test
    public void givenCustomDelimiterWhenIncludeBaseDelimiterThenException() {
        String str1 = "//,\\n1,2,3";
        String str2 = "//:\\n1:2,3";

        assertThrows(IllegalArgumentException.class, () -> calculator.calc(str1));
        assertThrows(IllegalArgumentException.class, () -> calculator.calc(str2));
    }

    @Test
    public void givenCustomDelimiterWhenWrongWayThenException() {
        String str1 = "/#\\n1,2,3";
        String str2 = "//#\\f1,2,3";

        assertThrows(IllegalArgumentException.class, () -> calculator.calc(str1));
        assertThrows(IllegalArgumentException.class, () -> calculator.calc(str2));
    }
}