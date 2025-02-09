package coding.generalprograms;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

// https://www.geeksforgeeks.org/lru-cache-implementation/
public class LRUCache {

	public static void main(String[] args) {
	
		LRUCacheImp lru = new LRUCacheImp(3);
		
		lru.refer(1);
		lru.refer(2);
		lru.refer(3);
		lru.print();
		lru.refer(4);
		lru.print();
		lru.refer(2);
		lru.refer(3);
		lru.refer(4);
	}
}


class LRUCacheImp {
	Deque<Integer> q;
	Set<Integer> set; // this is used so O(1) checking if the element is in the cache or not. else we have to do O(n) to search
	int cacheSize;
	
	LRUCacheImp(int size) {
		q = new LinkedList<>();
		set = new HashSet<>();
		cacheSize = size;
	}
	
	public void refer(int page) {
		if(!set.contains(page)) {	// element not in the cache. checking if the cache size is exceeded. removing the last if exceeded.
			if(q.size() == cacheSize) {
				int last = q.removeLast();
				set.remove(last);
			} 
		} else {  // element is present in the cache. removing the element from there so that it can be pushed to the front of the list
			q.remove(page); // can change this to 
		}
		
		set.add(page); // adding to the set if not present
		q.addFirst(page);  // pushing the newly visited to the front of the queue
	}
	
	public void print() {
		System.out.println("LRU cache: ");
		q.forEach(lru -> System.out.print(lru + " "));
		System.out.println();
	}
}
