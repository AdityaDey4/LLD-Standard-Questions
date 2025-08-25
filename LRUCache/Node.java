package LRUCache;

public class Node {
    
    int key, value;
    Node prev, next;

    Node(int k, int v) {
        this.key = k;
        this.value = v;
        prev = null;
        next = null;
    }
}
