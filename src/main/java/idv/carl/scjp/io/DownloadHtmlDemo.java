package idv.carl.scjp.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

/**
 * @author Carl Lu
 */
public class DownloadHtmlDemo {

    public static void main(String[] args) throws IOException {
        URL url = new URL(args[0]);
        InputStream src = url.openStream();
        OutputStream dest = new FileOutputStream(args[1]);
        GeneralIOUtil.byteDump(src, dest);
    }
}
