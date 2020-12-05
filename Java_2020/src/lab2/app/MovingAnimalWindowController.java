package lab2.app;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import lab2.animals.*;
import lab2.aviaries.AquariumAviary;
import lab2.aviaries.InfraredLightedAviary;
import lab2.aviaries.MeshAviary;
import lab2.aviaries.OpenAirAviary;
import lab2.main.Logger;
import lab2.main.Main;

import java.util.ArrayList;

public class MovingAnimalWindowController {

    static public String currentTypeAviaries = null;
    private ObservableList<AnimalForTable> animalData = FXCollections.observableArrayList();
    private AquariumAviary aquariumFrom = null;
    private OpenAirAviary openAirFrom = null;
    private MeshAviary meshAviaryFrom = null;
    private InfraredLightedAviary infraredLightedFrom = null;
    private AquariumAviary aquariumTo = null;
    private OpenAirAviary openAirTo = null;
    private MeshAviary meshAviaryTo = null;
    private InfraredLightedAviary infraredLightedTo = null;
    private Waterfowl curWaterfowl = null;
    private Ungulates curUngulates = null;
    private Feathered curFeathered = null;
    private ColdBlooded curColdBlooded = null;

    @FXML
    private ComboBox<String> movingAnimalTo;

    @FXML
    private Button moveAnimalButton;

    @FXML
    private ComboBox<String> movingAnimalFrom;

    @FXML
    private ComboBox<String> animalComboBox;

    @FXML
    void clearAllComboBox()
    {
        movingAnimalTo.getItems().clear();
        animalComboBox.getItems().clear();
    }
    @FXML
    void getFirstState()
    {
        String aviary = movingAnimalFrom.getValue();
        if (aviary!=null) {
            movingAnimalTo.getItems().clear();
            animalComboBox.getItems().clear();
            currentTypeAviaries = getTypeAndAviary(aviary, true);
            switch (currentTypeAviaries) {
                case "Aquarium":
                    ObservableList<String> AquariumAviariesList =
                            FXCollections.observableArrayList(Main.db.getNamesAquariumList());
                    movingAnimalTo.getItems().addAll(AquariumAviariesList);
                    AquariumAviary tmp1 = Main.db.getAviary(Main.db.arrayAquariumAviary, aviary);
                    ArrayList<Waterfowl> waterfowlList = tmp1.getArray();
                    ArrayList<String> waterfowlAnimals = new ArrayList<String>();
                    for (Waterfowl waterfowl : waterfowlList) {
                        waterfowlAnimals.add("Id: " + waterfowl.getId() + " name: " + waterfowl.getName());
                    }
                    ObservableList<String> AquariumAnimalsList =
                            FXCollections.observableArrayList(waterfowlAnimals);
                    animalComboBox.setItems(AquariumAnimalsList);
                    break;
                case "Open air":
                    ObservableList<String> OpenAirAviariesList =
                            FXCollections.observableArrayList(Main.db.getNamesOpenAirList());
                    movingAnimalTo.getItems().addAll(OpenAirAviariesList);
                    OpenAirAviary tmp2 = Main.db.getAviary(Main.db.arrayOpenAirAviary, aviary);
                    ArrayList<Ungulates> ungulatesList = tmp2.getArray();
                    ArrayList<String> ungulatesAnimals = new ArrayList<String>();
                    for (Ungulates ungulates : ungulatesList) {
                        ungulatesAnimals.add("Id: " + ungulates.getId() + " name: " + ungulates.getName());
                    }
                    ObservableList<String> OpenAirAnimalsList =
                            FXCollections.observableArrayList(ungulatesAnimals);
                    animalComboBox.setItems(OpenAirAnimalsList);
                    break;
                case "Mesh":
                    ObservableList<String> MeshAviariesList =
                            FXCollections.observableArrayList(Main.db.getNamesMeshList());
                    movingAnimalTo.getItems().addAll(MeshAviariesList);
                    MeshAviary tmp3 = Main.db.getAviary(Main.db.arrayMeshAviary, aviary);
                    ArrayList<Feathered> featheredList = tmp3.getArray();
                    ArrayList<String> featheredAnimals = new ArrayList<String>();
                    for (Feathered feathered : featheredList) {
                        featheredAnimals.add("Id: " + feathered.getId() + " name: " + feathered.getName());
                    }
                    ObservableList<String> MeshAnimalsList =
                            FXCollections.observableArrayList(featheredAnimals);
                    animalComboBox.setItems(MeshAnimalsList);
                    break;
                case "Infrared lighted":
                    ObservableList<String> InfraredLightedAviariesList =
                            FXCollections.observableArrayList(Main.db.getNamesInfraredLightedList());
                    movingAnimalTo.getItems().addAll(InfraredLightedAviariesList);
                    InfraredLightedAviary tmp4 = Main.db.getAviary(Main.db.arrayInfraredLightedAviary, aviary);
                    ArrayList<ColdBlooded> coldBloodedList = tmp4.getArray();
                    ArrayList<String> coldBloodedAnimals = new ArrayList<String>();
                    for (ColdBlooded coldBlooded : coldBloodedList) {
                        coldBloodedAnimals.add("Id: " + coldBlooded.getId() + " name: " + coldBlooded.getName());
                    }
                    ObservableList<String> InfraredLightedAnimalsList =
                            FXCollections.observableArrayList(coldBloodedAnimals);
                    animalComboBox.setItems(InfraredLightedAnimalsList);
                    break;
                default:
                    break;
            }
        }


    }

