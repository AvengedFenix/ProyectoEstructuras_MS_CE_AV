/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoestructuras;

import java.util.ArrayList;

/**
 *
 * @author andre
 */
public class Nodo {

    private String id;
    ArrayList<Double> pesoAdy = new ArrayList();
    ArrayList<Nodo> NodosAdy = new ArrayList();

    public Nodo(String id) {
        this.id = id;
    }

    public void agregarArista(Nodo destino, double dist) {
        NodosAdy.add(destino);
        pesoAdy.add(dist);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Nodo> getNodosAdyacentes() {
        return this.NodosAdy;
    }

    public ArrayList<Double> getPesoAdyacente() {
        return this.pesoAdy;
    }

    public String printNodosAdy() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < NodosAdy.size(); i++) {
            String s = "";
            s += this.id + " -> " + NodosAdy.get(i).getId() + ": " + pesoAdy.get(i) + "\n";
            sb.append(s);
        }

        return sb.toString();

    }

}
