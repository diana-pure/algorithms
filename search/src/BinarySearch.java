import java.util.Scanner;

/**
 * На вход дано целое число N(1⩽N⩽100000). Далее идут
 * N целых чисел, упорядоченные по возрастанию.
 * Затем дано целое число M(1⩽M⩽300000), за которым следуют
 * M запросов. Каждый запрос — это целое число. На каждый запрос
 * X выведите в отдельной строке количество элементов входного массива,
 * которые строго больше X.
 * <p>
 * Sample Input
 * 5
 * 1 3 4 6 8
 * 3
 * 3 0 9
 */
public class BinarySearch {

    public static void search() {
        int[] input;
        int[] test;
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            input = new int[n];
            for (int i = 0; i < n; i++) {
                input[i] = scanner.nextInt();
            }
            int m = scanner.nextInt();
            test = new int[m];
            for (int i = 0; i < m; i++) {
                test[i] = scanner.nextInt();
            }
        }

        for (int i = 0; i < test.length; i++) {
            int position = searchNotBiggerThan(input, test[i]);
            int num;
            if (position == input.length - 1) {
                num = 0;
            } else {
                num = input.length - 1 - position;
            }
            System.out.println(num);
        }
    }

    private static int searchNotBiggerThan(int[] input, int target) {
        if(target >= input[input.length - 1]) {
            return input.length - 1;
        }
        if(target < input[0]) {
            return -1;
        }

        int low = 0;
        int high = input.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target < input[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        if (low - 1 >= 0 && target == input[low - 1]) {
            return low - 1;
        }
        return high;
    }
}
