package com.tpobjetperdu.controller;

import com.tpobjetperdu.model.Owner;

import javafx.scene.control.TextField;

public class OwnerController {
    public OwnerController(TextField name, TextField number, TextField email) {
        String O_name = name.getText();
        String O_number = number.getText();
        String O_email = email.getText();


        Owner owner = new Owner(O_name, O_number, O_email);


        if (owner.save() == 0) {
            System.out.println("Vous avez été enrégistré!");
        } else {
            System.out.println("Echec de votre enrégistrement!");
        }
    }
}
