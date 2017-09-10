
import proyectoestructuras.Tree;
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
public class TreePersona extends Tree {
    
    


    private String name;
    private int evaluation = 0;
    
    


    public TreePersona() {
        
    }

    public TreePersona(String name, int evaluation, int order, int hash, Tree parent) {
        super(order, hash, parent);
        this.name = name;
        this.evaluation = evaluation;
    }

    public TreePersona(String name, int order, int hash, Tree parent) {
        super(order, hash, parent);
        this.name = name;
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
    
}