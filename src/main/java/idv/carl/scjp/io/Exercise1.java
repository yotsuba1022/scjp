package idv.carl.scjp.io;

import java.io.*;

/**
 * @author Carl Lu
 */
public class Exercise1 {

    private final static String LOG_NAME = "src/main/java/idv/carl/scjp/io/exception.log";
    private final static int BUFFER_SIZE = 1024;

    private static void dump(InputStream inputStream, OutputStream outputStream) {
        try (InputStream src = inputStream; OutputStream dest = outputStream) {
            byte[] data = new byte[BUFFER_SIZE];
            int length;
            while (( length = src.read(data) ) != -1) {
                dest.write(data, 0, length);
                // dest.write(data, 0 + Integer.MAX_VALUE, length);
                throw new IOException("爆炸惹~ㄏㄏㄏㄏㄏ");
            }
        } catch (IOException | IndexOutOfBoundsException ioException) {
            writeErrorLog(ioException);
        }
    }

    private static void writeErrorLog(Exception exception) {
        try {
            Writer errorLog = new OutputStreamWriter(new FileOutputStream(LOG_NAME), "UTF-8");
            GeneralIOUtil.charDump(new StringReader(exception.toString()), errorLog);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        InputStream input = new FileInputStream("src/main/java/idv/carl/scjp/io/test.txt");
        OutputStream output = new FileOutputStream("src/main/java/idv/carl/scjp/io/out.txt");

        dump(input, output);
    }

}
