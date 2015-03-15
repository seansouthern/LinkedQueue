
public class LinkedTest
{

	public static void main(String args[]) throws LinkedQueue.UnderflowException, LinkedQueue.OverflowException
	{

		//Test unlimited size
		LinkedQueue testQueue = new LinkedQueue(0);

		String nodeData1 = "Test1";
		String nodeData2 = "Test2";
		String nodeData3 = "Test3";
		String nodeData4 = "Test4";


		testQueue.enqueue(nodeData1);
		System.out.println(testQueue.size() + " is the size");
		testQueue.enqueue(nodeData2);
		System.out.println(testQueue.size() + " is the size");
		testQueue.enqueue(nodeData3);
		System.out.println(testQueue.size() + " is the size");
		testQueue.enqueue(nodeData4);
		System.out.println(testQueue.size() + " is the size");
		showQueue(testQueue);
		
		testQueue.dequeue();
		testQueue.dequeue();
		testQueue.dequeue();
		testQueue.dequeue();
		testQueue.dequeue();
		
		System.out.println();
		
		showQueue(testQueue);
		
		System.out.println(testQueue.head + " is the final head");
		System.out.println(testQueue.tail + " is the final tail");
	}


	public static void showQueue(LinkedQueue testQueue)
	{
		LinkedQueue.Node currentNode = testQueue.tail;

		while(currentNode != null)
		{
			System.out.println(currentNode.toString() + " is the currentnode payload");
			
			//handle last item in the queue
			if(currentNode.prev != null)
			{
				System.out.println(currentNode.prev.toString() + " is the currentnode prev pointer");
			}
			else
			{
				System.out.println(currentNode.toString() + " prev pointer is null");
			}
			
			//handle the first item in the queue
			if(currentNode.next != null)
			{
				System.out.println(currentNode.next.toString() + " is the currentnode next pointer");
			}
			else
			{
				System.out.println(currentNode.toString() + " next pointer is null");
			}
			currentNode = currentNode.next;
		}
		
		System.out.println("Finished printing!");
	}



}