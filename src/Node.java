/**
 * Name: Jerimey Simons
 * Description: Node class structure for linked list
 * Word: String word.
 * Next: Node connection to next Node in list.
 */
public class Node {
	 String word;
	 Node next;

	 /**
	  * Method call to print linked list
	  * @param head <code>Node</code> head of linked list
	  */
	 public void printList(Node head){
		  while(head != null){
				System.out.print(head.word + " ");
				head = head.next;
		  }

	 }
}






