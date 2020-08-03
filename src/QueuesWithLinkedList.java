import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class QueuesWithLinkedList<T> implements Iterable<T> {
    private int size = 0;
    private Node<T> head = null;
    private Node<T> tail = null;

    private static class Node<T>{
        private T data;
        private Node<T> next;

        public Node(T data, Node<T> next){
            this.data = data;
            this.next = next;
        }
        @Override
        public String toString(){
            return data.toString();
        }
    }
    /* Add a node to the head of the queue
   @param : node is the value of node to be added
   @return :
    */
    public void push (T node){
        Node<T> temp =  new Node(node,head);
        head = temp;
        size++;

    }
      /* get the node value at the end of the queue (tail)
     @param : node is the value of the node to be added
     @return :
      */
      public void pull(T node){

      }



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
}
