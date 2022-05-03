
/**
 * Name: Jerimey Simons
 * Date: 4/20/2022
 * Description: program to perform a Radix sort on the provided words, utilizing a
 * Right to Left alphabetical sorting process.
 */
public class Radix{
	 /**
	  * Main method to process string Array into a linked list, print list to console, and then send out to be sorted
	  */
	 public static void main (String[] args){
		 	//variable library
		  	int maxLength = 0;
		 	int wordCount = 0;
			Node head = null;
			Radix horse = new Radix();

		  	System.out.println("Jerimey is the best!!! ;)\n");
 	 		String[] list = {"bar","cat","apple","bug","cog","caper","antler","ankle","bear",};
			System.out.print("SORT -> ");
			Node tmp = new Node();
		   //for loop to process string array to determine maxlength, wordcount, and create linked list from Array.
	 		for(String word: list){
				 Node newNode = new Node();
				 if(head == null){
					head = newNode;
				 }
				 newNode.word = word;
				 tmp.next = newNode;
				 tmp = newNode;
				 System.out.print(word + " ");
				 if(word.length()> maxLength){
				  maxLength = word.length();
				 }
				 wordCount++;
			}
	 		System.out.println("\n");
    		horse.radixSort(head,maxLength, wordCount);
	 }

	 /**
	  * Method to process an Araay using a Radix alphabetical sorting process
	  * @param head <code>String</code> Node head of linked list for unsorted list.
	  * @param maxLength <code>int</code> Integer holding the max length of the longest word in the Array.
	  * @param wordCount <code>int</code> Integer holding the number of words in the Array.
	  */
	 public void radixSort(Node head, int maxLength, int wordCount){
		  //variable library
		  Node sortlist = head;
		  Node sortedList = null;
		  Node[] queue = new Node[26];

		  //for loop to process through each letter in the word pull from the linked list.
			for(int charPosition = 1; charPosition<= maxLength+1; charPosition++){
				 //pop first node from sortlist to process into its queue position
				 for(int i =0; i<=wordCount; i++){
					  Node sortWord = sortlist;
					  sortlist = sortlist.next;
					  sortWord.next = null;
					  int j = 0;
					  //for loop to add nodes to sorted linked list when node's word length is less than charPosition
					  for(char alphabet = 'a'; alphabet <= 'z'; alphabet++){
							if(sortWord.word.length() < charPosition){
								 if(sortedList == null){
									  sortedList = sortWord;
									  break;
								 }else{
									  Node tmp = sortedList;
									  while(sortedList.next != null){
											sortedList = sortedList.next;
									  }
									  sortedList.next = sortWord;
									  sortedList = tmp;
									  j = 0;
									  break;
								 }
								 //if statement to sort the queue Array alphabetical for continued processing
							}else if (sortWord.word.charAt(sortWord.word.length()-charPosition) ==alphabet){
								 if(queue[j] == null){
									  queue[j]= sortWord;
									  j = 0;
									  break;
								 }else{
									  Node tmp = queue[j];
									  while(queue[j].next != null){
											queue[j] = queue[j].next;
									  }
									  queue[j].next =sortWord;
									  queue[j] = tmp;
									  j = 0;
									  break;
								 }
							}
							j++;
					  }
					  if(sortlist == null){
							break;
					  }
				 }
				 //prints list of sorted linked list
				 if(sortedList != null){
					  System.out.print("DONE -> ");
					  head.printList(sortedList);
					  System.out.print("\n");
				 }
				 //for loop to gather nodes from queue Array and add the
				 //Node back to the sort linked list until maxlength +1 is reached.
				 for(int i = 0; i< queue.length; i++){
					  Node tmp = new Node();
					  if(queue[i] != null){
							tmp = queue[i];
							queue[i] = null;
							if(sortlist == null){
								 sortlist = tmp;
							}else {
								 Node tmpHead = sortlist;
								 while (sortlist.next !=null){
									  sortlist = sortlist.next;
								 }
								 sortlist.next = tmp;
								 sortlist =tmpHead;
							}
					  }
				 }
				 //print out list of unsorted list
				 if(sortlist != null){
					  System.out.print("SORT -> ");
					  head.printList(sortlist);
					  System.out.print("\n");
				 }
				 System.out.print("\n");
			}
	 }
}
