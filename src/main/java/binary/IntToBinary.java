package binary;

import java.util.Scanner;

/**
 * Demonstration of integer -> binary conversion.
 * Constraints: 0 < n && n < 256.
 */
public class IntToBinary {
    public static void main(String[] args)
    {
        final int[] table = {128, 64, 32, 16, 8, 4, 2, 1};

        System.out.println("Enter integer below");

        final Scanner sc = new Scanner(System.in);
        final int n = sc.nextInt();
        final StringBuilder sb = new StringBuilder();

        convertIntToBinary(sb, table, n);
        System.out.print(sanitizeResult(sb));
    }

    private static void convertIntToBinary(StringBuilder sb, int[] t, int n)
    {
        for (int val : t)
        {
            if (0 < n && n < 256)
            {
                int res = n / val;

                if (res == 1)
                {
                    sb.append("1");
                    n = n - val;
                }
                else if (res == 0)
                {
                    sb.append("0");
                }
            }
            else
            {
                break;
            }
        }
    }

    private static String sanitizeResult(StringBuilder sb)
    {
        return sb.toString().replaceAll("^0+", "");
    }
}
