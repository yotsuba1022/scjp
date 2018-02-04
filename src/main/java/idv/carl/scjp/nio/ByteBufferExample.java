package idv.carl.scjp.nio;

import java.nio.ByteBuffer;
import java.nio.InvalidMarkException;

/**
 * @author Carl Lu
 */
public class ByteBufferExample {

    public static void main(String[] args) {
        ByteBufferExample demo = new ByteBufferExample();
        demo.manipulateByteBuffer();
        demo.bufferMarkDemo();
        demo.bufferRewindDemo();
        demo.bufferCompactDemo();
    }

    public void manipulateByteBuffer() {
        // Crate buffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(6);

        // Add one byte
        byteBuffer.put((byte) 9);

        // Add another three byte
        byteBuffer.put((byte) 4).put((byte) 8).put((byte) 7);

        byteBuffer.flip();

        System.out.println(byteBuffer.get());

        while (byteBuffer.hasRemaining()) {
            System.out.println(byteBuffer.get());
        }

        byteBuffer.clear();
    }

    public void bufferMarkDemo() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(6);
        byteBuffer.put((byte) 9).put((byte) 4).put((byte) 8).put((byte) 7);
        byteBuffer.flip();

        try {
            System.out.println("Invoke mark() when mark is undefined.");
            byteBuffer.reset();
        } catch (InvalidMarkException ignored) {
            System.out.println("Got InvalidMarkException when mark is undefined.");
        }

        System.out.println("Invoke get() first time: " + byteBuffer.get());

        System.out.println("Invoke mark().");
        byteBuffer.mark();
        System.out.println("Invoke get() second time: " + byteBuffer.get());

        System.out.println("Invoke get() third time: " + byteBuffer.get());
        System.out.println("Invoke get() fourth time: " + byteBuffer.get());

        System.out.println("Invoke reset().");
        byteBuffer.reset();

        System.out.println("Invoke get() after reset(): " + byteBuffer.get());
    }

    public void bufferRewindDemo() {
        byte[] input = new byte[] {9, 4, 8, 7};
        ByteBuffer byteBuffer = ByteBuffer.wrap(input);

        System.out.println("Move position to index 1.");
        byteBuffer.position(1);
        System.out.println("Show buffer content:");
        showBufferContent(byteBuffer);

        System.out.println("Invoke rewind() method.");
        byteBuffer.rewind();
        System.out.println("Show buffer content:");
        showBufferContent(byteBuffer);

        System.out.println("Invoke rewind() method.");
        byteBuffer.rewind();
        System.out.println("Show buffer content:");
        showBufferContent(byteBuffer);
    }

    public void bufferCompactDemo() {
        byte[] input = new byte[] {9, 4, 8, 7, 1, 2, 3, 4, 5, 6};
        ByteBuffer byteBuffer = ByteBuffer.wrap(input);

        System.out.print("First iteration: ");
        int firstIteration = 6;
        for (int i = 0; i < firstIteration; i++) {
            System.out.print(byteBuffer.get() + " ");
        }
        System.out.println();

        if (byteBuffer.hasRemaining()) {
            System.out.println(
                    "Buffer has remaining content: position = " + byteBuffer.position() + ", limit = " + byteBuffer.limit()
                            + ", capacity = " + byteBuffer.capacity());
            byteBuffer.compact();
            System.out.println(
                    "After compact(): position = " + byteBuffer.position() + ", limit = " + byteBuffer.limit() + ", capacity = "
                            + byteBuffer.capacity());
            byteBuffer.flip();
        } else {
            byteBuffer.clear();
        }

        while (byteBuffer.hasRemaining()) {
            System.out.print(byteBuffer.get() + " ");
        }
    }

    private void showBufferContent(ByteBuffer byteBuffer) {
        while (byteBuffer.hasRemaining()) {
            System.out.print(byteBuffer.get() + " ");
        }
        System.out.println();
    }

}
