package View;
import MockData.MockArticles;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class AddNewArticleView {
    private static VBox CurrentLayout;
    public static void display(String username){
        Stage window = new Stage();
        window.setTitle("Articol nou REDACTOR " + username);
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
