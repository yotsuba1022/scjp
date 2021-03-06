package idv.carl.scjp.generics;

import com.alibaba.fastjson.JSON;
import idv.carl.scjp.generics.basics.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Carl Lu
 */
public class GenericTest {

    @Test
    public void testNonGenericObjectCoordinatePoint() {
        int expectedIntX = 100;
        double expectedDoubleX = 100.2d;

        ObjectCoordinatePoint intPoint = new ObjectCoordinatePoint();
        intPoint.setX(expectedIntX); // Java will do auto-boxing here so I just use primitive type.
        assertEquals(expectedIntX, intPoint.getX());

        ObjectCoordinatePoint doublePoint = new ObjectCoordinatePoint();
        doublePoint.setX(expectedDoubleX);
        assertEquals(expectedDoubleX, doublePoint.getX());
    }

    @Test(expected = ClassCastException.class)
    public void testClassCastExceptionAtRuntimeByObjectCoordinatePoint() {
        double expectedX = 101.3d;

        ObjectCoordinatePoint doublePoint = new ObjectCoordinatePoint();
        doublePoint.setX(expectedX);
        String doubleX = (String) doublePoint.getX();
        assertEquals(String.valueOf(expectedX), doubleX);
    }

    @Test
    public void testGenericCoordinatePoint() {
        int expectedIntX = 987;
        double expectedDoubleX = 948.7d;

        GenericCoordinatePoint<Integer> integerPoint = new GenericCoordinatePoint<>();
        integerPoint.setX(expectedIntX);
        assertEquals(Integer.valueOf(expectedIntX), integerPoint.getX());

        // integerPoint.setX(100d); Integer cannot be applied to double

        GenericCoordinatePoint<Double> doublePoint = new GenericCoordinatePoint<>();
        doublePoint.setX(expectedDoubleX);
        assertEquals(Double.valueOf(expectedDoubleX), doublePoint.getX());
    }

    @Test
    public void testMultiGenericCoordinatePoint() {
        int expectedX = 987;
        int expectedY = 978;

        MultiGenericCoordinatePoint<Integer, String> multiGenericCoordinatePoint = new MultiGenericCoordinatePoint<>();
        String expectedPointName = "Critical Point";
        multiGenericCoordinatePoint.setX(expectedX);
        multiGenericCoordinatePoint.setY(expectedY);
        multiGenericCoordinatePoint.setPointName(expectedPointName);

        assertEquals(Integer.valueOf(expectedX), multiGenericCoordinatePoint.getX());
        assertEquals(Integer.valueOf(expectedY), multiGenericCoordinatePoint.getY());
        assertEquals(expectedPointName, multiGenericCoordinatePoint.getPointName());
    }

    @Test
    public void testNonGenericInformation() {
        String expected = "9487 la";

        NonGenericInformation nonGenericInformation = new NonGenericInformation(expected);
        assertEquals(expected, nonGenericInformation.getInfo());
        /*
         * However, class NonGenericInformation is not a generic class,
         * so we still need to hard code the String type in class,
         * it's not a good example.
         * */
    }

    @Test
    public void testGenericInformation() {
        String expected = "9487 la";

        GenericInformation<String> genericInformation = new GenericInformation<>(expected);
        assertEquals(expected, genericInformation.getInfo());
    }

    @Test
    public void testMultiGenericInformation() {
        int expectedInfoX = 987;
        double expectedInfoY = 948.7d;
        String expectedInfo = "9487 la";

        MultiGenericInformation<Integer, Double, String> multiGenericInformation =
                new MultiGenericInformation<>(expectedInfoX, expectedInfoY, expectedInfo);
        assertEquals(Integer.valueOf(expectedInfoX), multiGenericInformation.getInfoX());
        assertEquals(Double.valueOf(expectedInfoY), multiGenericInformation.getInfoY());
        assertEquals(expectedInfo, multiGenericInformation.getInfo());
    }

    @Test
    public void testGenericMethod() {
        GenericMethodClass.staticGenericMethod("String");
        GenericMethodClass genericMethodClass = new GenericMethodClass();
        genericMethodClass.instanceGenericMethod("String");

        /*
         * Notice that if you want to use fast json, do not create a custom constructor,
         * please only use getter/setter for set value for object.
         * */

        long expectedGroupId = 0L;
        long expectedAdmin1Id = 1L;
        long expectedAdmin2Id = 2L;

        String expectedGroupName = "admin";
        String expectedAdmin1Name = "admin1";
        String expectedAdmin2Name = "admin2";

        Group group = new Group();
        group.setId(expectedGroupId);
        group.setName(expectedGroupName);

        User admin1 = new User();
        admin1.setId(expectedAdmin1Id);
        admin1.setName(expectedAdmin1Name);

        User admin2 = new User();
        admin2.setId(expectedAdmin2Id);
        admin2.setName(expectedAdmin2Name);

        group.addUser(admin1);
        group.addUser(admin2);

        String expectedJsonStringResult =
                "{\"id\":0,\"name\":\"admin\",\"users\":[{\"id\":1,\"name\":\"admin1\"},{\"id\":2,\"name\":\"admin2\"}]}";
        assertEquals(expectedJsonStringResult, JSON.toJSONString(group));

        Group parsedGroup = GenericMethodClass.parseObject(expectedJsonStringResult, Group.class);
        assertEquals(Long.valueOf(expectedGroupId), parsedGroup.getId());
        assertEquals(expectedGroupName, parsedGroup.getName());
        assertEquals(Long.valueOf(expectedAdmin1Id), parsedGroup.getUsers().get(0).getId());
        assertEquals(expectedAdmin1Name, parsedGroup.getUsers().get(0).getName());
        assertEquals(Long.valueOf(expectedAdmin2Id), parsedGroup.getUsers().get(1).getId());
        assertEquals(expectedAdmin2Name, parsedGroup.getUsers().get(1).getName());

        Integer intInputs[] = GenericMethodClass.parseGenericArray(1, 2, 3, 4, 5, 6);
        assertEquals(6, intInputs.length);

        String strInputs[] = GenericMethodClass.parseGenericArray("foo", "bar", "9487");
        assertEquals(3, strInputs.length);
    }

}
