package Sort;

/**
 *
 * Heap Sort
 *
 * O heapsort utiliza uma estrutura de dados chamada heap binário para ordenar os elementos
 * a medida que os insere na estrutura. Assim, ao final das inserções,
 * os elementos podem ser sucessivamente removidos da raiz da heap, na ordem desejada.
 * Um heap binário é uma árvore binária mantida na forma de um vetor.
 *
 * pt.wikipedia.com
 *
 */
public class Heap {

    public static void heapSort(int[] v) {
        buildMaxHeap(v);
        int n = v.length;

        for (int i = v.length - 1; i > 0; i--) {
            swap(v, i, 0);
            maxHeapify(v, 0, --n);
        }
    }

    private static void buildMaxHeap(int[] v) {
        for (int i = v.length / 2 - 1; i >= 0; i--) {
            maxHeapify(v, i, v.length);
        }
    }

    private static void maxHeapify(int[] v, int pos, int n) {
        int max = 2 * pos + 1, right = max + 1;
        if (max < n) {
            if (right < n && v[max] < v[right]) {
                max = right;
            }
            if (v[max] > v[pos]) {
                swap(v, max, pos);
                maxHeapify(v, max, n);
            }
        }
    }

    public static void swap(int[] v, int j, int aposJ) {
        int aux = v[j];
        v[j] = v[aposJ];
        v[aposJ] = aux;
    }
}
