import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

//Stacks implemented with a linked list (Singly linked list)
class StackWithLinkedList<T> implements Iterable<T> {

    private int size = 0;
    private Node<T> peek = null; //Sommet de la pile

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super T> action) {

    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
    }

    private static class Node<T>{
        private int  data;
        private Node<T> next;


        public Node(int data, Node<T> next){
            this.data = data;
            this.next = next;
        }
        @Override
        public String toString(){
            return Integer.toString(data);
        }
    }
    /* return the value of the peek of the stack and delete it

     */
    public int peek(){
        if(isEmpty()){
            System.out.println("the stack is empty!");
            return -1;
        }
        int temp = peek.data;
        peek = peek.next;
        size--;
        return temp;
    }

    /* return the size of the stack

     */
    public int size(){
        return size;
    }
    /*
    return whether the the stack is empty

     */
    public boolean isEmpty(){
        return size() == 0;
    }
    /* insert a new value at the top of the stack
    @param : newElement the value of the element to be inserted
     */
    public void push(int newElement){
        // In the implementation we insert the new element in the head of the linked list
        Node temp = new Node(newElement, peek);
        peek  = temp;
        size++;
    }

    /* pop the element at the top of the stack
    the difference with peek() is that we don't return the element to be removed
     */
    public void pop(){
        // In the implementation we delete the head element
        if(isEmpty()){
            System.out.println("The stack is empty!");
            return;
        }
        peek = peek.next;
        size--;
    }

    /* diplay the content of the stack in the insertion order (peek -> ... -> bottom)

     */
    public void display(){
        if(isEmpty()){
            System.out.println("The stack is empty!");
        }
        Node temp = peek;
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    // Driver Program to test above functions
    public static void main(String[] args) {
        StackWithLinkedList<Integer> st = new StackWithLinkedList<>();
        st.push(23);
        st.push(45);
        st.push(3434);
        st.push(3434);
        st.push(3434);
        st.display();
        System.out.println("pop the top element from the stack");
        st.pop();
        st.pop();
        st.pop();
        st.display();
        System.out.println("get the size of the stack");
        System.out.println(st.size());
        System.out.println("check whether the stack is empty");
        System.out.println(st.isEmpty());
        st.pop();
        st.pop();
        System.out.println(st.isEmpty());
        st.pop();
        st.push(400);
        st.display();
    }
}