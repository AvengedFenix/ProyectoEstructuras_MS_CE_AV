
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
    public final int PREV = 0;
    public final int SIMETRIC = 1;
    public final int POST = 2;
    
    private int order;
    private int hash;
    private ArrayList<Tree> subtrees;
    private String name;
    private int evaluation;

    public TreePersona() {
        
    }
        
    public TreePersona(String name, int evaluation) {
        this.name = name;
        this.evaluation = evaluation;
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

    public void setEvaluation(int evaluation) {
        this.evaluation = evaluation;
    }
    
    public ArrayList<Tree> getSubtrees() {
        return subtrees;
    }

    public void setSubtrees(ArrayList<Tree> subtrees) {
        this.subtrees = subtrees;
    }   
    
    
    
    public void addTree(Tree x, boolean y){
        if(y == true){//true significa que estamos agregando arboles a un arbol que no tenia hijos
            this.subtrees = new ArrayList();
        }
        this.subtrees.add(x);
    }
    
    public void addTrees(ArrayList<Tree> trees, boolean y){
        if(y == true){
            this.subtrees = new ArrayList();
        }
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
}
