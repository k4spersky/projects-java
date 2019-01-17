package arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Sorting algorithm, which is leveraging the divide-and-conquer principle. It has an average O(n log n) complexity.
 */
public class QuickSort {
    public static void main(String[] args)
    {
        System.out.println("Enter a sequence of integers, each separated by space and follow the sequence with a bang(!), e.g. 2 3 1 !");

        final Scanner sc = new Scanner(System.in);
        final List<Integer> a = new ArrayList<>();

        while (sc.hasNextInt())
        {
            a.add(sc.nextInt());
        }
        sc.close();

        final int low = 0;
        final int high = a.size() - 1;

        quickSort(a, low, high);

        System.out.print("ans:");
        a.forEach(n -> System.out.print(" " + n));
    }

    private static void quickSort(List<Integer> a, int low, int high)
    {
        if (low < high)
        {
            final int pi = partition(a, low, high);
            // low to pi
            quickSort(a, low, pi -1);
            // pi to high
            quickSort(a, pi + 1, high);
        }
    }

    private static int partition(List<Integer> a, int low, int high)
    {
        final int pivot = a.get(high);
        int t = low;

        for (int i = low; i < high; i++)
        {
            final int currentValue = a.get(i);
            if (currentValue <= pivot)
            {
                final int temp = a.get(t);
                a.set(t, currentValue);
                a.set(i, temp);

                t++;
            }
        }

        final int temp = a.get(t);
        a.set(t, a.get(high));
        a.set(high, temp);

        return t;
    }
}
