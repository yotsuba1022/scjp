package idv.carl.scjp.compileerror;

/**
 * @author Carl Lu
 */
public class Beta extends Alpha {
    // private void bar(int x){} -> weaker access privilege
    // public Alpha bar(int x){} -> incompatible return type
    // public int bar(int x){return x;} -> incompatible return type
}
