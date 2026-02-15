import java.util.Arrays;
import java.util.Scanner;

/**
 * В первой строке стандартного входа даны целые числа N, K, M — длина трассы в километрах,
 * количество новых придорожных кафе и максимально допустимое расстояние между двумя соседними кафе после появления новых
 * (10⩽N⩽1000,1⩽K⩽100,1⩽M⩽N). Далее дано целое число L, за которым следует
 * L натуральных чисел — номера путевых столбов, у которых уже есть придорожные кафе (помимо двух крайних).
 * У одного столба есть не более одного кафе. Гарантируется, что L+K<N.
 * В выходной поток выведите «YES», если там, где сейчас нет кафе, можно построить
 * K новых придорожных кафе так, чтобы расстояние между любыми двумя соседними кафе не превосходило
 * M км. В противном случае выведите «NO».
 * <p>
 * Sample Input:
 * 15 2 3
 * 3
 * 6 3 12
 * <p>
 * Sample Output:
 * YES
 */
public class CafesOnRoad {

    public static void readAndRun() {
        try (Scanner scanner = new Scanner(System.in)) {
            int nRoadLength = scanner.nextInt();
            int kNeedToBuildCafes = scanner.nextInt();
            int mNotFartherDistance = scanner.nextInt();
            int lCafesBuiltBetween = scanner.nextInt();
            int[] cafesBetween = new int[lCafesBuiltBetween];
            for (int i = 0; i < lCafesBuiltBetween; i++) {
                cafesBetween[i] = scanner.nextInt();
            }
            var result = calcPossibilityToBuildCafes(
                    nRoadLength, kNeedToBuildCafes, mNotFartherDistance, cafesBetween);
            if (result) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static boolean calcPossibilityToBuildCafes(
            int nRoadLength,
            int kNeedToBuildCafes,
            int mNotFartherDistance,
            int[] cafesBetween
    ) {
        int[] cafesAllBuilt = Arrays.copyOf(cafesBetween, cafesBetween.length + 2);
        cafesAllBuilt[cafesBetween.length] = 0;
        cafesAllBuilt[cafesBetween.length + 1] = nRoadLength;
        Arrays.sort(cafesAllBuilt);

        int[] distances = new int[cafesAllBuilt.length - 1];
        for (int i = 0; i < cafesAllBuilt.length - 1; i++) {
            distances[i] = cafesAllBuilt[i + 1] - cafesAllBuilt[i];
        }
        Arrays.sort(distances);

        int numMinimumToCoverAtLeastDistance = 0;
        for (int j = distances.length - 1; j >= 0; j--) {
            if (distances[j] < mNotFartherDistance) {
                break;
            }
            int widerThanMDistance = distances[j];
            numMinimumToCoverAtLeastDistance += widerThanMDistance % mNotFartherDistance == 0
                    ? widerThanMDistance / mNotFartherDistance - 1
                    : widerThanMDistance / mNotFartherDistance;
        }

        int maxEmptySlots = 0;
        for (int i = 0; i < distances.length; i++) {
            if (distances[i] >= 2) {
                maxEmptySlots += distances[i] + 1 - 2;
            }
        }

        return kNeedToBuildCafes <= maxEmptySlots && kNeedToBuildCafes >= numMinimumToCoverAtLeastDistance;
    }
}
