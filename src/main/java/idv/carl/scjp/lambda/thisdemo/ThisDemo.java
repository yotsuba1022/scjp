package idv.carl.scjp.lambda.thisdemo;

import idv.carl.scjp.lambda.thisdemo.Hello;

/**
 * @author Carl Lu
 */
public class ThisDemo {

    public static void main(String[] args) {
        Hello hello = new Hello();
        hello.r1.run();
        hello.r2.run();
    }

}
