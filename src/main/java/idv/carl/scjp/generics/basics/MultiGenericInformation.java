package idv.carl.scjp.generics.basics;

/**
 * @author Carl Lu
 */
public class MultiGenericInformation<X, Y, T> implements Information<T> {

    private X infoX;
    private Y infoY;
    private T info;

    public MultiGenericInformation(X infoX, Y infoY, T info) {
        this.infoX = infoX;
        this.infoY = infoY;
        this.info = info;
    }

    public X getInfoX() {
        return infoX;
    }

    public void setInfoX(X infoX) {
        this.infoX = infoX;
    }

    public Y getInfoY() {
        return infoY;
    }

    public void setInfoY(Y infoY) {
        this.infoY = infoY;
    }

    @Override
    public T getInfo() {
        return info;
    }

    @Override
    public void setInfo(T infoT) {
        this.info = infoT;
    }
}
