/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoestructuras;

import java.util.ArrayList;
import java.util.Collections;
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
        DorogovtsevMendesGenerator gen = new DorogovtsevMendesGenerator();
        Graph graph = new DefaultGraph("Prim Test");

        String css = "edge .notintree {size:1px;fill-color:gray;text-font:montserrat;} "
                + "edge .intree {size:3px;fill-color:black;text-font:montserrat;}"
                + "node {fill-mode: dyn-plain;fill-color: red, blue;text-size:16;text-font:montserrat;"
                + "size: 20px;}";

        graph.addAttribute("ui.stylesheet", css);
        graph.display();

        gen.addEdgeLabels(true);
        gen.addEdgeAttribute("weight");
        gen.setEdgeAttributesRange(1, 100.0);
        gen.addNodeLabels(true);
        gen.addSink(graph);
        gen.begin();

        for (int i = 0; i < 3 && gen.nextEvents(); i++);
        gen.end();

        for (int i = 0; i < graph.getEdgeCount(); i++) {
            Edge e = graph.getEdge(i);
            Double d = e.getAttribute("weight");
            System.out.println(e.getId() + " : " + d);
        }

        //graph.getNode(0).setAttribute("ui.color", 0.5);
        ArrayList<Node> nodes = new ArrayList();
        ArrayList<Edge> edges = new ArrayList();
        int u = 0;
        int v = 0;
        Node n = graph.getNode(0);

        for (int i = 0; i < graph.getEdgeSet().size(); i++) {
            edges.add(graph.getEdge(i));
        }

        System.out.println(edges);

        Edge lowEdge = null;

        while (graph.getNodeCount() + 1 != nodes.size()) {
            double weight = 0;
            double low = 10000;
            for (int i = 0; i < edges.size(); i++) {
                if ((double) edges.get(i).getAttribute("weight") < low) {
                    lowEdge = edges.get(i);
                    low = edges.get(i).getAttribute("weight");
                    System.out.println(low);
                }
            }
            for (int j = 0; j < edges.size() - 1; j++) {
                weight = lowEdge.getAttribute("weight");
                Node n1 = lowEdge.getNode0();
                Node n2 = lowEdge.getNode1();

                if (!nodes.contains(n2)) {
                    System.out.println("EDGE " + lowEdge.getId() + " INDEX " + j + "  WEIGHT " + weight);
                    lowEdge.changeAttribute("ui.style", "size:3px;fill-color:black;");
                    edges.remove(lowEdge);
                    nodes.add(n2);
                }
                if (!nodes.contains(n1)) {
                    System.out.println("EDGE " + lowEdge.getId() + " INDEX " + j + "  WEIGHT " + weight);
                    lowEdge.changeAttribute("ui.style", "size:3px;fill-color:black;");
                    edges.remove(lowEdge);
                    nodes.add(n1);
                }
                /*
                if (nodes.contains(n1) && nodes.contains(n2)) {
                    edges.remove(lowEdge);
                    lowEdge.changeAttribute("ui.style", "size:3px;fill-color:black;");
                }*/
            }

            System.out.println("Nodes" + nodes);
            System.out.println("Edges" + edges);

        }
    }

}
