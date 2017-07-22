package idv.carl.scjp.compileerror;

/**
 * @author Carl Lu
 */
public class SubC {
    public static void main(String[] args) {
        // try {
        // new Aa.B().process();
        // } catch (IOException e) {
        // System.out.println("Exception");
        // }
    }
}


class Aa {
    public void process() {
        System.out.print("A, ");
    }

    class B extends Aa {

        // Overridden method does not throw IOException
        // public void process() throws IOException {
        // super.process();
        // System.out.print("B, ");
        // throw new IOException();
        //
        // }
    }
}
