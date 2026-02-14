import java.util.Random;

public class BinarySearchTest {

    public static void main(String[] args) {
//        test1();
        test2();
    }

    public static void test1() {
        int[] input = new int[]{1, 3, 4, 6, 8};
        int[] test = new int[]{3, 0, 9};
        int[] expected = new int[]{3, 5, 0};
        long start = System.currentTimeMillis();
        var result = BinarySearch.binarySearch(input, test);
        System.out.println("time: " + (System.currentTimeMillis() - start) + "ms");
    }

    public static void test2() {
        int[] input = new int[100000];
        int[] test = new int[300000];

        for (int i = 0; i < 100000; i++) {
            input[i] = Math.abs(Random.from(new Random(System.currentTimeMillis())).nextInt());
        }

        for (int i = 0; i < 300000; i++) {
            test[i] = Math.abs(Random.from(new Random(System.currentTimeMillis())).nextInt());
        }

        long start = System.currentTimeMillis();
        var result = BinarySearch.binarySearch(input, test);
        System.out.println("time: " + (System.currentTimeMillis() - start) + "ms");
    }
}
