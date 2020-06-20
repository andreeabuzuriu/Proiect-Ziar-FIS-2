package Utils;

import Models.UserModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Assert;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class UsersGeneratorTest extends ApplicationTest {
    @Test
    public void testGenerateUsersList() throws FileNotFoundException {
        FileReader reader = new FileReader("users.json");
        ArrayList<UserModel> usersList = new Gson().fromJson(reader, new TypeToken<ArrayList<UserModel>>() {
        }.getType());
        Assert.assertNotNull(usersList);
    }

    @Test (expected = FileNotFoundException.class)
    public void testGenerateUsersListFileNotFound() throws FileNotFoundException{
        FileReader reader = new FileReader("numegresit.json");
    }
}
