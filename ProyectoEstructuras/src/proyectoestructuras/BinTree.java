/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoestructuras;

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
    
    public void insertRNode(BinTree RNode, String info){
        this.RNode = RNode;
        this.RNode.setInfo(info);
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
    
}
