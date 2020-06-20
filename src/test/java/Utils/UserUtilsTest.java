package Utils;

import Models.UserModel;
import Models.UserType;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Assert;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

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

    @Test(expected = FileNotFoundException.class)
    public void testReadUsersFileWrongFile() throws FileNotFoundException {
        FileReader reader = new FileReader("FisierInexistent.json");
    }


    @Test
    public void testReadUsersFile() throws FileNotFoundException {
        Gson gson = new Gson();
        FileReader reader = new FileReader("users.json");
        ArrayList<UserType> users = gson.fromJson(reader, new TypeToken<ArrayList<UserModel>>() {
        }.getType());
        Assert.assertNotNull(users);
    }


}