    @FXML void move()
    {
        if (animalComboBox.getValue()!=null && movingAnimalTo.getValue()!=null
        && movingAnimalFrom.getValue()!=null) {
        String aviaryTo = movingAnimalTo.getValue();
        getTypeAndAviary(aviaryTo, false);
        int id = Integer.parseInt(animalComboBox.getValue().split(" ")[1]);
            if (currentTypeAviaries!=null)
                switch (currentTypeAviaries){
                    case "Aquarium":
                        aquariumFrom.getById(id).move(aquariumTo);
                       break;
                    case "Open air":
                        openAirFrom.getById(id).move(openAirTo);
                        break;
                    case "Mesh":
                        meshAviaryFrom.getById(id).move(meshAviaryTo);
                         break;
                    case "Infrared lighted":
                        infraredLightedFrom.getById(id).move(infraredLightedTo);
                        break;
                    default:
                        break;
                }
            Stage stage = (Stage)moveAnimalButton.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    void initialize()
    {
        ObservableList<String> InfraredLightedAviariesList =
                FXCollections.observableArrayList(Main.db.getAllNamesAviaries());
        movingAnimalFrom.getItems().addAll(InfraredLightedAviariesList);
    }

    String getTypeAndAviary(String name, boolean fromOrTo)
    {
        for (int i = 0; i < Main.db.getNamesAquariumList().size(); i++)
        {
            if(Main.db.getNamesAquariumList().get(i).equals(name)) {
                if(fromOrTo)
                aquariumFrom = Main.db.arrayAquariumAviary.get(i);
                else
                    aquariumTo = Main.db.arrayAquariumAviary.get(i);
                return "Aquarium";
            }
        }
        for (int i = 0; i < Main.db.getNamesOpenAirList().size(); i++)
        {
            if(Main.db.getNamesOpenAirList().get(i).equals(name)) {
                if(fromOrTo)
                openAirFrom = Main.db.arrayOpenAirAviary.get(i);
                else
                    openAirTo = Main.db.arrayOpenAirAviary.get(i);
                return "Open air";
            }
        }
        for (int i = 0; i < Main.db.getNamesMeshList().size(); i++)
        {
            if(Main.db.getNamesMeshList().get(i).equals(name)) {
                if(fromOrTo)
                meshAviaryFrom = Main.db.arrayMeshAviary.get(i);
                else
                    meshAviaryTo = Main.db.arrayMeshAviary.get(i);
                return "Mesh";
            }
        }
        for (int i = 0; i < Main.db.getNamesInfraredLightedList().size(); i++)
        {
            if(Main.db.getNamesInfraredLightedList().get(i).equals(name)) {
                if(fromOrTo)
                infraredLightedFrom = Main.db.arrayInfraredLightedAviary.get(i);
                else
                    infraredLightedTo = Main.db.arrayInfraredLightedAviary.get(i);
                return "Infrared lighted";
            }
        }
        return null;
    }

}
