package Arrays;
public class VectList {
    /**
     * 
     * 
     * esta matriz está organizada da seguinte maneira:
     * Linha [0] indica onde está o proximo elemento;
     * Linha [1] os dados do vetor (int)
     * 
     * |  1  |  2  |  3  | ...
     * | 122 | 183 | 295 |
     *   [0]   [1]   [2] ...
     * 
     * Adicionando elemento:
     * Primeiramente, faz-se uma busca no vetor para verificar se este ja não existe. 
     * Deve-se descobrir a posição correta do novo elemento, este é inserido na primeira posição válida. e também descobrir o índice do elemento anterior e o do posterior
     * O elemento adicionado recebe o índice do elemento anterior, o elemento anterior recebe o índice real do elemento adicionado
     * 
     * |  5  |  6  |  4  | ...
     * | 427 | 754 | 546 |
     *   [3]   [4]   [5] ...
     * 
     * Removendo elemento:
     * Busca-se o elemento,
     * 
     */
    private int[][] mat;
    int n;
    public VectList() {
        
    }
    
}
