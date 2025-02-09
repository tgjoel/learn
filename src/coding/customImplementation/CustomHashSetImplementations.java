package coding.customImplementation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CustomHashSetImplementations {
    public static void main(String[] args) {
        HashSetByList hashSetByList = new HashSetByList();
        hashSetByList.add(1);
        hashSetByList.add(2);
        hashSetByList.add(3);
        hashSetByList.add(4);
        System.out.println(hashSetByList.contains(3));
        hashSetByList.remove(2);
        System.out.println(hashSetByList.contains(2));
    }
}


class HashSetByList {

    // Time and space complexity depends on the size of the table.ie, the no. of buckets and the no. of linkedList in the bucket
    // if the list is of too big load factor comes to picture and rehashing and rearranging will be done in the hashset.
    // if we need to do something like that, then increase the array size and fetch all the elements and do the add functionality again
    final int MAX_SIZE = 10000;
    final int ARRAY_SIZE = 100;
    List<List<Integer>> bucketList; // -- will have a list of bucket and each of this bucket will be a linkedlist

    public HashSetByList() {
        bucketList = new ArrayList<>(ARRAY_SIZE); // assuming we will have max size of buckets
        for (int i = 0; i < ARRAY_SIZE ; i++) { // this is required as by default the array will be initialized with size 0
            bucketList.add(null);
        }
    }

    public void add(int key) {
        int index = key % ARRAY_SIZE; // we will get the index
        List<Integer> childList = bucketList.get(index);
        if (childList == null) { // if there was not linkedlist available at that index creating a new list and set that list at that index
            List<Integer> list = new LinkedList<>();
            list.add(key);
            bucketList.set(index, list);
        } else {
            // if there is already a linkedlist for that index then need to check if the list contains that key or not.
            // if it does not contains the key, then set the value.
            if (!childList.contains(key)) {
                childList.add(key);
            }
        }
    }

    public boolean contains(int key) {
        int index = key % ARRAY_SIZE;
        List<Integer> childList = bucketList.get(index);
        if(childList == null) {
            return false;
        }
        return childList.contains(key);
    }

    public void remove(int key) {
        int index = key % ARRAY_SIZE;
        List<Integer> childList = bucketList.get(index);
        if(childList == null) {
            return;
        }
        // need to do boxing else it will remove the element at the index of the key instead of removing the element itself
        childList.remove(Integer.valueOf(key));
    }
}



//>>>>> One way of implementing <<<<<<
class HashSetByArrays {
    // Can only implement this if the there is a range provided(10000) and can only contains positive integers
    // Not efficient as it uses more memory. But it will be very fast.
    // O(1) --> time complexity
    // O(n) --> space complexity
    boolean[] arr;
    public HashSetByArrays() {
        arr = new boolean[10001]; // max capacity is 0 to 10000, so total is 10001
    }
    public void add(int key) {
        arr[key] = true;
    }
    public boolean contains(int key) {
        return arr[key];
    }
    public void remove(int key) {
        arr[key] = false;
    }

}