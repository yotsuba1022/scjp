package idv.carl.monad.casestudy.login;

import java.net.URL;

/**
 * @author Carl Lu
 */
public class LoginService {

    private final static String URL_FOR_DASHBOARD = "https://dashboard";
    private final static String URL_FOR_LOGIN = "https://login";

    public String login(String id, String password) throws Exception {
        final URL dashboard = new URL(URL_FOR_DASHBOARD);
        final URL loginPage = new URL(URL_FOR_LOGIN);
        User user;

        Authenticator authenticator = new Authenticator();
        try {
            user = authenticator.login(id, password);
        } catch (Exception loginException) {
            System.out.println("System login failed = " + loginException.getMessage());
            try {
                user = authenticator.gmailLogin(id, password);
            } catch (Exception gmailLoginException) {
                System.out.println("gmail login failed = " + gmailLoginException.getMessage());
                return Dispatcher.redirect(loginPage);
            }
        }

        URL target;

        try {
            long twoFactorPws = 9487;
            authenticator.twoFactor(user, twoFactorPws);
            target = dashboard;
        } catch (Exception twoFactorException) {
            System.out.println("Two factor auth failed = " + twoFactorException.getMessage());
            target = loginPage;
        }
        return Dispatcher.redirect(target);
    }

    public String monadicLogin(String id, String password) throws Exception {
        final URL dashboard = new URL(URL_FOR_DASHBOARD);
        final URL loginPage = new URL(URL_FOR_LOGIN);

        Authenticator authenticator = new Authenticator();

        Try<URL> target = Try.with(() -> authenticator.login(id, password)).
                recoverWith(exception -> Try.with(() -> authenticator.gmailLogin(id, password))).
                chain(user -> Try.with(() -> {
                    long twoFactorPws = 9487;
                    authenticator.twoFactor(user, twoFactorPws);
                    return dashboard;
                })).
                orElse(Try.with(() -> loginPage));

        return Dispatcher.redirect(target.get());
    }

}
