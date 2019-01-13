package napiers.methods;

import napiers.INapiersMethod;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Collections.sort;

/**
 * Abbreviation process for a location numeral. For more details see:
 *
 * https://en.wikipedia.org/wiki/Location_arithmetic#Abbreviated_and_Extended_Form
 */
public class LocationNumeralAbbrev implements INapiersMethod {

    /**
     * Provides input data to {@link #abbreviateLocNumeral(String, StringBuilder, int)} via system input.
     */
    public void convert()
    {
        System.out.println("Enter location numeral below");

        final String input = SC.next();
        final StringBuilder sb = new StringBuilder();
        final int len = input.length();

        abbreviateLocNumeral(input, sb, len);
    }

    /**
     * Converts the extended form of location numeral to its abbreviated form.
     *
     * Each digit in a location numeral represents twice the value of its next-lower digit, replacing any two occurrences
     * of the same digit with one of the next-higher digit does not change the numeral's numeric value.
     *
     * "abccdefghh" -> "abddefghh" -> "abeefghh" -> "abffghh" -> "abgghh" -> "abhhh" -> "abhi"
     *
     * @param input location numeral
     * @param sb string builder
     * @param len initial length of input
     */
    private void abbreviateLocNumeral(String input, StringBuilder sb, int len)
    {
        // length used to avoid iterating through entire alphabet once we have evaluated all letters in input
        int length = len;

        for (int i = 0; i < ALPHABET_STR.length; i++)
        {
            final String val = ALPHABET_STR[i];

            // if input contains letter in [i] then attempt abbreviation
            if (input.contains(val))
            {
                // determine how many identical letters are present in input
                final int count = input.length() - input.replaceAll(val, "").length();

                // we do not need to abbreviate if the letter is unique in input (e.g. only 1 of "a")
                if (count > 1)
                {
                    abbreviate(count, length, i, sb);
                }
                else
                {
                    sb.append(val);
                    length -= 1;
                }

                // stop if length has been reduced to 0
                if (length < 1)
                    break;
            }
        }
        input = sb.toString();

        final List<String> sbStr = Arrays.asList(input.split(""));
        final Set<String> deDupedInput = new HashSet<>(sbStr);

        // if the set of input is of same size as our abbreviated list of input, we abbreviated
        // the location numeral in its entirety, stop recursion
        if (deDupedInput.size() == sbStr.size())
        {
            // sort and print the abbreviated result
            final List<String> ans = Arrays.asList(input.split(""));

            sort(ans);

            System.out.print("ans: ");
            ans.forEach(System.out::print);
            return;
        }

        sb.setLength(0);
        // recursively abbreviate the location numeral
        abbreviateLocNumeral(input, sb, input.length());
    }

    private void abbreviate(int count, int length, int i, StringBuilder sb)
    {
        final int mod = count % 2;
        // check for even number, then we only have pairs
        if (mod == 0)
        {
            abbrevPairs(getPairs(count), length, i, sb);
        }
        else
        {
            // we have pairs and an odd letter remaining
            abbrevPairsAndOdds(count, mod, length, i, sb);
        }
    }

    // helper methods

    /**
     * Abbreviates pairs with letters of same type in the location numeral. Examples of abbreviations:
     *
     * "aa" -> "b"
     * "dddd" -> "cc" -> "f"
     *
     * @param pairs number of pairs with letter of same type
     * @param length current length of input
     * @param i current index
     * @param sb string builder
     */
    private void abbrevPairs(int pairs, int length, int i, StringBuilder sb)
    {
        for (int j = 0; j < pairs; j++)
        {
            sb.append(ALPHABET_STR[i + 1]);
            length -= 2;
        }
    }

    /**
     * Abbreviates pairs AND odd letters of same type in the location numeral. Examples of abbreviations:
     *
     * "aaa" -> "ab"
     * "ccccc" -> "cdd" -> "ce"
     *
     * @param count number of letters of same type
     * @param mod remainder of count
     * @param length current length of input
     * @param i current index
     * @param sb string builder
     */
    private void abbrevPairsAndOdds(int count, int mod, int length, int i, StringBuilder sb)
    {
        abbrevPairs(getPairs(count, mod), length, i, sb);

        // add the odd letter
        sb.append(ALPHABET_STR[i]);
        length -= 1;
    }

    /**
     * Provides number of pairs in location numeral for letter of same type. This helper function is to be used
     * when given an even number of letters of same type e.g. 4 of "a".
     *
     * @param count number of letters of same type
     * @return number of pairs of letters of same type e.g. 5 of "a" -> return: 2
     */
    private int getPairs(int count)
    {
        return count / 2;
    }

    /**
     * Provides number of pairs in location numeral for letter of same type. This helper function is to be used
     * when given an odd number of letters of same type e.g. 5 of "a".
     *
     * @param count number of letters of same type
     * @param mod remainder of count
     * @return number of pairs of letters of same type e.g. 5 of "a" -> return: 2
     */
    private int getPairs(int count, int mod)
    {
        return (count - mod) / 2;
    }
}
