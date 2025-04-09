package com.tpobjetperdu.views;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PrimaryView extends VBox{
    private Scene scene;

    public PrimaryView(Stage stage) {
        
        Text welcome = new Text("Bienvenue sur Findback");
        HBox hBox = new HBox(50);

        Button saveObject = new Button("Enrégistrer un objet volé");

        //Action du bouton saveObject
        saveObject.setOnAction(
            e -> {
                Sign sign = new Sign(stage);
            }
        );

        Button stollenObject = new Button("Vérifier si un objet a été volé");

        //action du bouton stollenObject
        stollenObject.setOnAction(
            e -> {
                InfoObj infoObj = new InfoObj(stage); 
            }
        );

        //Aligner les bouttons
        hBox.getChildren().addAll(saveObject, stollenObject);
        this.setAlignment(Pos.TOP_CENTER);
        this.getChildren().addAll(welcome, hBox);

        scene = new Scene(this);
        stage.setScene(scene);
        stage.setWidth(400);
        stage.setHeight(300);
        stage.setTitle("Primary View");
        stage.show();
    }
}
