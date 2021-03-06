package Utils;

import Models.UserModel;
import Models.UserType;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class UserUtils {
    public static UserType isUserValid(String username, String password) {
        ArrayList<UserModel> usersList = readUsersFile();
        for(int i=0;i<usersList.size();i++){
            String cryptedPassword = EncryptUtil.decrypt(usersList.get(i).getPassword());
            if((usersList.get(i).getUsername().equals(username)) && cryptedPassword.equals(password))
                return usersList.get(i).getRole();
        }
        return null;
    }

    private static ArrayList<UserModel> readUsersFile() {

        Gson gson = new Gson();
        try (FileReader reader = new FileReader("users.json")) {
            //Read JSON file
            ArrayList<UserModel> usersList = gson.fromJson(reader, new TypeToken<ArrayList<UserModel>>() {
            }.getType());

            return usersList;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
