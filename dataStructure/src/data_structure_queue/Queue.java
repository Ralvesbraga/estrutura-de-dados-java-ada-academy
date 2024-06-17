public class Queue {

    private Node first;
    private Node last;
    private int length;

    public Queue(int value) {
        Node newNode = new Node(value);
        first = newNode;
        last = newNode;
        length = 1;
    }


    public class Node{
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }



    public void getFirst(){
        if(first == null){
            System.out.println("Fila vazia");
        } else{
            System.out.println("Primeiro: " + first.value);
        }
    }

    public void getLast(){
        if(last == null){
            System.out.println("Fila vazia");
        } else{
            System.out.println("Último: " + last.value);
        }
    }

    public void getLength(){
        if (length == 0){
            System.out.println("Fila vazia");
        } else{
            System.out.println("Tamanho: " + length);
        }
    }

    public void print(){
        System.out.println("####################");
        if(length == 0){
            System.out.println("Fila vazia");
        } else{
            Node temp = first;
            while(temp != null){
                System.out.println(temp.value);
                temp = temp.next;
            }
        }
        System.out.println("####################");
    }

    public void enqueue(int value){
        Node newNode = new Node(value);
        if(length == 0){
            last = newNode;
            first = newNode;
        } else{
            last.next = newNode;
            last = newNode;
        }
        length++;
    }

    public Node dequeue(){
        if(length == 0) return null;
        Node temp = first;
        if(length == 1){
            first = null;
            last = null;
        } else{
            first = first.next;
            temp.next = null;
        }
        length--;
        return temp;
    }

    public void enqueueArray(int[] array){
        for(int i = 0; i < array.length; i++){
            enqueue(array[i]);
        }
    }

    public void dequeueArray(Queue queue, int length){
        for(int i = 0; i < length; i++){
            System.out.println(queue.dequeue());
        }
    }

    public static void main(String[] args) {
        Queue myQueue = new Queue(1);

        myQueue.getFirst();
        myQueue.getLast();
        myQueue.getLength();
        myQueue.print();

        myQueue.enqueue(2);
        myQueue.enqueue(3);

        myQueue.getFirst();
        myQueue.getLast();
        myQueue.getLength();
        myQueue.print();

        System.out.println(myQueue.dequeue().value);

        myQueue.getFirst();
        myQueue.getLast();
        myQueue.getLength();
        myQueue.print();
    }
}

