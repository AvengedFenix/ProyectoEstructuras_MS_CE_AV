import java.util.ArrayList;
import javafx.scene.Node;


public class Tree {
    

    /*public final int PREV = 0;
    public final int SIMETRIC = 1;
    public final int POST = 2;*/
    
    private int order;
    private int hash;
    
    private ArrayList<Tree> subtrees = new ArrayList();
    private Tree parent = null;

    public Tree(int order, int hash) {
        this.order = order;
        this.hash = hash;
    }
    
    
    public Tree(int order, int hash, Tree parent) {
        this.order = order;
        this.hash = hash;
        this.parent = parent;
    }
    
    public Tree(){
        
    }
    
    public void update() {}
    public void create() {}
    public void sort() {}
    public void setOrder(int n) {}
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
    public void begin() {}
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

    public ArrayList<Tree> getSubtrees() {
        return subtrees;
    }

    public void setSubtrees(ArrayList<Tree> subtrees) {
        this.subtrees = subtrees;
    }   
    
    
    
    public void addTree(Tree x){
        x.setParent(this);
        this.subtrees.add(x);
    }
    
    public void addTrees(ArrayList<Tree> trees){
        for (int i = 0; i < trees.size(); i++) {
            trees.get(i).setParent(this);
            this.subtrees.add(trees.get(i));
        }
    }
    
    public boolean isLeaf(){
        if(this.subtrees.isEmpty()){
            return true;
        }else{
            return false;
        }
        
    }
    
    
    public void setParent(Tree parent) {
        parent.addTree(this);
        this.parent = parent;
    }
    
    public boolean isRoot(){
        if(this.parent == null){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean isChild(){
        if(this.parent != null){
           return true; 
        }else{
            return false;
        }
    }
    
    public boolean isParent(){
        if(!this.subtrees.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
    
}