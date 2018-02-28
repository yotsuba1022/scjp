package idv.carl.scjp.io;

import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;

/**
 * @author Carl Lu
 */
public class CharDumpDemo {

    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader(args[0]);
        StringWriter writer = new StringWriter();
        GeneralIOUtil.charDump(reader, writer);
        System.out.println(writer.toString());
    }

}
