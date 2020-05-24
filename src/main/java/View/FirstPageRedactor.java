package View;

import MockData.MockArticles;
import Models.ArticleModel;
import Models.ArticleState;
import Services.DatabaseService;
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
        ArrayList<ArticleModel> articles=DatabaseService.getUserArticles(CurrentUserName);
        if(articles!=null)
        {myArticles.addAll(articles);}

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
        Button refreshButton = new Button("Refresh");

        refreshButton.setOnAction(e->
        {
            refreshList();
        });
        HBox buttonsHBox = new HBox();
        buttonsHBox.getChildren().addAll(addButton,refreshButton);
        addButton.setAlignment(Pos.CENTER);
        addButton.setOnAction(e-> AddNewArticleView.display(CurrentUserName));

        Label articleViewTitle = new Label("My articles list");
        articleViewTitle.setAlignment(Pos.CENTER);

        myArticleView.setAlignment(Pos.CENTER);
        CurrentLayout.setAlignment(Pos.CENTER);

        myArticleView.getChildren().addAll(articleViewTitle, myContentView);
        createMyArticlesList();
        buttonsHBox.setAlignment(Pos.CENTER);
        CurrentLayout.getChildren().addAll(buttonsHBox,myScroll);

    }
    private static void refreshList(){
        myContentView.getChildren().clear();
        myArticles.clear();
        myArticles.addAll(DatabaseService.getUserArticles(CurrentUserName));
        createMyArticlesList();
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
        Label declinedReason=new Label();

        String state="Pending";
        if(article.getArticleState().equals(ArticleState.ACCEPTED))
        {
            state="Accepted";
        }
        if(article.getArticleState().equals(ArticleState.DECLINED))
        {
            state="Declined";

            declinedReason=new Label("Motiv : "+article.getFeedback());
        }
        Label articleStateLabel=new Label("Article state : "+state);

        descLabel.setWrapText(true);
        descLabel.setPrefWidth(500);
        descLabel.setTextAlignment(TextAlignment.JUSTIFY);

        if(article.getArticleState()==ArticleState.DECLINED)
        { detailBox.getChildren().addAll(articleStateLabel,declinedReason,titleLabel, descLabel);}
        else{
            detailBox.getChildren().addAll(articleStateLabel,titleLabel, descLabel);
        }

        HBox actionBox = new HBox();
        actionBox.minWidth(60);
        actionBox.setSpacing(5);

        Button editButton = new Button("Edit");
        Button deleteButton = new Button("Delete");

        editButton.setOnAction(e ->
        {
            if(article.getArticleState()==ArticleState.ACCEPTED)      //daca articolul a fost deja acceptat, nu se admin modificari
            {
                AlertBox.display("Warning","Articolul a fost deja publicat!");
            }
            else {
                EditArticleView.display(article);
            }
        });
        deleteButton.setOnAction(e ->
        {
            if(article.getArticleState()==ArticleState.ACCEPTED)      //daca articolul a fost deja acceptat, nu se admin modificari
            {
                AlertBox.display("Warning","Articolul a fost deja publicat!");
            }
            else {
                DatabaseService.deleteArticle(article);
                refreshList();

            }
        });

        actionBox.getChildren().addAll(editButton, deleteButton);
        actionBox.setAlignment(Pos.CENTER);

        cellParent.getChildren().addAll(detailBox, actionBox);
        return cellParent;
    }
}