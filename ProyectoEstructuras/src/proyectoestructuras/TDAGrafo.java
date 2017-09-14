/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectoestructuras;
import java.util.Scanner;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.SingleGraph;

public class TDAGrafo{
    public static void main(String[] args){
        Graph graph = new SingleGraph("Prueba1");
        graph.setStrict(false);
        graph.setAutoCreate(true);
        graph.addEdge("31", "3", "1",true);
        graph.addEdge("12", "1", "2",true);
        graph.addEdge("25", "2", "5",true);
        graph.addEdge("57", "5", "7",true);
        graph.addEdge("76", "7", "6",true);
        graph.addEdge("36", "3", "6",true);
        graph.addEdge("43", "4", "3",true);
        graph.addEdge("45", "4", "5",true);
        graph.addEdge("74", "7", "4",true);
        graph.addEdge("46", "4", "6",true);
        graph.addEdge("14", "1", "4",true);
        graph.addEdge("24", "2", "4",true);
        
        
        graph.display();
    }
}


