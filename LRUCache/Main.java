package LRUCache;

public class Main {
    public static void main(String args[]) {

        LRUCache instance = LRUCache.getInstance(2);

        instance.add(1, 1);
        instance.add(2,2);

        instance.printAllNodes();

        instance.add(3,3);
        instance.add(2,4);

        instance.printAllNodes();

        System.out.println(instance.get(1));
        System.out.println(instance.get(2));
    }
}
