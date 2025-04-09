package com.tpobjetperdu.views;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;;

public class InfoObj extends GridPane {
    private Scene scene;

    public InfoObj(Stage stage) {
        GridPane grid = new GridPane();
        grid.setHgap(30);
        grid.setVgap(50);

        TextField type = new TextField();
        TextField address = new TextField();

        Button valid = new Button("Valider");
        Button back = new Button("Retour");

        back.setOnAction
        (
            e -> {
                new PrimaryView(stage);       
            }
        );
        
        //place les boutons sur la même horizontale 
        HBox hbox = new HBox(50);
        hbox.getChildren().addAll(back, valid);

        grid.add(new Label("Veuillez saisir le type de l'objet"), 0, 0);
        grid.add(new Label("Veuillez saisir l'adresse de l'objet"), 0, 1);
        grid.add(type, 2, 0);
        grid.add(address, 2, 1);
        grid.add(hbox, 0, 3);

        scene = new Scene(grid);
        stage.setScene(scene);
        stage.setWidth(400);
        stage.setHeight(300);
        stage.setTitle("Vérification");
        stage.show();

    }

}
