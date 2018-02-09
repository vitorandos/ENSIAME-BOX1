/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opisiame.controller.animateur;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.stage.*;
import opisiame.database.Connection_db;

/**
 * FXML Controller class
 *
 * @author Audrey
 */
public class Del_animController implements Initializable {

    @FXML
    private AnchorPane content;

    private List<Integer> liste_supr = new ArrayList<>();

    public void setAnim_id(List liste_id) {
        this.liste_supr = liste_id;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void Confirmer() throws IOException {
        ListIterator<Integer> i = liste_supr.listIterator();
        try {
            Connection connection = Connection_db.getDatabase();
            while (i.hasNext()) {
                int supr = i.next();
                PreparedStatement requette;

                requette = connection.prepareStatement("DELETE FROM animateur WHERE Anim_id = ?");
                requette.setInt(1, supr);
                requette.executeUpdate();

            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        Stage stage = (Stage) content.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void Annuler() throws IOException {
        Stage stage = (Stage) content.getScene().getWindow();
        stage.close();
    }

}
