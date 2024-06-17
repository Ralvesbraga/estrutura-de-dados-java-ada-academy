package data_structure_ABB;

import data_structure_binaries_trees.BinarieTree;

public class Abb {

    public Node root;

    public class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public void insert(int value){
        if(root == null){
            root = new Node(value);
        } else{
            insert(root,value);
        }
    }

    private void insert(Node root, int value) {
        if(root == null) return;
        if (value == root.value) return;
        if (value > root.value){
            if(root.right == null) root.right = new Node(value);
            else insert(root.right, value);
        } else{
            if(root.left == null) root.left = new Node(value);
            else insert(root.left, value);
        }
    }


    private void inOrder(){
        System.out.println("################");
        inOrder(root);
        System.out.println("################");
    }

    private void inOrder(Node root) {
        if(root != null){
            inOrder(root.left);
            System.out.println(root.value);
            inOrder(root.right);
        }
    }

    public boolean contains(int value){
        return contains(root,value);
    }

    private boolean contains(Node root, int value) {
        if(root == null) return false;
        if (root.value == value) return true;
        if (value > root.value) return contains(root.right, value);
        else return contains(root.left, value);
    }

    public int minValue(Node currentNode){
        while(currentNode.left != null){
            currentNode = currentNode.left;
        }
        return currentNode.value;
    }

    public void deleteNode(int value){
        root = deleteNode(root, value);
    }

    public Node deleteNode(final Node root, int value){
        if (root == null) return null;

        if(value < root.value){
            root.left = deleteNode(root.left,value);
        } else if(value > root.value){
            root.right = deleteNode(root.right, value);
        } else{
            if((root.left == null) && (root.right == null)){
                return  null;
            } else if(root.left == null){
                return  root.right;
            } else if(root.right == null){
                return  root.left;
            } else{
                int minValue = minValue(root.right);
                root.value = minValue;
                root.right = deleteNode(root.right, minValue);

            }
        }
        return root;
    }

    public static void main(String[] args) {
        Abb tree = new Abb();

        tree.insert(37);
        tree.insert(11);
        tree.insert(66);
        tree.insert(8);
        tree.insert(17);
        tree.insert(42);
        tree.insert(72);

        System.out.println(tree.contains(57));
        tree.deleteNode(66);

        tree.inOrder();
    }
}
