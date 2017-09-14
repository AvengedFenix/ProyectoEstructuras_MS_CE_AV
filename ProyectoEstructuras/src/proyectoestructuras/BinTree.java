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


public class BinTree implements Comparable<BinTree>{
    BinTree LNode = null, RNode = null;
    String info;

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
    
    public String BinCode(BinTree node, String st)
    {
        if (node.isLeaf(node)){
            return node.getInfo() + "," + st;
        }
        
        String l = BinCode(node.getLNode(),st + "0");
        String r = BinCode(node.getRNode(),st + "1");
        
        String ret = l + "," + r;
        return ret;
    }

    public int evaluar(BinTree nodo) {
        if (nodo == null) {
            return 0;
        }

        if (nodo.getLNode() == null && nodo.getRNode() == null) {//esto significa que el nodo es leaf, por lo tanto es un numero
            //System.out.println("info " + nodo.getInfo());
            return Integer.parseInt(nodo.getInfo());
        }

        int valor_l = evaluar(nodo.getLNode()); //evaluar left node
        int valor_r = evaluar(nodo.getRNode()); // evaluar right node


        String operator = nodo.getInfo();
        switch (operator) {
            
        }
        switch(nodo.getInfo()){//si nodo.getInfo() es un operado
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

    public void postfixTree(String s, Stack<BinTree> stack) {
        if (isDigit(s)) {
            stack.push(new BinTree(s));
        } else {
            BinTree operatorNode = new BinTree(s);

            BinTree rNodo = (stack.pop());//nodo derecho
            BinTree lNodo = (stack.pop());
            operatorNode.insertRNode(rNodo);//inserta nodo derecho
            operatorNode.insertLNode(lNodo);

            /*
            if(isDigit(popt1.getInfo()) && !isDigit(popt2.getInfo())){//lo hice asi para que los nodos de los operadores siempre esten en el lado izquierdo
                //si nodo 1 es digito y nodo 2 es operador, entonces el nodo 2 va a ser hijo izquierdo del operatorNode
                operatorNode.insertLNode(popt2);
                operatorNode.insertRNode(popt1);
            }else if(isDigit(popt2.getInfo()) && !isDigit(popt1.getInfo())){
                operatorNode.insertLNode(popt1);
                operatorNode.insertRNode(popt2);
            }else{//si los dos nodos son numeros son leaves
                operatorNode.insertLNode(popt1);
                operatorNode.insertRNode(popt2);
            }
             */
            System.out.println("Padre: " + operatorNode.getInfo());
            System.out.println("Left node: " + operatorNode.getLNode().getInfo());
            System.out.println("Right node: " + operatorNode.getRNode().getInfo());
            System.out.println("");

            stack.push(operatorNode);
        }
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
    public int compareTo(BinTree nodo){
        int compararCantidad = Integer.parseInt(nodo.getInfo());
        
        
        return Integer.parseInt(this.getInfo()) - compararCantidad;
    }
    
    public static BinTree postf_toTree(String[] s){//ESTO TIENE QUE ESTAR EN EL MAIN o en una clase Tree que contenga un nodo root pero no se si es necesario
        BinTree b = new BinTree();
        
        Stack<BinTree> stackTree = new Stack();
        
        for (int i = 0; i < s.length; i++) {
            b.postfixTree(s[i], stackTree);
        }

        return stackTree.pop();
    }
    
    
    public static String[] infixtoPostfix(String[] infix){
        Stack<String> s = new Stack();
        StringBuilder sb = new StringBuilder();
        
        for (String infix1 : infix) {
            if (infix1.equals(" ")) {//si hay un espacio no hace nada
            } else if (isDigit(infix1)) {//si infix[i] o infix1 es un digito, se agrega directamente al stringbuilder
                sb.append(infix1).append(" ");
            } else if (isOperator(infix1)) {//si es operador verifica que el stack no este vacio y la precedencia mas alta
                while (!s.isEmpty() && !s.peek().equals("(") && precedenciaMasAlta(s.peek(), infix1)) {
                    sb.append(s.pop()).append(" ");
                }
                s.push(infix1);
            } else if (infix1.equals("(")) {//si encuentra un "(" se agrega al stack
                s.push(infix1);
            } else if (infix1.equals(")")) {
                while(!s.empty() && !s.peek().equals("(")){
                    sb.append(s.pop()).append(" ");
                }
                s.pop();
            }
        }
        
        while(!s.isEmpty()){
            sb.append(s.pop()).append(" ");
        }
        
        String[] sFinal = sb.toString().split(" ");
        return sFinal;
    }
    
    public static boolean isDigit(String s){
        return Character.isDigit(s.charAt(0));
    }
    
    public static boolean isOperator(String s){
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("^");
    }
    
    public static int Precedencia(String s){
        int pre = 0;
        if(s.equals("+") || s.equals("-")){
            pre = 1;
        }
        if(s.equals("*") || s.equals("/")){
            pre = 2;
        }
        if(s.equals("^")){
            pre = 3;
        }
        return pre;
    }
    
    public static boolean precedenciaMasAlta(String s, String s2){
        int prec = Precedencia(s);
        int prec2 = Precedencia(s2);
        
        if(prec == prec2){
            if(s.equals("^")){//if(Associative(s))
                return false;
            }else{
                return true;
            }
        }else{
            if(prec>prec2) return true;

        }
        return false;
    }
}


/*
public static BinTree postf_toTree(String[] s){//ESTO TIENE QUE ESTAR EN EL MAIN o en una clase Tree que contenga un nodo nodo pero no se si es necesario
        BinTree b = new BinTree();
        
        Stack<BinTree> stackTree = new Stack();
        
        for (int i = 0; i < s.length; i++) {
            b.postfixTree(s[i], stackTree);
        }

        return stackTree.pop();
}


 */


