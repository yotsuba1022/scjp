package idv.carl.scjp;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.junit.Test;

/**
 * @author Carl Lu
 */
public class ScjpTest1 {

    @Test
    public void test1() {
        String str = "420";
        str += 42;
        assertTrue(str.equals("42042"));
        assertFalse(str.equals(42042));
    }

    @Test
    public void test2() {
        int x = 5;
        boolean b1 = true;
        boolean b2 = false;
        if ((x == 4) && !b2)
            System.out.print("1 ");
        System.out.print("2 ");
        if ((b2 = true) && b1)
            System.out.print("3 ");
    }

    @Test
    public void test3() {
        String o = "";
        z: for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 2; y++) {
                if (x == 1)
                    break;
                if (x == 2 && y == 1)
                    break z;
                o = o + x + y;
            }
        }
        assertEquals(o, "000120");
    }

    @Test
    public void test4() {
        int x = 0;
        int y = 10;
        do {
            y--;
            ++x;
        } while (x < 5);
        assertEquals("5,5", x + "," + y);
    }

    @Test
    public void test5() {
        String[] elements = {"for", "tea", "too"};
        String first = (elements.length > 0) ? elements[0] : null;

        assertTrue(first.equals("for"));
    }

    @Test
    public void test6() {
        String[] colors = {"blue", "red", "green", "yellow", "orange"};
        Arrays.sort(colors);
        int s2 = Arrays.binarySearch(colors, "orange");
        int s3 = Arrays.binarySearch(colors, "violet");

        assertEquals("2-5", s2 + "" + s3);
        // Go to see the implementation.
    }

    @Test
    public void test7() {
        int[] x[] = {{1, 2}, {3, 4, 5}, {6, 7, 8, 9}};
        int[][] y = x;
        assertEquals(y[2][1], 7);
    }

    @Test
    public void test8() {
        Object obj = new int[] {1, 2, 3};
        int[] someArray = (int[]) obj;
        for (int i : someArray)
            System.out.print(i + " ");
        // 1 2 3
    }

    @Test
    public void test9() {
        String test = "Test A. Test B. Test C.";
        String regex = "\\.\\s*";
        String[] result = test.split(regex);

        assertEquals(3, result.length);
    }

    @Test
    public void test10() {
        assertTrue(Boolean.valueOf("True"));
        assertTrue(Boolean.valueOf("true"));
        assertFalse(Boolean.valueOf("False"));
        assertFalse(Boolean.valueOf("false"));
        assertFalse(Boolean.valueOf("True1"));
    }

    @Test(expected = InputMismatchException.class)
    public void test11() {
        String csv = "Sue,5,true,3";
        Scanner scanner = new Scanner(csv);
        scanner.useDelimiter(",");
        int age = scanner.nextInt();
    }

    @Test
    public void test12() {
        String test = "a1b2c3";
        String[] tokens = test.split("\\d");
        for (String s : tokens)
            System.out.print(s + " ");
    }

    @Test(expected = IllegalMonitorStateException.class)
    public void test13() throws Exception {
        Object obj = new Object();

        /*
         * The reason for IllegalMonitorStateException is (according to JDK document):
         * Thrown to indicate that a thread has attempted to wait on an object's monitor or to
         * notify other threads waiting on an object's monitor without owning the specified monitor.
         */
        synchronized (Thread.currentThread()) {
            /*
             * Solution:
             * obj.wait() and obj.notify() should be included in a synchronized(obj) {...} block
             */
            obj.wait();
            obj.notify();
        }
    }

    @Test
    public void test14() throws InterruptedException {
        Runnable r = new Runnable() {
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("interrupted");
                }
                System.out.println("ran");
            }
        };
        Thread t = new Thread(r);
        t.start();
        System.out.println("started");
        t.sleep(2000);
        System.out.println("interrupting");
        t.interrupt();
        System.out.println("ended");
    }
}
