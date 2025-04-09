package com.tpobjetperdu.views;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import com.tpobjetperdu.controller.DeviseOController;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FicheEnrO extends GridPane {
    private Scene scene;

    public FicheEnrO(Stage stage) {
        GridPane grid = new GridPane();
        grid.setHgap(30);
        grid.setVgap(50);

        TextField type = new TextField();
        TextField address = new TextField();
        DatePicker date = new DatePicker();
        TextField region = new TextField();
        TextField owner_id = new TextField();
        
        // Convertir l'owner_id en String et l'afficher dans le TextField
        //owner_id.setText(String.valueOf(owner_id));


        Button valid = new Button("Valider");

        valid.setOnAction(
            e -> {
                new DeviseOController(type, address, date, region, owner_id);
            }
        );

        Button back = new Button("Retour");

        back.setOnAction(
            e -> {
                new SignIn(stage);
            }
        );
        
        //place les boutons sur la même horizontale 
        HBox hbox = new HBox(50);
        hbox.getChildren().addAll(back, valid);

        grid.add(new Label("Veuillez saisir le type d'objet que vous avez perdu"), 0, 0);
        grid.add(new Label("Veuillez saisir l'adresse mac de l'objet"), 0, 1);
        grid.add(new Label("Veuillez choisir la date de perte de votre objet"), 0, 2);
        grid.add(new Label("Veuillez saisir le nom de la zone où vous avez perdu l'objet(ville)"), 0, 3);
        grid.add(new Label("Veuillez saisir votre identifiant dans l'application"), 0, 4);
        grid.add(type, 2, 0);
        grid.add(address, 2, 1);
        grid.add(date, 2, 2);
        grid.add(region, 2, 3);
        grid.add(owner_id, 2, 4);
        grid.add(hbox, 0, 6);

        scene = new Scene(grid);
        stage.setScene(scene);
        stage.setWidth(700);
        stage.setHeight(700);
        stage.setTitle("Fiche d'enrégistrement");
        stage.show();
    }
}
