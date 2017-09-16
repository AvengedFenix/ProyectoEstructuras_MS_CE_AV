/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoestructuras;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Scanner;
import org.graphstream.algorithm.Dijkstra;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.DefaultGraph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.stream.file.FileSourceDGS;

public class TDAGrafo {

    static String my_graph
            = "DGS004\n"
            + "my 0 0\n"
            + "an A \n"
            + "an B \n"
            + "an C \n"
            + "an D \n"
            + "an E \n"
            + "an F \n"
            + "ae AB A B weight:1 \n"
            + "ae AD A D weight:1 \n"
            + "ae BC B C weight:1 \n"
            + "ae CF C F weight:10 \n"
            + "ae DE D E weight:1 \n"
            + "ae EF E F weight:1 \n";

    public static void main(String[] args) throws IOException {
        Graph graph = new SingleGraph("Prueba1");
        graph.setStrict(false);
        graph.setAutoCreate(true);
        graph.addEdge("31", "3", "1",true);
        Node a = graph.getNode("3");
        a.addAttribute("ui.label", "A"); //Para que salga el nombre del vertice
        Edge AB = graph.getEdge("31");
        AB.setAttribute("weight", 2); // le seteas el atributo weight
        AB.setAttribute("ui.label", 2); //Lo imprime
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
        Node A = graph.getNode("A");

        Dijkstra d = new Dijkstra(Dijkstra.Element.EDGE, "weight", "A");
        d.init(graph);
   //     d.setSource("A");
//        d.compute();
//        System.out.println(d.getPathLength(A));
        graph.display();
    }

}
