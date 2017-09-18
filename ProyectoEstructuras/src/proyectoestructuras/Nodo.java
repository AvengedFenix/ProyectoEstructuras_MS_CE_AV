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
    private ArrayList<Nodo> caminoMasCorto = new ArrayList();
    private double distancia;
    ArrayList<Double> pesoAdy = new ArrayList();
    ArrayList<Nodo> NodosAdy = new ArrayList();
    
    
    public Nodo(String id){
        this.id = id;
    }
    
    public void agregarDestino(Nodo destino, double dist){
        //nodosAdy.put(destino, dist);
        NodosAdy.add(destino);
        pesoAdy.add(dist);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Nodo> getCaminoMasCorto() {
        return caminoMasCorto;
    }

    public void setCaminoMasCorto(ArrayList<Nodo> caminoMasCorto) {
        this.caminoMasCorto = caminoMasCorto;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    
    public ArrayList<Nodo> getNodosAdyacentes(){
        return this.NodosAdy;
    }
    
    public ArrayList<Double> getPesoAdyacente(){
        return this.pesoAdy;
    }
    
    
    
}
