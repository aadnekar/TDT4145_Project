package treningsdagbokApp;

import entityConstructors.LagApparatCtrl;
import entityConstructors.LagTreningsøktCtrl;
import entityConstructors.LagØvelseCtrl;
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
    void addTreningsøkt() {

        int prestasjon = (int)slidepf.getValue();
        int personligForm = (int)slideprest.getValue();

        LagTreningsøktCtrl ctrl = new LagTreningsøktCtrl();
        ctrl.lagTreningsøkt(personligForm, prestasjon);
        ctrl.fullførTreningsøkt();

    }
    @FXML
    void addØvelse() {
        String navn = tfNavnOvelse.getText();
        String beskrivelse = taBeskrivelse.getText();
        int sett = (int)spinnerSett.getValue();
        int kg = (int)spinnerKg.getValue();

        LagØvelseCtrl ctrl = new LagØvelseCtrl();
        ctrl.lagØvelse(navn, beskrivelse,kg,sett);
        ctrl.fullførØvelse();
    }

    @FXML
    void addApparat() {
        String navn = tfNavnApparat.getText();
        String beskrivelse = taBeskrivelseApparat.getText();

        LagApparatCtrl ctrl = new LagApparatCtrl();
        ctrl.lagApparat(navn, beskrivelse);
        ctrl.fullførApparat();

    }

    @FXML
    void initialize() {}
}