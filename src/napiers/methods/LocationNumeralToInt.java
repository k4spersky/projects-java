package napiers.methods;

import napiers.INapiersMethod;

/**
 * Conversion of location numeral to int number.
 */
public class LocationNumeralToInt implements INapiersMethod {

    public void convert()
    {
        System.out.println("Enter location numeral below");
        char[] locNum = SC.next().toCharArray();
        long sum = 0;

        for (char c : locNum) {
            for (int j = 0; j < ALPHABET_CHAR.length; j++) {
                if (c == ALPHABET_CHAR[j]) {
                    sum += Math.pow(2, j);
                    break;
                }
            }
        }
        System.out.println(String.format("ans: %s", sum));
    }
}
