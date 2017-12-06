package idv.carl.scjp.foobar;

/**
 * @author Carl Lu
 */
public enum Title {
    MR("Mr."),
    MRS("Mrs."),
    MS("Ms.");
    private final String title;

    private Title(String t) {
        title = t;
    }

    public static void main(String[] args) {
        System.out.println(Title.MR.format("Doe", "John"));
    }

    public String format(String last, String first) {
        return title + " " + first + " " + last;
    }

}
