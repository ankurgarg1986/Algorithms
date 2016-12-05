package linkedlist;

class Node1 {

  int data;
  Node1 next;

  Node1(int d) {
    data = d;
    next = null;
  }
}

public class LinkedListReverseRecursion {

  static Node1 head;
  static Node1 headL = null;

  // A simple and tail recursive function to reverse
  // a linked list. prev is passed as NULL initially.
  void reverseUtil(Node1 curr) {
      if(curr.next == null ){
        headL = curr;
        return ;
      }
      reverseUtil(curr.next);
      curr.next.next = curr;
     // if(headL == null) headL = curr.next;
      curr.next = null;
      return;
      
  }

  // prints content of double linked list
  void printList(Node1 node) {
    while (node != null) {
      System.out.print(node.data + " ");
      node = node.next;
      
    }
  }

  public static void main(String[] args) {
    LinkedListReverseRecursion list = new LinkedListReverseRecursion();
    list.head = new Node1(1);
   list.head.next = new Node1(2);
    list.head.next.next = new Node1(3);
    list.head.next.next.next = new Node1(4);
    list.head.next.next.next.next = new Node1(5);
    list.head.next.next.next.next.next = new Node1(6);
    list.head.next.next.next.next.next.next = new Node1(7);
    list.head.next.next.next.next.next.next.next = new Node1(8);

    System.out.println("Original Linked list ");
    list.printList(head);
   
    list.reverseUtil(head);
    System.out.println("");
    System.out.println("");
    System.out.println("Reversed linked list ");
    list.printList(headL);
  }
}