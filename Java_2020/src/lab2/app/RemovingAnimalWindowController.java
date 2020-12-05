package lab2.app;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import lab2.animals.ColdBlooded;
import lab2.animals.Feathered;
import lab2.animals.Ungulates;
import lab2.animals.Waterfowl;
import lab2.aviaries.AquariumAviary;
import lab2.aviaries.InfraredLightedAviary;
import lab2.aviaries.MeshAviary;
import lab2.aviaries.OpenAirAviary;
import lab2.main.Main;

import java.util.ArrayList;

public class RemovingAnimalWindowController {

    static public String currentTypeAviaries = null;

    @FXML
    private ComboBox<String> chooseAviary;

    @FXML
    private Button removeAnimalButton;

    @FXML
    private ComboBox<String> chooseAnimal;

    @FXML
    private ComboBox<String> chooseTypeAviary;

    @FXML
    void clearAllComboBox()
    {
        chooseAnimal.getItems().clear();
        chooseAviary.getItems().clear();
    }

    @FXML
    void getFirstState()
    {
        String type = chooseTypeAviary.getValue();
        if (type!=null) {
            clearAllComboBox();
            currentTypeAviaries = type;
            switch (currentTypeAviaries) {
                case "Aquarium":
                    ObservableList<String> AquariumAviariesList =
                            FXCollections.observableArrayList(Main.db.getNamesAquariumList());
                    chooseAviary.getItems().addAll(AquariumAviariesList);
                    break;
                case "Open air":
                    ObservableList<String> OpenAirAviariesList =
                            FXCollections.observableArrayList(Main.db.getNamesOpenAirList());
                    chooseAviary.getItems().addAll(OpenAirAviariesList);
                    break;
                case "Mesh":
                    ObservableList<String> MeshAviariesList =
                            FXCollections.observableArrayList(Main.db.getNamesMeshList());
                    chooseAviary.getItems().addAll(MeshAviariesList);
                    break;
                case "Infrared lighted":
                    ObservableList<String> InfraredLightedAviariesList =
                            FXCollections.observableArrayList(Main.db.getNamesInfraredLightedList());
                    chooseAviary.getItems().addAll(InfraredLightedAviariesList);
                    break;
                default:
                    break;
            }
        }
    }

    @FXML
    void getSecondState()
    {
        String aviary = chooseAviary.getValue();
        if (aviary!=null) {
            switch (currentTypeAviaries) {
                case "Aquarium":
                    AquariumAviary tmp1 = Main.db.getAviary(Main.db.arrayAquariumAviary, aviary);
                    ArrayList<Waterfowl> waterfowlList = tmp1.getArray();
                    ArrayList<String> waterfowlAnimals = new ArrayList<String>();
                    for (Waterfowl waterfowl : waterfowlList) {
                        waterfowlAnimals.add("Id: " + waterfowl.getId() + " name: " + waterfowl.getName());
                    }
                    ObservableList<String> AquariumAnimalsList =
                            FXCollections.observableArrayList(waterfowlAnimals);
                    chooseAnimal.setItems(AquariumAnimalsList);
                    break;
                case "Open air":
                    OpenAirAviary tmp2 = Main.db.getAviary(Main.db.arrayOpenAirAviary, aviary);
                    ArrayList<Ungulates> ungulatesList = tmp2.getArray();
                    ArrayList<String> ungulatesAnimals = new ArrayList<String>();
                    for (Ungulates ungulates : ungulatesList) {
                        ungulatesAnimals.add("Id: " + ungulates.getId() + " name: " + ungulates.getName());
                    }
                    ObservableList<String> OpenAirAnimalsList =
                            FXCollections.observableArrayList(ungulatesAnimals);
                    chooseAnimal.setItems(OpenAirAnimalsList);
                    break;
                case "Mesh":
                    MeshAviary tmp3 = Main.db.getAviary(Main.db.arrayMeshAviary, aviary);
                    ArrayList<Feathered> featheredList = tmp3.getArray();
                    ArrayList<String> featheredAnimals = new ArrayList<String>();
                    for (Feathered feathered : featheredList) {
                        featheredAnimals.add("Id: " + feathered.getId() + " name: " + feathered.getName());
                    }
                    ObservableList<String> MeshAnimalsList =
                            FXCollections.observableArrayList(featheredAnimals);
                    chooseAnimal.setItems(MeshAnimalsList);
                    break;
                case "Infrared lighted":
                    InfraredLightedAviary tmp4 = Main.db.getAviary(Main.db.arrayInfraredLightedAviary, aviary);
                    ArrayList<ColdBlooded> coldBloodedList = tmp4.getArray();
                    ArrayList<String> coldBloodedAnimals = new ArrayList<String>();
                    for (ColdBlooded coldBlooded : coldBloodedList) {
                        coldBloodedAnimals.add("Id: " + coldBlooded.getId() + " name: " + coldBlooded.getName());
                    }
                    ObservableList<String> InfraredLightedAnimalsList =
                            FXCollections.observableArrayList(coldBloodedAnimals);
                    chooseAnimal.setItems(InfraredLightedAnimalsList);
                    break;
                default:
                    break;
            }
        }
    }
}
