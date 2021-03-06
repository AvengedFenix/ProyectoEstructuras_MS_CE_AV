/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoestructuras;

import java.util.ArrayList;
import java.util.Collections;
import org.graphstream.algorithm.Kruskal;
import org.graphstream.algorithm.generator.DorogovtsevMendesGenerator;
import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.DefaultGraph;

/**
 *
 * @author calvinespinoza
 */
public class KruskalTest {

    public static void main(String... args) {
        //DorogovtsevMendesGenerator gen = new DorogovtsevMendesGenerator();
        //Graph graph = new DefaultGraph("Prim Test");
        GrafoMatriz graph = new GrafoMatriz(4, true);
        graph.agregarArista(0, 2, -2);
        graph.agregarArista(2, 3, 2);
        graph.agregarArista(3, 1, -1);
        graph.agregarArista(1, 0, 4);
        graph.agregarArista(1, 2, 3);
        
        Graph graphstream = new DefaultGraph("Prim Test");
        for (int i = 0; i < graph.getMatrizAdy().length; i++) {
            graphstream.addNode(Integer.toString(i));
            // for (int j = 0; j < graph.getMatrizAdy().length; j++) {
            //   graphstream.add
            //}
        }

        for (int i = 0; i < graph.getMatrizAdy().length; i++) {
            for (int j = 0; j < graph.getMatrizAdy().length; j++) {
               // String s = Integer.toString(i) + Integer.toString(j);
                if (i == j) {
                    System.out.println("Nothing");
                }else if(graph.getMatrizAdy()[i][j] != 0){
                    graphstream.addEdge("i: " + Integer.toString(i) + " j: " + Integer.toString(j), Integer.toString(i), Integer.toString(j));
                    graphstream.getEdge("i: " + Integer.toString(i) + " j: " + Integer.toString(j)).setAttribute("weight", graph.getValorMatriz(i, j));
                    graphstream.getEdge("i: " + Integer.toString(i) + " j: " + Integer.toString(j)).setAttribute("ui.label", graph.getValorMatriz(i, j));
                    
                }
            }
        }

        String css = "edge .notintree {size:1px;fill-color:gray;text-font:montserrat;} "
                + "edge .intree {size:3px;fill-color:black;text-font:montserrat;}"
                + "node {fill-mode: dyn-plain;fill-color: red, blue;text-size:16;text-font:montserrat;"
                + "size: 20px;}";

        graphstream.addAttribute("ui.stylesheet", css);
        graphstream.display();

        /*gen.addEdgeLabels(true);
        gen.addEdgeAttribute("weight");
        gen.setEdgeAttributesRange(1, 100.0);
        gen.addNodeLabels(true);
        gen.addSink(graph);
        gen.begin();

        for (int i = 0; i < 3 && gen.nextEvents(); i++);
        gen.end();*/

        Kruskal kruskal = new Kruskal("ui.class", "intree", "notintree");
        kruskal.init(graphstream);
        kruskal.compute();

    }
    
