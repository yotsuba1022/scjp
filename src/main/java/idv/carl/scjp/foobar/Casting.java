package idv.carl.scjp.foobar;

import idv.carl.scjp.compileerror.FooFoo;

/**
 * @author Carl Lu
 */
public class Casting {

}


class Alpha implements FooFoo {
}


class Beta extends Alpha {
}


class Delta extends Beta2 {
    public static void main(String[] args) {
        Beta2 x = new Beta2();
        // incompatibale types
        // Foo f = (Delta) x;
    }
}
