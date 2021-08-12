package Sort;

/**
 *
 * @author dan
 */
public class Quick {

    public static void quickSort(int data[], int left, int right) {
        int mid, tmp, i, j;


        i = left;
        j = right;
        mid = data[(left + right) / 2];
        do {
            while (data[i] < mid) {
                i++;
            }
            while (mid < data[j]) {
                j--;
            }
            if (i <= j) {
                tmp = data[i];
                data[i] = data[j];
                data[j] = tmp;
                i++;
                j--;
            }
        } while (i <= j);
        if (left < j) {
            quickSort(data, left, j);
        }
        if (i < right) {
            quickSort(data, i, right);
        }
    }
}
