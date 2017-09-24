/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoestructuras;

/**
 *
 * @author andre
 */
public class Floyd {
    private final GrafoMatriz grafo;
    
    public Floyd(GrafoMatriz grafo){
        this.grafo = grafo;
    }
    
    public double[][] distanciaTodosLosDestinos(){
       // int[][] distancias = new int[grafo.getMatrizAdy().length][grafo.getMatrizAdy().length];
        double[][] matriz = new double[grafo.getMatrizAdy().length][grafo.getMatrizAdy().length];

        for (int i = 0; i < grafo.getMatrizAdy().length; i++) {
            for (int j = 0; j < grafo.getMatrizAdy().length; j++) {
                if (i == j) {
                    grafo.setValor(i, j, 0);
                    //  matriz[i][j] = 0;
                } else {
                    matriz[i][j] = grafo.getValorMatriz(i, j);
                    if (grafo.getValorMatriz(i, j) == 0) {
                        grafo.setValor(i, j, 99999);
                        matriz[i][j] = 99999;
                    }
                }
            }
        }
        System.out.println("\n\n");
        /*
        for (int i = 0; i < grafo.getMatrizAdy().length; i++) {
            for (int j = 0; j < grafo.getMatrizAdy().length; j++) {
                System.out.print(matriz[i][j] + " ");
                //System.out.print(grafo.getValorMatriz(j, j));
            }
            System.out.println();
        }*/

        System.out.println();

        for (int k = 0; k < grafo.getMatrizAdy().length; k++) {
            for (int i = 0; i < grafo.getMatrizAdy().length; i++) {
                for (int j = 0; j < grafo.getMatrizAdy().length; j++) {
                    if (matriz[i][j] > matriz[i][k] + matriz[k][j] /*grafo.getValorMatriz(i, j)> (grafo.getValorMatriz(i, k) + grafo.getValorMatriz(k, j))*/) {
                        // grafo.setValor(i, j, grafo.getMatrizAdy()[i][k] + grafo.getMatrizAdy()[k][j]);

                        matriz[i][j] = matriz[i][k] + matriz[k][j];

                        //System.out.println("k: " + k + " j: " + j + " i: " + i);
                    }
                }
            }
        }
        
        return matriz;
    }
    
}
