package idv.carl.scjp.foobar;

/**
 * @author Carl Lu
 */
// No compilation error.
interface DoStuff2 {
    float getRange(int low, int high);
}


interface DoMore {
    float getAvg(int a, int b, int c);
}


interface DoAll extends DoMore {
    float getAvg(int a, int b, int c, int d);
}


abstract class DoAbstract implements DoStuff2, DoMore {
}


class DoStuff implements DoStuff2 {
    public float getRange(int x, int y) {
        return 3.14f;
    }
}
