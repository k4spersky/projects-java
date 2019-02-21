package napiers.methods;

import napiers.INapiersMethod;

/**
 * Conversion of location numeral to int number.
 */
public class LocationNumeralToInt extends NapiersMethodsBase implements INapiersMethod {

    @Override
    public String getInput()
    {
        System.out.println("Enter location numeral below");
        return SC.next();
    }

    @Override
    public String convert(String input)
    {
        char[] locNum = input.toCharArray();
        long sum = 0;

        for (char c : locNum) {
            for (int j = 0; j < ALPHABET_CHAR.length; j++) {
                if (c == ALPHABET_CHAR[j]) {
                    sum += Math.pow(2, j);
                    break;
                }
            }
        }
        return Long.toString(sum);
    }
}
