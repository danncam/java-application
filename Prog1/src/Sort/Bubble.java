package Sort;

/**
 *
 * @author dan
 */
public class Bubble {

    public static void bubbleSort(int data[]) {
        int tmp, i, j;
        int n = data.length;
        for (i = 0; i < n - 1; i++) {
            for (j = i; j < n - 1; j++) {
                if (data[j] > data[j + 1]) {
                    tmp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = tmp;
                }
            }
        }
    }
}
