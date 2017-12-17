package idv.carl.scjp.collection.set;

import idv.carl.scjp.domain.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * @author Carl Lu
 */
public class SetTest {

    private Set<Student> hashSet;
    private Set<Student> treeSet;

    private Comparator<Student> compareByName = (Student s1, Student s2) -> ( s1.getName().compareTo(s2.getName()) );
    private Comparator<Student> compareByAge = (Student s1, Student s2) -> ( s1.getAge().compareTo(s2.getAge()) );

    private Student student1 = new Student(1L, "Carl", 28);
    private Student student2 = new Student(2L, "RuRu", 18);
    private Student student3 = new Student(3L, "Miffy", 16);
    private Student student4 = new Student(4L, "Lara", 38);
    private Student student5 = new Student(5L, "BB", 8);

    @Before
    public void init() {
        hashSet = new HashSet<>();
        treeSet = new TreeSet<>();
    }

    @After
    public void clear() {
        hashSet.clear();
        treeSet.clear();
    }

    @Test
    public void testAddAndDuplicateFree() {
        assertTrue(hashSet.add(student1));
        assertTrue(hashSet.add(student2));
        assertTrue(hashSet.add(student3));
        assertTrue(hashSet.add(student4));
        assertTrue(hashSet.add(student5));
        assertFalse(hashSet.add(student1));
        assertEquals(5, hashSet.size());

        assertTrue(treeSet.add(student1));
        assertTrue(treeSet.add(student2));
        assertTrue(treeSet.add(student3));
        assertTrue(treeSet.add(student4));
        assertTrue(treeSet.add(student5));
        assertFalse(treeSet.add(student3));
        assertEquals(5, treeSet.size());
    }

    @Test
    public void testTreeSetNaturalOrdering() {
        treeSet.add(student3);
        treeSet.add(student4);
        treeSet.add(student5);
        treeSet.add(student1);
        treeSet.add(student2);

        String actualIdSequence = Arrays.toString(treeSet.stream().map(Student::getId).toArray());
        String expectedIdSequence = Arrays.toString(
                new Long[] {student1.getId(), student2.getId(), student3.getId(), student4.getId(), student5.getId()});
        assertEquals(expectedIdSequence, actualIdSequence);
    }

    @Test
    public void testTreeSetOrderByName() {
        treeSet = new TreeSet<>(compareByName);
        treeSet.add(student5);
        treeSet.add(student4);
        treeSet.add(student3);
        treeSet.add(student2);
        treeSet.add(student1);

        String actualNameSequence = Arrays.toString(treeSet.stream().map(Student::getName).toArray());
        String expectedNameSequence = Arrays.toString(
                new String[] {student5.getName(), student1.getName(), student4.getName(), student3.getName(),
                        student2.getName()});

        assertEquals(expectedNameSequence, actualNameSequence);
    }

    @Test
    public void testTreeSetOrderByAge() {
        treeSet = new TreeSet<>(compareByAge);
        treeSet.add(student5);
        treeSet.add(student3);
        treeSet.add(student4);
        treeSet.add(student2);
        treeSet.add(student1);

        String actualAgeSequence = Arrays.toString(treeSet.stream().map(Student::getAge).toArray());
        String expectedAgeSequence = Arrays.toString(
                new Integer[] {student5.getAge(), student3.getAge(), student2.getAge(), student1.getAge(), student4.getAge()});
        assertEquals(expectedAgeSequence, actualAgeSequence);
    }

    @Test
    public void testConvertHashSetToTreeSetAndVerifyByNaturalOrdering() {
        hashSet.add(student3);
        hashSet.add(student4);
        hashSet.add(student2);
        hashSet.add(student1);
        hashSet.add(student5);

        treeSet = new TreeSet<>(hashSet);

        String actualIdSequence = Arrays.toString(treeSet.stream().map(Student::getId).toArray());
        String expectedIdSequence = Arrays.toString(
                new Long[] {student1.getId(), student2.getId(), student3.getId(), student4.getId(), student5.getId()});
        assertEquals(expectedIdSequence, actualIdSequence);
    }

}
