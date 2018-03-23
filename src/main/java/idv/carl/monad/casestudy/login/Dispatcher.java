package idv.carl.monad.casestudy.login;

import java.net.URL;

/**
 * @author Carl Lu
 */
public class Dispatcher {

    static String redirect(URL target) {
        System.out.println("Going to => " + target + System.lineSeparator());
        return target.toString();
    }

}
