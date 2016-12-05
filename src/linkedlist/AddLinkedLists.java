package linkedlist;

class AddLinkedLists {

  static Node head1, head2;

  static int carry;

  static class Node {

    int data;
    Node next;

    Node(int d) {
      data = d;
      next = null;
    }
  }

  /* Adds contents of two linked lists and return the head node of resultant list */
  Node addTwoLists(Node first, Node second, int carry) {
    Node res = null;
    int sum,d = 0;
    if (first == null && second == null)
      return null;
    if (first.next != null && second.next != null){
      res = addTwoLists(first.next, second.next, carry);
      
    }
    else if (first.next != null && second.next == null){
      res = addTwoLists(first.next, second, carry);
      sum = first.data + second.data + carry;
    }
    else if (first.next == null && second.next != null){
      res = addTwoLists(first, second.next, carry);
    }
    
    sum = first.data + second.data + carry;
    if (sum > 10) {
      d = sum % 10;
      carry = sum / 10;
    }
    res = new Node(d);
    return res;
  }

  /* Utility function to prit a linked list */

  private void reverse(Node head) {

  }

  void printList(Node head) {
    while (head != null) {
      System.out.print(head.data + " ");
      head = head.next;
    }
    System.out.println("");
  }

  public static void main(String[] args) {
    AddLinkedLists list = new AddLinkedLists();

    // creating first list
    list.head1 = new Node(7);
    list.head1.next = new Node(5);
    list.head1.next.next = new Node(9);
    list.head1.next.next.next = new Node(4);
    list.head1.next.next.next.next = new Node(6);
    System.out.print("First List is ");
    list.printList(head1);

    // creating seconnd list
    list.head2 = new Node(8);
    list.head2.next = new Node(4);
    System.out.print("Second List is ");
    list.printList(head2);

    // add the two lists and see the result
    Node rs = list.addTwoLists(head1, head2, 0);
    System.out.print("Resultant List is ");
    list.printList(rs);
  }
}