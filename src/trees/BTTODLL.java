//package trees;
//
////Java Program to convert a Binary Tree to a
////Circular Doubly Linked List
//
////Node class represents a Node of a Tree
//class Node {
//	int val;
//	Node left, right;
//
//	public Node(int val) {
//		this.val = val;
//		left = right = null;
//	}
//	
//}
//
//// A class to represent a tree
//class Tree {
//	
//	Node head;
//	Node root;
//	// Method converts a tree to a circular
//	// Link List and then returns the head
//	// of the Link List
//	public Node bTreeToCList(Node root) {
//		if (root == null)
//			return root;
//		Node head = null;
//		Node prev = null;
//		bTreeToListUtil(root, head, prev);
//		return head;
//
//	}
//
//	private Node bTreeToListUtil(Node root, Node head, Node prev) {
//		if (root == null)
//			return root;
//		Node leftAns = bTreeToListUtil(root.left, head, prev);
//		Node rightAns = bTreeToListUtil(root.right, head, prev);
//		root.left = leftAns;
//		if (leftAns != null) {
//			leftAns.right = root;
//		}
//		root.right = rightAns;
//		if (rightAns != null) {
//			rightAns.left = root;
//		}
//		while (root.right != null) {
//			root = root.right;
//		}
//		return root;
//	}
//
//	// Display Circular Link List
//	public void display(Node head) {
//		System.out.println("Circular Linked List is :");
//		Node itr = head;
//		do {
//			System.out.print(itr.val + " ");
//			itr = itr.right;
//		} while (itr != head);
//		System.out.println();
//	}
//
//	public Node bTreeToDList(Node root) {
//		if (root == null)
//			return root;
//		if (root.left != null) {
//			Node leftAns = bTreeToDList(root.left);
//			if (leftAns != null) {
//				root.left = leftAns;
//				leftAns.right = root;
//			}
//		}
//		if(root.right != null){
//			Node rightAns = bTreeToDList(root.right);
//			if (rightAns != null) {
//				root.right = rightAns;
//				rightAns.left = root;
//			}
//			while(root.right != null){
//				root = root.right;
//			}
//		}	
//		return root;
//
//	}
//
//	public  void BToDLL(Node root) {
//	    if(root == null) return ;
//		BToDLL(root.right);
//		if(head != null){
//			head.left = root;
//		}
//		root.right = head;
//		head = root;
//		BToDLL(root.left);
//	}
//}
//
//// Driver Code
//public class BTTODLL {
//	public static void main(String args[]) {
//		// Build the tree
//		Tree tree = new Tree();
//		tree.root = new Node(10);
//		tree.root.left = new Node(12);
//		tree.root.right = new Node(15);
//		tree.root.left.left = new Node(25);
//		tree.root.left.right = new Node(30);
//		tree.root.right.left = new Node(36);
//        
//		// head refers to the head of the Link List
//		tree.BToDLL(tree.root);
//      //  Tree.printList(head);
//
//		// Display the Circular LinkedList
//	//	tree.display(head);
//	}
//}