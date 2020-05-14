package View;

import MockData.MockArticles;
import Models.ArticleModel;
import Models.ArticleState;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.ArrayList;


public class FirstPageRedactorSef {

    private static HBox CurrentLayout;
    private static VBox pendingView,pendingContentView,articlesView,acceptedContentView;
    private static ArrayList<ArticleModel> pendingArticles = new ArrayList<>();
    private static ArrayList<ArticleModel> acceptedArticles = new ArrayList<>();


    static void display(String username) {

        Stage window = new Stage();
        window.setTitle("Pagina principala REDACTOR SEF " + username);
        CurrentLayout = new HBox();
        Scene scene = new Scene(CurrentLayout, 1000, 600);
        window.setScene(scene);
        window.show();

        onCreate();
    }

    private static void onCreate() {

        //TODO initiez listele cu articole
        pendingArticles.addAll(MockArticles.pendingArticles);
        acceptedArticles.addAll(MockArticles.acceptedArticles);

        //setPending List
        pendingView = new VBox();
        pendingView.setSpacing(10);

        pendingContentView=new VBox();
        pendingContentView.setPrefWidth(500);

        ScrollPane pendingScroll;
        pendingScroll = new ScrollPane();
        pendingScroll.setContent(pendingView);
        pendingScroll.setFitToWidth(true);

        Label pendingTitleView = new Label("All articles list ");
        pendingTitleView.setAlignment(Pos.CENTER);

        pendingView.getChildren().addAll(pendingTitleView,pendingContentView);

        createPendingList();

        //set Articles view
        articlesView = new VBox();
        articlesView.setSpacing(10);

        acceptedContentView=new VBox();
        acceptedContentView.setPrefWidth(500);

        ScrollPane articlesScroll;
        articlesScroll = new ScrollPane();
        articlesScroll.setContent(articlesView);
        articlesScroll.setFitToWidth(true);

        Label articlesViewTitle = new Label("Accepted articles list");
        articlesViewTitle.setAlignment(Pos.CENTER);

        articlesView.getChildren().addAll(articlesViewTitle,acceptedContentView);

        createAcceptedList();

        CurrentLayout.getChildren().addAll(pendingScroll, articlesScroll);

    }

    private static void createPendingList() {
        pendingContentView.getChildren().clear();


        for (int i=0;i<pendingArticles.size();i++){
            pendingContentView.getChildren().add(createPendingCell(pendingArticles.get(i)));
        }
    }

    private static void createAcceptedList(){
        acceptedContentView.getChildren().clear();

        for (int i=0;i<acceptedArticles.size();i++){
            acceptedContentView.getChildren().add(createAcceptedCell(acceptedArticles.get(i)));
        }
    }


    private static VBox createAcceptedCell(ArticleModel article){
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

        cellParent.getChildren().add(detailBox);

        return cellParent;
    }



    private static VBox createPendingCell(ArticleModel article) {
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

        Button acceptButton = new Button("Accept");
        Button declineButton = new Button("Decline");

        acceptButton.setOnAction(e ->
        {
            System.out.println(article.getNume());
        });
        declineButton.setOnAction(e ->
        {
            System.out.println(article.getNume() + " decline");
        });

        actionBox.getChildren().addAll(acceptButton, declineButton);
        actionBox.setAlignment(Pos.CENTER);

        cellParent.getChildren().addAll(detailBox, actionBox);

        return cellParent;
    }
}