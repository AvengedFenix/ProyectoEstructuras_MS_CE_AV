/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class Person {
    private String name;
    private int evaluation;

    public Person() {
        
    }
        
    public Person(String name, int evaluation) {
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
    
    
    
}
