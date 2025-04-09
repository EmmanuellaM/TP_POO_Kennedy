package com.tpobjetperdu.views;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ObjetPasVole extends VBox{
    private Scene scene;

    public ObjetPasVole(Stage stage) {
        Text opv = new Text("L'objet n'a pas été volé!");
        HBox hBox = new HBox(50);

        Button back = new Button("Retour");
        
        //ajouter un bouton retour
        back.setOnAction(
            e -> {
                new InfoObj(stage);
            }
        );

        hBox.getChildren().addAll(back);
        this.setAlignment(Pos.TOP_CENTER);
        this.getChildren().addAll(opv, hBox);

        scene = new Scene(this);
        stage.setScene(scene);
        stage.setWidth(400);
        stage.setHeight(300);
        stage.setTitle("Objet non reconnu");
        stage.show();
    }
}
