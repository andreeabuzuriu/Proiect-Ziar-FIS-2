import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class CreateJSONFile
{
    @SuppressWarnings("unchecked")
    public static void main( String[] args )
    {
        //First User
        JSONObject userDetails = new JSONObject();
        userDetails.put("username", "andrei");
        userDetails.put("password", "parola123");
        userDetails.put("role", "redactorsef");

        JSONObject userObject = new JSONObject();
        userObject.put("user", userDetails);

        //Second User
        JSONObject userDetails2 = new JSONObject();
        userDetails2.put("username", "bogdan");
        userDetails2.put("password", "parola333");
        userDetails2.put("role", "redactor");

        JSONObject userObject2 = new JSONObject();
        userObject2.put("user", userDetails2);

        //Add users to list
        JSONArray usersList = new JSONArray();
        usersList.add(userObject);
        usersList.add(userObject2);

        //Write JSON file
        try (FileWriter file = new FileWriter("users.json")) {

            file.write(usersList.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}