package idv.carl.scjp.compileerror;

/**
 * @author Carl Lu
 */
public class ConstructorExtend {

    class Person {
        String name = "No name";

        public Person(String nm) {
            name = nm;
        }
    }
    class Employee extends Person {
        String empID = "0000";

        // no default constructor available:

        // public Employee(String id) {
        // empID = id;
        // }

        // should be like this:
        public Employee(String nm) {
            super(nm);
        }
    }
    /*
     * class EmployeeTest {
     * public static void main(String[] args) {
     * Employee e = new Employee("4321");
     * System.out.println(e.empID);
     * }
     * }
     */

}
