public class CafeOnRoadTest {

    public static void main(String[] args) {
        test2();
    }

    public static void test1() {
        int n = 15;
        int k = 2;
        int m = 3;
        int[] cafes = new int[]{6, 3, 12};
        long start = System.currentTimeMillis();
        var res = CafesOnRoad.calcPossibilityToBuildCafes(n, k, m, cafes);
        System.out.println("time: " + (System.currentTimeMillis() - start) + "ms");
        if (res) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static void test2() {
        int n = 15;
        int k = 2;
        int m = 1;
        int[] cafes = new int[]{6, 3, 12};
        long start = System.currentTimeMillis();
        var dd = CafesOnRoad.calcPossibilityToBuildCafes(n, k, m, cafes);
        System.out.println("time: " + (System.currentTimeMillis() - start) + "ms");
        if (dd) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static void test3() {
        int n = 15;
        int k = 2;
        int m = 3;
        int[] cafes = new int[]{};
        long start = System.currentTimeMillis();
        var dd = CafesOnRoad.calcPossibilityToBuildCafes(n, k, m, cafes);
        System.out.println("time: " + (System.currentTimeMillis() - start) + "ms");
        if (dd) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
