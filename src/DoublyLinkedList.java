import java.awt.desktop.SystemEventListener;

public class DoublyLinkedList<T> implements Iterable<T>{
    private int size = 0;
    private Node<T> head = null;
    private Node<T> tail =  null;


    private static class Node<T>{
        private T data;
        private Node<T> prev, next;

        public Node(T data, Node<T> prev, Node<T> next){
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
        @Override
        public String toString(){
            return data.toString();
        }
    }

    /* Delete all the elements of the list
    @param :
    @return :
     */
    public void clear(){
        Node<T> temp = head;
        while(temp != null){
            Node<T> next = temp.next;
            temp.prev = temp.next = null;
            temp.data = null;
            temp = next;
        }
        head = tail = temp = null;
        size = 0;

    }
    /* Get the size of the list
     @param :
     @return : the size
      */
    public int size(){
        return size;
    }
     /* Return whether a list is empty
    @param :
    @return : true if list is empty
     */
     public boolean isEmpty(){
        return size() == 0;
    }

    /* Add a node to the list (at the end of the list)
      @param : node the node to be added
      @return :
       */
    public void add(T node){
        addLast(node);
    }

    public void addLast(T node){
        if(isEmpty()){
            head = tail = new Node<T>(node, null, null );
        }else {
            tail.next = new Node<T>(node, tail, null);
            tail = tail.next;
        }
        size++;
    }
    /* Add a node at the start of the list
  @param : node is the node to be added
  @return :
   */
    public void addFirst(T node){
        Node<T> temp =  new Node<T>(node, null, head);
        head.prev = temp;
        head = head.prev;
        size++;
    }
    /* Add an element at an index-based position in the list
     @param : index the position where to add the new element, data the node to be added
     @return :
      */
    public void AddIn(int index, T data) throws Exception {
        if(index < 0){
            throw new Exception("index non valide");
        }
        if(index == 0){
            addFirst(data);
            return;
        }
        if(index == size){
            addLast(data);
            return;
        }
        Node<T> temp = head;
        for( int i = 0; i < index - 1; i++ ){
            temp = temp.next;
        }
        Node<T> newvalue = new Node<T>(data, temp, temp.next);
        temp.next.prev = newvalue;
        temp.next = newvalue;
        size++;

    }

    /* Return the head node
     @param :
     @return : the value of the head node
      */
    public T peek() throws Exception {
        if(isEmpty()) throw new Exception("la liste est vide");
        return head.data;
    }
    /* Return the tail node
      @param :
      @return : the value of the tail node
       */
    public T peekEnd() throws Exception {
        if(isEmpty()) throw new Exception("la liste est vide");
        return tail.data;
    }
    /* Remove the head node
      @param :
      @return :
       */
    public void removeHead() throws Exception {
        if(isEmpty()) throw new Exception("La liste est vide");
        T temp = head.data;
        head = head.next;
        size--;

        if(isEmpty()) tail = null;
        else head.prev =null;
    }
    /* Remove the tail node
      @param :
      @return :
       */
    public void removeTail() throws Exception {
        if(isEmpty()) throw new Exception("La liste est vide");
        T temp =  tail.data;
        tail = tail.prev;
        size--;
        if(isEmpty()) head = null;
        else tail.next = null; //Liberation de mermoire

    }
    /* Remove a specific node in the list
   @param : node is the node to be removed
   @return : the value of the removed node
    */
    private T remove(Node<T> node) throws Exception {
        if(node.prev == null ) removeHead(); // remove the head
        if(node.next == null ) removeTail(); // remove the tail
        node.next.prev = node.prev;
        node.prev.next = node.next;
        T nodevalue = node.data;
        node.data = null;
        node.next = node.prev = null;
        size--;

        return nodevalue;
    }
    /* Remove a node with the index-based position
      @param : index the position of the node to be removed
      @return : the value of the node to be removed
       */
    public T removeIn(int index) throws Exception {
        if(index < 0 || index >= size) throw new Exception ("La liste est vide");
        Node<T> temp = head;
        for(int i  = 0; i < index ; i++){
            temp = temp.next;
        }

        return remove(temp);
    }
    /* Return whether a list contains a specific node
  @param : node the node to be searched
  @return : true if the list contains node
   */
    public boolean contains(T node){
        return indexOf(node) != -1;
    }
    /* Return the index of node in the list (-1 otherwise)
      @param : node is the node to be searched
      @return : the index of the node in the list
       */
    public int indexOf(T node){
        Node<T> temp = head;
        for(int i = 0 ; i < size ; i ++ ){
            if(temp.data == node) return i;
            temp = temp.next;
        }
        return -1;
    }
    /* Display the content of the list
  @param :
  @return :
   */
    public void display(){
        if(isEmpty()){
            System.out.println("The list is empty");
            return;
        }
        Node<T> temp =  head;
        while(temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    @Override
    public java.util.Iterator<T> iterator(){
        return new java.util.Iterator<T>(){
            private Node<T> temp = head;


            @Override
            public boolean hasNext(){
                return temp != null;
            }

            @Override
            public T next(){
                T data =  temp.data;
                temp = temp.next;
                return data;
            }

            @Override
            public void remove(){
                throw new  UnsupportedOperationException();
            }

        };

    }
    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append(" [ ");
        Node<T> temp = head;
        while(temp != null){
            s.append(temp.data);
            if(temp.next != null){
                s.append(", ");
            }
            temp = temp.next;
        }
        s.append(" ]");
        return s.toString();
    }
    // Driver Program to test above functions
    //
    //
     public static void main(String[] args) throws Exception {
       DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
       System.out.println("Adding elements to the list");
       list.add(1);
       list.add(2);
       list.add(3);
       list.add(4);
       list.display();
       System.out.println("Removing elements from the list");
       list.removeTail();
       list.removeHead();
       list.display();
       System.out.println("Get the size of the list");
       System.out.println(list.size());
       System.out.println("Check if the list is empty");
       System.out.println(list.isEmpty());
       list.removeHead();
       list.removeHead();
       System.out.println(list.isEmpty());
       list.add(1);
       list.add(2);
       list.add(3);
       list.add(4);
       System.out.println("Check the index of the node 3 (0-based index)");
       System.out.println(list.indexOf(3));
       System.out.println(list.toString());
       System.out.println("Check if the node 2 is contained in the list");
       System.out.println((list.contains(2)));
       System.out.println("Remove the node in the index 2 (0-based index so the node is 3)");
       list.removeIn(2);
       list.display();


    }
}


