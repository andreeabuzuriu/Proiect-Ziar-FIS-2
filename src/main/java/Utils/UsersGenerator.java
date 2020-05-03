package Utils;

import Models.UserModel;
import Models.UserType;
import com.google.gson.Gson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class UsersGenerator {
    public static void generateUsersList() {
        ArrayList<UserModel> users = new ArrayList<UserModel>(3);
        UserModel u1 = new UserModel("adi", "parola", UserType.REDACTOR);
        UserModel u2 = new UserModel("bogdan", "parola123", UserType.REDACTOR_SEF);
        UserModel u3 = new UserModel("cristi", "123456", UserType.REDACTOR);
        users.add(u1);
        users.add(u2);
        users.add(u3);

        Gson gson = new Gson();
        String usersList = gson.toJson(users);

        /*
        ArrayList<UserModel> users2 = gson1.fromJson(json1, new TypeToken<ArrayList<UserModel>>(){}.getType());
        for(int i=0;i<users2.size();i++)
            System.out.println(users2.get(i).username+ " " +users2.get(i).password + " " +users2.get(i).role);
            */

        try (FileWriter file = new FileWriter("users.json")) {
            file.write(usersList);
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
