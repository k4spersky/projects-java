package napiers;

import java.util.*;

/**
 * Demonstration of Napiers Location Numerals, following methods demonstrate:
 *  - location numeral to int
 *  - int to location numeral
 *  - location numeral abbreviation process
 *
 * see: https://en.wikipedia.org/wiki/Location_arithmetic#Location_Numerals
 */
public class NapiersMethodsClient {

    public static void main(String[] args) {
        System.out.println(
                "[1] for location numeral to int conversion:\n" +
                "[2] for int to location numeral conversion:\n" +
                "[3] for location numeral abbreviation:");
        final Scanner sc = new Scanner(System.in);

        final NapiersMethodsFactory nmf = new NapiersMethodsFactory();
        final INapiersMethod nm = nmf.getNapiersMethod(sc.next());

        nm.convert();
    }
}
