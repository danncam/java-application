package Sort;

/**
 *
 * @author dan
 */
public class Selection {

    public static void selectSort(int data[], int n) {
        int min, tmp, i, j, min_id = 0;

        for (i = 0; i < n - 1; i++) {
            min = data[i];
            for (j = i + 1; j < n; j++) {
                if (data[j] < min) {
                    min = data[j];
                    min_id = j;
                }
            }
            tmp = data[i];
            data[i] = data[min_id];
            data[min_id] = tmp;
        }
    }
}
