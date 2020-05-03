import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJSONFile
{
    @SuppressWarnings("unchecked")
    public static void main(String[] args)
    {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("users.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray usersList = (JSONArray) obj;
            System.out.println(usersList);

            //Iterate over users array
            usersList.forEach( user -> parseUserObject( (JSONObject) user ) );

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static void parseUserObject(JSONObject user)
    {
        //Get user object within list
        JSONObject userObject = (JSONObject) user.get("user");

        //Get username
        String username = (String) userObject.get("username");
        System.out.println(username);

        //Get password
        String password = (String) userObject.get("password");
        System.out.println(password);

        //Get role
        String role = (String) userObject.get("role");
        System.out.println(role);
    }
}