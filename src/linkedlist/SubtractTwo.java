package linkedlist;

class SNode {

  int data;
  SNode next;

  public SNode(int d) {
    this.data = d;
    this.next = null;
  }

}

public class SubtractTwo {

  static int borrow = 0;
  public static SNode subtract(SNode l1, SNode l2) {
    if (l1 == null && l2 == null)
      return  null;
    int n1 = findLength(l1);
    int n2 = findLength(l2);
    SNode temp1;
    SNode temp2;
    temp1 = (n1 < n2) ? l1 : l2;
    temp2 = (n1 < n2) ? l2 : l1;
    int diff = Math.abs(n1-n2);
    if(diff>0){
      addZeroes(diff,l1);
    }else{
        //equal length
    }
    return subtractHelper(temp1,temp2);
  }

  private static SNode subtractHelper(SNode s, SNode l) {
     if(s==null && l==null ) return null;
     SNode ans  = subtractHelper(s.next,l.next);
     int d1 = s.data;
     int d2 = l.data - borrow;
     SNode node = null;
     if(d2 >= d1){
         node = new SNode(d2-d1);
     }else{
        d2 = d2+ 10;
        node = new SNode(d2-d1);
        borrow = 1;
     }
     node.next = ans;
     return node;
     
  }

  private static void addZeroes(int diff, SNode l1) {
    // TODO Auto-generated method stub
    
  }

  private static int findLength(SNode l2) {

    return 0;
  }

  public static void main(String[] args) {
    SNode head = new SNode(1);
    head.next = new SNode(0);
    head.next.next = new SNode(0);
    SNode l2 = new SNode(1);
    l2.next = null;
    SNode ans  = subtract(head, l2);

  }

}
