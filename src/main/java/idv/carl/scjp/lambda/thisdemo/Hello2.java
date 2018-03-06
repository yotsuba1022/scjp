package idv.carl.scjp.lambda.thisdemo;

/**
 * @author Carl Lu
 */
public class Hello2 {

    Runnable r1 = () -> System.out.println(this);
    Runnable r2 = () -> System.out.println(toString());

    public String toString() {
        return "YOO";
    }

}
