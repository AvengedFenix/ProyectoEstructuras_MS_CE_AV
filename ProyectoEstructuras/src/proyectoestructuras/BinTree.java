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
    BinTree LNode, RNode;
    char info;
    
    BinTree(BinTree LNode, BinTree RNode, char info){
        this.LNode = LNode;
        this.RNode = RNode;
        this.info = info;
    }
    
    BinTree(){
        
    }
    
    public void insertLNode(BinTree LNode, char info){
        this.LNode = LNode;
        this.LNode.setInfo(info);
    }
    
    public void insertRNode(BinTree RNode, char info){
        this.RNode = RNode;
        this.RNode.setInfo(info);
    }
    
    public void setInfo(char info){
        this.info = info;
    }
    
}
