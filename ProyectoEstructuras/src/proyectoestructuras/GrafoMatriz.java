/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoestructuras;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author andre
 */
public class GrafoMatriz {

    int nodos;
    double[][] matrizAdy;

    boolean dirigido;
    boolean bicoloreable;

    public GrafoMatriz(int nodos) {
        dirigido = false;
        this.nodos = nodos;
        matrizAdy = new double[nodos][nodos];

        for (int i = 0; i < matrizAdy.length; i++) {
            for (int j = 0; j < matrizAdy.length; j++) {
                if (i == j) {
                    matrizAdy[i][j] = 0;
                }
            }
        }
    }

    public GrafoMatriz(int nodos, boolean dirigido) {
        this.nodos = nodos;
        this.dirigido = dirigido;

        matrizAdy = new double[nodos][nodos];

        for (int i = 0; i < matrizAdy.length; i++) {
            for (int j = 0; j < matrizAdy.length; j++) {
                if (i == j) {
                    matrizAdy[i][j] = 0;
                }
            }
        }
    }

    public void agregarArista(int origen, int destino, double peso) {
        if ((origen >= 0 && origen < matrizAdy.length) && (destino >= 0 && destino < matrizAdy.length) && origen != destino) {
            if (!dirigido) {
                matrizAdy[origen][destino] = peso;
                matrizAdy[destino][origen] = peso;
            } else {
                matrizAdy[origen][destino] = peso;
            }

        } else {
            System.out.println("No se ha agregado el nodo");
        }

    }

    public void agregarArista(int origen, int destino) {
        if ((origen >= 0 && origen < matrizAdy.length) && (destino >= 0 && destino < matrizAdy.length) && origen != destino) {
            if (!dirigido) {
                matrizAdy[origen][destino] = 1;
                matrizAdy[destino][origen] = 1;
            } else {
                matrizAdy[origen][destino] = 1;
            }

        } else {
            System.out.println("No se ha agregado el nodo");
        }
    }

    public boolean tieneArista(int origen, int destino) {
        return (matrizAdy[origen][destino] != 0);
    }

    public void imprimirNodosAdy(int nodo) {
        for (int i = 0; i < matrizAdy.length; i++) {
            if (matrizAdy[nodo][i] != 0) {
                System.out.println(nodo + "->" + i + ": " + matrizAdy[nodo][i] + ", ");
            }
        }
    }

    public int getNodoAdyMenorCosto(int nodo) {
        int menor = 1000;
        for (int i = 0; i < matrizAdy.length; i++) {
            if (matrizAdy[nodo][i] != 0 && matrizAdy[nodo][i] < menor) {
                menor = i;
            }
        }

        return menor;
    }

    public void imprimirMatrizAdy() {
        for (int i = 0; i < matrizAdy.length; i++) {
            for (int j = 0; j < matrizAdy.length; j++) {
                System.out.print(matrizAdy[i][j] + "\t");
            }
            System.out.println("");
        }
    }

    public int getNodos() {
        return nodos;
    }

    public void setNodos(int nodos) {
        this.nodos = nodos;
    }

    public double[][] getMatrizAdy() {
        return matrizAdy;
    }
    
    public double getValorMatriz(int x, int y){
        return matrizAdy[x][y];
    }

    public void setMatrizAdy(double[][] matrizAdy) {
        this.matrizAdy = matrizAdy;
    }
    
    public void setValor(int x, int y, double v){
        matrizAdy[x][y] = v;
    }

    public boolean isDirigido() {
        return dirigido;
    }