    public static void Krusky(String path){
          GrafoMatriz graph = new GrafoMatriz(4, true);
        graph.agregarArista(0, 2, -2);
        graph.agregarArista(2, 3, 2);
        graph.agregarArista(3, 1, -1);
        graph.agregarArista(1, 0, 4);
        graph.agregarArista(1, 2, 3);
        
        Graph graphstream = new DefaultGraph("Prim Test");
        for (int i = 0; i < graph.getMatrizAdy().length; i++) {
            graphstream.addNode(Integer.toString(i));
            // for (int j = 0; j < graph.getMatrizAdy().length; j++) {
            //   graphstream.add
            //}
        }

        for (int i = 0; i < graph.getMatrizAdy().length; i++) {
            for (int j = 0; j < graph.getMatrizAdy().length; j++) {
               // String s = Integer.toString(i) + Integer.toString(j);
                if (i == j) {
                   // System.out.println("Nothing");
                }else if(graph.getMatrizAdy()[i][j] != 0){
                    graphstream.addEdge("i: " + Integer.toString(i) + " j: " + Integer.toString(j), Integer.toString(i), Integer.toString(j));
                    graphstream.getEdge("i: " + Integer.toString(i) + " j: " + Integer.toString(j)).setAttribute("weight", graph.getValorMatriz(i, j));
                    graphstream.getEdge("i: " + Integer.toString(i) + " j: " + Integer.toString(j)).setAttribute("ui.label", graph.getValorMatriz(i, j));
                    
                }
            }
        }

        String css = "edge .notintree {size:1px;fill-color:gray;text-font:montserrat;} "
                + "edge .intree {size:3px;fill-color:black;text-font:montserrat;}"
                + "node {fill-mode: dyn-plain;fill-color: red, blue;text-size:16;text-font:montserrat;"
                + "size: 20px;}";

        graphstream.addAttribute("ui.stylesheet", css);
        graphstream.display();

        /*gen.addEdgeLabels(true);
        gen.addEdgeAttribute("weight");
        gen.setEdgeAttributesRange(1, 100.0);
        gen.addNodeLabels(true);
        gen.addSink(graph);
        gen.begin();

        for (int i = 0; i < 3 && gen.nextEvents(); i++);
        gen.end();*/

        Kruskal kruskal = new Kruskal("ui.class", "intree", "notintree");
        kruskal.init(graphstream);
        kruskal.compute();
    }

    public static void myKruskal(Graph graph) {
        for (int i = 0; i < graph.getEdgeCount(); i++) {
            Edge e = graph.getEdge(i);
            e.addAttribute("ui.label", Double.toString(e.getAttribute("weight")));
            Double d = e.getAttribute("weight");
            System.out.println(e.getId() + " : " + d);
        }

        //graph.getNode(0).setAttribute("ui.color", 0.5);
        ArrayList<Node> nodes = new ArrayList();
        ArrayList<Edge> edges = new ArrayList();
        ArrayList<Edge> visited = new ArrayList();
        for (int i = 0; i < graph.getEdgeSet().size(); i++) {
            edges.add(graph.getEdge(i));
        }

        System.out.println(edges);
        Edge lowEdge = null;

        while (visited.size() <= nodes.size() + 1) {
            double weight = 0;
            double low = 10000;
            for (int i = 0; i < edges.size(); i++) {
                if ((double) edges.get(i).getAttribute("weight") < low) {
                    lowEdge = edges.get(i);
                    low = edges.get(i).getAttribute("weight");
                    System.out.println(low);
                }
            }
            edges.remove(lowEdge);
            visited.add(lowEdge);
            for (int j = 0; j < edges.size() - 1; j++) {
                weight = lowEdge.getAttribute("weight");
                Node n1 = lowEdge.getNode0();
                Node n2 = lowEdge.getNode1();

                if (!nodes.contains(n2)) {
                    System.out.println("EDGE " + lowEdge.getId() + " INDEX " + j + "  WEIGHT " + weight);
                    lowEdge.changeAttribute("ui.style", "size:3px;fill-color:black;");
                    nodes.add(n2);
                }
                if (!nodes.contains(n1)) {
                    System.out.println("EDGE " + lowEdge.getId() + " INDEX " + j + "  WEIGHT " + weight);
                    lowEdge.changeAttribute("ui.style", "size:3px;fill-color:black;");
                    nodes.add(n1);
                }

                if (nodes.contains(n1) && nodes.contains(n2) && checkCycle(visited, lowEdge) == false) {
                    System.out.println("EDGE " + lowEdge.getId() + " INDEX " + j + "  WEIGHT " + weight);

                    lowEdge.changeAttribute("ui.style", "size:3px;fill-color:black;");
                }

            }
            System.out.println("Nodes" + nodes);
            System.out.println("Edges" + edges);

        }
    }

    public static boolean checkCycle(ArrayList<Edge> edges, Edge lowEdge) {
        Node n1 = lowEdge.getNode0();
        Node n2 = lowEdge.getNode1();
        for (int i = 0; i < edges.size(); i++) {
            Node n3 = edges.get(i).getNode0();
            Node n4 = edges.get(i).getNode1();
            if (n3.equals(n1) || n4.equals(n1) || n3.equals(n2) || n4.equals(n2)) {
                return true;
            }
        }
        return false;
    }
}
