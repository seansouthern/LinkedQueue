
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


	}

	public void enqueue(Object payload)
	{
		// Couple things, we need to preserve the link order
		// Still unsure if we actually need the prev attribute
		// preserve the tail, insert the payload
		// New tail points to old tail
		// Old tail keeps it's old pointer
		if(tail != null)
		{
			// If tail.next isn't null we have a populated list that we must shift around
			if(tail.next != null)
			{
				Node oldTail = tail;
				tail = new Node(payload);

				tail.next = oldTail;
				tail.next.prev = tail;
				tail.next.next = oldTail.next;
			}

			// If tail.next is null that means we are in a zero or one element list
			// We need to create the proper structure as we insert
			if(tail.next == null)
			{
				Node oldTail = tail;
				tail = new Node(payload);

				tail.next = oldTail;
				tail.next.prev = tail;
				tail.next.next = null;

				head = tail.next;
			}
		}
		else if (tail == null)
		{
			tail = new Node(payload);
			tail.next = null;
			tail.prev = null;
			head = tail;

		}
	}


	public Object dequeue() throws UnderflowException
	{
		if(head != null)
		{
			if(head.prev != null)
			{
				Node oldHead = head;

				head = head.prev;
				head.next = null;

				return oldHead.getData();
			}
			else if(head.prev == null)
			{
				Node oldHead = head;
				head = null;
				tail = null;
				
				return oldHead.getData();
			}
		}
		else
		{
			throw new UnderflowException();
		}
		return null;
	}

	public boolean isEmpty()
	{
		return (head == null);
	}


	public int size()
	{
		return 0;
	}


	public class UnderflowException extends Exception
	{
		public UnderflowException()
		{
			super("The queue is empty!");
		}
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