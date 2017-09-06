/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoestructuras;

import java.util.Stack;

/**
 *
 * @author andre
 */
public class BinTree {
    BinTree LNode = null, RNode = null;
    String info;
    
    BinTree(BinTree LNode, BinTree RNode, String info){
        this.LNode = LNode;
        this.RNode = RNode;
        this.info = info;
    }
    
    BinTree(String info){
        this.info = info;
    }
    
    BinTree(){
        this.LNode = null;
        this.RNode = null;
    }
    
    public void insertLNode(BinTree LNode, String info){
        this.LNode = LNode;
        this.LNode.setInfo(info);
    }
    
    public void insertLNode(BinTree LNode){
        this.LNode = LNode;
    }
    
    public void insertRNode(BinTree RNode, String info){
        this.RNode = RNode;
        this.RNode.setInfo(info);
    }
    
    public void insertRNode(BinTree RNode){
        this.RNode = RNode;
    }
    
    public void setInfo(String info){
        this.info = info;
    }
    
    public String getInfo(){
        return this.info;
    }
    
    public BinTree getLNode(){
        return this.LNode;
    }
    
    public BinTree getRNode(){
        return this.RNode;
    }  
    
    
    public int evaluar(BinTree root){
        if(root == null){
            return 0;
        }
        
        if(root.getLNode() == null && root.getRNode() == null){
            //System.out.println("info " + root.getInfo());
            return Integer.parseInt(root.getInfo());
        }
        
        int valor_l = evaluar(root.getLNode()); //evaluar left node
        int valor_r = evaluar(root.getRNode()); // evaluar right node

        if(root.getInfo().equals("+")){
            //System.out.println("\n" + valor_l + " + " + valor_r + " = ");
            return valor_l + valor_r;
        }
        
        else if(root.getInfo().equals("-")){
            return valor_l - valor_r;
        }
        
        else if(root.getInfo().equals("*")){
            return valor_l * valor_r;
        }
        
        else if (root.getInfo().equals("^")){
            return (int) Math.pow(valor_l, valor_r);
        }
        
        else return valor_l / valor_r;
    }
    
    public void postfixTree(String s, Stack<BinTree> stack){
        if(isDigit(s)){
            stack.push(new BinTree(s));
        }
        else{
            BinTree operatorNode = new BinTree(s);          
            
            /*esto es sin ningun orden especifico pero siempre funciona
            operatorNode.insertRNode(stack.pop());
            operatorNode.insertLNode(stack.pop());
            */
            
            //
            BinTree popt1 = stack.pop();//nodo 1 del stack
            BinTree popt2 = stack.pop();//nodo 2

            
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
            //
            
            System.out.println("Padre: " + operatorNode.getInfo());
            System.out.println("Left node: " + operatorNode.getLNode().getInfo());
            System.out.println("Right node: " + operatorNode.getRNode().getInfo());
            System.out.println("");         

            stack.push(operatorNode);
        }
    }
    
    public boolean isDigit(String s){
        return Character.isDigit(s.charAt(0));    
    }
}

/*

public static BinTree postf_toTree(String[] s){//ESTO TIENE QUE ESTAR EN EL MAIN o en una clase Tree que contenga un nodo root pero no se si es necesario
        BinTree b = new BinTree();
        
        Stack<BinTree> stackTree = new Stack();
        
        for (int i = 0; i < s.length; i++) {
            b.postfixTree(s[i], stackTree);
        }

        return stackTree.pop();
}


*/


