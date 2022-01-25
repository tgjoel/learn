package coding.queueproblems;

import java.util.LinkedList;
import java.util.Queue;

public class SortQueueWithoutExtraSpace {

	public static void main(String[] args) {

		Queue<Integer> q = new LinkedList<>();
		q.add(11);
		q.add(5);
		q.add(4);
		q.add(21);
		System.out.println("Before Sorting: ");
		q.forEach(elem ->  System.out.print(elem + " "));
		sortQueue(q);
		System.out.println();
		System.out.println("After Sorting: ");
		q.forEach(elem ->  System.out.print(elem + " "));

	}

	private static void sortQueue(Queue<Integer> q) {
		for (int i = 0; i < q.size(); i++) {
			int minIndex = minIndex(q, q.size() - i);
			insertMinToEnd(q, minIndex);
		}
	}

	private static void insertMinToEnd(Queue<Integer> q, int minIndex) {
		int minValue = 0;
		int qSize = q.size();
		for (int i = 0; i < qSize; i++) {
			int current = q.remove();
			if(i!=minIndex) {
				q.add(current); // adding back to the queue if its not the min value
			} else {
				minValue = current; // getting the min value and not adding it to the queue
			}
		}
		q.add(minValue);

	}

	private static int minIndex(Queue<Integer> q, int index) {

		int minIndex = Integer.MIN_VALUE;
		int minValue = Integer.MAX_VALUE;
		int qSize = q.size();
		
		for (int i = 0; i < qSize; i++) {
			int current = q.remove();
			if(current < minValue && i < index) { // to avoid checking the sorted part again
				minIndex = i;
				minValue = current;
			}
			q.add(current);
		}

		return minIndex;
	}

}
