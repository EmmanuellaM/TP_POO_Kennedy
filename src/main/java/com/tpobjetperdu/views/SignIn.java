package com.tpobjetperdu.views;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignIn extends GridPane {
    private Scene scene;

    public SignIn(Stage stage) {
        GridPane grid = new GridPane();
        grid.setHgap(30);
        grid.setVgap(50);

        TextField name = new TextField();
        TextField email = new TextField();

        Button valid = new Button("Valider");
        Button back = new Button("Retour");

        back.setOnAction
        (
            e -> {
                new Sign(stage);       
            }
        );
        
        //place les boutons sur la même horizontale 
        HBox hbox = new HBox(50);
        hbox.getChildren().addAll(back, valid);

        grid.add(new Label("Veuillez saisir votre nom"), 0, 0);
        grid.add(new Label("Veuillez saisir votre adresse mail"), 0, 1);
        grid.add(name, 2, 0);
        grid.add(email, 2, 1);
        grid.add(hbox, 0, 3);

        scene = new Scene(grid);
        stage.setScene(scene);
        stage.setWidth(400);
        stage.setHeight(300);
        stage.setTitle("Sign In");
        stage.show();

    }
}
