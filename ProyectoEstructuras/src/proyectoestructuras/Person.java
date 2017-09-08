package proyectoestructuras;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class Person {
    private String name;
    private double evaluation;

    public Person() {
        
    }
        
    public Person(String name, double evaluation) {
        this.name = name;
        this.evaluation = evaluation;
    }
      
    public Person(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(double evaluation) {
        this.evaluation = evaluation;
    }
    
    
    
}
