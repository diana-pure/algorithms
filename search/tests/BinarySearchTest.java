
public class BinarySearchTest {

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        int[] input = new int[]{1, 3, 4, 6, 8};
        int[] test = new int[]{3, 0, 9};
        int[] expected = new int[]{3, 5, 0};
        long start = System.currentTimeMillis();
        var result = BinarySearch.binarySearch(input, test);
        System.out.println("time: " + (System.currentTimeMillis() - start) + "ms");
    }

}
