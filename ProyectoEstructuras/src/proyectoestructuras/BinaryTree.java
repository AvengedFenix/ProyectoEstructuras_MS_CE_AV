/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoestructuras;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Stack;

/**
 *
 * @author andre
 */
public class BinaryTree implements Comparable<BinaryTree> {

    BinaryTree LNode = null, RNode = null;
    String info;

    BinaryTree(BinaryTree LNode, BinaryTree RNode, String info) {
        this.LNode = LNode;
        this.RNode = RNode;
    }

    BinaryTree(String info) {
        this.info = info;
    }

    BinaryTree() {
        this.LNode = null;
        this.RNode = null;
    }

    public void insertLNode(BinaryTree LNode, String info) {
        this.LNode = LNode;
        this.LNode.setInfo(info);
    }

    public void insertLNode(BinaryTree LNode) {
        this.LNode = LNode;
    }

    public void insertRNode(BinaryTree RNode, String info) {
        this.RNode = RNode;
        this.RNode.setInfo(info);
    }

    public void insertRNode(BinaryTree RNode) {
        this.RNode = RNode;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getInfo() {
        return this.info;
    }

    public int getInfoInt() {
        return Integer.parseInt(this.getInfo());
    }

    public BinaryTree getLNode() {
        return this.LNode;
    }

    public BinaryTree getRNode() {
        return this.RNode;
    }

    public boolean isLeaf(BinaryTree nodo) {

        if (nodo.getLNode() == null || nodo.getRNode() == null) {

            return true;
        }
        return false;
    }

    public String BinCode(BinaryTree node, String st) {
        if (node.isLeaf(node)) {
            return node.getInfo() + "," + st;
        }

        String l = BinCode(node.getLNode(), st + "0");
        String r = BinCode(node.getRNode(), st + "1");

        String ret = l + "," + r;
        return ret;
    }

    public BinaryTree BintoText(BinaryTree raiz, BinaryTree node, ArrayList<String> binary, int x, int y) {
        if (y > binary.get(x).length()) {
            node.setInfo(binary.get(x - 1).toString());
            BintoText(raiz, node, binary, x++, 0);
        }
        BinaryTree newNode = new BinaryTree();

        if (binary.get(x).charAt(y) == '0') {
            if (y == 0) {
                raiz.insertLNode(newNode);
            }
            node.insertLNode(newNode);
            BintoText(raiz, newNode, binary, x, y++);
        }

        if (binary.get(x).charAt(y) == '1') {
            if (y == 0) {
                raiz.insertRNode(newNode);
            }
            node.insertRNode(newNode);
            BintoText(raiz, newNode, binary, x, y++);
        }

        if (x >= binary.size()) {
            return raiz;
        }
        return raiz;
    }

    public double evaluar(BinaryTree nodo) {
        if (nodo == null) {
            return 0;
        }

        if (nodo.getLNode() == null && nodo.getRNode() == null) {//esto significa que el nodo es leaf, por lo tanto es un numero
            //System.out.println("info " + nodo.getInfo());
            return Integer.parseInt(nodo.getInfo());
        }

        double valor_l = evaluar(nodo.getLNode()); //evaluar left node
        double valor_r = evaluar(nodo.getRNode()); // evaluar right node

        String operator = nodo.getInfo();
        switch (operator) {

        }
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
                return (int) Math.pow(valor_l, valor_r);
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
        return 0;
    }

    public void inorden(BinaryTree nodo) {
        if (nodo != null) {
            inorden(nodo.getLNode());
            System.out.print(nodo.getInfo() + " ");
            inorden(nodo.getRNode());
        }
    }

    public void preorden(BinaryTree nodo) {
        if (nodo != null) {
            System.out.print(nodo.getInfo() + " ");
            preorden(nodo.getLNode());
            preorden(nodo.getRNode());
        }
    }

    public void postorden(BinaryTree nodo) {
        if (nodo != null) {
            postorden(nodo.getLNode());
            postorden(nodo.getRNode());
            System.out.print(nodo.getInfo() + " ");
        }
    }
    
    @Override
    public int compareTo(BinaryTree nodo) {
        int compararCantidad = Integer.parseInt(nodo.getInfo());
    
        return Integer.parseInt(this.getInfo()) - compararCantidad;
    }

    

    public static boolean isDigit(String s) {
        return Character.isDigit(s.charAt(0));
    }

    public static boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("^");
    }
}

/*
public static BinaryTree postf_toTree(String[] s){//ESTO TIENE QUE ESTAR EN EL MAIN o en una clase Tree que contenga un nodo nodo pero no se si es necesario
        BinaryTree b = new BinaryTree();
        
        Stack<BinaryTree> stackTree = new Stack();
        
        for (int i = 0; i < s.length; i++) {
            b.postfixTree(s[i], stackTree);
        }

        return stackTree.pop();
}

 */