    public void setDirigido(boolean dirigido) {
        this.dirigido = dirigido;
    }

    
    public ArrayList<String> Bicoloreable(int nodoOrigen) {
        boolean bipartito = true;

        int cantNodos = matrizAdy.length;
        //char colores[] = new char[cantNodos];
        /*ArrayList<Boolean> sincolor = new ArrayList();
        for(int i = 0; i < cantNodos; i++){
            sincolor.add(false);
        }*/

        ArrayList<String> colores = new ArrayList();
        for(int i = 0; i < cantNodos; i++){
            colores.add("null");
        }
        /*for (int i = 0; i < cantNodos; i++) {
            colores[i] = 'n';//n significa que no se le ha asignado un color
        }*/

        String[] a_o_r = new String[2];// array que contiene los colores que se asignaran a los nodos (azul o rojo)
        a_o_r[0] = "azul";
        a_o_r[1] = "rojo";

        //colores[nodoOrigen] = 'a';
        colores.set(nodoOrigen, "azul");
        ArrayList<Integer> nodosMatriz = new ArrayList();
        nodosMatriz.add(nodoOrigen);

        while (!nodosMatriz.isEmpty()) {
            //System.out.println("size: " + nodosMatriz.size());
            int nodo = nodosMatriz.remove(0);

            for (int ady = 0; ady < cantNodos; ady++) {
                if (matrizAdy[nodo][ady] != 0 && colores.get(ady).equals("null")/*colores[ady] == 'n'*/) {

                    //colores[ady] = (colores[nodo] == 'a') ? (colores[ady] = a_o_r[1]) : (colores[ady] = a_o_r[0]);// se le asigna el color opuesto al nodo adyacente, 
                    String color = colores.get(nodo).equals("azul") ? (a_o_r[1]) : (a_o_r[0]);
                    colores.set(ady, color);
                    //si es rojo se le asigna azul, si es azul se le asigno rojo

                    //sincolor.set(ady, true);
                    nodosMatriz.add(ady);
                } else if (matrizAdy[nodo][ady] != 0 && colores.get(nodo).equals(colores.get(ady))/*colores[ady] == colores[nodo]*/) {
                    System.out.println("Nodos adyacentes: " + (nodo + 1) + "->" + (ady + 1) + " tienen el mismo color");
                    bipartito = false;

                }
            }
        }

        if (bipartito) {
            for (int i = 0; i < colores.size()/*length*/; i++) {
                //System.out.println("nodo: " + i + ", color: " + colores[i]);
                System.out.println("nodo: " + i + ", color: " + colores.get(i));
            }
            this.bicoloreable = true;
        }

        return colores;
    }
    
    public boolean isBicoloreable(){
        return this.bicoloreable;
    }
    
    
    public ArrayList<String> DFSbipartito(int origen) {
        /*
         procedure DFS-iterative(G,v):
2      let S be a stack
3      S.push(v)
4      while S is not empty
5          v = S.pop()
6          if v is not labeled as discovered:
7              label v as discovered
8              for all edges from v to w in G.adjacentEdges(v) do 
9                  S.push(w)*/

        Stack<Integer> s = new Stack();
        boolean[] visitados = new boolean[matrizAdy.length];
        ArrayList<String> colores = new ArrayList();

        for (int i = 0; i < matrizAdy.length; i++) {
            colores.add("");
        }


        s.push(origen);//agregar nodo origen al stack
        colores.set(origen, "azul");//se asigna un color al nodo origen
        while (!s.isEmpty()) {
            
            int nodo = s.pop();
            
            if (visitados[nodo] == false) {
                visitados[nodo] = true;
                System.out.println("nodo dfs: " + nodo);
            }

            for (int ady = 0; ady < matrizAdy.length; ady++) {
                if (matrizAdy[nodo][ady] != 0 && visitados[ady] == false) {
                    if (colores.get(nodo).equals("azul") && colores.get(ady).equals("")) /*&& colores.get(ady).equals(" ")*/ {
                        colores.set(ady, "rojo");
                        System.out.println("pintando " + ady + " rojo");
                        //System.out.println("entro rojo if ");
                    } else if(colores.get(nodo).equals("rojo") && colores.get(ady).equals("")){
                        colores.set(ady, "azul");
                        System.out.println("pintando " + ady + " azul");
                        //System.out.println("entro azul else");
                    }
                    //System.out.print(matrizAdy[nodo][ady] + " ");
                    //if(!s.contains(ady))
                        s.push(ady);
                }
            }

        }
        
        /*
        System.out.println("colores: \n");
        for (int i = 0; i < colores.size(); i++) {
            System.out.println(colores.get(i));
        }*/

        bicoloreable = true;
        //System.out.println("colores size: " + colores.size());
        System.out.println("");
        for (int i = 0; i < matrizAdy.length; i++) {
            for (int j = 0; j < matrizAdy.length; j++) {
                if (matrizAdy[i][j] != 0) {
                    if (colores.get(i).equals(colores.get(j))) {//si el color de i (nodo actual) es igual al color de j (adyacente) no es bipartito
                        bicoloreable =  false;
                    }
                }
            }
        }
        //System.out.println("");
        return colores;
    }
    
    
}
