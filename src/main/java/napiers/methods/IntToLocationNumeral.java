package napiers.methods;

import napiers.INapiersMethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Conversion of int number to location numeral.
 */
public class IntToLocationNumeral extends NapiersMethodsBase implements INapiersMethod {

    @Override
    public String getInput()
    {
        System.out.println("Enter integer below");
        return SC.next();
    }

    /**
     * A set up method to provide data to {@link #intToLocNumeral}
     */
    @Override
    public String convert(String input)
    {
        final List<Character> locNumeralChars = new ArrayList<>();

        intToLocNumeral(Integer.parseInt(input), locNumeralChars);

        // sort in alphabetical order
        Collections.sort(locNumeralChars);

        final StringBuilder sb = new StringBuilder();
        locNumeralChars.forEach(sb::append);

        return sb.toString();
    }

    private void intToLocNumeral(int input, List<Character> sb)
    {
        if (input > 0)
        {
            double d = Math.log(input) / Math.log(2);
            int y = (int)d;
            sb.add(ALPHABET_CHAR[y]);
            input = (int)(input - Math.pow(2, y));

            // do recursion and repeat until input is 0
            intToLocNumeral(input, sb);
        }
    }
}
