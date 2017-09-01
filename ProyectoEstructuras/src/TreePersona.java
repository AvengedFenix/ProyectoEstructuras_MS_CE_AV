
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author andre
 */
public class TreePersona {

    private int hash;
    private ArrayList<TreePersona> subtrees;
    private String name;
    private int evaluation;
    
    

    private TreePersona parent = null;

    public TreePersona() {
        
    }
        
    public TreePersona(String name, int evaluation, int hash) {
        this.name = name;
        this.evaluation = evaluation;

        this.hash = hash;
    }
    
    public TreePersona(int hash, TreePersona parent, String name, int evaluation) {
        this.name = name;
        this.evaluation = evaluation;
        this.hash = hash;
        this.parent = parent;
        
    }
      

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEvaluation() {
        return evaluation;
    }
    
    public String getInfo(){
        return this.getName() + ": " + this.getEvaluation();
    }

    public void setEvaluation(int evaluation) {
        this.evaluation = evaluation;
    }
    
    public ArrayList<TreePersona> getSubtrees() {
        return subtrees;
    }

    public void setSubtrees(ArrayList<TreePersona> subtrees) {
        this.subtrees = subtrees;
    }   
    
    
    
    public void addTree(TreePersona x){
        this.subtrees.add(x);
    }
    
    public void addTrees(ArrayList<TreePersona> trees){
        for (int i = 0; i < trees.size(); i++) {
            this.subtrees.add(trees.get(i));
        }
    }
    
     public int getHash() {
        return hash;
    }

    public void setHash(int hash) {
        this.hash = hash;
    }
    
    public void setOrder(int n) {}
    public int getOrder() {
        return 0;
    }
    
    public boolean isLeaf(){
        if(this.subtrees.isEmpty()){
            return true;
        }else{
            return false;
        }
        
    }
    
    
    public void setParent(TreePersona parent) {
        parent.addTree(this);
        this.parent = parent;
    }
}
