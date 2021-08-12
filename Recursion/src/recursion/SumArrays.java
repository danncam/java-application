package recursion;
public class SumArrays {
    
    public static float sumArray(float[] array)
    {
        return sum_Aux2(array, 0, array.length);
    }
    
    
    /**
     * Método auxiliar recursivo que recebe um array de float e  armazena a saída em output:float
     * intialIndex e finalIndex servem para somar índices específicos do array
     */
    private static float sum_Aux(float[] array, float output, int initialIndex, int finalIndex)
    {
        if (initialIndex == finalIndex)
        {
            return output;
        } else {
            return output + sum_Aux(array, array[initialIndex], ++initialIndex, finalIndex);
        }
    }
    private static float sum_Aux2(float[] array, int initialIndex, int finalIndex)
    {
        if(initialIndex == finalIndex)
        {
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + " ");
                
            }
            return array[finalIndex - 1];
        } else {
            return array[initialIndex] + sum_Aux2(array, ++initialIndex, finalIndex);
        }
    }
}
