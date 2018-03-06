package idv.carl.scjp.lambda.thisdemo;

/**
 * @author Carl Lu
 */
public class Hello {

    Runnable r1 = new Runnable() {
        @Override
        public void run() {
            System.out.println(this);
        }
    };

    Runnable r2 = new Runnable() {
        @Override
        public void run() {
            System.out.println(toString());
        }
    };

    public String toString() {
        return "YOOOOOO~~~";
    }

}
