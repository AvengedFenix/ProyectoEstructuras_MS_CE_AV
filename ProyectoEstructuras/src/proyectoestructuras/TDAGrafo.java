/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoestructuras;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import org.graphstream.algorithm.Dijkstra;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.DefaultGraph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.stream.file.FileSourceDGS;

public class TDAGrafo {

    static Scanner sc = new Scanner(System.in);

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

        graph.addEdge("AB", "A", "B", true);
        Node a = graph.getNode("A");
        a.addAttribute("ui.label", "A"); //Para que salga el nombre del vertice
        Edge AB = graph.getEdge("AB");
        AB.setAttribute("weight", 1); // le seteas el atributo weight
        AB.setAttribute("ui.label", 1); //Lo imprime

        graph.addEdge("BC", "B", "C", true);
        Node b = graph.getNode("B");
        b.addAttribute("ui.label", "B"); //Para que salga el nombre del vertice
        Edge BC = graph.getEdge("BC");
        BC.setAttribute("weight", 2); // le seteas el atributo weight
        BC.setAttribute("ui.label", 2); //Lo imprime

        graph.addEdge("CD", "C", "D", true);
        Node c = graph.getNode("C");
        c.addAttribute("ui.label", "C"); //Para que salga el nombre del vertice
        Edge CD = graph.getEdge("CD");
        CD.setAttribute("weight", 3); // le seteas el atributo weight
        CD.setAttribute("ui.label", 3); //Lo imprime

        graph.addEdge("DE", "D", "E", true);
        Node d = graph.getNode("D");
        d.addAttribute("ui.label", "C"); //Para que salga el nombre del vertice
        Edge DE = graph.getEdge("DE");
        DE.setAttribute("weight", 4); // le seteas el atributo weight
        DE.setAttribute("ui.label", 4); //Lo imprime

        graph.addEdge("EF", "E", "F", true);
        Node e = graph.getNode("E");
        e.addAttribute("ui.label", "E"); //Para que salga el nombre del vertice
        Edge EF = graph.getEdge("EF");
        EF.setAttribute("weight", 5); // le seteas el atributo weight
        EF.setAttribute("ui.label", 5); //Lo imprime

        graph.addEdge("AF", "A", "F", true);
        Node f = graph.getNode("F");
        f.addAttribute("ui.label", "F"); //Para que salga el nombre del vertice
        Edge AF = graph.getEdge("AF");
        AF.setAttribute("weight", 6); // le seteas el atributo weight
        AF.setAttribute("ui.label", 6); //Lo imprime

        graph.addEdge("GA", "G", "A", true);
        Node g = graph.getNode("G");
        g.addAttribute("ui.label", "G"); //Para que salga el nombre del vertice
        Edge GA = graph.getEdge("GA");
        GA.setAttribute("weight", 7); // le seteas el atributo weight
        GA.setAttribute("ui.label", 7); //Lo imprime

        graph.addEdge("GD", "G", "D", true);

        Edge GD = graph.getEdge("GD");
        GD.setAttribute("ui.label", 8); //Lo imprime
        GD.setAttribute("weight", 8);
        graph.addEdge("EG", "E", "G", true);
        // Node e = graph.getNode("C");
        //  a.addAttribute("ui.label", "C"); //Para que salga el nombre del vertice
        Edge EG = graph.getEdge("EG");
        EG.setAttribute("weight", 9); // le seteas el atributo weight
        EG.setAttribute("ui.label", 9); //Lo imprime

        graph.addEdge("GF", "G", "F", true);
        //Node f = graph.getNode("C");
        //a.addAttribute("ui.label", "C"); //Para que salga el nombre del vertice
        Edge GF = graph.getEdge("GF");
        GF.setAttribute("weight", 10); // le seteas el atributo weight
        GF.setAttribute("ui.label", 10); //Lo imprime

        graph.addEdge("BG", "B", "G", true);
        //  Node b = graph.getNode("C");
        //a.addAttribute("ui.label", "C"); //Para que salga el nombre del vertice
        Edge BG = graph.getEdge("BG");
        BG.setAttribute("weight", 11); // le seteas el atributo weight
        BG.setAttribute("ui.label", 11); //Lo imprime

        graph.addEdge("CG", "C", "G", true);
        //   Node c = graph.getNode("C");
        //a.addAttribute("ui.label", "C"); //Para que salga el nombre del vertice
        Edge CG = graph.getEdge("CG");
        CG.setAttribute("weight", 12); // le seteas el atributo weight
        CG.setAttribute("ui.label", 12); //Lo imprime

        Node A = graph.getNode("A");
        System.out.println("Select the node you want as a Start Point");
        for (int i = 0; i < graph.getNodeCount(); i++) {
            System.out.println(graph.getNode(i).getId());
        }
        String start = sc.next();
        Node sn = graph.getNode(start);
        System.out.println("Select the node you want as an ending point");
        for (int i = 0; i < graph.getNodeCount(); i++) {
            System.out.println(graph.getNode(i).getId());
        }
        String end = sc.next();
        Node en = graph.getNode(end);
        graph.display();
        // DijkstraMethod(sn, en, 0);
        FloydMayweather(graph);
        System.out.println("Ya salí del método");

        //  Dijkstra d = new Dijkstra(Dijkstra.Element.EDGE, "weight", "A");
        //  d.init(graph);
        //     d.setSource("A");
//        d.compute();
//        System.out.println(d.getPathLength(A));
    }

    public static int DijkstraMethod(Node sn, Node en, int camino) {
        if (sn == en) {
            System.out.println("El camino más barato tiene un valor de: " + camino);
            return camino;
        }
        System.out.println("Edge set");
        System.out.println(sn.getEdgeSet());

        int temp = sn.getEdge(0).getAttribute("weight");
        //Node nextNode = sn.getEdge(0).getNode0();
        Node nextNode = sn.getEdge(0).getTargetNode();

        for (int i = 0; i < sn.getEdgeSet().size(); i++) {
            System.out.println(sn.getEdge(i).getId());
            System.out.println("Aqui está temp..............................................");
            System.out.println(temp);
            if ((int) sn.getEdge(i).getAttribute("weight") < temp) {
                System.out.println("Aqui está temp 2");
                System.out.println(temp);
                temp = sn.getEdge(i).getAttribute("weight");
                nextNode = sn.getEdge(i);
            }
            camino = +temp;
            System.out.println("Entre" + i);
        }
        System.out.println(nextNode);
        DijkstraMethod(nextNode, en, camino);
        return camino;
    }

    public static void FloydMayweather(Graph g) {
        int[][] matrix = new int[g.getEdgeCount()][g.getEdgeCount()];
        for (int i = 0; i < g.getNodeCount(); i++) {
            for (int j = 0; j < 10; j++) {
                if (i == j) {
                    matrix[i][j] = 0;
                } else {
                    matrix[i][j] = g.getEdge(i).getAttribute("weight");
                }
                    System.out.print(matrix[i][j] + " ");

            }
            System.out.println("");
        }

    }
}
