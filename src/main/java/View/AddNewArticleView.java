package View;
import MockData.MockArticles;
import Models.ArticleModel;
import Models.ArticleState;
import Services.DatabaseService;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;


public class AddNewArticleView {
    private static VBox CurrentLayout;
    private static String CurrentUser;
    private static Stage window;
    public static void display(String username){
        window = new Stage();
        window.setTitle("Articol nou REDACTOR " + username);
        CurrentUser=username;
        CurrentLayout = new VBox();
        Scene scene = new Scene(CurrentLayout, 400, 400);
        window.setScene(scene);
        window.show();

        onCreate();
    }

    private static void onCreate() {
        //TODO initiez listele cu articole
        Label titleLabel = new Label("Titlu:");
        TextField titleTextField = new TextField();
        Label contentLabel = new Label("Continut:");
        TextArea contentTextArea = new TextArea();
        Button saveArticleButton = new Button("Salveaza");
        saveArticleButton.setOnAction(e->
        {
            if(titleTextField.getText().isEmpty() || contentTextArea.getText().isEmpty())
            {
                AlertBox.display("Warning","Please complete all fields");
                return;
            }
            ArticleModel article=new ArticleModel(CurrentUser,titleTextField.getText(),contentTextArea.getText(), ArticleState.PENDING);
            DatabaseService.addArticle(article);
            window.close();

        });

        contentTextArea.setPrefHeight(300);
        contentTextArea.setPrefWidth(300);
        contentTextArea.setWrapText(true);

        HBox titleHBox = new HBox();
        HBox contentHBox = new HBox();
        HBox buttonBox = new HBox();
        titleHBox.getChildren().addAll(titleLabel,titleTextField);
        contentHBox.getChildren().addAll(contentLabel,contentTextArea);
        buttonBox.getChildren().add(saveArticleButton);
        CurrentLayout.getChildren().addAll(titleHBox,contentHBox,buttonBox);
        CurrentLayout.setPadding(new Insets(10,10,10,10));
        buttonBox.setAlignment(Pos.CENTER);
        CurrentLayout.setSpacing(10);

    }

}