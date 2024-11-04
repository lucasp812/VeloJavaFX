package application;

import java.io.InputStream;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class VueController {

  @FXML
  private ImageView imageVeloVille;

  @FXML
  private ImageView imageVeloCourse;

  @FXML
  private ImageView imageVeloSel;

  @FXML
  private Label prixTotal;

  static Velo veloSel = null;
 static ComboBox<Option> comboOptions2 = null;
  static ComboBox<Option> comboOptions = null;

  public void SwitchVue(MouseEvent e) {
      try {
          Parent rootFXML = FXMLLoader.load(getClass().getResource("vue2.fxml"));

          Scene sceneFXML = new Scene(rootFXML);
          Stage stage = (Stage) ((ImageView) e.getSource()).getScene().getWindow();
          stage.setTitle("Velo");
          stage.setScene(sceneFXML);

          comboOptions = (ComboBox<Option>) rootFXML.lookup("#comboOptions");
          if (comboOptions != null) {
              ObservableList<Option> optionsList = FXCollections.observableArrayList(
                  new Couleur("Couleur personnalisée", 10, "Rouge métallisé"),
                  new Couleur("Couleur personnalisée", 10, "Bleu"),
                  new Couleur("Couleur personnalisée", 12, "Vert")
              );
              comboOptions.setItems(optionsList);
          }

          comboOptions2 = (ComboBox<Option>) rootFXML.lookup("#comboOptions2");
          if (comboOptions2 != null) {
              ObservableList<Option> optionsList2 = FXCollections.observableArrayList(
                  new Taille("Taille personnalisée", 10, "Taille enfant"),
                  new Taille("Taille personnalisée", 11, "Taille moyenne"),
                  new Taille("Taille personnalisée", 12, "Taille grande")
              );
              comboOptions2.setItems(optionsList2); 
          }

          ImageView imageVeloSel = (ImageView) rootFXML.lookup("#imageVeloSel");
          Class<?> clazz = this.getClass();
          InputStream input2 = null;

          if (imageVeloSel != null) {
              if (e.getSource() == imageVeloVille) {
                  input2 = clazz.getResourceAsStream("../img/ville.jpg");
                  veloSel = new Velo("Ville", 250);  
              } else if (e.getSource() == imageVeloCourse) {
                  input2 = clazz.getResourceAsStream("../img/course.jpg");
                  veloSel = new Velo("Course", 120);  
              }

              if (input2 != null) {
                  Image image = new Image(input2);
                  imageVeloSel.setImage(image);
              }
          }

          stage.show();
      } catch (Exception e1) {
          e1.printStackTrace();
      }
  }

  public void CalculerPrix(ActionEvent e) {
      if (veloSel == null) {
          prixTotal.setText("Erreur : Aucun vélo sélectionné.");
          return;
      }

      double prixTotalVelo = veloSel.getPrixVelo(); 
      double prixTotalOptions = 0;

      if (comboOptions != null && comboOptions.getValue() != null) {
          prixTotalOptions += comboOptions.getValue().getPrixOption();
      } else {
          System.out.println("Erreur : Option de couleur non sélectionnée.");
      }

      if (comboOptions2 != null && comboOptions2.getValue() != null) {
          prixTotalOptions += comboOptions2.getValue().getPrixOption();
      } else {
          System.out.println("Erreur : Option de taille non sélectionnée.");
      }

      double prixFinal = prixTotalVelo + prixTotalOptions;
      prixTotal.setText("Prix Total: " + prixFinal + " €");
  }
}
