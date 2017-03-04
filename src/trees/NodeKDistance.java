package trees;

import java.util.LinkedList;
import java.util.Queue;

public class NodeKDistance {

  Node root;

  void printkdistanceNode(Node node, Node target, int k) {
    if (node == null)
      return;
    Queue<Node> parent = new LinkedList<Node>();
    findNode(node, target, parent);
    Node prev = target;
    int c = 0;
    while ( !parent.isEmpty()) {
      Node curr = parent.poll();
      c++;
      printParentsFromStack(prev, curr, parent, k - c);
      prev = curr;
    }
    printNodesDown(target, k);

  }

  private void printNodesDown(Node node, int k) {
    if (node == null)
      return;
    if (k == 0)
      System.out.println(node.data);
    printNodesDown(node.left, k - 1);
    printNodesDown(node.right, k - 1);
  }

  private void printParentsFromStack(Node prev, Node curr, Queue<Node> parent, int d) {
    if (curr == null || prev == null)
      return;
    if(d == 0 ) System.out.println(curr.data);
    if (curr.left == prev) {
      printNodesDown(curr.right,d-1);
    } else if (curr.right == prev) {
      printNodesDown(curr.left,d-1);
    }

  }

  private boolean findNode(Node node, Node target, Queue<Node> parent) {
    if (node == null || target == null)
      return false;
    if (node == target)
      return true;
    if (findNode(node.left, target, parent) || findNode(node.right, target, parent)){
      parent.add(node);
      return true;
    }
    return false;
  }

  public static void main(String args[]) {
    NodeKDistance tree = new NodeKDistance();
    /* Let us construct the tree shown in above diagram */
    tree.root = new Node(20);
    tree.root.left = new Node(8);
    tree.root.right = new Node(22);
    tree.root.left.left = new Node(4);
    tree.root.left.left.right = new Node(19);
    tree.root.left.right = new Node(12);
    tree.root.left.right.left = new Node(10);
    tree.root.left.right.right = new Node(14);
    tree.root.left.right.right.left = new Node(16);
    Node target = tree.root.left.right;
    tree.printkdistanceNode(tree.root, target, 1);
  }
}