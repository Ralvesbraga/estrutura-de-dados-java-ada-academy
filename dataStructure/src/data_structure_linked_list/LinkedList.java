package data_structure_linked_list;

public class LinkedList {

    //Corpo da data_structure_linked_list.LinkedList, com inicio, fim e tamanho da lista
    private Node head;
    private Node tail;
    private int length;

    static class Node { //Corpo do nó, e o seu construtor
        String data;
        Node next;

        // Construtor por onde será passado o dado para a criação do nó
        public Node(String data) {
            this.data = data;
        }
    }

    // Criação da lista
    public LinkedList(String data){
        length = 1;
        Node newNode = new Node(data);
        head = newNode;
        tail = newNode;
    }

    public void getHead(){
        if(this.head == null){
            System.out.println("Lista vazia:");
        } else{
            System.out.println("Head: " + this.head.data);
        }
    }

    public void getTail(){
        if(this.tail == null){
            System.out.println("Lista vazia:");
        }else{
            System.out.println("Tail: " + this.tail.data);
        }
    }

    public void getLength(){
        System.out.println("Length: " + this.length);
    }

    public void makeEmpty(){
        head = null;
        tail = null;
        length = 0;
    }

    public void print(){
        System.out.println("##############################");
        Node temp = this.head;
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println("##############################");
    }

    public void append(String data){
        Node newNode = new Node(data);
        if(length == 0){
            head = newNode;
            tail = newNode;
        } else{
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public Node removeLast(){
        if (length == 0) return null;

        Node temp = head;
        Node remove = tail;

        if (length == 1) {
            head = null;
            tail = null;
        } else {
            while (temp.next != tail) {
                temp = temp.next;
            }
            tail = temp;
            tail.next = null;
        }

        length--;
        return remove;
    }

    public void prepend(String data){
        Node newNode = new Node(data);
        if(length == 0){
            head = newNode;
            tail = newNode;
        }else{
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public Node removeFirst(){
        if(length == 0) return null;
        Node remove = head;
        head = head.next;
        length--;
        if(length == 0){
            tail = null;
        }
        return remove;
    }

    public Node get(int index){
        if(index < 0 || index >= length) return null;
        Node temp = head;
        for(int i = 0; i < index; i++){
            temp = temp.next;
        }
        return temp;
    }

    public boolean insert(String data, int index){
        if(index < 0 || index > length) return false;
        if(index == 0){
            prepend(data);
            return true;
        }
        if(index == length){
            append(data);
            return true;
        }

        Node newNode = new Node(data);
        Node temp = get(index-1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }

    public boolean set(int index, String data){
        Node temp = get(index);
        if (temp != null){
            temp.data = data;
            return true;
        }
        return false;
    }

    public Node remove(int index){
        if (index < 0 || index >= length) return null;
        if (index == 0) return removeFirst();
        if (index == length - 1) return removeLast();

        Node prev = get(index -1);
        Node temp = prev.next;

        prev.next = temp.next;
        temp.next = null;
        length--;

        return temp;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList("elemento 1");
        list.append("elemento 2");
        list.append("elemento 3");
        list.getHead();
        list.getTail();
        list.getLength();
        list.print();
        list.removeLast();
        list.print();
        list.prepend("elemento 0");
        list.print();
        list.removeFirst();
        list.print();
        System.out.println(list.get(1).data);
        list.insert("elemento 2.5", 2);
        list.print();
        list.set(0, "elemento 0.5");
        list.print();
        list.remove(2);
        list.print();
    }
}
