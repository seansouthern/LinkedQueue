
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

	// If the passed Size is zero, the queue can be of infinite length
	public LinkedQueue(int inSize)
	{
		capacity = inSize;

	}

	public void enqueue(Object payload) throws OverflowException
	{
		// Couple things, we need to preserve the link order
		// Still unsure if we actually need the prev attribute
		// preserve the tail, insert the payload
		// New tail points to old tail
		// Old tail keeps it's old pointer
		// We will not enqueue beyond the declared capacity of the queue
		// unless it is an infinite queue (a queue of 0 size is infinite here)
		if(tail != null && size() < capacity || size() == 0)
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
		else if(size() > capacity && size() != 0)
		{
			throw new OverflowException();
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
		// Walk through the queue, incrementing at every node
		int size = 1;

		// If the tail is null we know the queue is empty
		if(tail != null)
		{
			Node currentNode = tail;
			while(currentNode.next != null)
			{
				size++;
				currentNode = currentNode.next;

			}
		}
		else
		{
			System.out.println("tail is null");
			return 0;
		}
		return size;
	}


	public class UnderflowException extends Exception
	{
		public UnderflowException()
		{
			super("The queue is empty!");
		}
	}
	public class OverflowException extends Exception
	{
		public OverflowException()
		{
			super("The queue is full!");
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