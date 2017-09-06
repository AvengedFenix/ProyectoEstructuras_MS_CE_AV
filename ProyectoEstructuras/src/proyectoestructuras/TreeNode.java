/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoestructuras;

import java.util.ArrayList;

/**
 *
 * @author andre
 */
public class TreeNode {

    private int order;
    private int evaluacion ;
    private int hash;

    boolean visited = false;
    
    private ArrayList<TreeNode> children = new ArrayList();
    private TreeNode parent = null;

    public TreeNode(int order, int hash) {
        this.order = order;
        this.hash = hash;
    }

    public TreeNode(int order, int hash, TreeNode parent) {
        this.order = order;
        this.hash = hash;
        this.parent = parent;
    }

    public TreeNode() {

    }

    public void update() {
    }

    public void create() {
    }

    public void sort() {
    }

    public void setOrder(int n) {
    }

    public int getOrder() {
        return 0;
    }

    /*public Node next() {        
        if(order == PREV) {
            
        } else if(order == SIMETRIC) {
            
        } else if(order == POST) {
            
        }
    
        return null;
    }*/
    public void begin() {

    }

    public int height() {
        return 0;
    }

    public String map() {
        return "";
    }

    public int getHash() {
        return hash;
    }

    public void setHash(int hash) {
        this.hash = hash;
    }

    public ArrayList<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<TreeNode> children) {
        this.children = children;
    }

    public void addTreeNode(TreeNode x) {
        x.setParent(this);
        this.children.add(x);
    }

    public void addTreeNodes(ArrayList<TreeNode> trees) {
        for (int i = 0; i < trees.size(); i++) {
            trees.get(i).setParent(this);
            this.children.add(trees.get(i));
        }
    }

    public boolean isLeaf() {
        if (this.children.isEmpty()) {
            return true;
        } else {
            return false;
        }

    }

    public void setParent(TreeNode parent) {
        parent.addTreeNode(this);
        this.parent = parent;
    }

    public boolean isRoot() {
        if (this.parent == null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isChild() {
        if (this.parent != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isParent() {
        if (!this.children.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public TreeNode Lectura(TreeNode padre) {
        if (padre.getChildren().isEmpty()) {
            
            return padre;
        } else {
            for (int i = 0; i < padre.getChildren().size()-1; i++) {
                if (padre.getChildren().get(i).getVisited() == true) {
                    System.out.println("Already visited");
                }else{
                    return Lectura(padre.getChildren().get(i));
                }
            }
        }
    }

    
 public boolean getVisited(){
        return this.visited;
    }
    
    public void setVisited(boolean visited){
        this.visited = visited;
    }
    public void Evaluar(){
        
    }
}
