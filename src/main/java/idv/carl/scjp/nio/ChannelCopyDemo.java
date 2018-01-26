package idv.carl.scjp.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

/**
 * @author Carl Lu
 */
public class ChannelCopyDemo {

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("/Users/Carl/Downloads/testInput.txt");
        ReadableByteChannel source = fileInputStream.getChannel();

        FileOutputStream fileOutputStream = new FileOutputStream("/Users/Carl/Downloads/testOutput.txt");
        WritableByteChannel destination = fileOutputStream.getChannel();

        copyDate(source, destination);
        source.close();
        destination.close();
    }

    private static void copyDate(ReadableByteChannel src, WritableByteChannel dest) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(16 * 1024);

        while (src.read(buffer) != -1) {
            /*
             * If you forgot to flip the buffer, the textOutput.txt will be full of "0000" byte data
             * due to the limit pointer of the buffer was still the same as the capacity pointer (1024MB).
             * */
            buffer.flip();
            while (buffer.hasRemaining()) {
                dest.write(buffer);
            }
            buffer.clear();
        }
    }

}
