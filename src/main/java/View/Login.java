package View;

import Models.UserModel;
import Models.UserType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.application.Application;
import javafx.beans.binding.ObjectExpression;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Login extends Application {

    TextField usernameTextField = new TextField ();
    PasswordField passwordTextField = new PasswordField ();
    public static void main(String[] args){
        launch(args);
    }
    public void start(Stage primaryStage) throws Exception{

        primaryStage.setTitle("Login");

        Label usernameLabel = new Label("Username:");
        Label passwordLabel = new Label("Password:");
        Button loginButton = new Button("Login");


        HBox usernameBox = new HBox();
        HBox passwordBox = new HBox();
        usernameBox.setSpacing(10);
        usernameBox.setAlignment(Pos.CENTER);
        usernameBox.getChildren().addAll(usernameLabel,usernameTextField);
        passwordBox.getChildren().addAll(passwordLabel,passwordTextField);
        passwordBox.setSpacing(10);
        passwordBox.setAlignment(Pos.CENTER);

        VBox loginVBox = new VBox();
        loginVBox.getChildren().addAll(usernameBox,passwordBox,loginButton);
        loginVBox.setSpacing(10);
        loginVBox.setAlignment(Pos.CENTER);

        StackPane layout = new StackPane();
        layout.getChildren().addAll(loginVBox);

        Scene scene = new Scene(layout,300,250);
        primaryStage.setScene(scene);
        primaryStage.show();
        loginButton.setOnAction(e->loginAction());

    }

    public void loginAction(){
        System.out.println(passwordTextField.getText()+ " " + usernameTextField.getText());



            /*
            Gson gson = new Gson(); // Or use new GsonBuilder().create();
            String json = gson.toJson(new UserModel("abc","def", UserType.REDACTOR));
            System.out.println(json);

            UserModel target2 = gson.fromJson(json, UserModel.class); // des
            System.out.println(target2.username + " " + target2.password + " "+ target2.role);
            */

    }



}
