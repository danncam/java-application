package Workaround;

public class SortingMatrix {
// for each
    public static void main(String[] args) {
        int[][] mtx = {{1, 35, 3, 7, 3, 5, 12},
            {5, 76, 2, 9, 7, 3, 23},
            {56, 43, 57, 36, 4, 67}};
//        for (int i = 0; i < mtx.length; i++) {
//            for (int j = i; j < mtx[0].length - 1 ; j++) {
//                for (int k = 0; k < mtx.length; k++) {
//                    for (int l = k; l < mtx[0].length - 1; l++) {
//                        int aux;
//                        if (mtx[i][j] < mtx[k][l]) {
//                            aux = mtx[i][j];
//                            mtx[i][j] = mtx[k][l];
//                            mtx[k][l] = aux;
//                        }
//
//                    }
//
//                }
//
//            }
//
//        }
        int[] is = openMatrix(mtx);
        for (int i = 0; i < mtx.length; i++) {
//            for (int j = 0; j < mtx.length; j++) {
                System.out.print(is[i]+ "\t");
                
//            }
//            System.out.print("");
        }
//        int[] vect = openMatrix(mat);
//        for (int i : vect) {
//            System.out.print(i + "\t");
//        }


    }
//    public static void SortMatrix(int[][] mat){
//        for (int i = 0; i < mat.length; i++) {
//            int[] is = mat[i];
//            
//        }
////        for (int[] is : mat) {
////            System.out.println(is);
////        }
//    }

    public static int[] openMatrix(int[][] mtx) {
        int[] is = new int[mtx.length * mtx[0].length];
        int countRow = 0, i;
        while(countRow > mtx[0].length){
            for (int[] j : mtx) {
                is = j;
            }
            countRow*=mtx.length;
        }
        return is;
    }

    public static int[][] SortingMatrix(int[][] mtx) {
        for (int i = 0; i < mtx.length; i++) {
            for (int j = 0; j < mtx[0].length; j++) {
                for (int k = 0; k < mtx.length; k++) {
                    for (int l = 0; l < mtx[0].length; l++) {
                        int aux;
                        if (mtx[i][j] < mtx[k][l]) {
                            aux = mtx[i][j];
                            mtx[i][j] = mtx[k][l];
                            mtx[k][l] = aux;
                        }

                    }

                }

            }

        }
        return mtx;
    }
}
