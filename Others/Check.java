package Others;
import java.util.*;

class Node {
    String name;
    int value;

     Node(String n, int v) {
        this.name = n;
        this.value = v;
    }
}
public class Check {
    public static void main(String[] args) {
        // TreeSet<Integer> set = new TreeSet<>();
        // set.add(5);
        // set.add(3);
        // set.add(7);

        // System.out.println(set);

        // System.out.println(set.ceiling(8));
        // System.out.println(set.floor(6));

        // Node node1 = new Node("A", 1);
        // Node node2 = new Node("A", 1);
        // Node node3 = node2;

        // System.out.println(node1 == node2);
        // System.out.println(node3 == node2);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(3);
        pq.add(2);
        pq.add(1);
        pq.add(2);
        
        pq.remove(2);
        System.out.println(pq);

        // List<Integer> al = new ArrayList<>();
        // al.add(1);
        // al.add(2);

        // System.out.println(al.indexOf(10));

        // Thread t;

        // t = new Thread(()-> {
        //     System.out.println("1 : "+Thread.currentThread().getName());
        // });
        // t.start();

        // t.interrupt();

        // t = new Thread(()-> {
        //     System.out.println("2 : "+Thread.currentThread().getName());
        // });
        // t.start();


        System.err.println(-3%5);
        String arr[] = {"dddc", "a", "ad", "ab", "b", "be", "cd", "cded"};
        System.out.println(findOrder(arr));
    }

    public static String findOrder(String[] words) {
        // code here
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[26];
        boolean[] exists = new boolean[26];

        // Initialize graph
        for (int i = 0; i < 26; i++) {
            graph.add(new ArrayList<>());
        }

        // Mark characters that exist in the input
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                exists[ch - 'a'] = true;
            }
        }

        // Build the graph based on adjacent word comparisons
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            int len = Math.min(w1.length(), w2.length());
            int j = 0;

            while (j < len && w1.charAt(j) == w2.charAt(j)) {
                j++;
            }

            if (j < len) {
                int u = w1.charAt(j) - 'a';
                int v = w2.charAt(j) - 'a';
                graph.get(u).add(v);
                inDegree[v]++;
            } else if (w1.length() > w2.length()) {
                
                // Invalid input
                return "";
            }
        }

        // Topological Sort
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            if (exists[i] && inDegree[i] == 0) {
                q.offer(i);
            }
        }

        StringBuilder result = new StringBuilder();

        while (!q.isEmpty()) {
            int u = q.poll();
            result.append((char) (u + 'a'));

            for (int v : graph.get(u)) {
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    q.offer(v);
                }
            }
        }

        // Check for cycle
        for (int i = 0; i < 26; i++) {
            if (exists[i] && inDegree[i] != 0) {
                return "";
            }
        }

        return result.toString();
    }
}
