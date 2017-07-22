package idv.carl.scjp;

/**
 * @author Carl Lu
 */
public class PingPong implements Runnable {
    public static void main(String[] args) {
        new Thread(new PingPong()).start();
        new Thread(new PingPong()).start();
    }

    synchronized void hit(long n) {
        for (int i = 1; i < 3; i++)
            System.out.print(n + "-" + i + " ");
    }

    public void run() {
        hit(Thread.currentThread().getId());
    }
}
