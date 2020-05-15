package View;

import MockData.MockArticles;
import Models.ArticleModel;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.ArrayList;

public class FirstPageRedactor {
    private static VBox CurrentLayout;
    private static VBox myArticleView, myContentView;
    private static ArrayList<ArticleModel> myArticles = new ArrayList<>();
    private static String CurrentUserName;

    static void display(String username) {

        Stage window = new Stage();
        window.setTitle("Pagina principala REDACTOR " + username);
        CurrentLayout = new VBox();
        Scene scene = new Scene(CurrentLayout, 500, 700);
        window.setScene(scene);
        window.show();

        CurrentUserName=username;

        onCreate();
    }

    private static void onCreate() {
        //TODO initiez listele cu articole
        myArticles.addAll(MockArticles.pendingArticles);

        //setPending List
        myArticleView = new VBox();
        myArticleView.setSpacing(10);

        myContentView =new VBox();
        myContentView.setPrefWidth(500);

        ScrollPane myScroll;
        myScroll = new ScrollPane();
        myScroll.setContent(myArticleView);
        myScroll.setFitToWidth(true);

        Button addButton = new Button("Add");
        addButton.setAlignment(Pos.CENTER);
        addButton.setOnAction(e-> AddNewArticleView.display(CurrentUserName));

        Label articleViewTitle = new Label("My articles list");
        articleViewTitle.setAlignment(Pos.CENTER);

        myArticleView.setAlignment(Pos.CENTER);
        CurrentLayout.setAlignment(Pos.CENTER);

        myArticleView.getChildren().addAll(articleViewTitle, myContentView);
        createMyArticlesList();
        CurrentLayout.getChildren().addAll(addButton,myScroll);

    }

    private static void createMyArticlesList() {
        myContentView.getChildren().clear();
        for (int i = 0; i< myArticles.size(); i++){
            myContentView.getChildren().add(createMyArticleCell(myArticles.get(i)));
        }
    }

    private static VBox createMyArticleCell(ArticleModel article) {
        String cssLayout = "-fx-border-color: black;\n" +
                "-fx-border-insets: 5;\n" +
                "-fx-border-width: 3;\n";

        VBox cellParent = new VBox();
        cellParent.setPadding(new Insets(10, 10, 10, 10));
        cellParent.setStyle(cssLayout);
        cellParent.setSpacing(20);

        VBox detailBox = new VBox();
        detailBox.setPrefWidth(500);
        detailBox.setSpacing(5);

        Label titleLabel = new Label(article.getAutor() + ":" + article.getNume());
        Label descLabel = new Label(article.getContinut());

        descLabel.setWrapText(true);
        descLabel.setPrefWidth(500);
        descLabel.setTextAlignment(TextAlignment.JUSTIFY);
        detailBox.getChildren().addAll(titleLabel, descLabel);

        HBox actionBox = new HBox();
        actionBox.minWidth(60);
        actionBox.setSpacing(5);

        Button acceptButton = new Button("Edit");
        Button declineButton = new Button("Delete");

        acceptButton.setOnAction(e ->
        {
            System.out.println(article.getNume() + " edited");
        });
        declineButton.setOnAction(e ->
        {
            System.out.println(article.getNume() + " deleted");
        });

        actionBox.getChildren().addAll(acceptButton, declineButton);
        actionBox.setAlignment(Pos.CENTER);

        cellParent.getChildren().addAll(detailBox, actionBox);
        return cellParent;
    }
}