package idv.carl.scjp.nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

/**
 * @author Carl Lu
 */
public class BufferDemo2 {

    public static void main(String[] args) {
        /*
         * Allocate a new non-direct byte buffer with a 50 byte capacity
         * and set this to a big value to avoid BufferOverflowException
         * */
        ByteBuffer byteBuffer = ByteBuffer.allocate(50);

        // Creates a view of this byte buffer as a char buffer
        CharBuffer charBuffer = byteBuffer.asCharBuffer();

        // Write a string to char buffer
        charBuffer.put("Que pa so!");

        /*
         * Flips this buffer. The limit is set to the current position and then the position is set to zero.
         * If the mark is defined then it is discarded
         * */
        charBuffer.flip();

        System.out.println(charBuffer.toString());
    }

}
