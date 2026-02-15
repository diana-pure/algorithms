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
            f(n, k, m, l, cafes);
        }
    }

    public static void f(int n, int k, int m, int l, int[] cafesBetween) {
        int[] cafes = Arrays.copyOf(cafesBetween, cafesBetween.length + 2);
        cafes[cafesBetween.length] = 0;
        cafes[cafesBetween.length + 1] = n;
        Arrays.sort(cafes);
        int[] distances = new int[cafes.length - 1]; // distances
        int i;
        for (i = 0; i < cafes.length - 1; i++) {
            distances[i] = cafes[i + 1] - cafes[i];
        }
        Arrays.sort(distances);

        int cnt = 0; // minimum needed to cover at least m distance cafes
        for (int j = distances.length - 1; j >= 0; j--) {
            if (distances[j] < m) {
                break;
            }
            int r = distances[j];
            cnt += r % m == 0 ? r / m - 1 : r / m;
        }

        int cnt2 = 0; // maximum slots available to place a cafe
        for (i = 0; i < cafes.length - 1; i++) {
            if (distances[i] > 2) {
                cnt2 += distances[i] - 2;
            }
        }

        if (cnt <= k && k <= cnt2) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

//        int low = 0;
//        int high = distances.length - 1;
//        int mid;
//        while (low <= high) {
//            mid = low + (high - low) / 2;
//            if (m > distances[mid]) {
//                high = mid - 1;
//            } else {
//                low = mid + 1;
//            }
//        }
//        int spare = 0;
//        if (low - 1 < 0 || low - 1 > distances.length - 1) {
//            return m + 1;
//        }
//        for (int j = low - 1; j <= distances.length - 1; j++) {
//            spare += distances[j];
//        }
//        return spare / (k + 1);
    }
}
