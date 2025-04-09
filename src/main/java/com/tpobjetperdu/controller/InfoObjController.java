package com.tpobjetperdu.controller;

import com.tpobjetperdu.model.DeviseO;
import javafx.scene.control.TextField;

public class InfoObjController {
    public InfoObjController(TextField type, TextField address) {
        String O_type = type.getText();
        String O_address = address.getText();


        DeviseO devise = new DeviseO(O_type, O_address);


        if (devise.verify(O_type, O_address) == 0) {
            System.out.println("L'objet se trouve dans la base de données!");
        } else {
            System.out.println("L'objet ne se trouve pas dans la base de données!");
        }
    }
}
