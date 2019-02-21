package napiers;

import java.util.Scanner;

/**
 * Contract to be used with Napiers methods.
 */
public interface INapiersMethod {

    String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    char[] ALPHABET_CHAR = ALPHABET.toCharArray();
    String[] ALPHABET_STR = ALPHABET.split("");
    Scanner SC = new Scanner(System.in);
}
