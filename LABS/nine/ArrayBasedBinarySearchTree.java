public class ArrayBasedBinarySearchTree extends ArrayBasedBinaryTree{

public void insert(Integer value){
    if (size == 0){
        data[0] = value;
        size++;
        return;
    }
    insertRec(root,value);
}

public void insertRec(int index, Integer value){
    
    if(data[index] > value){
        if (data[getLeft(index)] == null){
            data[getLeft(index)] = value;
            size++;
            return;
        }else{
            insertRec(getLeft(index), value);
        }
        
    }else if(data[index] < value){
        if (data[getRight(index)] == null){
            data[getRight(index)] = value;
            size++;
            return;
        }else{
            insertRec(getRight(index), value);
        }
        
    }
}

    public static void main(String[] args) {
        ArrayBasedBinarySearchTree emptyTree = new ArrayBasedBinarySearchTree();
        
        ArrayBasedBinarySearchTree myTree = new ArrayBasedBinarySearchTree();
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
    }

}
