package lab2.app;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import lab2.aviaries.AquariumAviary;
import lab2.aviaries.InfraredLightedAviary;
import lab2.aviaries.MeshAviary;
import lab2.aviaries.OpenAirAviary;
import lab2.main.Main;

import java.util.ArrayList;

public class CreatingAviaryWindowController {

    @FXML
    private TextField newName;
    @FXML
    private ComboBox<String> newTypeAviary;
    @FXML
    private Button createAviaryButton;
    @FXML
    private Label errorLabel;

    @FXML
    void createAviary()
    {
        String name = newName.getText();
        String type = newTypeAviary.getValue();
        if (type!=null && !name.isEmpty()) {
            switch (type) {
                case "Aquarium":
                    Main.db.arrayAquariumAviary.add(new AquariumAviary(name));
                    Main.logsWrite("Menu: created new AquariumAviary aviary: " + name);
                    break;
                case "Open air":
                    Main.db.arrayOpenAirAviary.add(new OpenAirAviary(name));
                    Main.logsWrite("Menu: created new OpenAirAviary aviary: " + name);
                    break;
                case "Mesh":
                    Main.db.arrayMeshAviary.add(new MeshAviary(name));
                    Main.logsWrite("Menu: created new MeshAviary aviary: " + name);
                    break;
                case "Infrared lighted":
                    Main.db.arrayInfraredLightedAviary.add(new InfraredLightedAviary(name));
                    Main.logsWrite("Menu: created new InfraredLightedAviary aviary: " + name);
                    break;
                default:
                    break;
            }
            Stage stage = (Stage) createAviaryButton.getScene().getWindow();
            stage.close();
        }
        else
        {
            errorLabel.setTextFill(Color.RED);
            errorLabel.setText("fill all fields");
        }
    }

    @FXML
    private void initialize()
    {

    }
}
