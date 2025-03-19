import java.lang.Math;
import java.util.LinkedList;
/*
 * RefBasedBinaryTree.java
 *
 * A ref-based BinaryTree meant to store values of type Integer
 */
public class RefBasedBinaryTree implements BinaryTree{
    protected TreeNode root;
    
    public RefBasedBinaryTree() {
        this.root = null;
    }
    
    public void insert(Integer value){
        if (root==null) {
            root = new TreeNode(value);
        } else {
            insert(null, root, value);
		}
        
    }
    // not a balanced insert
    private void insert(TreeNode parent, TreeNode t, Integer value) {
        if (t==null) {
            if(parent.getLeft()==null) {
                parent.setLeft(new TreeNode(value));
			} else {
                parent.setRight(new TreeNode(value));
			}            
        }  else {
            int htLeft = height(t.getLeft());
            int htRight = height(t.getRight());
            if (htLeft>htRight) {
                insert(t, t.getRight(), value);
			} else {
                insert(t, t.getLeft(), value);
			}
        }
    }
    
    private int height(TreeNode t) {
        if (t==null) {
            return -1;
		} else {
            int highest = Math.max(height(t.getLeft()), height(t.getRight()));
            return 1 + highest;
        }
    }
    
    /*
     * Purpose: prints the value at each TreeNode in this BinaryTree
     *          following an in-order traversal
     * Parameters: none
     * Returns: Nothing
     */
    public void inOrder(){
        inOrder(root);
        System.out.println();
    }
    
    /*
     * Purpose: prints the value at each TreeNode in t,
     *          following an in-order traversal
     * Parameters: TreeNode t
     * Returns: Nothing
     */
    private void inOrder(TreeNode t){
        if (t==null) {
            return;
        } else {
            inOrder(t.getLeft());
            System.out.print(t.getValue() + " ");
            inOrder(t.getRight());
        }
    }
    
    /*
     * Purpose: prints the value at each TreeNode in this BinaryTree
     *          following a pre-order traversal
     * Parameters: none
     * Returns: Nothing
     */
    public void preOrder(){
        preOrder(root);
        System.out.println();
    }
    
    /*
     * Purpose: prints the value at each TreeNode in t,
     *          following a pre-order traversal
     * Parameters: TreeNode t
     * Returns: Nothing
     */
    private void preOrder(TreeNode t){
        if (t==null) {
            return;
        } else {
            System.out.print(t.getValue() + " ");
            preOrder(t.getLeft());
            preOrder(t.getRight());
        }
    }
    
    /*
     * Purpose: prints the value at each TreeNode in this BinaryTree
     *          following a post-order traversal
     * Parameters: none
     * Returns: Nothing
     */
    public void postOrder(){
        postOrder(root);
        System.out.println();
    }
    
    /*
     * Purpose: prints the value at each TreeNode in t,
     *          following a post-order traversal
     * Parameters: TreeNode t
     * Returns: Nothing
     */
    private void postOrder(TreeNode t){
        if (t==null) {
            return;
        } else {
            postOrder(t.getLeft());
            postOrder(t.getRight());
            System.out.print(t.getValue() + " ");
        }
    }
    
    /*
     * Purpose: returns a String reprensentation of this BinaryTree
     * Parameters: none
     * Returns: String - the representation
     */
    public String toString() {
        return toString(root);
    }
    
    private String toString(TreeNode t) {
        if(t==null) {
            return "";
        } else {
            String s = "";
            
            s += toString(t.getLeft());
            s += t.getValue() + " ";
            s += toString(t.getRight());
            
            return s;
        }
    }

    public int sum(){
        return sumRec(root);
    }

    public int sumRec(TreeNode cur){ // to be inherited by the search tree
        if (cur == null){
            return 0;
        }else{
            return (cur.getValue() + sumRec(cur.getLeft()) + sumRec(cur.getRight()));
        }
    }

    public boolean find(int val){
        return findRec(root,val);
    }
    
    public boolean findRec(TreeNode cur, int val){ // can be the same but should not be inherited, should be improved in search tree.
        if(cur == null){
            return false;
        }else if (cur.getValue() == val){
            return true;
        }else{ 
            if (findRec(cur.getLeft(),val) || findRec(cur.getRight(),val)){
                return true;
            }else{
                return false;
            }
        }
    }

    public int getMax() throws TreeEmptyException{ // this would work in search tree aswell, but can be optimized significantly so shouldnt be inherited.
        if (root == null){
            throw new TreeEmptyException();
        }
        return getMaxRec(root,root.getValue());
    }

    public int getMaxRec(TreeNode cur, int winner){
        if (cur == null){
            return winner;
        }else{
            if(cur.getValue() > winner){
                winner = cur.getValue();
            }
            return Math.max(getMaxRec(cur.getLeft(),winner),getMaxRec(cur.getRight(),winner));
        }
    }
    
    public static void main(String[] args) {
        // use these trees to test the methods you will implement in Part II
        RefBasedBinaryTree emptyTree = new RefBasedBinaryTree();
        RefBasedBinaryTree myTree = new RefBasedBinaryTree();
        for(int i=2; i<8; i++) {
            myTree.insert(i);
        }
        int total = myTree.sum();
        System.out.println(total);

        int val = 4;
        System.out.println(myTree.find(val));
        val = 15;
        System.out.println(myTree.find(val));

        int max1;
        int max2;
       
        
        try{
         max2 = myTree.getMax();
         System.out.println(max2);
        }catch(TreeEmptyException e){
            System.out.println("shouldnt be here");
        }
        try{
            max1 = emptyTree.getMax();
        }catch(TreeEmptyException e){
        System.out.println("empty");
        }

    }
    
}
