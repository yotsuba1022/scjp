package idv.carl.scjp.generics.basics;

/**
 * @author Carl Lu
 */
public class GenericCoordinatePoint<T> {

    private T x;
    private T y;

    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }

    public T getY() {
        return y;
    }

    public void setY(T y) {
        this.y = y;
    }

}
