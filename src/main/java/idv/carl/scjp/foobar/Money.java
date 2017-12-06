package idv.carl.scjp.foobar;

/**
 * @author Carl Lu
 */
class Money {
    private String country = "Canada";

    public String getC() {
        return country;
    }
}


class Yen extends Money {
    public String getC() {
        // return super.country; -> You can't access private attribute here.
        return null;
    }
}


class Euro extends Money {
    public static void main(String[] args) {
        System.out.print(new Yen().getC() + " " + new Euro().getC());
    }

    public String getC() {
        return super.getC();
    }
}
