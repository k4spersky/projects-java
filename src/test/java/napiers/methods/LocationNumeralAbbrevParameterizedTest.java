package napiers.methods;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class LocationNumeralAbbrevParameterizedTest {

    public LocationNumeralAbbrevParameterizedTest(final String input, final String expectedAns)
    {
        this.input = input;
        this.expectedAns = expectedAns;
    }

    @Test
    public void test()
    {
        final LocationNumeralAbbrev locationNumeralAbbrev = new LocationNumeralAbbrev();
        assertEquals(expectedAns, locationNumeralAbbrev.convert(input));
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"aaa", "ab"},
                {"aabb", "bc"},
                {"bbccc", "e"}
        });
    }

    private String input;
    private String expectedAns;
}
