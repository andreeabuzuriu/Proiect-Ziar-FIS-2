package Utils;

import Models.UserModel;
import Models.UserType;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class UsersGenerator {
    public static void generateUsersList(){
        ArrayList<UserModel> users = new ArrayList<UserModel>(3);
        UserModel u1 = new UserModel("adi","parola", UserType.REDACTOR);
        UserModel u2 = new UserModel("bogdan","parola123",UserType.REDACTOR_SEF);
        users.add(u1);
        users.add(u2);
        Gson gson1 = new Gson();
        String json1 = gson1.toJson(users);
        System.out.println(json1);
        /*
        ArrayList<UserModel> users2 = gson1.fromJson(json1, new TypeToken<ArrayList<UserModel>>(){}.getType());
        for(int i=0;i<users2.size();i++)
            System.out.println(users2.get(i).username+ " " +users2.get(i).password + " " +users2.get(i).role);
            */

    }
}
