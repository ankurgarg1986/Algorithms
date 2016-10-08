package trees;

public class ReplaceWithRightGreatest {

  class Node {

    int data;
    Node left;
    Node right;

    Node(int data) {
      this.data = data;
      this.left = null;
      this.right = null;
    }
  }

  private Node successor;
  private Node root;

  private int[] replace(int[] inputArray) {

    root = new Node(inputArray[inputArray.length - 1]);
    for (int i = inputArray.length - 1; i >= 0; i--) {
      this.successor = null;
      insert(inputArray[i], root);
      if (successor != null) {
        inputArray[i] = successor.data;
      } else {
        inputArray[i] = -1;
      }
    }
    return inputArray;
  }

  private void insert(int data, Node root) {

    if (data < root.data) {
      successor = root;
      if (root.left == null) {
        root.left = new Node(data);
      } else {
        insert(data, root.left);
      }
    } else if (data > root.data) {
      if (root.right == null) {
        root.right = new Node(data);
      } else {
        insert(data, root.right);
      }
    }
  }

  public static void main(String args[]) {
    ReplaceWithRightGreatest replace = new ReplaceWithRightGreatest();
    int[] inputArray = { 8, 58, 71, 18, 31, 32, 63, 92, 43, 3, 91, 93, 25, 80, 28 };

    int[] replacedArray = replace.replace(inputArray);

    for (int number : replacedArray) {
      System.out.print(" " + number + " ");
    }
  }
}
