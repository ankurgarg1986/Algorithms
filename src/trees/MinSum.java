package trees;

class Node1 {
	Node1 right;
	Node1 left;
	int rSum;// sum of right Subtree
	int lSum;// sum of left Subtree
	int pLen;

	public Node1(int pLen) {
		this.rSum = 0;
		this.lSum = 0;
		this.pLen = pLen;
		this.right = null;
		this.left = null;
	}
}

public class MinSum {

	Node1 root;
	
	static int ans = 0;

	public static int computeSum(Node1 root) {

		if (root == null)
			return 0;
		int lSum = computeSum(root.left);
		root.lSum += lSum;
		int rSum = computeSum(root.right);
		root.rSum += rSum;
		//handle the case for leaf Node or with only one child 
		if(lSum != 0 && rSum != 0) {
			ans += Math.abs(root.rSum - root.lSum);
		}
		return root.pLen + Math.max(root.rSum, root.lSum);
	}

	public static void main(String[] args) {
		Node1 root = new Node1(0);// root Node with pLen 0
		MinSum ms = new MinSum();
		ms.root = root;
		ms.root.left = new Node1(5);
		ms.root.right = new Node1(10);
		ms.root.left.right = new Node1(12);
		ms.root.left.left = new Node1(16);
		ms.root.left.left.left = new Node1(3);
		ms.root.right.left = new Node1(20);
		ms.root.right.right = new Node1(6);
		ms.root.left.left.right = new Node1(14);
		ms.root.left.right.left = new Node1(17);
		ms.root.right.left.right = new Node1(4);
		computeSum(ms.root);
		System.out.println(ans);

	}

}
