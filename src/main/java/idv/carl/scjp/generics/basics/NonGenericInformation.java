package idv.carl.scjp.generics.basics;

/**
 * @author Carl Lu
 */
public class NonGenericInformation implements Information<String> {

    private String info;

    public NonGenericInformation(String info) {
        this.info = info;
    }

    @Override
    public String getInfo() {
        return info;
    }

    @Override
    public void setInfo(String info) {
        this.info = info;
    }

}
