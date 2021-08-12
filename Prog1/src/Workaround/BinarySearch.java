package Workaround;

/**
 *
 * @author dan
 */
public class BinarySearch {

    /**
     * You can see recursive solution for Java and iterative for C++ below.
     * searches for a value in sorted array
     *
     * @param array
     *            array to search in
     * @param value
     *            searched value
     * @param left
     *            index of left boundary
     * @param right
     *            index of right boundary
     * @return position of searched value, if it presents in the array or -1, if
     *         it is absent
     */
    public static int binarySearch(int[] array, int value, int left, int right) {
        if (left > right) {
            return -1;
        }
        int middle = (left + right) / 2;
        if (array[middle] == value) {
            return middle;
        } else if (array[middle] > value) {
            return binarySearch(array, value, left, middle - 1);
        } else {
            return binarySearch(array, value, middle + 1, right);
        }
    }

    public static int binarySearch(int[] array, int value) {
        int firstIndex = 0;
        int lastIndex = array.length - 1;
        while (firstIndex <= lastIndex) {
            int middle = (firstIndex + lastIndex) / 2;
            if (array[middle] == value) {
                return middle;
            } else if (array[middle] > value) {
                lastIndex = middle - 1;

            } else {
                firstIndex = middle + 1;
            }
        }
        return -1;
    }
}
