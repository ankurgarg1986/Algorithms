package linkedlist;

public class MergeTwoLinkedListWithoutChanging {

  static Node1 h2;
  
  public static void main(String[] args) {

    Node1 h1 = new Node1(4);
//    h1.next = new Node1(4);
    h1.next = new Node1(7);
//    h1.next.next.next = new Node1(8);
//    h1.next.next.next.next = new Node1(10);

     h2 = new Node1(3);
    h2.next = new Node1(5);
   h2.next.next = new Node1(12);

    merge(h1, h2);

    Node1 curr1 = h1;
    Node1 curr2 = h2;
    while (curr1 != null) {
      System.out.print(curr1.data + " ");
      curr1 = curr1.next;
    }
    System.out.print( "\n");
    while (curr2 != null) {
      System.out.print(curr2.data + " ");
      curr2 = curr2.next;
    }

  }

  private static void merge(Node1 h1, Node1 h2) {

    if (h1 == null || h2 == null)
      return;
    while (h1 != null && h2 != null) {
      if (h1.data > h2.data) {
        int temp = h1.data;
        h1.data = h2.data;
        h2.data = temp;
        if (h2.next != null && h2.data > h2.next.data) {
          Node1 prev = null;
          Node1 t = h2.next;
          while (t != null && t.data < h2.data) {
            prev = t;
            t = t.next;
          }
          Node1 t1 = h2;
          h2 = h2.next;
          prev.next = t1;
          t1.next = t;
        }
      }

      h1 = h1.next;
    }
//    Node1 curr2 = h2;
//    while (curr2 != null) {
//      System.out.print(curr2.data + " ");
//      curr2 = curr2.next;
//    }
  }

}