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
import java.util.Map.Entry;

/**
 *
 * @author andre
 */
public class Prim {

    double[][] matrizAdy;
    TreeNode tree;
    Grafo grafo;

    public Prim(double[][] matriz) {
        matrizAdy = matriz;
    }
    
    public Prim(Grafo g){
        grafo = g;
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
                    //System.out.println("entro if");
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
    
    public void kruskal(){
        Map<Nodo, Nodo> aristas = new HashMap();
        for (int i = 0; i < grafo.getNodos().size(); i++) {
            ArrayList<Nodo> adyacentes = grafo.getNodos().get(i).getNodosAdyacentes();
            for (int j = 0; j < grafo.getNodos().get(i).getNodosAdyacentes().size(); j++) {
                if((aristas.containsKey(/*adyacentes.get(j)*/grafo.getNodos().get(i)) && aristas.get(/*adyacentes.get(j)*/grafo.getNodos().get(i)) != adyacentes.get(j))){
                    aristas.put(grafo.getNodos().get(i), adyacentes.get(j));
                }else if(aristas.containsKey(adyacentes.get(j)) && aristas.get(/*adyacentes.get(j)*/adyacentes.get(j)) != grafo.getNodos().get(i)){
                    aristas.put(adyacentes.get(j), grafo.getNodos().get(i));
                }else if(!aristas.containsKey(grafo.getNodos().get(i))){
                    aristas.put(grafo.getNodos().get(i), adyacentes.get(j));
                }else if(!aristas.containsKey(adyacentes.get(j))){
                    aristas.put(adyacentes.get(j), grafo.getNodos().get(i));
                    
                
                }
            }
        }
        
        for(Entry<Nodo, Nodo> arista : aristas.entrySet()){
            Nodo n = arista.getKey();
            Nodo n2 = arista.getValue();
            
            System.out.println("n: " + n.getId() + ", n2: " + n2.getId());
        }
        
        
        
    }

}
