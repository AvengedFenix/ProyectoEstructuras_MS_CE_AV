package proyectoestructuras;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class FloydMayweather {

    //static GrafoMatriz g = new GrafoMatriz(7);
    static GrafoMatriz g = new GrafoMatriz(4, true);
    static String text = "";

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
 /*
        g.agregarArista(0, 2, -2);
        g.agregarArista(2, 3, 2);
        g.agregarArista(3, 1, -1);
        //g.agregarArista(1, 0, -4);
        g.agregarArista(1, 0, 4);
        g.agregarArista(1, 2, 3);

        g.imprimirMatrizAdy();
         */
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
                text += matriz[i][j] + "; ";
            }
            System.out.println();
            text += "\n";
        }
        getText();

        System.out.println("This is the variable text");
        System.out.println(text);
    }

    public String Floyd(String path) throws IOException {

    //    GrafoMatriz temp = createMatriz(path, true);
        GrafoMatriz g = createMatriz(path,true);
        /*
        g.agregarArista(0, 2, -2);
        g.agregarArista(2, 3, 2);
        g.agregarArista(3, 1, -1);
        //g.agregarArista(1, 0, -4);
        g.agregarArista(1, 0, 4);
        g.agregarArista(1, 2, 3);
         */
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
        System.out.println();
        text += "               ";
        for (int i = 0; i < g.getMatrizAdy().length; i++) {
            for (int j = 0; j < g.getMatrizAdy().length; j++) {
                System.out.print(matriz[i][j] + "; ");
                text += "   " + matriz[i][j] + ";   ";
            }
            System.out.println();
            if (i != g.getMatrizAdy().length - 1) {
                text += "\n\n\n";
                text += "               ";

            }
        }
        getText();

        System.out.println("This is the variable text");
        System.out.println(text);

        return text;
    }

    public GrafoMatriz createMatriz(String path, boolean dirigido) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        GrafoMatriz g;
        ArrayList<String[]> info = new ArrayList();
        try {
            String line = br.readLine();

            //int[][] matriz = new int[5][5];
            while (line != null) {
                String s = line.replaceAll(" ", "");
                info.add(s.split(","));
                //String[] x = info.get(info.size()-1);
                /*for(String s : x){
                    s = s.replaceAll(" ", "");
                }*/
                //System.out.println(Arrays.toString(s.split(",")));
                line = br.readLine();
            }

            for (int i = 0; i < info.size(); i++) {
                System.out.println(Arrays.toString(info.get(i)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            br.close();
        }
        g = new GrafoMatriz(info.size(), dirigido);

        double[][] matriz = new double[info.size()][info.size()];
        for (int i = 0; i < info.size(); i++) {
            for (int j = 0; j < info.size(); j++) {
                matriz[i][j] = Double.parseDouble(info.get(i)[j]);
                System.out.print(info.get(i)[j] + " ");
            }
            System.out.println("");
        }

        g.setMatrizAdy(matriz);
        //System.out.println(g.isBicoloreable());

        return g;
    }

    public static String getText() {
        return text;
    }
}
