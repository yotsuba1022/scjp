package idv.carl.monad.casestudy.login;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Carl Lu
 */
public class LoginServiceTest {

    private final static String URL_FOR_DASHBOARD = "https://dashboard";
    private final static String URL_FOR_LOGIN = "https://login";

    private final static String INVALID_LOGIN_USER_ID = "bku";
    private final static String INVALID_GMAIL_LOGIN_USER_ID = "danwang";
    private final static String INVALID_TWO_FACTOR_LOGIN_USER_ID = "clu";

    private LoginService loginService;

    private static User getValidUser() {
        return new User("taco", "taco");
    }

    private static User getInvalidLoginUser() {
        return new User(INVALID_LOGIN_USER_ID, INVALID_LOGIN_USER_ID);
    }

    private static User getInvalidGmailLoginUser() {
        return new User(INVALID_GMAIL_LOGIN_USER_ID, INVALID_GMAIL_LOGIN_USER_ID);
    }

    private static User getInvalidTwoFactorLoginUser() {
        return new User(INVALID_TWO_FACTOR_LOGIN_USER_ID, INVALID_TWO_FACTOR_LOGIN_USER_ID);
    }

    @Before
    public void init() {
        loginService = new LoginService();
    }

    @After
    public void destroy() {
        loginService = null;
    }

    @Test
    public void testForNormalLogin() throws Exception {
        User validUser = getValidUser();
        String actual = loginService.login(validUser.getId(), "password");
        assertEquals(URL_FOR_DASHBOARD, actual);
    }

    @Test
    public void testForInvalidLogin() throws Exception {
        User invalidLoginUser = getInvalidLoginUser();
        String actual = loginService.login(invalidLoginUser.getId(), "password");
        assertEquals(URL_FOR_DASHBOARD, actual);
    }

    @Test
    public void testForInvalidGmailLogin() throws Exception {
        User invalidGmailLoginUser = getInvalidGmailLoginUser();
        String actual = loginService.login(invalidGmailLoginUser.getId(), "password");
        assertEquals(URL_FOR_LOGIN, actual);
    }

    @Test
    public void testForInvalidTwoFactorLogin() throws Exception {
        User invalidTwoFactorLoginUser = getInvalidTwoFactorLoginUser();
        String actual = loginService.login(invalidTwoFactorLoginUser.getId(), "password");
        assertEquals(URL_FOR_LOGIN, actual);
    }

    @Test
    public void testForNormalMonadicLogin() throws Exception {
        User validUser = getValidUser();
        String actual = loginService.monadicLogin(validUser.getId(), "password");
        assertEquals(URL_FOR_DASHBOARD, actual);
    }

    @Test
    public void testForInvalidMonadicLogin() throws Exception {
        User invalidLoginUser = getInvalidLoginUser();
        String actual = loginService.monadicLogin(invalidLoginUser.getId(), "password");
        assertEquals(URL_FOR_DASHBOARD, actual);
    }

    @Test
    public void testForInvalidGmailMonadicLogin() throws Exception {
        User invalidGmailLoginUser = getInvalidGmailLoginUser();
        String actual = loginService.monadicLogin(invalidGmailLoginUser.getId(), "password");
        assertEquals(URL_FOR_LOGIN, actual);
    }

    @Test
    public void testForInvalidTwoFactorMonadicLogin() throws Exception {
        User invalidTwoFactorLoginUser = getInvalidTwoFactorLoginUser();
        String actual = loginService.monadicLogin(invalidTwoFactorLoginUser.getId(), "password");
        assertEquals(URL_FOR_LOGIN, actual);
    }

}
