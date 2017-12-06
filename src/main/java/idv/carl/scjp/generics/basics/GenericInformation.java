package idv.carl.scjp.generics.basics;

/**
 * @author Carl Lu
 */
public class GenericInformation<T> implements Information<T> {

    private T info;

    public GenericInformation(T info) {
        this.info = info;
    }

    @Override
    public T getInfo() {
        return info;
    }

    @Override
    public void setInfo(T info) {
        this.info = info;
    }
    
}
