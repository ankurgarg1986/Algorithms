package trees;


class CNode 
{
    int data;
    CNode left, right, nextRight;
  
    CNode(int item) 
    {
        data = item;
        left = right = nextRight = null;
    }
}
  
public class ConnectNodesSameLevel 
{
    CNode root;
  
    /* Set next right of all descendents of p. This function makes sure that
       nextRight of nodes ar level i is set before level i+1 nodes. */
    public void connectRecur(CNode root) 
    {
       if(root == null) return;
       if(root.left != null){
           if(root.right != null){
             root.left.nextRight = root.right;
           }else{
             root.left.nextRight = populateNextRight(root);
           }
       }
       if(root.right != null){
         root.right.nextRight = populateNextRight(root);
       }
       connectRecur(root.nextRight);
       connectRecur(root.left);
       connectRecur(root.right);
    }
  
    private CNode populateNextRight(CNode root) {
        if(root.nextRight == null) return null;
        while(root != null){
          root = root.nextRight;
          if(root.left != null){
            return root.left;
          }
          if(root.right != null)
            return root.right;
          root =  root.nextRight;
        }
        return root;
    }

    /* Driver program to test the above functions */
    public static void main(String args[]) 
    {
        ConnectNodesSameLevel tree = new ConnectNodesSameLevel();
        tree.root = new CNode(10);
        tree.root.left = new CNode(8);
        tree.root.right = new CNode(2);
        tree.root.left.left = new CNode(3);
        tree.root.right.right = new CNode(90);
  
        // Populates nextRight pointer in all nodes
        tree.connectRecur(tree.root);
  
        // Let us check the values of nextRight pointers
        int a = tree.root.nextRight != null ? 
                          tree.root.nextRight.data : -1;
        int b = tree.root.left.nextRight != null ? 
                          tree.root.left.nextRight.data : -1;
        int c = tree.root.right.nextRight != null ?
                            tree.root.right.nextRight.data : -1;
        int d = tree.root.left.left.nextRight != null ?
                        tree.root.left.left.nextRight.data : -1;
        int e = tree.root.right.right.nextRight != null ? 
                        tree.root.right.right.nextRight.data : -1;
          
        // Now lets print the values
        System.out.println("Following are populated nextRight pointers in "
                + " the tree(-1 is printed if there is no nextRight)");
        System.out.println("nextRight of " + tree.root.data + " is " + a);
        System.out.println("nextRight of " + tree.root.left.data + " is " + b);
        System.out.println("nextRight of " + tree.root.right.data + " is " + c);
        System.out.println("nextRight of " + tree.root.left.left.data + 
                                                              " is " + d);
        System.out.println("nextRight of " + tree.root.right.right.data + 
                                                              " is " + e);
    }
}
