package idv.carl.scjp.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Carl Lu
 */
public class FileCopyDemo {

    public static void main(String[] args) throws IOException {
        GeneralIOUtil.byteDump(new FileInputStream(args[0]), new FileOutputStream(args[1]));
    }

}
