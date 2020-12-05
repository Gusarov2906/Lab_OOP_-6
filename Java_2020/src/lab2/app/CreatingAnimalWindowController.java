package lab2.app;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import lab2.animals.ColdBlooded;
import lab2.animals.Feathered;
import lab2.animals.Ungulates;
import lab2.animals.Waterfowl;
import lab2.main.Main;

public class CreatingAnimalWindowController {

    @FXML
    private TextField newAnimalName;

    @FXML
    private ComboBox<String> newAnimalSpecies;

    @FXML
    private Button createAnimalButton;

    @FXML
    private TextField newAnimalType;

    @FXML
    private TextField newAnimalWeight;

    @FXML
    private TextField newAnimalAge;

    @FXML
    private Label errorLabel;
    @FXML
    void createAnimal()
    {
        String weightStr = newAnimalWeight.getText();
        String ageStr = newAnimalAge.getText();
        String name = newAnimalName.getText();
        String type = newAnimalType.getText();
        String species = newAnimalSpecies.getValue();
        if (weightStr != null && ageStr != null && name != null && type != null && species != null) {

            float weight = 0;
            int age = 0;
            try {
                weight = Float.parseFloat(weightStr);
                age = Integer.parseInt(ageStr);
            } catch (Exception e) {
                errorLabel.setText(e.getMessage());
                return;
            }
            if(weight <= 0 || age < 0)
            {
                errorLabel.setText("Invalid values of weight or age");
                return;
            }

            if (species != null)
                switch (species) {
                    case "Waterfowl":
                        if (Waterfowl.defAquariumAviary != Main.db.arrayAquariumAviary.get(0))
                            Waterfowl.defAquariumAviary = Main.db.arrayAquariumAviary.get(0);
                        Waterfowl tmp1 = new Waterfowl(name, type, weight, age);
                        Main.logsWrite("Menu: created new Waterfowl animal: " + tmp1.getId());
                        break;
                    case "Ungulates":
                        if (Ungulates.defOpenAirAviary != Main.db.arrayOpenAirAviary.get(0))
                            Ungulates.defOpenAirAviary = Main.db.arrayOpenAirAviary.get(0);
                        Ungulates tmp2 = new Ungulates(name, type, weight, age);
                        Main.logsWrite("Menu: created new Waterfowl animal: " + tmp2.getId());
                        break;
                    case "Feathered":
                        if (Feathered.defMeshAviary != Main.db.arrayMeshAviary.get(0))
                            Feathered.defMeshAviary = Main.db.arrayMeshAviary.get(0);
                        Feathered tmp3 = new Feathered(name, type, weight, age);
                        Main.logsWrite("Menu: created new Feathered animal: " + tmp3.getId());
                        break;
                    case "Coldblooded":
                        if (ColdBlooded.defInfraredLightedAviary != Main.db.arrayInfraredLightedAviary.get(0))
                            ColdBlooded.defInfraredLightedAviary = Main.db.arrayInfraredLightedAviary.get(0);
                        ColdBlooded tmp4 = new ColdBlooded(name, type, weight, age);
                        Main.logsWrite("Menu: created new ColdBlooded animal: " + tmp4.getId());
                        break;
                    default:
                        break;
                }
            Stage stage = (Stage) createAnimalButton.getScene().getWindow();
            stage.close();
        }
        else {
            errorLabel.setText("fill all fields");
        }
    }

    @FXML
    void initialize()
    {
        errorLabel.setTextFill(Color.RED);
    }
}
