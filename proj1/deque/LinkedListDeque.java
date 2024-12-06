package deque;

public class LinkedListDeque<T> {
    public class Node{
        T data;
        Node next;
        Node prev;
        public Node(T data) {
            this.data = data;
        }
    }
    private Node sentinel;
    private int size;
    // initializing an empty Deque
    public LinkedListDeque() {
        sentinel = new Node(null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }
    /** function that told tha deque is empty or not */
    public boolean isEmpty() {
        return sentinel == sentinel.next;
    }
    /** function that return the size of the deque*/
    public int size() {
        return size;
    }
    /** add to the first of the deque */
    public void addFirst(T data) {
        Node newNode = new Node(data);
        newNode.next = sentinel.next;
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        newNode.prev = sentinel;
        size++;

    }
    /** add to the last of the deque */
    public void addLast(T data) {
        Node newNode = new Node(data);
        newNode.prev = sentinel.prev;
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
        newNode.next = sentinel;
        size++;
    }
    /** function that removes the first element of the deque */
    public T removeFirst() {
        if(isEmpty()) return null;
        Node first = sentinel.next;
        sentinel.next.next.prev=sentinel;
        sentinel.next = sentinel.next.next;
        size--;
        return first.data;

    }
    /** function that removes the last element of the deque */
    public T removeLast() {
        if(isEmpty()) return null;
        Node last = sentinel.prev;
        sentinel.prev.prev.next=sentinel;
        sentinel.prev = sentinel.prev.prev;
        size--;
        return last.data;
    }
    /** function that return the node at the specific index */
    public Node get(int idx){
        Node current = sentinel.next;
        int i=0;
        while (current  != sentinel && i < idx) {
            System.out.print(current.data + " ");
            current = current.next;
            i++;
        }
        if(i==idx)return current;
        return null;
    }
    private  Node getRecursive(Node cur,int idx){
        if(idx==0)return cur;
        return getRecursive(cur.next,idx-1);
    }
    /** function that return the data in the node at the given index*/
    public T getRecursive(int indx){
        return getRecursive(sentinel,indx).data;
    }
    /** function that print the elements in the deque */
    public void printDeque() {
        Node current = sentinel.next;
        while (current  != sentinel) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    
}