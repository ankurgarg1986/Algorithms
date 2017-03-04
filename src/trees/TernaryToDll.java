package trees;

class TernaryTree {

  int val;
  TernaryTree left;
  TernaryTree right;
  TernaryTree mid;

  public TernaryTree(int val) {
    super();
    this.val = val;
    this.left = null;
    this.right = null;
    this.mid = null;
  }

}

public class TernaryToDll {

  static TernaryTree troot = null;

  static TernaryTree tail = null;

  private static void convertToDll(TernaryTree root) {
      if(root == null) return ;
      if(troot == null) troot = root;//initial 
      TernaryTree left = root.left;
      TernaryTree mid = root.mid;
      TernaryTree right = root.right;
      addToTail(root);
      convertToDll(left);
      convertToDll(mid);
      convertToDll(right);
  }

  private static void addToTail( TernaryTree root) {
    
    if(root == null) return ;
    
    if(tail == null){
      tail = root;
      tail.left = null;
      tail.right = null;
      tail.mid = null;
    }
    else{
      tail.right = root;
      root.left = tail;
      tail.mid = null;
      tail  = root;
    }
    
  }

  private static void printDLL(TernaryTree troot) {
    if(troot == null) return;  
    while(troot != null){
      System.out.print(troot.val + "=>");
      troot = troot.right;
    }
    
  }
  
  
  public static void main(String[] args) {
    TernaryTree root = new TernaryTree(30);
    root.left = new TernaryTree(5);
    root.mid = new TernaryTree(11);
    root.right = new TernaryTree(63);
    root.left.left = new TernaryTree(1);
    root.left.right = new TernaryTree(8);
    root.left.mid = new TernaryTree(4);
    root.mid.left = new TernaryTree(6);
    root.mid.mid = new TernaryTree(7);
    root.mid.right = new TernaryTree(15);
    root.right.left = new TernaryTree(31);
    root.right.mid = new TernaryTree(55);
    root.right.right = new TernaryTree(65);
    convertToDll(root);
    printDLL(troot);

  }

 

}
