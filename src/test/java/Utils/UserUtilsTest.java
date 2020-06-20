package Utils;

import Models.UserType;
import org.junit.Assert;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

public class UserUtilsTest extends ApplicationTest {

    @Test
    public void testIsUserValidWithNull(){
        UserType userType = UserUtils.isUserValid(null,null);
        Assert.assertEquals(null,userType);
    }

    @Test
    public void testIsUserValid(){
        UserType userType = UserUtils.isUserValid("adi","parola");
        Assert.assertNotNull(userType);
    }
    
}
