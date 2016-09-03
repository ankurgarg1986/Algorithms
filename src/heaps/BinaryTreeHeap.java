package heaps;

class Node {
	Node left;
	Node right;
	int data;

	public Node(int data, Node left, Node right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

public class BinaryTreeHeap {

	public static void main(String[] args) {
		Node root = new Node(10, null, null);
		root.left = new Node(9);
		root.right = new Node(8);
		root.left.left = new Node(7);
		root.left.right = new Node(6);
		root.right.left = new Node(5);
		root.right.right = new Node(4);
		root.left.left.left = new Node(3);
		root.left.left.right = new Node(2);
		root.left.right.left = new Node(1);
		if(isMaxHeap(root)){
			System.out.println("Yes");
		}else{
			System.out.println("False");
		}

	}

	
	private static boolean isMaxHeap(Node root) {
	   if(root==null){
		   return true;
	   }
	   int n = nodeCount(root);
       System.out.println(n);
	   return isMaxHeapUtil(root,n,0);
	}


	private static boolean isMaxHeapUtil(Node root, int n,int i) {
		if(root == null) return true;
		if(i >=n) return false;
		if(root.left == null && root.right ==null) return true;//leaf node
		
		int l = 2*i + 1;
		int r = 2*i + 2;
		if(root.right != null && root.left != null){
			int maxm  = Math.max(root.right.data, root.left.data);
			if(root.data < maxm){
				return false;
			}
		}
		else if (root.right != null){
			if (root.data < root.right.data){
				return false;
			}
		}
		else if (root.left != null){
			if(root.data < root.left.data){
				return false;
			}
		}
	
		return isMaxHeapUtil(root.right,n,r) && isMaxHeapUtil(root.left,n,l);
	}


	private static int nodeCount(Node root) {
		if(root == null) return 0;
		return 1 + nodeCount(root.left) + nodeCount(root.right);
	}
}
