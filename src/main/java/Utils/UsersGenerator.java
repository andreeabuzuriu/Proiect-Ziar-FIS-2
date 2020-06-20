package Utils;

import Models.UserModel;
import Models.UserType;
import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class UsersGenerator {
    public static void generateUsersList() {
        ArrayList<UserModel> users = new ArrayList<UserModel>(3);
        String user1Pass="parola";
        String user1PassEncrypted=EncryptUtil.encrypt(user1Pass);
        String user2Pass="parola123";
        String user2PassEncrypted=EncryptUtil.encrypt(user2Pass);
        String user3Pass="123456";
        String user3PassEncrypted=EncryptUtil.encrypt(user3Pass);

        UserModel u1 = new UserModel("adi", user1PassEncrypted, UserType.REDACTOR);
        UserModel u2 = new UserModel("bogdan", user2PassEncrypted, UserType.REDACTOR_SEF);
        UserModel u3 = new UserModel("cristi", user3PassEncrypted, UserType.REDACTOR);
        users.add(u1);
        users.add(u2);
        users.add(u3);

        Gson gson = new Gson();
        String usersList = gson.toJson(users);

        try (FileWriter file = new FileWriter("users.json")) {
            file.write(usersList);
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
