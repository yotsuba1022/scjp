package idv.carl.scjp.nio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Carl Lu
 * <p>
 * A MemoryMappedBuffer has a fixed size, but the file it's mapped to is elastic.
 * Specifically, if a file's size changes while the mapping is in effect,
 * some or all of the buffer may become inaccessible, undefined data could be returned,
 * or unchecked exceptions could be thrown. Be careful about how files are manipulated
 * by other threads or external processes when they are memory-mapped.
 */
public class MemoryMappedDemo {

    public static void main(String[] args) throws IOException {
        String fileName = "/Users/Carl/Downloads/testInput.txt";
        File file = new File(fileName);
        write(file);
        read(file);
    }

    private static void write(File file) throws IOException {
        file.delete();
        FileChannel fileChannel = new RandomAccessFile(file.getName(), "rw").getChannel();
        MappedByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, 4096 * 8 * 8);
        /*
         * The user process sees the file data as memory, so there is no need to issue read() or write() system calls.
         * */
        buffer.put("Que pa so!".getBytes());
    }

    private static void read(File file) throws IOException {
        FileChannel fileChannel = new RandomAccessFile(file.getName(), "r").getChannel();
        MappedByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());
        System.out.println("Buffer loaded: " + buffer.isLoaded());
        System.out.println("Buffer capacity: " + buffer.capacity());
        while (buffer.hasRemaining()) {
            char output = (char) buffer.get();
            if (output != 0) {
                System.out.println(output);
            }
        }
    }

}
