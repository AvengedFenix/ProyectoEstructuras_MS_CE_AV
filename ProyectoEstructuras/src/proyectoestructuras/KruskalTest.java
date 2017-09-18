/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoestructuras;

import java.util.ArrayList;
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

        for (int i = 0; i < 6 && gen.nextEvents(); i++);
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
        nodes.add(n);
        for (int i = 0; i < graph.getEdgeSet().size(); i++) {
            edges.add(graph.getEdge(i));
        }
        
        System.out.println(nodes);

        while (graph.getNodeCount() != nodes.size()) {
            double low = 1000000;
            double weight = 0;
            for (int k = 0; k < nodes.size(); k++) {
                n = nodes.get(k);
                for (int j = 0; j < n.getEdgeSet().size(); j++) {
                    weight = n.getEdge(j).getAttribute("weight");
                    if (!edges.contains(n.getEdge(j)) && (!nodes.contains(n.getEdge(j).getSourceNode()) || !nodes.contains(n.getEdge(j).getTargetNode()))) {
                        System.out.println("NODE " + n.getId() + "  EDGE " + j + "  WEIGHT " + weight);
                        if (weight < low) {
                            low = weight;
                            v = j;
                            u = k;
                        }
                    }
                }
            }
            System.out.println(low);

            Node n1 = nodes.get(u).getEdge(v).getNode0();
            Node n2 = nodes.get(u).getEdge(v).getNode1();

            if (!nodes.contains(n2)) {
                nodes.add(n2);
            } else if (!nodes.contains(n1)) {
                nodes.add(n1);
            }
            edges.add(nodes.get(u).getEdge(v));
            nodes.get(u).getEdge(v).changeAttribute("ui.style", "size:3px;fill-color:black;");

            System.out.println("Nodes" + nodes);
            System.out.println("Edges" + edges);

        }
    }

}
