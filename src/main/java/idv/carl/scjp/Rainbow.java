package idv.carl.scjp;

/**
 * @author Carl Lu
 */
public class Rainbow {
    public static void main(String[] args) {
        // insert code here
        MyColor c = MyColor.GREEN;

        // Enum types cannot be instantiated
        // MyColor purple = new MyColor(0xff00ff);
    }

    public enum MyColor {
        RED(0xff0000),
        GREEN(0x00ff00),
        BLUE(0x0000ff);
        private final int rgb;

        MyColor(int rgb) {
            this.rgb = rgb;
        }

        public int getRGB() {
            return rgb;
        }
    }
}
