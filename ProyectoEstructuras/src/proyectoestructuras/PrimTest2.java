/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoestructuras;

/**
 *
 * @author calvinespinoza
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.DefaultGraph;

import org.graphstream.algorithm.generator.DorogovtsevMendesGenerator;
import org.graphstream.graph.Edge;
import org.graphstream.graph.Node;


public class PrimTest2 {

    public static void main(String... args) throws IOException {
        String path = "";
        GrafoMatriz graph = new GrafoMatriz(4, true);//createMatriz(path, true);
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
        /*  DorogovtsevMendesGenerator gen = new DorogovtsevMendesGenerator();*/

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
        gen.begin();*/

 /*for (int i = 0; i < 6 && gen.nextEvents(); i++);
        gen.end();*/
        for (int i = 0; i < graphstream.getEdgeCount(); i++) {
            Edge e = graphstream.getEdge(i);
            Double d = e.getAttribute("weight");
            System.out.println(e.getId() + " : " + d);
        }

        //graph.getNode(0).setAttribute("ui.color", 0.5);
        ArrayList< Node> nodes = new ArrayList();
        ArrayList<Edge> edges = new ArrayList();
        int u = 0;
        int v = 0;
        Node n = graphstream.getNode(0);
        nodes.add(n);

        while (graph.getMatrizAdy().length != nodes.size()) {
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

    public static GrafoMatriz createMatriz(String path, boolean dirigido) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        GrafoMatriz g;
        ArrayList<String[]> info = new ArrayList();
        try {
            String line = br.readLine();

            //int[][] matriz = new int[5][5];
            while (line != null) {
                String s = line.replaceAll(" ", "");
                info.add(s.split(","));
                //String[] x = info.get(info.size()-1);
                /*for(String s : x){
                    s = s.replaceAll(" ", "");
                }*/
                //System.out.println(Arrays.toString(s.split(",")));
                line = br.readLine();
            }

            for (int i = 0; i < info.size(); i++) {
                System.out.println(Arrays.toString(info.get(i)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            br.close();
        }
        g = new GrafoMatriz(info.size(), dirigido);

        double[][] matriz = new double[info.size()][info.size()];
        for (int i = 0; i < info.size(); i++) {
            for (int j = 0; j < info.size(); j++) {
                matriz[i][j] = Double.parseDouble(info.get(i)[j]);
                System.out.print(info.get(i)[j] + " ");
            }
            System.out.println("");
        }

        g.setMatrizAdy(matriz);
        //System.out.println(g.isBicoloreable());

        return g;
    }
}
