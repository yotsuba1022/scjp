package idv.carl.scjp.foobar;

/**
 * @author Carl Lu
 */
class Atom {
    Atom() {
        System.out.print("atom ");
    }
}


class Rock extends Atom {
    Rock(String type) {
        System.out.print(type);
    }
}


class Mountain extends Rock {
    Mountain() {
        super("granite ");
        new Rock("granite ");
    }

    public static void main(String[] a) {
        new Mountain();
        // Will print: atom granite atom granite
    }
}
