/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoestructuras;

import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author andre
 */
public class Grafo {

    //int[] nodos;
    private ArrayList<Nodo> nodos;


    public Grafo() {
        nodos = new ArrayList();
    }
    
    public void agregarNodo(Nodo nodo){
        if(!existeNodo(nodo))
            nodos.add(nodo);
        else
            System.out.println("ya existe");
    }
    
    public boolean existeNodo(Nodo nodo){
        for(Nodo vertice : nodos){
            if(vertice.getId().equals(nodo.getId())) return true;
        }
        
        return false;
    }
    
    
    

    /*
    public Grafo(int NumNodos) {
        nodos = new int[NumNodos];
        aristas = new ArrayList();
        for (int i = 0; i < nodos.length; i++) {
            nodos[i] = -1;
            aristas.add(new ArrayList());
        }
    }

    public void addNodo(int a) {
        for (int i = 0; i < nodos.length; i++) {
            if (nodos[i] == (-1)) {
                nodos[i] = a;
                 break;
            }
           
        }
    }

    public void agregarArista(int nodo, int origen, int destino) {
        aristas.get(nodo).add(new Arista(origen, destino));
    }

    public void agregarAristaPeso(int nodo, double peso, int origen, int destino) {
        aristas.get(nodo).add(new Arista(peso, origen, destino));
    }

    public boolean existeNodo(String nodo) {
        for (int i = 0; i < nodos.length; i++) {
            if (nodo.equals(nodos[i])) {
                return true;
            }
        }

        return false;
    }

    public String nodosConectados(int nodo) {
        int index = -1;
        
        for (int i = 0; i < nodos.length; i++) {
            if (nodo == (nodos[i])) {
                index = i;
            }
        }
        System.out.println("i: " + index + " = " + nodos[index]);
        ArrayList<Arista> ari = aristas.get(index);
        
        StringBuilder sb = new StringBuilder();

        for (Arista arista : ari) {
            sb.append(arista.toString());
            sb.append(" ");
        }
        return sb.toString();

    }
*/

    public ArrayList<Nodo> getNodos() {
        return nodos;
    }

    public void setNodos(ArrayList<Nodo> nodos) {
        this.nodos = nodos;
    }

    
    public boolean esBipartito(Grafo grafo){
        ArrayList<Nodo> grupo1 = new ArrayList();
        ArrayList<Nodo> grupo2 = new ArrayList();
        for(Nodo nodo : grafo.getNodos()){
            grupo1.add(nodo);
            /*Map<Nodo, Double> nodosAdy = nodo.getNodosAdy();
            for(Map.Entry<Nodo, Double> adyacentes: nodosAdy.entrySet()){
                Nodo nodoAdyacente = adyacentes.getKey();
                
                grupo2.add(nodoAdyacente);
                
            }*/
        }
        return true;
    }
    
    
}
