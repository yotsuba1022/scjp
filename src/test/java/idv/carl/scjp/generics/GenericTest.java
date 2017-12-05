package idv.carl.scjp.generics;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author Carl Lu
 */
public class GenericTest {



    /*
     * Test collections:
     *
     * ArrayList<TypeB> list1 = new ArrayList<TypeB>();
     * ArrayList<TypeB> list2 = new ArrayList();
     * ArrayList<TypeB> list3 = new ArrayList<>();
     *
     * ArrayList<Object> list4 = new ArrayList<Object>();
     * ArrayList<Object> list5 = new ArrayList();
     * ArrayList<Object> list6 = new ArrayList<>();
     *
     * ArrayList list7 = new ArrayList<TypeB>();
     * ArrayList list8 = new ArrayList<Object>();
     * ArrayList list9 = new ArrayList();
     * ArrayList list10 = new ArrayList<>();
     *
     * ArrayList<?> list11 = new ArrayList<TypeB>();
     * ArrayList<?> list12 = new ArrayList<Object>();
     * ArrayList<?> list13 = new ArrayList();
     * ArrayList<?> list14 = new ArrayList<>();
     *
     * ArrayList<? extends TypeB> list15 = new ArrayList();
     * ArrayList<? super TypeB> list16 = new ArrayList();
     *
     *  Test scenarios:
     * 1. Add TypeA object
     * 1. Add TypeB object
     * 1. Add TypeC object
     * 1. Add TypeR object
     * 1. Get TypeA object
     * 1. Get TypeB object
     * 1. Get TypeC object
     * 1. Get TypeR object
     *
     * */

    TypeA typeA = new TypeA();
    TypeB typeB = new TypeB();
    TypeC typeC = new TypeC();
    TypeR typeR = new TypeR();

    @Test
    public void testForList1() {
        ArrayList<TypeB> list1 = new ArrayList<TypeB>();

        //list1.add(typeA); 編譯錯誤: add TypeB in ArrayList can not be applied to TypeA
        ( (ArrayList) list1 ).add(typeA); // Unchecked call to add(E)
        list1.add(typeB);
        list1.add(typeC);
        //list1.add(typeR); 編譯錯誤: add TypeB in ArrayList can not be applied to TypeR
        ( (ArrayList) list1 ).add(typeR); // Unchecked call to add(E)

        TypeA typeA = list1.get(0);
        TypeB typeB = list1.get(1);
        TypeC typeC = (TypeC) list1.get(2); // 沒cast會編譯錯誤
        //TypeR typeR = (TypeR) list1.get(3); Inconvertible types, can not cast TypeB to TypeR
        TypeR typeR = (TypeR) ( (ArrayList) list1 ).get(3);
    }

    @Test
    public void testForList2() {
        ArrayList<TypeB> list2 = new ArrayList();

        // list2.add(typeA); 編譯錯誤: add TypeB in ArrayList can not be applied to TypeA
        ( (ArrayList) list2 ).add(typeA);
        list2.add(typeB);
        list2.add(typeC);
        // list2.add(typeR); add TypeB in ArrayList can not be applied to TypeR
        ( (ArrayList) list2 ).add(typeR);

        TypeA typeA = list2.get(0);
        TypeB typeB = list2.get(1);
        TypeC typeC = (TypeC) list2.get(2); // 沒cast會編譯錯誤
        // TypeR typeR = (TypeR) list2.get(3); Inconvertible types, can not cast TypeB to TypeR
        TypeR typeR = (TypeR) ( (ArrayList) list2 ).get(3);
    }

    @Test
    public void testForList3() {
        ArrayList<TypeB> list3 = new ArrayList<>();

        // list3.add(typeA); 編譯錯誤: add TypeB in ArrayList can not be applied to TypeA
        ( (ArrayList) list3 ).add(typeA);
        list3.add(typeB);
        list3.add(typeC);
        // list3.add(typeR); add TypeB in ArrayList can not be applied to TypeR
        ( (ArrayList) list3 ).add(typeR);

        TypeA typeA = list3.get(0);
        TypeB typeB = list3.get(1);
        TypeC typeC = (TypeC) list3.get(2); // 沒cast會編譯錯誤
        // TypeR typeR = (TypeR) list3.get(3); Inconvertible types, can not cast TypeB to TypeR
        TypeR typeR = (TypeR) ( (ArrayList) list3 ).get(3);
    }

    @Test
    public void testForList4() {
        ArrayList<Object> list4 = new ArrayList<Object>();

        list4.add(typeA);
        list4.add(typeB);
        list4.add(typeC);
        list4.add(typeR);

        TypeA typeA = (TypeA) list4.get(0);
        TypeB typeB = (TypeB) list4.get(1);
        TypeC typeC = (TypeC) list4.get(2);
        TypeR typeR = (TypeR) list4.get(3);
    }

