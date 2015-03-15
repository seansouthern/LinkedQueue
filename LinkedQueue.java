
/*
 * Remember:
 * 
 * Head:-----------------------------:Tail
 * 
 * ^Data comes out of here		^Data enters here		
 * 
 * next attribute will make enqueuing easier
 * prev will make dequeuing easier
 * 
 * Initially we need Head and Tail to be linked through the prev and next attributes
 * next always points towards the head of the queue.
 * 
 */



public class LinkedQueue
{
	public Node head;
	public Node tail;
	public int capacity;


	public LinkedQueue(int inSize)
	{
		capacity = inSize;

		head = new Node();
		head.prev = tail;
		
		tail = new Node();
		tail.next = head;
	}

	public void enqueue(Object payload)
	{
		// Couple things, we need to preserve the link order
		// Still unsure if we actually need the prev attribute
		// preserve the tail, insert the payload
		// New tail points to old tail
		// Old tail keeps it's old pointer
		if(tail.next != null)
		{
			Node oldTail = tail;
			tail = new Node(payload);

			tail.next = oldTail;
			tail.next.prev = tail;
		}
		// If tail.next is null that means we are in a zero element list
		// This needs to be thought through
		else
		{
			tail = new Node(payload);
		}
		
	}

	public Object dequeue()
	{
		Node oldHead = head;
		if(head == null)System.out.println("it's null");
		
		head = head.prev;
		System.out.println(head.getData().toString());
		head.next = null;
		System.out.println(head.next.toString());
		
		return oldHead.getData();
	}

	public boolean isEmpty()
	{
		return (head == null);
	}


	public int size()
	{
		return 0;
	}


	public class Node
	{
		public Object data;
		public Node next;
		public Node prev;
		
		public Node()
		{
			next = null;
			prev = null;
			data = null;
		}
		
		public String toString()
		{
			return data.toString();
		}
		
		public Node(Object inData)
		{
			setData(inData);
		}

		public Object getData()
		{
			return data;
		}
		public void setData(Object payload)
		{
			data = payload;
		}

	}

}