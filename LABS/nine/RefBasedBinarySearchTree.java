import java.lang.Math;
/*
 * RefBasedBinarySearchTree.java
 *
 * A ref-based BinaryTree meant to store values of type Integer
 */
public class RefBasedBinarySearchTree extends RefBasedBinaryTree {

    public void insert(Integer value){
        if (root == null){
            TreeNode n = new TreeNode(value);
            this.root = n;
            return;
        }else{
            insertRec(root,value);
        }
    }
    
    public void insertRec(TreeNode cur, Integer value){
        if(cur.getValue() > value){
            if (cur.getLeft() == null){
                TreeNode n = new TreeNode(value);
                cur.setLeft(n);
                return;
            }else{
                insertRec(cur.getLeft(), value);
            }
        
        }else if(cur.getRight() == null){
            TreeNode n = new TreeNode(value);
            cur.setRight(n);
            return;
        }else{
            insertRec(cur.getRight(), value);
        }
        }

    public boolean find(int val){
        return findRec(root,val);
    }

    public boolean findRec(TreeNode cur, int val){ //this gets results faster
        if (cur == null){
            return false;
        }else if(val == cur.getValue()){
            return true;
        }else if (val < cur.getValue()){
            return findRec(cur.getLeft(),val);
        }else if (val > cur.getValue()){
            return findRec(cur.getRight(),val);
        }
        return false;
    }

    public int getMax() throws TreeEmptyException{
        if (root == null){
            throw new TreeEmptyException();
        }
        return getMaxRec(root);
    }

    public int getMaxRec(TreeNode cur){ //much faster and simpler code
        if(cur.getRight() == null){
            return cur.getValue();
        }else{
            return getMaxRec(cur.getRight());
        }
    }
    public static void main(String[] args) {
        // use these trees to test the methods you will implement
        RefBasedBinarySearchTree emptyTree = new RefBasedBinarySearchTree();
        RefBasedBinarySearchTree myTree = new RefBasedBinarySearchTree();
        myTree.insert(2);
        myTree.insert(1);
        myTree.insert(5);
        myTree.insert(7);
        myTree.insert(0);
        myTree.insert(4);
        myTree.insert(6);
        
        System.out.println("in");
        myTree.inOrder();
        System.out.println("pre");
        myTree.preOrder();
        System.out.println("post");
        myTree.postOrder();
        
        System.out.println("toString\n" + myTree);

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
        return;
    }
    
    
}
