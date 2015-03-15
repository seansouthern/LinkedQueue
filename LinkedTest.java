public class LinkedTest
{

	public static void main(String args[])
	{

		//Test unlimited size
		LinkedQueue testQueue = new LinkedQueue(0);

		String nodeData1 = "Test1";
		String nodeData2 = "Test2";
		String nodeData3 = "Test3";
		String nodeData4 = "Test4";


		testQueue.enqueue(nodeData1);		
		testQueue.enqueue(nodeData2);
		testQueue.enqueue(nodeData3);
		testQueue.enqueue(nodeData4);
		showQueue(testQueue);
		
		testQueue.dequeue();
		testQueue.dequeue();
		
		System.out.println();
		
		showQueue(testQueue);
	}


	public static void showQueue(LinkedQueue testQueue)
	{
		LinkedQueue.Node currentNode = testQueue.tail;

		while(currentNode != null && currentNode.data != null && currentNode.next != null)
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
				return;
			}
			currentNode = currentNode.next;
		}

	}



}