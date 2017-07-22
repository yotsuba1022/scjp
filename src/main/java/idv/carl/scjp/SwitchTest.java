package idv.carl.scjp;

/**
 * @author Carl Lu
 */
public class SwitchTest {
    public static void main(String[] args) {
        Dogs myDog = Dogs.collie;
        switch (myDog) {
            case collie:
                System.out.print("collei ");
            case harrier:
                System.out.print("harrier ");
        }
    };

    public enum Dogs {
        collie,
        harrier
    }
}
