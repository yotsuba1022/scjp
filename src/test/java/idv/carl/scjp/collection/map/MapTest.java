package idv.carl.scjp.collection.map;

import idv.carl.scjp.domain.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author Carl Lu
 */
public class MapTest {

    private Map<Long, Student> hashMap;
    private Map<Long, Student> treeMapWithLongKey;
    private Map<String, Student> treeMapWithStrKey;
    private Map<Integer, Student> treeMapWithIntegerKey;

    private Comparator<Long> compareByIdDesc = (Long id1, Long id2) -> ( -id1.compareTo(id2) );
    private Comparator<String> compareByNameDesc = (String name1, String name2) -> ( -name1.compareTo(name2) );
    private Comparator<Integer> compareByAgeDesc = (Integer age1, Integer age2) -> ( -age1.compareTo(age2) );

    private Student student1 = new Student(1L, "Carl", 28);
    private Student student2 = new Student(2L, "RuRu", 18);
    private Student student3 = new Student(3L, "Miffy", 16);
    private Student student4 = new Student(4L, "Lara", 38);
    private Student student5 = new Student(5L, "BB", 8);
    private Student student6 = new Student(6L, "Gru", 12);
    private Student updatedStudent1 = new Student(1L, "Carl", 30);

    @Before
    public void init() {
        hashMap = new HashMap<>();
        treeMapWithLongKey = new TreeMap<>();
        treeMapWithStrKey = new TreeMap<>();
        treeMapWithIntegerKey = new TreeMap<>();
    }

    @After
    public void clear() {
        hashMap.clear();
        treeMapWithLongKey.clear();
        treeMapWithStrKey.clear();
        treeMapWithIntegerKey.clear();
    }

    @Test
    public void testPutWithHashMap() {
        hashMap.put(student1.getId(), student1);
        hashMap.put(student2.getId(), student2);
        hashMap.put(student3.getId(), student3);
        hashMap.put(student4.getId(), student4);
        hashMap.put(student5.getId(), student5);
        hashMap.put(student6.getId(), null);

        assertEquals(6, hashMap.size());
        assertEquals(student1, hashMap.get(student1.getId()));
        assertNull(hashMap.get(student6.getId()));

        assertEquals(student1, hashMap.put(updatedStudent1.getId(), updatedStudent1));
        assertNull(hashMap.put(student6.getId(), student6));
        assertEquals(updatedStudent1, hashMap.get(updatedStudent1.getId()));
        assertEquals(student6, hashMap.get(student6.getId()));
    }

    @Test
    public void testPutWithTreeMap() {
        treeMapWithLongKey.put(student1.getId(), student1);
        treeMapWithLongKey.put(student2.getId(), student2);
        treeMapWithLongKey.put(student3.getId(), student3);
        treeMapWithLongKey.put(student4.getId(), student4);
        treeMapWithLongKey.put(student5.getId(), student5);
        treeMapWithLongKey.put(student6.getId(), null);

        assertEquals(6, treeMapWithLongKey.size());
        assertEquals(student1, treeMapWithLongKey.get(student1.getId()));
        assertNull(treeMapWithLongKey.get(student6.getId()));

        assertEquals(student1, treeMapWithLongKey.put(updatedStudent1.getId(), updatedStudent1));
        assertNull(treeMapWithLongKey.put(student6.getId(), student6));
        assertEquals(updatedStudent1, treeMapWithLongKey.get(updatedStudent1.getId()));
        assertEquals(student6, treeMapWithLongKey.get(student6.getId()));
    }

    @Test
    public void testTreeMapWithNaturalIdOrdering() {
        treeMapWithLongKey.put(student2.getId(), student2);
        treeMapWithLongKey.put(student1.getId(), student1);
        treeMapWithLongKey.put(student5.getId(), student5);
        treeMapWithLongKey.put(student4.getId(), student4);
        treeMapWithLongKey.put(student3.getId(), student3);

        String actualKeyOrdering = Arrays.toString(new ArrayList<>(treeMapWithLongKey.keySet()).toArray());
        String expectedKeyOrdering = Arrays.toString(
                new Long[] {student1.getId(), student2.getId(), student3.getId(), student4.getId(), student5.getId()});

        assertEquals(expectedKeyOrdering, actualKeyOrdering);
    }

    @Test
    public void testTreeMapWithIdOrderingDesc() {
        treeMapWithLongKey = new TreeMap<>(compareByIdDesc);
        treeMapWithLongKey.put(student2.getId(), student2);
        treeMapWithLongKey.put(student1.getId(), student1);
        treeMapWithLongKey.put(student5.getId(), student5);
        treeMapWithLongKey.put(student4.getId(), student4);
        treeMapWithLongKey.put(student3.getId(), student3);

        String actualKeyOrdering = Arrays.toString(new ArrayList<>(treeMapWithLongKey.keySet()).toArray());
        String expectedKeyOrdering = Arrays.toString(
                new Long[] {student5.getId(), student4.getId(), student3.getId(), student2.getId(), student1.getId()});

        assertEquals(expectedKeyOrdering, actualKeyOrdering);
    }

