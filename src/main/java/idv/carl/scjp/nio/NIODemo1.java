package idv.carl.scjp.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Carl Lu
 */
public class NIODemo1 {

    public static void main(String[] args) throws IOException {
        RandomAccessFile randomAccessFile =
                new RandomAccessFile("/Users/Carl/work/Project/java/scjp/src/main/resources/io/test.txt", "r");
        FileChannel channel = randomAccessFile.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int byteCount;
        while (( byteCount = channel.read(buffer) ) > 0) {
            System.out.println(byteCount);
            buffer.flip();
            for (int i = 0; i < buffer.limit(); i++) {
                System.out.println((char) buffer.get());
            }
            buffer.clear();
        }
        channel.close();
        randomAccessFile.close();
    }

}
