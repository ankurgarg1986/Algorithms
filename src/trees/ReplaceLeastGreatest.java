package trees;

public class ReplaceLeastGreatest {

  private static void replaceWithLeastGreatest(int[] arr) {
    int n = arr.length;
    int i;
    Node root = new Node(arr[n-1]);
    for (i = n-2; i >= 0; i--) {
      insert(arr[i], root);
    }
    int[] ans = new int[n];
    for (i = 0; i < n - 1; i++) {
      ans[i] = findInorderSuccessor(root, arr[i]);
    }
    ans[n - 1] = -1;

  }

  private static int findInorderSuccessor(Node root, int val) {
    if (root == null)
      return -1;
    Node curr = root;
    Node parent = null;
    while (curr != null) {
      if (val == curr.data)
        break;
      if (val < curr.data) {
        parent = curr;
        curr = curr.left;
      } else {
        curr = curr.right;
      }
    }
    if (curr == null)
      return -1;

    if (curr.right != null) {
      curr = curr.right;
      while (curr.left != null) {
        curr = curr.left;
      }
      return curr.data;
    } else {
      if (parent == null)
        return -1;
      return parent.data;
    }
  }


  private static void insert(int val, Node root) {
    Node curr = root;
    while (curr != null) {
      if (val > curr.data) {
        while (curr.right != null && val > curr.data)
          curr = curr.right;
        if (curr.right == null && val > curr.data) {
          curr.right = new Node(val);
          return;
        }
      } else {
        while (curr.left != null && val < curr.data)
          curr = curr.left;
        if (curr.left == null && val < curr.data) {
          curr.left = new Node(val);
          return;
        }
      }
    }
  }

  public static void main(String[] args) {
    int arr[] = { 8, 58, 71, 18, 31, 32, 63, 92, 43, 3, 91, 93, 25, 80, 28 };
    replaceWithLeastGreatest(arr);

  }

}