    @Test
    public void testForList5() {
        ArrayList<Object> list5 = new ArrayList();

        list5.add(typeA);
        list5.add(typeB);
        list5.add(typeC);
        list5.add(typeR);

        TypeA typeA = (TypeA) list5.get(0);
        TypeB typeB = (TypeB) list5.get(1);
        TypeC typeC = (TypeC) list5.get(2);
        TypeR typeR = (TypeR) list5.get(3);
    }

    @Test
    public void testForList6() {
        ArrayList<Object> list6 = new ArrayList<>();

        list6.add(typeA);
        list6.add(typeB);
        list6.add(typeC);
        list6.add(typeR);

        TypeA typeA = (TypeA) list6.get(0);
        TypeB typeB = (TypeB) list6.get(1);
        TypeC typeC = (TypeC) list6.get(2);
        TypeR typeR = (TypeR) list6.get(3);
    }

    @Test
    public void testForList7() {
        ArrayList list7 = new ArrayList<TypeB>();

        list7.add(typeA);
        list7.add(typeB);
        list7.add(typeC);
        list7.add(typeR);

        TypeA typeA = (TypeA) list7.get(0);
        TypeB typeB = (TypeB) list7.get(1);
        TypeC typeC = (TypeC) list7.get(2);
        TypeR typeR = (TypeR) list7.get(3);
    }

    @Test
    public void testForList8() {
        ArrayList list8 = new ArrayList<Object>();

        list8.add(typeA);
        list8.add(typeB);
        list8.add(typeC);
        list8.add(typeR);

        TypeA typeA = (TypeA) list8.get(0);
        TypeB typeB = (TypeB) list8.get(1);
        TypeC typeC = (TypeC) list8.get(2);
        TypeR typeR = (TypeR) list8.get(3);
    }

    @Test
    public void testForList9() {
        ArrayList list9 = new ArrayList();

        list9.add(typeA);
        list9.add(typeB);
        list9.add(typeC);
        list9.add(typeR);

        TypeA typeA = (TypeA) list9.get(0);
        TypeB typeB = (TypeB) list9.get(1);
        TypeC typeC = (TypeC) list9.get(2);
        TypeR typeR = (TypeR) list9.get(3);
    }

    @Test
    public void testForList10() {
        ArrayList list10 = new ArrayList<>();

        list10.add(typeA);
        list10.add(typeB);
        list10.add(typeC);
        list10.add(typeR);

        TypeA typeA = (TypeA) list10.get(0);
        TypeB typeB = (TypeB) list10.get(1);
        TypeC typeC = (TypeC) list10.get(2);
        TypeR typeR = (TypeR) list10.get(3);
    }

    // list11~14 are the same
    @Test
    public void testForList11() {
        /*
         * "?" here equeals to "? extends Object", means it should be Object or any sub class of Object.
         * */
        ArrayList<?> list11 = new ArrayList<TypeB>();

        // list11.add(typeA); add capture<?> in ArrayList can not be applied to TypeA
        ( (ArrayList) list11 ).add(typeA);
        // list11.add(typeB); add capture<?> in ArrayList can not be applied to TypeB
        ( (ArrayList) list11 ).add(typeB);
        // list11.add(typeC); add capture<?> in ArrayList can not be applied to TypeC
        ( (ArrayList) list11 ).add(typeC);
        // list11.add(typeR); add capture<?> in ArrayList can not be applied to TypeR
        ( (ArrayList) list11 ).add(typeR);

        TypeA typeA = (TypeA) list11.get(0);
        TypeB typeB = (TypeB) list11.get(1);
        TypeC typeC = (TypeC) list11.get(2);
        TypeR typeR = (TypeR) list11.get(3);

        Object obj = new Object();
        // list11.add(obj); add capture<?> in ArrayList can not be applied to Object
        /*
         * It means that "?" doesn't mean java.lang.Object.
         * We can see ? as "unknown", we don't know what type of object will be passed in
         * so that we can't guarantee the type of passed-in object.
         *
         * */

        obj = list11.get(0);
        /*
         * However, for return situation, it's very different.
         * The unknown object must be a type of java.lang.Object,
         * so we can use a Object type variable to store the return value.
         *
         * */

        // How about pass a "?" type obj?
        // list11.add(list11.get(0)); add capture<?> in ArrayList can not be applied to capture<?>
        /*
         * Even the "?" type element get from itself can not be the input to add back to itself.
         * */
    }

