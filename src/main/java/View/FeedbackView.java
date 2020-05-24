package View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FeedbackView {
    public static void display(){
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Fereastra Feedback");
        //window.setMinWidth(350);

        Label label = new Label();
        label.setText("Din ce cauza ati refuzat articolul? Scrieti un feedback pentru redactor:");
        label.setWrapText(true);
       // label.setPrefWidth(100);
        label.setTextAlignment(TextAlignment.JUSTIFY);
        TextArea feedbackText = new TextArea();
        feedbackText.setWrapText(true);
        Button sendButton = new Button("Trimiteti");
        //sendButton.setOnAction(e->  );

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10,10,10,10));

        layout.getChildren().addAll(label,feedbackText,sendButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout,600,300);
        window.setScene(scene);
        window.showAndWait();
    }
}
