package idv.carl.scjp.nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

/**
 * @author Carl Lu
 */
public class BufferDemo {

    private static CharBuffer charBuffer1;
    private static CharBuffer charBuffer2;
    private static CharBuffer charBuffer3;

    public static void main(String[] args) {
        /*
         * Init the buffer:
         *
         * You can init the buffer by allocate or wrapping.
         *
         * */
        ByteBuffer directByteBuffer = ByteBuffer.allocate(100);

        /*
         * Filling:
         *
         * Put data into the buffer.
         *
         * */
        directByteBuffer.put((byte) 10);
        directByteBuffer.put((byte) 20);
        directByteBuffer.put((byte) 30).put((byte) 40);
        directByteBuffer.put(0, (byte) 5).put((byte) 50);

        /*
         * The following line is equivalent to :
         *
         * directByteBuffer.limit(directByteBuffer.position()).position(0);
         *
         * */
        directByteBuffer.flip();

        /*
         * Draining:
         *
         * Buffers are not thread-safe. If you want to access a given buffer concurrently from multiple threads,
         * you'll need to do your own synchronization.
         *
         * */
        while (directByteBuffer.hasRemaining()) {
            System.out.print(directByteBuffer.get() + " ");
        }

        /*
         * Clear:
         *
         * It doesn't change any of the data elements of the buffer but simply sets the limit to the capacity
         * and the position back to 0. This leaves the buffer ready to be filled again.
         *
         * */
        directByteBuffer.clear();

    }

    private static void initCharBuffer() {
        /*
         * Create via allocation:
         *
         * Allocation creates a buffer object and allocates private space to hold capacity data elements.
         *
         * */
        charBuffer1 = CharBuffer.allocate(100);

        /*
         * Create via wrap:
         *
         * This implies that changes made to the buffer by invoking put() will be reflected in the array,
         * and any changes made directly to the array will be visible to the buffer object.
         *
         * */
        char[] charBackArray1 = new char[100];
        charBuffer2 = CharBuffer.wrap(charBackArray1);

        /*
         * Wrap with custom position and limit:
         *
         * The following code will create a CharBuffer with a position of 12, a limit of 54,
         * and a capacity of charBackArray2.length i.e. 100
         *
         * */
        char[] charBackArray2 = new char[100];
        charBuffer3 = CharBuffer.wrap(charBackArray2, 12, 42);
    }

}
