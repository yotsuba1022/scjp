package idv.carl.scjp;

import java.util.PriorityQueue;

/**
 * @author Carl Lu
 */
public class GetInLine {
    public static void main(String[] args) {
        PriorityQueue<String> pq = new PriorityQueue<String>();
        pq.add("banana");
        pq.add("pear");
        pq.add("apple");
        System.out.println(pq.poll() + " " + pq.peek());
    }
}
