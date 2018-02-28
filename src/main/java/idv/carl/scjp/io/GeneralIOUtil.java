package idv.carl.scjp.io;

import java.io.*;

/**
 * @author Carl Lu
 */
public class GeneralIOUtil {

    private final static int BUFFER_SIZE = 1024;

    public static void byteDump(InputStream inputStream, OutputStream outputStream) throws IOException {
        try (InputStream src = inputStream; OutputStream dest = outputStream) {
            doByteDump(src, dest);
        }
    }

    public static void bufferedByteDump(InputStream inputStream, OutputStream outputStream) throws IOException {
        try (InputStream src = new BufferedInputStream(inputStream); OutputStream dest = new BufferedOutputStream(outputStream)) {
            doByteDump(src, dest);
        }
    }

    public static void charDump(Reader reader, Writer writer) throws IOException {
        try (Reader src = reader; Writer dest = writer) {
            doCharDump(src, dest);
        }
    }

    public static void charDumpWithSpecifiedEncoding(InputStream src, OutputStream dest, String charset) throws IOException {
        doCharDump(new InputStreamReader(src, charset), new OutputStreamWriter(dest, charset));
    }

    private static void doByteDump(InputStream src, OutputStream dest) throws IOException {
        byte[] data = new byte[BUFFER_SIZE];
        int length;
        while (( length = src.read(data) ) != -1) {
            dest.write(data, 0, length);
        }
    }

    private static void doCharDump(Reader src, Writer dest) throws IOException {
        char[] data = new char[BUFFER_SIZE];
        int length;
        while (( length = src.read(data) ) != -1) {
            dest.write(data, 0, length);
        }
    }

}
