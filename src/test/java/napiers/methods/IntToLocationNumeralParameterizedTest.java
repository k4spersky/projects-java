package napiers.methods;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class IntToLocationNumeralParameterizedTest {

    public IntToLocationNumeralParameterizedTest(final String input, final String expectedAns)
    {
        this.input = input;
        this.expectedAns = expectedAns;
    }

    @Test
    public void test()
    {
        final IntToLocationNumeral intToLocationNumeral = new IntToLocationNumeral();
        assertEquals(expectedAns, intToLocationNumeral.convert(input));

    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"22", "bce"}
        });
    }

    private String input;
    private String expectedAns;
}
