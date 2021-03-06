package View;

import Models.ArticleModel;
import Models.ArticleState;
import Services.DatabaseService;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class EditArticleView {
    private static VBox CurrentLayout;
    private static Stage window;
    private static ArticleModel CurrentArticle;
    public static void display(ArticleModel articleModel){
        window = new Stage();
        window.setTitle("Fereastra Editare REDACTOR " + articleModel.getAutor());
        CurrentArticle=articleModel;
        CurrentLayout = new VBox();
        Scene scene = new Scene(CurrentLayout, 400, 400);
        window.setScene(scene);
        window.show();

        onCreate();
    }

    private static void onCreate() {
        Label titleLabel = new Label("Titlu:");
        TextField titleTextField = new TextField();
        titleTextField.setText(CurrentArticle.getNume());

        Label contentLabel = new Label("Continut:");
        TextArea contentTextArea = new TextArea();
        contentTextArea.setText(CurrentArticle.getContinut());

        Button saveArticleButton = new Button("Salveaza modificarile");
        saveArticleButton.setOnAction(e->
        {
            if(titleTextField.getText().isEmpty() || contentTextArea.getText().isEmpty())
            {
                AlertBox.display("Warning","Va rugam completati toate campurile.");
                return;
            }
            CurrentArticle.setNume(titleTextField.getText());
            CurrentArticle.setContinut(contentTextArea.getText());
            CurrentArticle.setArticleState(ArticleState.PENDING);

            DatabaseService.editArticle(CurrentArticle);

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
