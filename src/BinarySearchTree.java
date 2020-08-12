/*
Implementation of a binary search tree
 */

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value){
            this.value = value;
            right = null;
            left = null;
        }
    }

    Node root;

    /* Insert an element to the tree (recursively)
    @param current current node
    @param val the value to be inserted
    @return the node that contains the value to be inserted
      */

    private Node insertRecursive(Node current, int val){
        //check if the tree is empty and return the node added if its the case
        if(current == null){
            return new Node(val);
        }

        if(val < current.value){
            current.left = insertRecursive(current.left ,val);

        }else if (val > current.value){
            current.right = insertRecursive(current.right, val);
        } else {
            return current;
        }

        return current;
    }
    /* method that starts the addition from the root
    @param value the value to be added
     */
    private void add(int val){
        root =  insertRecursive(root,val);
    }
  /* find an element in the tree (recursive)
  @param current the current node during traversal
  @param val the value to be found
  @return whether the value exists in the tree
   */

  private boolean containsRecursive(Node current, int val){
      //we attained the leaves of the tree without encountering the value
      if(current == null){
          return false;
      }
      if(val == current.value){
          return true;
      }
    /*  if(val < current.value){
          return containsNode(current.left,val);
      }else {
          return containsNode(current.right,val);
      }

      Using ternary operator :
     */
    return (val < current.value)? containsRecursive(current.left, val) : containsRecursive(current.right, val);
  }
  /*
  Helper function to call the recursive finding function
  @param val the value to be searched
  @return whether the the value were found
   */

  public boolean containsNode(int val){
      return containsRecursive(root, val);
  }


  /*
  deleting a node from the tree (recursive)
  @param current the current node during the traversal
  @param val the value to be deleted
   */
  private Node deleteRecursive(Node current, int val){

      if(current == null){
          return null;
      }
      if(val == current.value){
          //if the node is a leaf
          if( current.left == null && current.right  == null ){
              return null;
          }

          //if the node contains only one child
          if(current.right == null){
              return current.left;
          }
          if(current.left == null){
              return current.right;
          }
          //if the node has two children
          int smallest = findSmallest(current.right); //find the smallest value in the right sub tree
          current.value = smallest; //replace the value to be deleted with the value found in the right sub tree
          current.right = deleteRecursive(current.right, smallest);//delete the duplicate
          return current;
      }
      if(val < current.value){
          current.left  = deleteRecursive(current.left, val);
          return current;
      }
      current.right =  deleteRecursive(current.right, val);
      return current;
  }
  /*
  helper function to fund the smallest element in the right sub tree
  @param root the node where we start the traversal
  @the smallest value in the right sub tree
   */
  private int findSmallest(Node root){
      return root.left == null ? root.value : findSmallest(root.left); //keep traversing the tree until we get the right most leaf
  }

  /* functions of tree traversal
  @inorder
  @postorder
  @preorder
   */

  public void inorderTraversal(Node node){
      if(node != null){
          inorderTraversal(node.left);
          System.out.println(node.value);
          inorderTraversal(node.right);
      }
  }

  public void postorderTraversal(Node node){
      if(node != null){
          postorderTraversal(node.left);
          postorderTraversal(node.right);
          System.out.println(node.value);
      }
  }

  public void preorderTraversal(Node node){
      if(node != null){
          System.out.println(node.value);
          preorderTraversal(node.left);
          preorderTraversal(node.right);
      }
  }

  /* function to traverse the tree by levels

   */

  public void levelTraversal(){
      if(root == null){
          return;
      }
      Queue<Node> list  =  new LinkedList<>(); // list to keep track of the elements
      list.add(root);

      while(!list.isEmpty()){
          Node node =  list.remove();
          System.out.println(" " + node.value);
          if(node.left != null){
              list.add(node.left);
          }
          if(node.right != null){
              list.add(node.right);
          }
      }

  }

/* get the depth/ level of the binary tree (the length of the deepest branch recursively)
@param root the root of the tree
@return the depth/level of the tree
 */
public static int getDepth(Node root) {
    if (root == null) return 0;
    int leftDepth = getDepth(root.left);
    int rightDepth = getDepth(root.right);

    return Math.max(leftDepth, rightDepth) + 1;
}

    /* get the number of elements in a tree (recursively)
    @param root the root of the tree
    @return the number of nodes in the tree
     */
    public static int numberOfElements(Node root) {
        if (root == null) return 0;
        return 1 + numberOfElements(root.right) + numberOfElements(root.left);
    }
    
     /* destroy a tree (delete all the elements in the tree)
    in the case of Java programming language the garbage collection
    will remove all the values that can't be accessed automatically
    (in this case the nodes that are not pointed at)
    @param root the root of the tree
     */
    public void deleteTree(Node root) {
        root = null;
        this.root = null;
    }
    
     /*  driver method to test the above functions
     */

    public static void main(String[] args){

        BinarySearchTree tree = new BinarySearchTree();
        tree.add(4);
        tree.add(6);
        tree.add(8);
        tree.add(90);
        tree.add(67);
        tree.add(5);
        tree.add(2);
        tree.add(1);
        tree.levelTraversal();
        System.out.println("the depth of the tree : " + getDepth(tree.root));
        System.out.println("the number of elements in the tree :  " + numberOfElements(tree.root));
    }
}
