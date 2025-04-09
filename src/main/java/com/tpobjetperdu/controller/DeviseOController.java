package com.tpobjetperdu.controller;

import java.time.LocalDate;

import com.tpobjetperdu.model.DeviseO;

import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class DeviseOController {
    public DeviseOController(TextField type, TextField address, DatePicker date, TextField region, TextField owner_id) {
        String O_type = type.getText();
        String O_address = address.getText();

        LocalDate O_date = date.getValue();

        String O_region = region.getText();
        int O_owner_id = Integer.valueOf(owner_id.getText());

        DeviseO devise = new DeviseO(O_type, O_address, O_date, O_region, O_owner_id);


        if (devise.save() == 0) {
            System.out.println("L'objet a été enrégistré!");
        } else {
            System.out.println("Echec de l'enrégistrement de l'objet!");
        }
    }
}
