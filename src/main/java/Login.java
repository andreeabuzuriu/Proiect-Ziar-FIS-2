import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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
    }



}
