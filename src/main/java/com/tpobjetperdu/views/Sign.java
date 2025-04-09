package com.tpobjetperdu.views;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Sign extends VBox {
    private Scene scene;

    public Sign(Stage stage) {
        
        Text texte = new Text("Authentification");
        HBox hBox = new HBox(50);

        Button signIn = new Button("Sign in");

        //Action du bouton SignIn
        signIn.setOnAction(
            e -> {
                new SignIn(stage);
            }
        );

        Button signUp = new Button("Sign up");

        //Action du bouton SignUp
        signUp.setOnAction(
            e -> {
                new SignUp(stage);
            }
        );

        Button back = new Button("Retour");
        
        //ajouter un bouton retour
        back.setOnAction(
            e -> {
                new PrimaryView(stage);
            }
        );

        //Aligner les bouttons
        hBox.getChildren().addAll(signIn, signUp);
        this.setAlignment(Pos.TOP_CENTER);
        this.getChildren().addAll(texte, hBox, back);

        scene = new Scene(this);
        stage.setScene(scene);
        stage.setWidth(400);
        stage.setHeight(300);
        stage.setTitle("Sign");
        stage.show();
    }
}
