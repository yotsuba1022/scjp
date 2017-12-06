package idv.carl.scjp.generics.basics;

/**
 * @author Carl Lu
 */
public class MultiGenericCoordinatePoint<T, S> {

    private T x;
    private T y;
    private S pointName;

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

    public S getPointName() {
        return pointName;
    }

    public void setPointName(S pointName) {
        this.pointName = pointName;
    }

}
