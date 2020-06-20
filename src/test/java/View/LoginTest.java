package View;

import Exceptions.EmptyPassword;
import Exceptions.EmptyUsername;
import org.junit.Assert;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

public class LoginTest extends ApplicationTest{
    private static String username,password;
    @Test(expected = EmptyUsername.class)
    public void testCheckEmptyUsername() throws EmptyUsername{
        Login.checkUsername("");
    }

    @Test(expected = EmptyPassword.class)
    public void testCheckEmptyPassword() throws EmptyPassword{
        Login.checkPassword("");
    }

    @Test
    public void testCheckUsernameNotEmpty() throws EmptyUsername {
        Login.checkUsername("andrei");
    }

    @Test
    public void testCheckPasswordNotEmpty() throws EmptyPassword{
        Login.checkPassword("parola");
    }

    @Test
    public void testLoginAction(){
        username="jjj";
        password="jjj";
        Login.usernameTextField.setText(username);
        Login.passwordTextField.setText(password);
        Login.isTesting=true;
        boolean result = Login.loginAction();
        Login.isTesting=false;
        Assert.assertEquals(false,result);
    }
}