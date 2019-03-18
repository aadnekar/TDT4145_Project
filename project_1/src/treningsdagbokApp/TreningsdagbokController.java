package treningsdagbokApp;

import entityConstructors.LagApparatCtrl;
import entityConstructors.LagTrenings�ktCtrl;
import entityConstructors.Lag�velseCtrl;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.scene.control.*;
import javafx.scene.control.SpinnerValueFactory;



public class TreningsdagbokController {

    @FXML
    private TextField tfNavnOvelse, tfNavnApparat;

    @FXML
    private TextArea taBeskrivelse, taBeskrivelseApparat, taNotat;

    @FXML
    private Slider slidepf, slideprest;

    @FXML
    private Spinner spinnerKg, spinnerSett;


/*
    public void update() {
        String personligForm;

    }
    */
    @FXML
    void addTrenings�kt() {

        int prestasjon = (int)slidepf.getValue();
        int personligForm = (int)slideprest.getValue();

        LagTrenings�ktCtrl ctrl = new LagTrenings�ktCtrl();
        ctrl.lagTrenings�kt(personligForm, prestasjon);
        ctrl.fullf�rTrenings�kt();

    }
    @FXML
    void add�velse() {
        String navn = tfNavnOvelse.getText();
        String beskrivelse = taBeskrivelse.getText();
        int sett = (int)spinnerSett.getValue();
        int kg = (int)spinnerKg.getValue();

        Lag�velseCtrl ctrl = new Lag�velseCtrl();
        ctrl.lag�velse(navn, beskrivelse,kg,sett);
        ctrl.fullf�r�velse();
    }

    @FXML
    void addApparat() {
        String navn = tfNavnApparat.getText();
        String beskrivelse = taBeskrivelseApparat.getText();

        LagApparatCtrl ctrl = new LagApparatCtrl();
        ctrl.lagApparat(navn, beskrivelse);
        ctrl.fullf�rApparat();

    }

    @FXML
    void initialize() {}
}