    @Test
    public void testForList12() {
        ArrayList<?> list12 = new ArrayList<Object>();

        // list11.add(typeA); add capture<?> in ArrayList can not be applied to TypeA
        ( (ArrayList) list12 ).add(typeA);
        // list11.add(typeB); add capture<?> in ArrayList can not be applied to TypeB
        ( (ArrayList) list12 ).add(typeB);
        // list11.add(typeC); add capture<?> in ArrayList can not be applied to TypeC
        ( (ArrayList) list12 ).add(typeC);
        // list11.add(typeR); add capture<?> in ArrayList can not be applied to TypeR
        ( (ArrayList) list12 ).add(typeR);

        TypeA typeA = (TypeA) list12.get(0);
        TypeB typeB = (TypeB) list12.get(1);
        TypeC typeC = (TypeC) list12.get(2);
        TypeR typeR = (TypeR) list12.get(3);
    }

    @Test
    public void testForList13() {
        ArrayList<?> list13 = new ArrayList();

        // list11.add(typeA); add capture<?> in ArrayList can not be applied to TypeA
        ( (ArrayList) list13 ).add(typeA);
        // list11.add(typeB); add capture<?> in ArrayList can not be applied to TypeB
        ( (ArrayList) list13 ).add(typeB);
        // list11.add(typeC); add capture<?> in ArrayList can not be applied to TypeC
        ( (ArrayList) list13 ).add(typeC);
        // list11.add(typeR); add capture<?> in ArrayList can not be applied to TypeR
        ( (ArrayList) list13 ).add(typeR);

        TypeA typeA = (TypeA) list13.get(0);
        TypeB typeB = (TypeB) list13.get(1);
        TypeC typeC = (TypeC) list13.get(2);
        TypeR typeR = (TypeR) list13.get(3);
    }

    @Test
    public void testForList14() {
        ArrayList<?> list14 = new ArrayList<>();

        // list11.add(typeA); add capture<?> in ArrayList can not be applied to TypeA
        ( (ArrayList) list14 ).add(typeA);
        // list11.add(typeB); add capture<?> in ArrayList can not be applied to TypeB
        ( (ArrayList) list14 ).add(typeB);
        // list11.add(typeC); add capture<?> in ArrayList can not be applied to TypeC
        ( (ArrayList) list14 ).add(typeC);
        // list11.add(typeR); add capture<?> in ArrayList can not be applied to TypeR
        ( (ArrayList) list14 ).add(typeR);

        TypeA typeA = (TypeA) list14.get(0);
        TypeB typeB = (TypeB) list14.get(1);
        TypeC typeC = (TypeC) list14.get(2);
        TypeR typeR = (TypeR) list14.get(3);
    }

    @Test
    public void testForList15() {
        /*
         * "? extends TypeB" means it should be TypeB or any subclass of TypeB.
         * */
        ArrayList<? extends TypeB> list15 = new ArrayList();

        // list15.add(typeA); add capture<? extends TypeB> in ArrayList can not be applied to TypeA
        ( (ArrayList) list15 ).add(typeA);
        // list15.add(typeB); add capture<? extends TypeB> in ArrayList can not be applied to TypeB
        ( (ArrayList) list15 ).add(typeB);
        // list15.add(typeC); add capture<? extends TypeB> in ArrayList can not be applied to TypeC
        ( (ArrayList) list15 ).add(typeC);
        // list15.add(typeR); add capture<? extends TypeB> in ArrayList can not be applied to TypeR
        ( (ArrayList) list15 ).add(typeR);

        /*
         * list15 guarantee that it only contains the instance of TypeB or the instance of TypeB's subclass,
         * so the return type must be TypeB, but it can not guarantee the input type.
         * */
        TypeA typeA = list15.get(0);
        TypeB typeB = list15.get(1);
        TypeC typeC = (TypeC) list15.get(2);
        TypeR typeR = (TypeR) ( (ArrayList) list15 ).get(3);
    }

    @Test
    public void testForList16() {
        /*
         * "? super TypeB" means is should be TypeB or any super class of TypeB.
         * */
        ArrayList<? super TypeB> list16 = new ArrayList();

        // list16.add(typeA); add capture<? extends TypeB> in ArrayList can not be applied to TypeA
        ( (ArrayList) list16 ).add(typeA);
        list16.add(typeB);
        list16.add(typeC);
        // list16.add(typeR); add capture<? extends TypeB> in ArrayList can not be applied to TypeR
        ( (ArrayList) list16 ).add(typeR);

        /*
         * The reason we can get all types of object is because java.lang.Object
         * is the super class of all types of class we defined, so the return type
         * of list16.get() can be see as Object type.
         * */
        TypeA typeA = (TypeA) list16.get(0);
        TypeB typeB = (TypeB) list16.get(1);
        TypeC typeC = (TypeC) list16.get(2);
        TypeR typeR = (TypeR) list16.get(3);
    }

}
