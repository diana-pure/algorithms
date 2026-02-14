import java.util.Arrays;
import java.util.Scanner;

public class CafesOnRoad {

    public static void search() {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt(); //road length
            int k = scanner.nextInt(); // number of new cafes
            int m = scanner.nextInt(); // max distance between cafes
            int l = scanner.nextInt(); // cafes that on the road
            int[] cafes = new int[l]; // cafes positions
            for (int i = 0; i < l; i++) {
                cafes[i] = scanner.nextInt();
            }
            int dd = f(n, k, m, l, cafes);
            if (dd <= m) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static int f(int n, int k, int m, int l, int[] cafes) {
        Arrays.sort(cafes);
        int[] distances = new int[l + 1]; // distances
        int i;
        for (i = 0; i < cafes.length - 1; i++) {
            distances[i] = cafes[i + 1] - cafes[i];
        }
        distances[cafes.length - 1] = cafes[0];
        distances[cafes.length] = n - cafes[cafes.length - 1];
        Arrays.sort(distances);

        int low = 0;
        int high = l;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (m > distances[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        int spare = 0;
        for (int j = low - 1; j <= distances.length - 1; j++) {
            spare += distances[j];
        }
        return spare / (k + 1);
    }
}
