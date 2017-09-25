/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoestructuras;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author andre
 */
public class Prim {

    double[][] matrizAdy;
    TreeNode tree;

    public Prim(double[][] matriz) {
        matrizAdy = matriz;
    }
    
    public ArrayList<int[]> prim(int origen){
        double[] distancia = new double[matrizAdy.length];
        int[] padre = new int[matrizAdy.length];
        
        //ArrayList nodos = new ArrayList();
        Map<Integer, Double> nodos = new HashMap();
        for (int i = 0; i < matrizAdy.length; i++) {
            distancia[i] = 9999;
            padre[i] = -1;
            //nodos.add(i);
            nodos.put(i, 9999.0);
        }
        
        distancia[origen] = 0;
        
        while(!nodos.isEmpty()){
            double menorD = 99999;
            int nodoActual = 0;
            
            for (int i = 0; i < distancia.length; i++) {
                if(distancia[i] < menorD && nodos.containsKey(i)){
                    nodoActual = i;
                    menorD = distancia[i];
                }
            }
            
            nodos.remove(nodoActual);
            
            for (int ady = 0; ady < matrizAdy.length; ady++) {
                if(nodos.containsKey(ady) && distancia[ady] > matrizAdy[nodoActual][ady] && padre[ady] == -1 && matrizAdy[nodoActual][ady] != 0){
                    padre[ady] = nodoActual;
                    distancia[ady] = matrizAdy[nodoActual][ady];
                    System.out.println("true");
                }
            }
            
            
        }
        
        ArrayList<int[]> aristas = new ArrayList();
        for (int i = 0; i < matrizAdy.length; i++) {
            
            int[] edge = new int[3];
            int Padre = padre[i];
            double Distancia = distancia[i];
            
            edge[0] = Padre;
            edge[1] = i;
            edge[2] = (int)Distancia;
            aristas.add(edge);
        }
        
        
        aristas.remove(origen);
        
        
        return aristas;
    }

}
