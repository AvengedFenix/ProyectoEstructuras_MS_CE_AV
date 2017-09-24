/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoestructuras;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author andre
 */
public class BinTree implements Comparable<BinTree> {

    BinTree LNode = null, RNode = null;
    String info;
    boolean treeFormed = false, decompressed = false;

    BinTree(BinTree LNode, BinTree RNode, String info) {
        this.LNode = LNode;
        this.RNode = RNode;
        this.info = info;
    }

    BinTree(String info) {
        this.info = info;
    }

    BinTree() {
        this.LNode = null;
        this.RNode = null;
    }

    public void insertLNode(BinTree LNode, String info) {
        this.LNode = LNode;
        this.LNode.setInfo(info);
    }

    public void insertLNode(BinTree LNode) {
        this.LNode = LNode;
    }

    public void insertRNode(BinTree RNode, String info) {
        this.RNode = RNode;
        this.RNode.setInfo(info);
    }

    public void insertRNode(BinTree RNode) {
        this.RNode = RNode;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getInfo() {
        return this.info;
    }

    public BinTree getLNode() {
        return this.LNode;
    }

    public BinTree getRNode() {
        return this.RNode;
    }

    public boolean isLeaf(BinTree nodo) {

        if (nodo.getLNode() == null || nodo.getRNode() == null) {

            return true;
        }
        return false;
    }

    public String BinCode(BinTree node, String st) {
        if (node.isLeaf(node)) {
            return node.getInfo() + "," + st;
        }

        String l = BinCode(node.getLNode(), st + "0");
        String r = BinCode(node.getRNode(), st + "1");

        String ret = l + "," + r;
        return ret;
    }

    public BinTree BintoText(BinTree raiz, BinTree node, ArrayList<String> binary, int x, int y) {
        System.out.println("\nLETTER: " + binary.get(x - 1));
        System.out.println("x: " + x);
        System.out.println("size: " + binary.size() + "\n");

        System.out.println("y: " + y);
        System.out.println("length: " + binary.get(x).length() + "\n");
        if (x >= binary.size()) {
            treeFormed = true;
            return raiz;
        }

        if (treeFormed == false && x < binary.size()) {
            if (y >= binary.get(x).length()) {
                System.out.println("EXCEEDED Y");
                node.setInfo(binary.get(x - 1).toString());
                if (x + 2 < binary.size()) {
                    BintoText(raiz, raiz, binary, x + 2, 0);
                } else {
                    System.out.println("EXCEEDED X");
                    //BintoText(raiz, raiz, binary, x, y, true);
                }
            } else {
                raiz.preorden(raiz);
                System.out.println("");
                BinTree newNode = new BinTree("not leaf");

                if (binary.get(x).charAt(y) == '0') {
                    System.out.println("LEFT 0");
                    if (raiz.getLNode() == null && y == 0) {
                        System.out.println("LRoot");
                        raiz.insertLNode(newNode);
                        BintoText(raiz, newNode, binary, x, y + 1);
                    } else if (node.getLNode() == null) {
                        System.out.println("New Node");
                        node.insertLNode(newNode);
                        BintoText(raiz, node.getLNode(), binary, x, y + 1);
                    } else {
                        System.out.println("Next Node");
                        BintoText(raiz, node.getLNode(), binary, x, y + 1);
                    }
                }

                if (binary.get(x).charAt(y) == '1') {
                    System.out.println("RIGHT 1");
                    if (raiz.getRNode() == null && y == 0) {
                        System.out.println("RRoot");
                        raiz.insertRNode(newNode);
                        BintoText(raiz, newNode, binary, x, y + 1);
                    } else if (node.getRNode() == null) {
                        System.out.println("New Node");
                        node.insertRNode(newNode);
                        BintoText(raiz, newNode, binary, x, y + 1);
                    } else {
                        System.out.println("Next Node");
                        BintoText(raiz, node.getRNode(), binary, x, y + 1);
                    }
                }
            }

        }
        return raiz;
    }

    public String DecomText(BinTree raiz, BinTree node, String binary, String text, int x) {
        System.out.println("");
        System.out.println("x: " + x);
        System.out.println("length: " + binary.length());

        System.out.println("TEXT: " + text);
        if (x >= binary.length()) {
            //text = text.concat(node.getInfo());
            decompressed = true;
            return text;
        }

        if (!decompressed && x < binary.length()) {
            if (binary.charAt(x) == '0' && !node.isLeaf(node)) {
                DecomText(raiz, node.getLNode(), binary, text, x + 1);
            } else if (binary.charAt(x) == '0' && node.isLeaf(node)) {
                text = text.concat(node.getInfo());
                DecomText(raiz, raiz, binary, text, x);

            }

            if (binary.charAt(x) == '1' && !node.isLeaf(node)) {
                DecomText(raiz, node.getRNode(), binary, text, x + 1);
            } else if (binary.charAt(x) == '1' && node.isLeaf(node)) {
                text = text.concat(node.getInfo());
                DecomText(raiz, raiz, binary, text, x);
            }
        }

        return text;
    }

    public double evaluar(BinTree nodo) {
        if (nodo == null) {
            return 0.0;
        }

        if (nodo.getLNode() == null && nodo.getRNode() == null) {//esto significa que el nodo es leaf, por lo tanto es un numero
            //System.out.println("info " + nodo.getInfo());
            return Double.parseDouble(nodo.getInfo());
        }

        double valor_l = evaluar(nodo.getLNode()); //evaluar left node
        double valor_r = evaluar(nodo.getRNode()); // evaluar right node


        switch (nodo.getInfo()) {//si nodo.getInfo() es un operado
            case "+":
                return valor_l + valor_r;
            case "-":
                return valor_l - valor_r;
            case "*":
                return valor_l * valor_r;
            case "/":
                return valor_l / valor_r;
            case "^":
                return (int) Math.pow((int)valor_l, (int)valor_r);
            case "!":
                return factorial((int)valor_l);

        }

        /*
        if(nodo.getInfo().equals("+")){
            //System.out.println("\n" + valor_l + " + " + valor_r + " = ");
            return valor_l + valor_r;
        }
        
        else if(nodo.getInfo().equals("-")){
            return valor_l - valor_r;
        }
        
        else if(nodo.getInfo().equals("*")){
            return valor_l * valor_r;
        }
        
        else if (nodo.getInfo().equals("^")){
            return (int) Math.pow(valor_l, valor_r);
        }*/
        return 0.0;
    }


    public boolean isDigit(String s) {
        return Character.isDigit(s.charAt(0));
    }

    public void inorden(BinTree nodo) {
        if (nodo != null) {
            inorden(nodo.getLNode());
            System.out.print(nodo.getInfo() + " ");
            inorden(nodo.getRNode());
        }
    }

    public void preorden(BinTree nodo) {
        if (nodo != null) {
            System.out.print(nodo.getInfo() + " ");
            preorden(nodo.getLNode());
            preorden(nodo.getRNode());
        }
    }

    public void postorden(BinTree nodo) {
        if (nodo != null) {
            postorden(nodo.getLNode());
            postorden(nodo.getRNode());
            System.out.print(nodo.getInfo() + " ");
        }
    }

    @Override
    public int compareTo(BinTree nodo) {
        int compararCantidad = Integer.parseInt(nodo.getInfo());

        return Integer.parseInt(this.getInfo()) - compararCantidad;
    }

    public int factorial(int n) {
        return (n == 0 ? 1 : n * factorial(n - 1));
    }
}
