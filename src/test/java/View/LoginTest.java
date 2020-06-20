package View;
import Exceptions.EmptyUsername;
import org.junit.Test;
public class LoginTest {

    @Test(expected = EmptyUsername.class)
    public void testCheckEmptyUsername() throws EmptyUsername{
        Login.checkUsername("");
    }

}