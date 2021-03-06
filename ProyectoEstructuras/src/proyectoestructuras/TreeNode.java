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
    private double evaluacion;
    private int numNodo;
    
    
    // persona;

    boolean visited = false;
    
    private ArrayList<TreeNode> children = new ArrayList();
    private TreeNode parent = null;

    public TreeNode(int order, int hash) {
        this.order = order;
    }
    
    /*public TreeNode(Person persona) {
        this.persona = persona;
    }*/

    public TreeNode(int order, int numNodo, TreeNode parent) {
        this.order = order;
        this.parent = parent;
        this.numNodo = numNodo;
    }
    
    public TreeNode(int numNodo, double evaluacion){
        this.numNodo = numNodo;
        this.evaluacion = evaluacion;
    }
    
    public TreeNode(double evaluacion){
        this.evaluacion = evaluacion;
    }
    
    public TreeNode(int numNodo){
        this.numNodo = numNodo;
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
/*
    public int getHash() {
        return hash;
    }

    public void setHash(int hash) {
        this.hash = hash;
    }
*/
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
       // parent.addTreeNode(this);
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
            for (int i = 0; i < padre.getChildren().size(); i++) {
                if (padre.getChildren().get(i).getVisited() == true) {
                    System.out.println("Already visited");
                }else{
                    
                    padre.getChildren().get(i).setVisited(true);
                    return Lectura(padre.getChildren().get(i));
                }
                
                if(padre.allChildrenVisited()){
                    padre.Eval();
                    return padre;
                }
            }
        }
        
        return null;
    }
    
    public double evaluarTree(TreeNode nodo){
        double eval = 0;
        if(nodo != null){
            nodo.setVisited(true);
            for (int i = 0; i < nodo.getChildren().size(); i++) {
                evaluarTree(nodo.getChildren().get(i));
            }
              
            if(nodo.isParent() && nodo.allChildrenVisited()){
                eval += nodo.Eval();
            }
        }
        
        return eval;
    }

    public void evaluarPostorden(TreeNode nodo){
        if(nodo != null){
            for(int i = 0; i < nodo.getChildren().size(); i++){
                evaluarPostorden(nodo.getChildren().get(i));
            }
            System.out.print("( " + nodo.getEvaluacion() + " )" + " ");
            System.out.println(nodo.allChildrenVisited());
            nodo.setVisited(true);
            if(nodo.allChildrenVisited()) nodo.Eval();
        }
    }
    
    public void recorridoPostorden(TreeNode nodo){
        if(nodo != null){
            for(int i = 0; i < nodo.getChildren().size(); i++){
                recorridoPostorden(nodo.getChildren().get(i));
            }
            System.out.print("( " + nodo.getEvaluacion() + " )" + " ");
        }
    }
    
 public boolean getVisited(){
        return this.visited;
    }
    
    public void setVisited(boolean visited){
        this.visited = visited;
    }
    
    public double getEvaluacion(){
        return this.evaluacion;
    }
    
    public void setEvaluacion(double x){
        this.evaluacion = x;
    }
    /*
    public void Evaluar(){
        double x = 0;
        double cont = 0;
        if(!this.getChildren().isEmpty()){
            for (int i = 0; i < this.getChildren().size(); i++) {
                x += this.getChildren().get(i).getPersona().getEvaluation();
                cont++;
            }
            
            x /= cont;
        this.getPersona().setEvaluation(x);
        }else{
            System.out.println("El nodo no tiene hijos");
        }
    }*/
    
    public boolean allChildrenVisited(){
        if(!this.children.isEmpty()){
        for (int i = 0; i < this.getChildren().size(); i++) {
            if(!this.getChildren().get(i).getVisited()) return false;
        }
        }else{
            return false;
        }
        
        return true;
    }
    
    public double Eval(){
        double x = 0;
        if(this.isParent()){
            for (int i = 0; i < this.getChildren().size(); i++) {
                x += this.getChildren().get(i).getEvaluacion();
            }
            
            x /= this.getChildrenCount();
        this.setEvaluacion(x);
        }
        return x;
    }
    
    public double getChildrenCount(){
        double cont = 0;
        for (int i = 0; i < this.getChildren().size(); i++) {
            cont++;
        }
        
        return cont;
    }
    
    /*public Person getPersona(){
        return this.persona;
    }
    
    public void setPersona(Person persona){
        this.persona = persona;
    }*/
    
    public void setNumNodo(int n){
        this.numNodo = n;
    }
    
    public int getNumNodo(){
        return this.numNodo;
    }
    
    public ArrayList<TreeNode> getPostOrder(TreeNode nodo) {
        ArrayList<TreeNode> pOrder = new ArrayList<>();
        buildPostOrder(nodo, pOrder, 0);
        return pOrder;
    }
    
    private void buildPostOrder(TreeNode nodo, ArrayList<TreeNode> pOrder, double sum) {
        
        
        for (TreeNode hijo : nodo.getChildren()) {
            buildPostOrder(hijo, pOrder, sum);
        }
        
        /*if(nodo.isParent()){
            nodo.Evaluar();
        }*/
        pOrder.add(nodo);
    }
    
    public void evaluarPOrden(TreeNode nodo){
        if(nodo != null){
            for (int i = 0; i < nodo.getChildren().size(); i++) {
                evaluarPOrden(nodo.getChildren().get(i));
            }
            //System.out.println("( " + nodo.getPersona().getName() + ": " + nodo.getPersona().getEvaluacion() + " )" + " ");
            //if(nodo.isParent()) nodo.Evaluar();
            if(nodo.isParent()) nodo.Eval();
        }
    }
    
}
