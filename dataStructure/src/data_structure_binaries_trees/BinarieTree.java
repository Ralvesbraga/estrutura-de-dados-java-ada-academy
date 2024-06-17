package data_structure_binaries_trees;



import java.util.LinkedList;
import java.util.Queue;

public class BinarieTree {

    public Node root;

    public static  class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }

        public boolean isLeaf(){
            return (this.left == null) && (this.right == null);
        }
    }

    public void insert(int value){
        if(root == null) root = new Node(value);
        else{
            Node newNode = new Node(value);
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while(!queue.isEmpty()){
                Node currentNode = queue.remove();
                if(currentNode.left == null) {
                    currentNode.left = newNode;
                    break;
                }
                else {
                    queue.add(currentNode.left);
                }

                if(currentNode.right == null){
                    currentNode.right = newNode;
                    break;
                }
                else {
                    queue.add(currentNode.right);
                }

            }
        }
    }

    public void preOrder(){
        System.out.println("################");
        preOrder(root);
        System.out.println("################");

    }

    private void preOrder(Node root) {
        if(root != null){
            System.out.println(root.value);
            preOrder(root.left);
            preOrder(root.right);
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

    private void posOrder(){
        System.out.println("################");
        posOrder(root);
        System.out.println("################");
    }

    private void posOrder(Node root) {
        if(root != null){
            posOrder(root.left);
            posOrder(root.right);
            System.out.println(root.value);
        }
    }

    public void BFS(){
        System.out.println("################");
        if(root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node node = queue.remove();
            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);

            System.out.println(node.value);
        }
        System.out.println("################");
    }


    public static void main(String[] args) {
        BinarieTree tree = new BinarieTree();
        tree.insert(37);
        tree.insert(11);
        tree.insert(66);
        tree.insert(8);
        tree.insert(17);
        tree.insert(42);
        tree.insert(72);


        tree.preOrder();
        tree.inOrder();
        tree.posOrder();
        tree.BFS();
    }

}
