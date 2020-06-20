package View;

import Exceptions.EmptyPassword;
import Exceptions.EmptyUsername;
import org.junit.Test;

public class LoginTest {

    @Test(expected = EmptyUsername.class)
    public void testCheckEmptyUsername() throws EmptyUsername{
        Login.checkUsername("");
    }

    @Test(expected = EmptyPassword.class)
    public void testCheckEmptyPassword() throws EmptyPassword{
        Login.checkPassword("");
    }
}