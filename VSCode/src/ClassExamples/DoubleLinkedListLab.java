/**
 * 
 */

/**
 * 
 */
public class DoubleLinkedListLab
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		DoublyLinkedListL18 list = new DoublyLinkedListL18();

		// System.out.println("Inserting at the End:");
		list.insertAtEnd(10);
		list.insertAtEnd(20);
		list.insertAtEnd(30);
		// list.printForward();
		// list.printBackward();

		// System.out.println("\nInserting at the Head:");
		list.insertAtHead(5);
		list.insertAtHead(1);
		// list.printForward();
		// list.printBackward();

		list.deleteNode(11);
		list.printForward();
		// list.printBackward();

		// System.out.println("\nReversing the List:");
		// list.reverseList();
		// list.printForward();
		// list.printBackward();
	}

}

class NodeL18
{
	int data;
	NodeL18 next;
	NodeL18 prev;

	public NodeL18(int data)
	{
		this.data = data;
		this.next = null;
		this.prev = null;
	}
}

class DoublyLinkedListL18
{
	NodeL18 head;
    NodeL18 tail;

	// Insert at the end (already implemented)
	public void insertAtEnd(int data)
	{
		NodeL18 newNode = new NodeL18(data);
		if (head == null)
		{
			head = newNode;
            tail = newNode;
		} else
		{
			NodeL18 temp = head;
			while (temp.next != null)
			{
				temp = temp.next;
			}
			temp.next = newNode;
            tail = newNode;
			newNode.prev = temp; // Backward link
		}
	}
	
	// Print the list forward
	public void printForward()
	{
		NodeL18 current = head;
		System.out.print("Forward: ");
		while (current != null)
		{
			System.out.print(current.data + " ⇄ ");
			current = current.next;
		}
		System.out.println("null");
	}

	// Students must complete this method
	public void insertAtHead(int data)
	{
        NodeL18 newNode = new NodeL18(data);
        if (head == null){
            head = newNode;
        } else {
            NodeL18 temp = head;
            while (temp.prev != null){
                temp = temp.prev;
            }
            head = newNode;
            newNode.next = temp;
        }
	}

	// Students must complete this method
	public void deleteNode(int data)
	{
		System.out.println("\nDeleting Node " + data + ": ");
		NodeL18 current = head;
		NodeL18 previous = null;
        if (head == null){
            return;
        } else {
            if (head.data == data) {
				head = current.next;
				head.prev = null;
                } else {
				while (current.data != data){
					previous = current;
					if (current.next != null){
					current = current.next;
					} else {
						System.out.println(data + " does not occur in the linked list.");
						return;
					}
				}
				if (current.next != null){
					previous.next = current.next;
					current.next.prev = previous;
				} else {
					previous.next = null;
					tail = previous;
				}
			}
		}
		// Implement this
		// System.out.println("Implement delete node:");
	}

	// Students must complete this method
	public void reverseList()
	{
		// Implement this
		System.out.println("Implement reverse list:");
	}
	
	// Print the list backward
	public void printBackward()
	{
        NodeL18 current = tail;
        System.out.print("Backward: ");
        while (current != null){
            System.out.print(current.data + " ⇄ ");
            current = current.prev;
        }
		System.out.println("null");
	}
}