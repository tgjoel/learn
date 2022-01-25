package coding.customImplementation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CustomHashMapImplementation {
    public static void main(String[] args) {
        CustomMapImpl customMap = new CustomMapImpl();
        customMap.put(1,1);
        customMap.put(2,2);
        customMap.put(3,3);
        customMap.put(4,4);
        System.out.println(customMap.get(2));
        customMap.remove(3);
        System.out.println(customMap.get(3));
        System.out.println(customMap.containsKey(4));
    }
}

class CustomMapImpl {
    final int ARRAY_SIZE = 100;
    List<List<CustomMap>> myMap; // forming a list of list

    public CustomMapImpl() {
        this.myMap = new ArrayList<>(ARRAY_SIZE);
        for (int i = 0; i < ARRAY_SIZE; i++) {  // this is required as by default the array will be initialized with size 0
            myMap.add(null);
        }
    }

    public void put(int key, int value) {
        int index = key % ARRAY_SIZE;
        List<CustomMap> childList = myMap.get(index);
        if(childList == null) {
            // there was no entry at that index. hence creating the linkedlist at that index and setting the value
            List<CustomMap> list = new LinkedList<>();
            list.add(new CustomMap(key, value));
            myMap.set(index, list);
        } else {
            boolean flag = true;
            for (CustomMap c: childList) {
                if(c.getK() == key) {
                    c.setV(value); // if key is same overwriting the value
                    flag = false;
                }
            }
            // if the key is not the same then need to create a new entry in the lindedlist for the same index
            if(flag) {
                childList.add(new CustomMap(key, value));
            }
        }
    }

    public int get(int key) {
        int index = key%100;
        List<CustomMap> mapList = myMap.get(index);
        if(mapList == null) {
            return -1;
        }
        CustomMap element = mapList.stream().filter(x->x.getK() == key).findAny().orElse(null);
        return element != null ? element.getV() : -1;
    }

    public void remove(int key) {
        int index = key%100;
        List<CustomMap> mapList = myMap.get(index);
        if(mapList == null) {
            return;
        }
        mapList.stream().filter(x->x.getK() == key).findAny().ifPresent(mapList::remove);
    }

    public boolean containsKey(int key){
        int index = key%100;
        List<CustomMap> mapList = myMap.get(index);
        return mapList != null && mapList.stream().anyMatch(map -> map.getK() == key);
    }
}

class CustomMap {
    private int k;
    private int v;

    public CustomMap(int k, int v) {
        this.k = k;
        this.v = v;
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }
}
