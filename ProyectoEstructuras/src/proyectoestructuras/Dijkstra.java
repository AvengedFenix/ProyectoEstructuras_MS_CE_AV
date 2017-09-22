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

    public Map<Nodo, Double> DijkstraFinal() {
        Map<Nodo, Double> distancias = new HashMap();
        for (Nodo nodo : grafo.getNodos()) {
            distancias.put(nodo, 900.0);
        }

        ArrayList<Nodo> completos = new ArrayList();
        ArrayList<Nodo> noCompletos = new ArrayList();

        distancias.replace(this.origen, 0.0);

        noCompletos.add(this.origen);
        while (!noCompletos.isEmpty()) {
            //nodoActual = nodo de menor distancia
            Nodo nodoActual = new Nodo("");
            double menDistancia = 9000;
            for (Nodo nodo : noCompletos) {
                double distancia = distancias.get(nodo);
                if (distancia < menDistancia) {
                    menDistancia = distancia;
                    nodoActual = nodo;
                }
            }

            noCompletos.remove(nodoActual);

            for (int i = 0; i < nodoActual.getNodosAdyacentes().size(); i++) {//encontrar la distancia menor de los nodos adyacentes
                Nodo nAdy = nodoActual.getNodosAdyacentes().get(i);
                Double peso = nodoActual.getPesoAdyacente().get(i);

                Double menorDistancia = distancias.get(nodoActual);
                if (!completos.contains(nAdy) && (distancias.get(nAdy) > menorDistancia + peso)) {
                    distancias.replace(nAdy, menorDistancia + peso);

                }

                noCompletos.add(nAdy);
            }

            completos.add(nodoActual);
        }

        return distancias;
    }

}
