/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoestructuras;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
    
    public Map<Nodo, ArrayList<Nodo>> implementarDijkstra3() {

        for (Nodo nodo : grafo.getNodos()) {
            nodo.setDistancia(900);
        }

        ArrayList<Nodo> vistos = new ArrayList();
        ArrayList<Nodo> no_vistos = new ArrayList();

        Map<Nodo, ArrayList<Nodo>> caminos = new HashMap();

        this.origen.setDistancia(0);

        for (Nodo n : grafo.getNodos()) {
            caminos.put(n, new ArrayList<>());
        }

        no_vistos.add(this.origen);
        while (!no_vistos.isEmpty()) {
            Nodo nodoActual = encontrarNodoMenorD(no_vistos);
            no_vistos.remove(nodoActual);

            for (int i = 0; i < nodoActual.getNodosAdyacentes().size(); i++) {
                Nodo nAdy = nodoActual.getNodosAdyacentes().get(i);
                Double peso = nodoActual.getPesoAdyacente().get(i);

                Double menorDistancia = nodoActual.getDistancia();
                if (!vistos.contains(nAdy) && (nAdy.getDistancia() > menorDistancia + peso)) {
                    nAdy.setDistancia(menorDistancia + peso);
                    ArrayList<Nodo> cMasCorto = new ArrayList(nodoActual.getCaminoMasCorto());
                    cMasCorto.add(nodoActual);

                    nAdy.setCaminoMasCorto(cMasCorto);
                    
                    caminos.replace(nAdy, cMasCorto);

                    /*ArrayList<Nodo> c = caminos.get(nAdy);
                        c = new ArrayList(cMasCorto);
                     */
                }

                no_vistos.add(nAdy);

                ///visitados.add(nodoActual);
            }

            vistos.add(nodoActual);
        }

        /*for(Entry<Nodo, ArrayList<Nodo>> camino: caminos.entrySet()){
                Nodo actual = camino.getKey();
                System.out.println("camino mas corto de " + actual.getId() + ": ");
                StringBuilder sb = new StringBuilder();
                
                for(Nodo n : actual.getCaminoMasCorto()){
                    sb.append(n.getId()).append(", ");
                }
                System.out.print(sb.toString());
        }*/
        return caminos;
    }
    
    public Nodo encontrarNodoMenorD(ArrayList<Nodo> nodos) {
        Nodo NodoMenorD = null;
        double menDistancia = 9000;

        for (Nodo nodo : nodos) {
            double distancia = nodo.getDistancia();
            if (distancia < menDistancia) {
                menDistancia = distancia;
                NodoMenorD = nodo;
            }
        }

        return NodoMenorD;
    }
    
}
