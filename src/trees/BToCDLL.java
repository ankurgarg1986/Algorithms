package trees;

// A Java program for in-place conversion of Binary Tree to DLL

// A binary tree node has data, left pointers and right pointers

public class BToCDLL {

  Node root;

  // head --> Pointer to head node of created doubly linked list
  Node head;

  // Initialize previously visited node as NULL. This is
  // static so that the same value is accessible in all recursive
  // calls
  static Node prev = null;

  
  private void BinaryTree2CircularDoubleLinkedList(Node root2) {
    if (root == null)
      return;
    BinaryTree2DoubleLinkedList(root);
    head.left = prev;
    if(prev!=null) prev.right = head;
    
  }
  // A simple recursive function to convert a given Binary tree
  // to Doubly Linked List
  // root --> Root of Binary Tree
  void BinaryTree2DoubleLinkedList(Node root) {
    if (root == null)
      return;
    BinaryTree2DoubleLinkedList(root.left);
    if (prev == null) {
      head = root;
     // head = prev;
    } else {
      root.left = prev;
      prev.right = root;
    }
    prev = root;
    BinaryTree2DoubleLinkedList(root.right);

  }

  /* Function to print nodes in a given doubly linked list */
  void printList(Node node) {
    while (node != null) {
      System.out.print(node.data + " ");
      node = node.left;
      System.out.print(node.data + " ");
      break;
     
    }
  }

  // Driver program to test above functions
  public static void main(String[] args) {
    // Let us create the tree as shown in above diagram
    BToCDLL tree = new BToCDLL();
    tree.root = new Node(10);
    tree.root.left = new Node(12);
    tree.root.right = new Node(15);
    tree.root.left.left = new Node(25);
    tree.root.left.left.right = new Node(100);
    tree.root.left.right = new Node(30);
    tree.root.right.left = new Node(36);
    tree.root.right.right = new Node(40);

    // convert to DLL
  //  tree.BinaryTree2DoubleLinkedList(tree.root);
    tree.BinaryTree2CircularDoubleLinkedList(tree.root);
    // Print the converted List
    tree.printList(tree.head);

  }

 
}