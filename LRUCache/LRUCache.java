package LRUCache;

import java.util.*;

public class LRUCache {
    
    DoubleLinkedList dll;
    int capacity;
    Map<Integer, Node> map;
    private static LRUCache instance;

    private LRUCache(int capacity) {
        this.capacity = capacity;
        dll = new DoubleLinkedList();
        map = new HashMap<>();
    }

    public static synchronized LRUCache getInstance(int k) {

        if(instance == null) {
            instance = new LRUCache(k);
        }

        return instance;
    }

    public void add(int key, int value) {

        if(capacity == 0) {
            Node lastNode = dll.getEnd();
            dll.remove(lastNode);
            map.remove(lastNode.key);
            capacity++;
        }
        else if(map.containsKey(key)) {
            Node existNode = map.get(key);
            dll.remove(existNode);
            map.remove(existNode.key);
            capacity++;
        }

        Node newNode = new Node(key, value);
        dll.add(newNode);
        map.put(key, newNode);
        capacity--;

    }

    public int get(int key) {

        if(map.containsKey(key) == false) return -1;

        Node existNode = map.get(key);
        dll.remove(existNode);
        map.remove(existNode.key);

        dll.add(existNode);
        map.put(key, existNode);

        return existNode.value;
    }

    public void printAllNodes() {

        Node start = dll.start.next;
        while(start != dll.end) {
            System.out.println("Key : "+start.key+" Value : "+start.value);
            start = start.next;
        }
    }
}
