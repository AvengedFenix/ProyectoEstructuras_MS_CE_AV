/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoestructuras;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author andre
 */
public class Dijkstra {

    Grafo grafo;
    Nodo origen;

    public void Dijkstra() {

    }

    public Dijkstra(Grafo grafo, Nodo origen) {
        this.grafo = grafo;
        this.origen = origen;
    }

    
    public Map<Nodo, Double> dijkstra(){
        Map<Nodo, Double> distancias = new HashMap();
        ArrayList<Nodo> nodosAProcesar = new ArrayList();

        

        for (int i = 0; i < grafo.getNodos().size(); i++) {
            distancias.put(grafo.getNodos().get(i), 9999.0);//la distancia de origen hasta el destino es infinita (no se sabe)
            if(Integer.parseInt(grafo.getNodos().get(i).getId()) == Integer.parseInt(origen.getId())){
            }
            nodosAProcesar.add(grafo.getNodos().get(i));
        }
        
        
        distancias.replace(origen, 0.0);//la distancia del nodo origen = 0
        while(!nodosAProcesar.isEmpty()){
            Nodo nodoActual = new Nodo("");
            //nodo actual va a ser el nodo con la menor distancia en la lista de nodos
            double menDistancia = 100000;
            for(Nodo n : nodosAProcesar){
                double distancia = distancias.get(n);
                if (distancia < menDistancia) {
                    menDistancia = distancia;
                    nodoActual = n;
                }
            }
            
            nodosAProcesar.remove(nodoActual);
            
            for (int j = 0; j < nodoActual.getNodosAdyacentes().size(); j++) {
                double dist = distancias.get(nodoActual) + nodoActual.getPesoAdyacente().get(j);
                Nodo ady = nodoActual.getNodosAdyacentes().get(j);
                if(dist < distancias.get(ady)){
                    distancias.replace(ady, dist);
                }
            }
        }
        
        
        
        return distancias;
        
        
    }

}
