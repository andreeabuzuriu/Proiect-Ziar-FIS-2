package View;

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

    TextField usernameTextField = new TextField ();
    PasswordField passwordTextField = new PasswordField ();
    Stage primaryStage;
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

    public void loginAction(){
        UserType userType = UserUtils.isUserValid(usernameTextField.getText(),passwordTextField.getText());

        if(userType==null)
            AlertBox.display("Eroare","Username sau parola gresita");
        else
        if(userType.equals(UserType.REDACTOR_SEF)){
            FirstPageRedactorSef.display(usernameTextField.getText());
            primaryStage.close();
        }
        else if(userType.equals(UserType.REDACTOR)){
            FirstPageRedactor.display(usernameTextField.getText());
            primaryStage.close();
        }

    }


    public static void checkUsername(String username) throws EmptyUsername{
        if(Objects.equals(username,""))
            throw new EmptyUsername(username);
    }



}
