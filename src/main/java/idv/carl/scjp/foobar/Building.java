package idv.carl.scjp.foobar;

/**
 * @author Carl Lu
 */
class Building {
}


class Barn extends Building {
    public static void main(String[] args) {
        Building build1 = new Building();
        Barn barn1 = new Barn();

        /*
         * This line should be passed in compilation time, however,
         * when running the main(), you'll see the following message:
         * 
         * Exception in thread "main" java.lang.ClassCastException: idv.carl.scjp.Building cannot be
         * cast to idv.carl.scjp.Barn
         * 
         */
        Barn barn2 = (Barn) build1;

        Object obj1 = (Object) build1;
        // String str1 = (String) build1; -> compilation fail
        Building build2 = (Building) barn1;
    }
}


class AA {

}


class BB extends AA {
    AA aa = new AA();
    BB bb = (BB) aa;
}
