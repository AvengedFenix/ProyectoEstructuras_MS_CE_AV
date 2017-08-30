import java.util.ArrayList;
import javafx.scene.Node;

/**
 * @author CJ
 */
public class Tree {
    
    /* Order Constants. */
    public final int PREV = 0;
    public final int SIMETRIC = 1;
    public final int POST = 2;
    
    private int order;
    private int hash;
    private ArrayList<Tree> subtrees;

    public Tree(int order, int hash) {
        this.order = order;
        this.hash = hash;
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
    
    public Node next() {        
        if(order == PREV) {
            
        } else if(order == SIMETRIC) {
            
        } else if(order == POST) {
            
        }
    
        return null;
    }
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
    
}