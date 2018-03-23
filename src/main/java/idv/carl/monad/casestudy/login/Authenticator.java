package idv.carl.monad.casestudy.login;

/**
 * @author Carl Lu
 */
public class Authenticator {

    private final static String INVALID_LOGIN_USER_ID = "bku";
    private final static String INVALID_GMAIL_LOGIN_USER_ID = "danwang";
    private final static String INVALID_TWO_FACTOR_LOGIN_USER_ID = "clu";

    public User login(String id, String password) throws Exception {
        System.out.println("Inside system login.");

        if (INVALID_LOGIN_USER_ID.equals(id) || INVALID_GMAIL_LOGIN_USER_ID.equals(id) || INVALID_TWO_FACTOR_LOGIN_USER_ID.equals(
                id)) {
            throw new Exception("Password mismatch: " + id + " is coming.");
        }

        return new User(id, id);
    }

    public User gmailLogin(String id, String password) throws Exception {
        System.out.println("Inside gmail login.");

        if (INVALID_GMAIL_LOGIN_USER_ID.equals(id)) {
            throw new Exception("Gmail validation error: " + id + " is coming.");
        }

        return new User(id, id);
    }

    public User twoFactor(User user, long password) throws Exception {
        System.out.println("Inside two factor.");

        String id = user.getId();
        if (INVALID_TWO_FACTOR_LOGIN_USER_ID.equals(id)) {
            throw new Exception("Two factor incorrect key: " + id + " is coming.");
        }

        return new User(id, id);
    }

}
