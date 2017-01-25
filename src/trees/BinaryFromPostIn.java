package trees;


//public class BinaryFromPostIn {
//
//  public static void main(String[] args) {
//    // TODO Auto-generated method stub
//
//  }
//
//}

class Node 
{
    int data;
    CNode left, right;
 
    public Node(int data) 
    {
        this.data = data;
        left = right = null;
    }
}
 
// Class Index created to implement pass by reference of Index
class Index 
{
    int index;
}
 
public class BinaryFromPostIn 
{
   static int i;  
  /* Recursive function to construct binary of size n
       from  Inorder traversal in[] and Preorder traversal
       post[].  Initial values of inStrt and inEnd should
       be 0 and n -1.  The function doesn't do any error
       checking for cases where inorder and postorder
       do not form a tree */
    CNode buildTreeUtil(int in[], int post[], int s,
            int e) 
    {
        if(s > e || i<0) return null;
        int rootVal = post[i];
        i--;
        CNode root = new CNode(rootVal);
        int idx = search(in,s,e,rootVal);
        root.right = buildTreeUtil(in,post,idx+1,e); 
        root.left =  buildTreeUtil(in,post,s,idx-1);
        return root;
 
    }
 
    // This function mainly initializes index of root
    // and calls buildUtil()
    CNode buildTree(int in[], int post[], int n) 
    {
      i = n-1;
      return buildTreeUtil(in,post,0,n-1);
    }
 
    /* Function to find index of value in arr[start...end]
       The function assumes that value is postsent in in[] */
    int search(int arr[], int strt, int end, int value) 
    {
        int i;
        for (i = strt; i <= end; i++) 
        {
            if (arr[i] == value)
                break;
        }
        return i;
    }
 
    /* This funtcion is here just to test  */
    void preOrder(CNode node) 
    {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
 
    public static void main(String[] args) 
    {
        BinaryFromPostIn tree = new BinaryFromPostIn();
        int in[] = new int[]{4, 8, 2, 5, 1, 6, 3, 7};
        int post[] = new int[]{8, 4, 5, 2, 6, 7, 3, 1};
        int n = in.length;
        CNode root = tree.buildTree(in, post, n);
        System.out.println("Preorder of the constructed tree : ");
        tree.preOrder(root);
    }
}
