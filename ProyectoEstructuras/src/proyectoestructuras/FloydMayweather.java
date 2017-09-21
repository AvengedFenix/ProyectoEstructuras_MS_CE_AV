package proyectoestructuras;

public class FloydMayweather {

    //static GrafoMatriz g = new GrafoMatriz(7);
    static GrafoMatriz g = new GrafoMatriz(4, true);

    public static void main(String args[]) {
        /*g.agregarArista(0, 1, 1);
        g.agregarArista(0, 6, 2);
        g.agregarArista(1, 2, 3);
        g.agregarArista(2, 3, 4);
        g.agregarArista(1, 3, 5);
        g.agregarArista(3, 4, 6);
        g.agregarArista(2, 4, 7);
        g.agregarArista(3, 0, 8);
        g.agregarArista(3, 6, 9);
        g.agregarArista(4, 5, 10);
        g.agregarArista(5, 3, 11);
        g.agregarArista(5, 6, 12);*/

        g.agregarArista(0, 2, -2);
        g.agregarArista(2, 3, 2);
        g.agregarArista(3, 1, -1);
        //g.agregarArista(1, 0, -4);
        g.agregarArista(1, 0, 4);
        g.agregarArista(1, 2, 3);

        g.imprimirMatrizAdy();

        double[][] matriz = new double[g.getMatrizAdy().length][g.getMatrizAdy().length];

        for (int i = 0; i < g.getMatrizAdy().length; i++) {
            for (int j = 0; j < g.getMatrizAdy().length; j++) {
                if (i == j) {
                    g.setValor(i, j, 0);
                    //  matriz[i][j] = 0;
                } else {
                    matriz[i][j] = g.getValorMatriz(i, j);
                    if (g.getValorMatriz(i, j) == 0) {
                        g.setValor(i, j, 99999);
                        matriz[i][j] = 99999;
                    }
                }
            }
        }
        System.out.println("\n\n");
        for (int i = 0; i < g.getMatrizAdy().length; i++) {
            for (int j = 0; j < g.getMatrizAdy().length; j++) {
                System.out.print(matriz[i][j] + " ");
                //System.out.print(g.getValorMatriz(j, j));
            }
            System.out.println();
        }

        System.out.println();

        for (int k = 0; k < g.getMatrizAdy().length; k++) {
            for (int i = 0; i < g.getMatrizAdy().length; i++) {
                for (int j = 0; j < g.getMatrizAdy().length; j++) {
                    if (matriz[i][j] > matriz[i][k] + matriz[k][j] /*g.getValorMatriz(i, j)> (g.getValorMatriz(i, k) + g.getValorMatriz(k, j))*/) {
                        // g.setValor(i, j, g.getMatrizAdy()[i][k] + g.getMatrizAdy()[k][j]);
                        /*if (g.getValorMatriz(i, k) == 99999) {
                            g.setValor(i, j, 0);
                        } else if ( g.getValorMatriz(k, j) == 99999) {
                            g.setValor(k, j, 0);
                        }*/
                        //matriz[i][j] = g.getValorMatriz(i, k) + g.getValorMatriz(k, j);
                        matriz[i][j] = matriz[i][k] + matriz[k][j];
                        /*System.out.println("Debug: i " + i + " k " + k);
                        System.out.println(g.getValorMatriz(i, k));
                        System.out.println("Debug k " + k + " j " + j );
                        System.out.println(g.getValorMatriz(k, j));
                        System.out.println("Debug te pisan");
                        System.out.println(g.getMatrizAdy()[i][k] + g.getMatrizAdy()[k][j]);
                         */
                        System.out.println("k: " + k + " j: " + j + " i: " + i);
                    }
                }
            }
        }
        //  g.imprimirMatrizAdy();
        System.out.println();
        for (int i = 0; i < g.getMatrizAdy().length; i++) {
            for (int j = 0; j < g.getMatrizAdy().length; j++) {
                System.out.print(matriz[i][j] + "; ");
            }
            System.out.println();
        }

    }

    public String Floyd(String path) {
        GrafoMatriz g = new GrafoMatriz(4, true);

        g.agregarArista(0, 2, -2);
        g.agregarArista(2, 3, 2);
        g.agregarArista(3, 1, -1);
        //g.agregarArista(1, 0, -4);
        g.agregarArista(1, 0, 4);
        g.agregarArista(1, 2, 3);

        g.imprimirMatrizAdy();

        double[][] matriz = new double[g.getMatrizAdy().length][g.getMatrizAdy().length];

        for (int i = 0; i < g.getMatrizAdy().length; i++) {
            for (int j = 0; j < g.getMatrizAdy().length; j++) {
                if (i == j) {
                    g.setValor(i, j, 0);
                    //  matriz[i][j] = 0;
                } else {
                    matriz[i][j] = g.getValorMatriz(i, j);
                    if (g.getValorMatriz(i, j) == 0) {
                        g.setValor(i, j, 99999);
                        matriz[i][j] = 99999;
                    }
                }
            }
        }
        System.out.println("\n\n");
        for (int i = 0; i < g.getMatrizAdy().length; i++) {
            for (int j = 0; j < g.getMatrizAdy().length; j++) {
                System.out.print(matriz[i][j] + " ");
                //System.out.print(g.getValorMatriz(j, j));
            }
            System.out.println();
        }

        System.out.println();

        for (int k = 0; k < g.getMatrizAdy().length; k++) {
            for (int i = 0; i < g.getMatrizAdy().length; i++) {
                for (int j = 0; j < g.getMatrizAdy().length; j++) {
                    if (matriz[i][j] > matriz[i][k] + matriz[k][j] /*g.getValorMatriz(i, j)> (g.getValorMatriz(i, k) + g.getValorMatriz(k, j))*/) {
                        // g.setValor(i, j, g.getMatrizAdy()[i][k] + g.getMatrizAdy()[k][j]);
                        /*if (g.getValorMatriz(i, k) == 99999) {
                            g.setValor(i, j, 0);
                        } else if ( g.getValorMatriz(k, j) == 99999) {
                            g.setValor(k, j, 0);
                        }*/
                        //matriz[i][j] = g.getValorMatriz(i, k) + g.getValorMatriz(k, j);
                        matriz[i][j] = matriz[i][k] + matriz[k][j];
                        /*System.out.println("Debug: i " + i + " k " + k);
                        System.out.println(g.getValorMatriz(i, k));
                        System.out.println("Debug k " + k + " j " + j );
                        System.out.println(g.getValorMatriz(k, j));
                        System.out.println("Debug te pisan");
                        System.out.println(g.getMatrizAdy()[i][k] + g.getMatrizAdy()[k][j]);
                         */
                        System.out.println("k: " + k + " j: " + j + " i: " + i);
                    }
                }
            }
        }
        String texto = "";
        for (int i = 0; i < g.getMatrizAdy().length; i++) {
            for (int j = 0; j < g.getMatrizAdy().length; j++) {
                texto += matriz[i][j] + "; ";
                System.out.print(matriz[i][j] + "; ");
            }
            System.out.println();
            texto += "\n";
        }

        return texto;
    }
}
