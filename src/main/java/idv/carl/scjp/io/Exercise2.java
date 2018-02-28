package idv.carl.scjp.io;

import java.io.*;

/**
 * @author Carl Lu
 */
public class Exercise2 {

    private static final String FILE_ENCODING = "UTF-8";

    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream(args[0]);
        OutputStream outputStream = new FileOutputStream(args[1]);

        GeneralIOUtil.charDumpWithSpecifiedEncoding(inputStream, outputStream, FILE_ENCODING);
    }

}
