package napiers.methods;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.runners.Parameterized.Parameters;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LocationNumeralToIntParameterizedTest {
    public LocationNumeralToIntParameterizedTest(final String input, final String expectedAns)
    {
        this.input = input;
        this.expectedAns = expectedAns;
    }

    @Test
    public void test()
    {
        final LocationNumeralToInt locationNumeralToInt = new LocationNumeralToInt();
        assertEquals(expectedAns, locationNumeralToInt.convert(input));
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"aaa", "3"}
        });
    }

    private String input;
    private String expectedAns;
}
