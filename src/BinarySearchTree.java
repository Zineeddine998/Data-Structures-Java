/*
Implementation of a binary search tree
 */

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
    @param curent current node
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
          ////
      }
      if(val < current.value){
          current.left  = deleteRecursive(current.left, val);
          return current;
      }
      current.right =  deleteRecursive(current.right, val);
      return current;
  }

    /*  driver method to test the above functions
    */

    public static void main(String[] args){
        BinarySearchTree tree = new BinarySearchTree();
    }
}
