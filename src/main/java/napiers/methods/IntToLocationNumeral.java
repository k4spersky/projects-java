package napiers.methods;

import napiers.INapiersMethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Conversion of int number to location numeral.
 */
public class IntToLocationNumeral implements INapiersMethod {

    /**
     * A set up method to provide data to {@link #intToLocNumeral}
     */
    public void convert()
    {
        System.out.println("Enter integer below");
        final int input = SC.nextInt();
        final List<Character> sb = new ArrayList<>();

        intToLocNumeral(input, sb);

        // sort in alphabetical order
        Collections.sort(sb);
        System.out.print("ans: ");
        sb.forEach(System.out::print);
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