    @Test
    public void testTreeMapWithNaturalNameOrdering() {
        treeMapWithStrKey.put(student2.getName(), student2);
        treeMapWithStrKey.put(student1.getName(), student1);
        treeMapWithStrKey.put(student5.getName(), student5);
        treeMapWithStrKey.put(student4.getName(), student4);
        treeMapWithStrKey.put(student6.getName(), student6);
        treeMapWithStrKey.put(student3.getName(), student3);

        String actualKeyOrdering = Arrays.toString(new ArrayList<>(treeMapWithStrKey.keySet()).toArray());
        String expectedKeyOrdering = Arrays.toString(
                new String[] {student5.getName(), student1.getName(), student6.getName(), student4.getName(), student3.getName(),
                        student2.getName()});

        assertEquals(expectedKeyOrdering, actualKeyOrdering);
    }

    @Test
    public void testTreeMapWithNameOrderingDesc() {
        treeMapWithStrKey = new TreeMap<>(compareByNameDesc);
        treeMapWithStrKey.put(student2.getName(), student2);
        treeMapWithStrKey.put(student1.getName(), student1);
        treeMapWithStrKey.put(student5.getName(), student5);
        treeMapWithStrKey.put(student4.getName(), student4);
        treeMapWithStrKey.put(student6.getName(), student6);
        treeMapWithStrKey.put(student3.getName(), student3);

        String actualKeyOrdering = Arrays.toString(new ArrayList<>(treeMapWithStrKey.keySet()).toArray());
        String expectedKeyOrdering = Arrays.toString(
                new String[] {student2.getName(), student3.getName(), student4.getName(), student6.getName(), student1.getName(),
                        student5.getName(),});

        assertEquals(expectedKeyOrdering, actualKeyOrdering);
    }

    @Test
    public void testTreeMapWithNaturalAgeOrdering() {
        treeMapWithIntegerKey.put(student2.getAge(), student2);
        treeMapWithIntegerKey.put(student1.getAge(), student1);
        treeMapWithIntegerKey.put(student5.getAge(), student5);
        treeMapWithIntegerKey.put(student4.getAge(), student4);
        treeMapWithIntegerKey.put(student6.getAge(), student6);
        treeMapWithIntegerKey.put(student3.getAge(), student3);

        String actualKeyOrdering = Arrays.toString(new ArrayList<>(treeMapWithIntegerKey.keySet()).toArray());
        String expectedKeyOrdering = Arrays.toString(
                new Integer[] {student5.getAge(), student6.getAge(), student3.getAge(), student2.getAge(), student1.getAge(),
                        student4.getAge()});

        assertEquals(expectedKeyOrdering, actualKeyOrdering);
    }

    @Test
    public void testTreeMapWithAgeOrderingDesc() {
        treeMapWithIntegerKey = new TreeMap<>(compareByAgeDesc);
        treeMapWithIntegerKey.put(student2.getAge(), student2);
        treeMapWithIntegerKey.put(student1.getAge(), student1);
        treeMapWithIntegerKey.put(student5.getAge(), student5);
        treeMapWithIntegerKey.put(student4.getAge(), student4);
        treeMapWithIntegerKey.put(student6.getAge(), student6);
        treeMapWithIntegerKey.put(student3.getAge(), student3);

        String actualKeyOrdering = Arrays.toString(new ArrayList<>(treeMapWithIntegerKey.keySet()).toArray());
        String expectedKeyOrdering = Arrays.toString(
                new Integer[] {student4.getAge(), student1.getAge(), student2.getAge(), student3.getAge(), student6.getAge(),
                        student5.getAge(),});

        assertEquals(expectedKeyOrdering, actualKeyOrdering);
    }

    @Test
    public void testConvertHashMapToTreeMapAndVerifyByNaturalOrdering() {
        hashMap.put(student3.getId(), student3);
        hashMap.put(student1.getId(), student1);
        hashMap.put(student5.getId(), student5);
        hashMap.put(student4.getId(), student4);
        hashMap.put(student2.getId(), student2);

        treeMapWithLongKey.putAll(hashMap);

        String actualKeyOrdering = Arrays.toString(new ArrayList<>(treeMapWithLongKey.keySet()).toArray());
        String expectedKeyOrdering = Arrays.toString(
                new Long[] {student1.getId(), student2.getId(), student3.getId(), student4.getId(), student5.getId()});

        assertEquals(expectedKeyOrdering, actualKeyOrdering);
    }

}
