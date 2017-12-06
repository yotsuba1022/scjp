package idv.carl.scjp.foobar;

import java.io.File;

/**
 * @author Carl Lu
 */
public class Maker {
    public static void main(String args[]) {
        File dir = new File("dir");
        File f = new File(dir, "f");
        // Nothing is added to the file system.
    }
}
