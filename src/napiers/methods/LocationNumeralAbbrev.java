package napiers.methods;

import napiers.INapiersMethod;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Abbreviation process for a location numeral.
 */
public class LocationNumeralAbbrev implements INapiersMethod {

    public void convert()
    {
        System.out.println("Enter location numeral below");
        final String input = SC.next();
        StringBuilder sb = new StringBuilder();
        int len = input.length();

        abbreviateLocNumeral(input, sb, len);
    }

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
                    int mod = count % 2;
                    // check for even number, then we only have pairs
                    if (mod == 0)
                    {
                        abbrevPairs(getPairs(count), count, length, i, sb);
                    }
                    else
                    {
                        // we have pairs and an odd letter remaining
                        abbrevPairsAndOdds(count, mod, length, i, sb);
                    }
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
        final Set<String> partitionedAlphabet = new HashSet<>(sbStr);

        // if the set of unique characters is of same size as our abbreviated list of characters, we abbreviated
        // the location numeral in its entirety, stop recursion
        if (partitionedAlphabet.size() == sbStr.size())
        {
            System.out.println(String.format("ans: %s", input));
            return;
        }

        sb.setLength(0);
        abbreviateLocNumeral(input, sb, input.length());
    }

    // helper methods
    private void abbrevPairs(int pairs, int count, int length, int i, StringBuilder sb)
    {
        for (int j = 0; j < pairs; j++)
        {
            sb.append(ALPHABET_STR[i + 1]);
            length -= 2;
        }
    }

    private void abbrevPairsAndOdds(int count, int mod, int length, int i, StringBuilder sb)
    {
        abbrevPairs(getPairs(count, mod), count, length, i, sb);

        for (int y = 0; y < mod; y++)
        {
            sb.append(ALPHABET_STR[i]);
            length -= 1;
        }
    }

    private int getPairs(int count)
    {
        return count / 2;

    }

    private int getPairs(int count, int mod)
    {
        return (count - mod) / 2;
    }
}
