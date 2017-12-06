package idv.carl.scjp.foobar;

/**
 * @author Carl Lu
 */
interface Data {
    public void load();
}


abstract class Info {
    public abstract void load();
}


public class Employee extends Info implements Data {
    public void load() { /* do something */ }
}
