package trees;

public class BoundaryTraversal {

  Node root;

  // Driver program to test above functions
  public static void main(String args[]) {
    BoundaryTraversal tree = new BoundaryTraversal();
    tree.root = new Node(20);
    tree.root.left = new Node(8);
//    tree.root.left.left = new Node(4);
//    tree.root.left.left.right = new Node(16);
//    tree.root.left.right = new Node(12);
//    tree.root.left.right.left = new Node(10);
//    tree.root.left.right.left.right = new Node(51);
//    tree.root.left.right.right = new Node(14);
//    tree.root.left.right.right.right = new Node(9);
   // tree.root.right = new Node(22);
//    tree.root.right.left = new Node(31);
//    tree.root.right.left.left = new Node(7);
//    tree.root.right.left.right = new Node(18);
//    tree.root.right.right = new Node(25);
    tree.printBoundary(tree.root);

  }

  private void printBoundary(Node root) {
    if (root == null)
      return;
    System.out.println(root.data);
    printLeftBoundary(root.left);
    printLeaves(root);
    printRightBoundary(root.right);
  }

  private void printLeaves(Node root) {
    if (root == null)
      return;
    if(isLeaf(root)) System.out.println(root.data);
    printLeaves(root.left);
    printLeaves(root.right);

  }

  private void printLeftBoundary(Node root) {
    if (root == null || isLeaf(root))
      return;
    System.out.println(root.data);
    printLeftBoundary(root.left);

  }

  private boolean isLeaf(Node root) {
   return (root.left == null && root.right== null);
  }

  private void printRightBoundary(Node root) {
    if (root == null || isLeaf(root))
      return;
    printRightBoundary(root.right);
    System.out.println(root.data);

  }
}