package Arrays;

public class Arrays {

    public static void main(String[] args) {
        int[][] arr1 = {
            {3, 2, 4, 5}, //14
            {4, 6, 10, 3}, // 23
            {12, 30, 6, 4}, //52
            {3, 4, 2, 9} //18
        };
        int[][] arr2 = {
            {3, 4, 2, 5},
            {2, 45, 2, 5},
            {20, 5, 0, 4},
            {23, 5, 2, 10}
        };
        int[][] arr3 = mult(arr2, arr1);
//        for (int i = 0; i < arr2.length; i++) {
//            for (int j = 0; j < arr2.length; j++) {
//
//                System.out.print(arr3[i][j] + "\t");
//            }
//            System.out.println("");
//        }
//        int det = det(arr3);
//        System.out.println(det);
//        System.out.println(tentativa(arr1));
    }

    public static int[][] mult(int z, int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] *= z;
            }
        }
        return arr;
    }

    public static int[][] mult(int[][] arr1, int[][] arr2) {
        if (arr1[0].length != arr2.length) {
            return null;
        }
        int[][] arr3 = new int[arr1.length][arr2[0].length];
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                for (int k = 0; k < arr2[0].length; k++) {
                    arr3[i][j] += arr1[i][k] * arr2[k][j];

                }
            }
        }
        return arr3;
    }

    public static int det(int[][] arr) {
        if (arr.length != arr[0].length) {
            return 0;
        } else {
            switch (arr.length) {
                case 1:
                    return arr[0][0];
                case 2:
                    return det2(arr);
                default:
                    return laplace(arr, true);
            }
        }
    }

    private static int det2(int[][] arr) {
        return arr[0][0] * arr[1][1] - arr[0][1] * arr[1][0];
    }

    private static int laplace(int[][] arr, boolean e) {
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            int[][] nm = new int[arr.length - 1][arr.length - 1];
            for (int j = 0; j < arr.length; j++) {
                if (i != j) {
                    for (int k = 0; k < arr.length; k++) {
                        int indice = -1;
                        if (i < j) {
                            indice = j;
                        } else {
                            indice = j - 1;
                        }
                        nm[indice][k - 1] = arr[j][k];
                    }
                }
                if (i % 2 == 0) {
                    sum += arr[i][0] * laplace(nm, true);
                } else {
                    sum += arr[i][0] * laplace(nm, true);
                }
            }

        }
        return sum;
    }

    public static int laplace(int[][] arr) {

        return laplace(arr);
    }

    public static int sumRow(int[][] arr, int row) {
        int column = 0;
        return sumRowAux(arr, row, column);
    }

    private static int sumRowAux(int[][] arr, int row, int column) {
        if (column == arr.length - 1) {
            return arr[row][column];
        } else {
            return arr[row][column] + sumRowAux(arr, row, column + 1);
        }
    }

    public static int sumColumn(int[][] arr, int column) {
        int row = arr.length - 1;
        return sumColumnAux(arr, column, row);
    }

    public static int sumColumnAux(int[][] arr, int column, int row) {
        if (row == 0) {
            return arr[row][column];
        } else {
            return arr[row][column] + sumColumnAux(arr, column, row - 1);
        }
    }

    public static int menorLinha(int[][] arr) {
        int sum = 0;
        int aux = 0;
        int minor = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int k = 1; k < arr.length; k++) {
                for (int j = 0; j < arr.length; j++) {
                    sum += arr[i][j];
                    aux += arr[k][j];

                }
                if (sum < aux) {
                    minor = i;
                } else {
                    minor = k;
                }
            }
        }


        return minor;
    }
    static int soma = 0;

    public static int tentativa(int[][] arr, int i, int j) {
        soma += arr[i][j];
        if (j < arr.length) {
            return soma + tentativa(arr, i, j++);
        } else {
            if (i < arr.length) {
                j = 0;
                return soma + tentativa(arr, i++, j);
            } else {
                return soma;
            }
        }
    }
//    static int sum1, sum2, minor, r = 0, s = 1, t = 0;
//
//    public static int tent(int[][] arr) {
//        if ((r < arr.length - 1) && (s < arr.length)) {
//            if (t < arr.length) {
//                sum1 = arr[r][t] + tent(arr);
//                sum2 = arr[s][t] + tent(arr);
//                t++;
//                if(sum2 < sum1){
//                    minor = s;
//                }
//                else minor = r;
//            } else {
//                if (r == arr.length) {
//                    return arr[r][arr.length - 1];
//                }
//                if (s == arr.length) {
//                    return arr[s][arr.length - 1];
//                }
//            }
//            r++;
//            s++;
//            
//        }
//        return minor;
//    }


    public static int cof(int[][] arr, int i, int j) {
        int[][] aux = new int[arr.length - 1][arr.length - 1];

        for (int k = 0; k < arr.length; k++) {
            for (int l = 0; l < arr.length; l++) {
                if ((i != k) && (j != l)) {
                    aux[k][l] = arr[k][l];
                }
            }

        }
        return 0;
    }
}
