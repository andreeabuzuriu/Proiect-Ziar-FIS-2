package View;

import Exceptions.EmptyPassword;
import Exceptions.EmptyUsername;
import Models.UserModel;
import Models.UserType;
import Utils.EncryptUtil;
import Utils.UserUtils;
import Utils.UsersGenerator;
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
import java.util.Objects;

public class Login extends Application {

    static TextField usernameTextField = new TextField ();
    static PasswordField passwordTextField = new PasswordField ();
    static boolean isTesting=false;
    private static Stage primaryStage;

    public static void main(String[] args){
        launch(args);
        UsersGenerator.generateUsersList();

    }
    public void start(Stage stage) throws Exception{
        this.primaryStage=stage;
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

        loginButton.setOnAction(e->
        {loginAction();
        });

    }

    public static boolean loginAction(){
        UserType userType = UserUtils.isUserValid(usernameTextField.getText(),passwordTextField.getText());

        if(userType==null) {
            if(isTesting)
            {new Runnable(){

                @Override
                public void run() {
                    AlertBox.display("Eroare", "Username sau parola gresita");
                }
            };}
            else
            {
                AlertBox.display("Eroare", "Username sau parola gresita");

            }
            return false;
        }
        else
        if(userType.equals(UserType.REDACTOR_SEF)){
            FirstPageRedactorSef.display(usernameTextField.getText());
            primaryStage.close();
            return true;
        }
        else if(userType.equals(UserType.REDACTOR)){
            FirstPageRedactor.display(usernameTextField.getText());
            primaryStage.close();
            return true;
        }
        return false;
    }



    public static void checkUsername(String username) throws EmptyUsername{
        if(Objects.equals(username,""))
            throw new EmptyUsername(username);
    }

    public static void checkPassword(String password) throws EmptyPassword{
        if(Objects.equals(password,""))
            throw new EmptyPassword(password);
    }




}
