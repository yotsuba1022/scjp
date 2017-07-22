package idv.carl.scjp.compileerror;

/**
 * @author Carl Lu
 */
public class Talk {
    public static void main(String[] args) {
        // Has private access to Console.
        // Console c = new Console();
        String pw;
        System.out.print("password: ");
        // pw = c.readLine();
        // System.out.println("got" + pw);
    }
}
