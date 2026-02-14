import java.util.Arrays;
import java.util.Random;

public class CafeOnRoadTest {

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        int n = 15;
        int k = 2;
        int m = 3;
        int l = 3;
        int[] cafes = new int[]{6, 3, 12};
        long start = System.currentTimeMillis();
        int dd = CafesOnRoad.f(n, k, m, l, cafes);
        System.out.println("time: " + (System.currentTimeMillis() - start) + "ms");
        if (dd <= m) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
