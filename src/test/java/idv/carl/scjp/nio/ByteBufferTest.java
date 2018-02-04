package idv.carl.scjp.nio;

import org.junit.Test;

import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;

import static org.junit.Assert.*;

/**
 * @author Carl Lu
 */
public class ByteBufferTest {

    @Test
    public void bufferEqualsDemo() {
        byte[] input1 = new byte[] {9, 4, 8, 7, 1, 2, 3, 4, 5, 6};
        byte[] input2 = new byte[] {9, 4, 8, 7, 1, 2, 3, 10, 5, 6};
        ByteBuffer buffer1 = ByteBuffer.wrap(input1);
        ByteBuffer buffer2 = ByteBuffer.wrap(input1);
        ByteBuffer buffer3 = ByteBuffer.wrap(input2);

        assertEquals(buffer1, buffer2);
        assertNotEquals(buffer1, buffer3);
    }

    @Test
    public void bufferEqualsWithMatchedContentDemo() {
        byte[] input1 = new byte[] {9, 4, 8, 7, 1, 2, 3, 4, 5, 6};
        byte[] input2 = new byte[] {2, 3, 8, 5, 6, 12, 33, 64, 1, 2, 3, 4, 5, 6};
        ByteBuffer buffer1 = ByteBuffer.wrap(input1);
        ByteBuffer buffer2 = ByteBuffer.wrap(input2);

        for (int i = 0; i < 4; i++) {
            buffer1.get();
        }

        for (int i = 0; i < 8; i++) {
            buffer2.get();
        }
        assertEquals(buffer1, buffer2);
    }

    @Test
    public void bufferEqualsWithMismatchedContentDemo() {
        byte[] input1 = new byte[] {9, 4, 8, 7, 1, 2, 3, 4, 5, 6};
        byte[] input2 = new byte[] {2, 3, 8, 5, 6, 12, 33, 64, 1, 2, 3, 4, 7, 6};
        ByteBuffer buffer1 = ByteBuffer.wrap(input1);
        ByteBuffer buffer2 = ByteBuffer.wrap(input2);

        for (int i = 0; i < 4; i++) {
            buffer1.get();
        }

        for (int i = 0; i < 8; i++) {
            buffer2.get();
        }
        assertNotEquals(buffer1, buffer2);
    }

    @Test
    public void bufferCompareToDemo() {
        byte[] input1 = new byte[] {9, 4, 8, 7, 1, 2, 3, 4, 5, 6};
        byte[] input2 = new byte[] {9, 4, 8, 7, 1, 2, 3, 10, 5, 6};
        byte[] input3 = new byte[] {9, 4, 8, 7, -1, 2, 3, 100, 5, 6};
        byte[] input4 = new byte[] {9, 4, 8, 7};
        ByteBuffer buffer1 = ByteBuffer.wrap(input1);
        ByteBuffer buffer2 = ByteBuffer.wrap(input2);
        ByteBuffer buffer3 = ByteBuffer.wrap(input3);
        ByteBuffer buffer4 = ByteBuffer.wrap(input2);
        ByteBuffer buffer5 = ByteBuffer.wrap(input4);

        assertTrue(( buffer1.compareTo(buffer2) ) < 0);
        assertTrue(( buffer1.compareTo(buffer3) ) > 0);
        assertTrue(( buffer2.compareTo(buffer4) ) == 0);
        assertTrue(( buffer1.compareTo(buffer5) ) > 0);
    }

    @Test
    public void drainBufferToArrayNormalCaseTest() {
        byte[] dest = new byte[10];
        byte[] input = new byte[] {9, 4, 8, 7};
        ByteBuffer buffer = ByteBuffer.wrap(input);

        buffer.get(dest, 0, buffer.remaining());
        buffer.flip();

        for (int i = 0; i < input.length; i++) {
            assertEquals(dest[i], input[i]);
        }
    }

    @Test
    public void drainPartialBufferToArrayNormalCaseTest() {
        byte[] dest = new byte[10];
        byte[] input = new byte[] {9, 4, 8, 7, 1, 2, 3};
        ByteBuffer buffer = ByteBuffer.wrap(input);

        int offset = 2;
        int length = buffer.remaining() - 1;
        buffer.get(dest, offset, length);
        buffer.flip();

        for (int i = 0; i < length; i++) {
            assertEquals(dest[i + offset], input[i]);
        }
    }

    @Test(expected = BufferUnderflowException.class)
    public void drainBufferToArrayAbnormalCaseTest() {
        byte[] dest = new byte[10];
        byte[] input = new byte[] {4, 8, 7};
        ByteBuffer buffer = ByteBuffer.wrap(input);

        buffer.get(dest, 0, buffer.remaining() + 1);
        // or use the following code:
        // buffer.get(dest);
    }

    @Test
    public void copyBufferTest() {
        byte[] input = new byte[] {9, 4, 8, 7, 0, 8, 5, 7, 0, 6, 7, 8, 1, 2, 3};
        ByteBuffer from = ByteBuffer.wrap(input);
        ByteBuffer to = ByteBuffer.allocate(input.length * 2);
        to.put(from);

        from.flip();
        to.flip();

        assertTrue(from.equals(to));
    }

    @Test(expected = BufferOverflowException.class)
    public void copyBufferFailedTest() {
        byte[] input = new byte[] {9, 4, 8, 7, 0, 8, 5, 7, 0, 6, 7, 8, 1, 2, 3};
        ByteBuffer from = ByteBuffer.wrap(input);
        ByteBuffer to = ByteBuffer.allocate(input.length / 2);
        to.put(from);
    }

    @Test(expected = IllegalArgumentException.class)
    public void copyBufferFailedTest2() {
        byte[] input = new byte[] {9, 4, 8, 7, 0, 8, 5, 7, 0, 6, 7, 8, 1, 2, 3};
        ByteBuffer from = ByteBuffer.wrap(input);
        from.put(from);
    }

    @Test
    public void drainBufferToArrayMultipleTimesTest() {
        byte[] dest = new byte[5];
        byte[] input = new byte[] {9, 4, 8, 7, 0, 8, 5, 7, 0, 6, 7, 8, 1, 2, 3};
        ByteBuffer byteBuffer = ByteBuffer.wrap(input);
        drainBufferToArray(dest, byteBuffer);
    }

    private void drainBufferToArray(byte[] dest, ByteBuffer buffer) {
        while (buffer.hasRemaining()) {
            int length = Math.min(buffer.remaining(), dest.length);
            buffer.get(dest, 0, length);
            showArrayContent(dest);
        }
    }

    private void showArrayContent(byte[] targets) {
        for (byte target : targets) {
            System.out.print(target + " ");
        }
        System.out.println();
    }

    private void showBufferContent(ByteBuffer byteBuffer) {
        while (byteBuffer.hasRemaining()) {
            System.out.print(byteBuffer.get() + " ");
        }
        System.out.println();
    }

}
