package lab2.app;

import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import lab2.animals.*;
import lab2.aviaries.AquariumAviary;
import lab2.aviaries.InfraredLightedAviary;
import lab2.aviaries.MeshAviary;
import lab2.aviaries.OpenAirAviary;
import lab2.main.Database;
import lab2.main.Main;

import java.io.IOException;
import java.util.ArrayList;

import static lab2.main.Main.loadFromFile;
import static lab2.main.Main.saveToFile;

public class MainWindowController {

    static public boolean isOpenNewAnimal = false;
    static public boolean isOpenMoveAnimal = false;
    static public boolean isOpenNewAviary = false;
    static public boolean isOpenRemoveAviary = false;
    static public String currentTypeAviaries = null;

    private ObservableList<AnimalForTable> animalData = FXCollections.observableArrayList();

    @FXML
    private Button newAviaryButton;

    @FXML
    private Button newAnimalButton;

    @FXML
    private Button moveAnimalButton;

    @FXML
    private TableView<AnimalForTable> animalTable;

    @FXML
    private TableColumn<AnimalForTable, Integer> animalTableId;

    @FXML
    private TableColumn<AnimalForTable, String> animalTableName;

    @FXML
    private TableColumn<AnimalForTable, String> animalTableType;

    @FXML
    private TableColumn<AnimalForTable, Float> animalTableWeight;

    @FXML
    private TableColumn<AnimalForTable, Integer> animalTableAge;

    @FXML
    private Button reload;

    @FXML
    private ComboBox<String> aviaryChoose;

    @FXML
    private Button removeAnimalButton;
    @FXML
    private ListView<String> aviaryList;

    @FXML
    void openCreatingAviaryWindow()
    {
        if (!isOpenNewAviary) {
            isOpenNewAviary = true;
            openNewWindow("/lab2/app/CreatingAviaryWindow.fxml");
            isOpenNewAviary = false;
        }
    }

    @FXML
    void openCreatingAnimalWindow()
    {
        if (!isOpenNewAnimal) {
            isOpenNewAnimal = true;
            openNewWindow("/lab2/app/CreatingAnimalWindow.fxml");
            isOpenNewAnimal = false;
        }
    }
    @FXML
    void openMovingAnimalWindow()
    {
        if(!isOpenMoveAnimal){
            isOpenMoveAnimal = true;
            openNewWindow("/lab2/app/MovingAnimalWindow.fxml");
            isOpenMoveAnimal = false;
        }
    }

    @FXML
    void openRemovingAnimalWindow()
    {
        if(!isOpenMoveAnimal){
            isOpenRemoveAviary = true;
            openNewWindow("/lab2/app/RemovingAnimalWindow.fxml");
            isOpenRemoveAviary = false;
        }
    }

    @FXML
    void reloadTables()
    {
        String type = aviaryChoose.getValue();
        if (type!=null) {
            aviaryList.getItems().clear();
            currentTypeAviaries = type;
            switch (type) {
                case "Aquarium":
                    ObservableList<String> AquariumAviariesList =
                            FXCollections.observableArrayList(Main.db.getNamesAquariumList());
                    aviaryList.getItems().addAll(AquariumAviariesList);
                    break;
                case "Open air":
                    ObservableList<String> OpenAirAviariesList =
                            FXCollections.observableArrayList(Main.db.getNamesOpenAirList());
                    aviaryList.getItems().addAll(OpenAirAviariesList);
                    break;
                case "Mesh":
                    ObservableList<String> MeshAviariesList =
                            FXCollections.observableArrayList(Main.db.getNamesMeshList());
                    aviaryList.getItems().addAll(MeshAviariesList);
                    break;
                case "Infrared lighted":
                    ObservableList<String> InfraredLightedAviariesList =
                            FXCollections.observableArrayList(Main.db.getNamesInfraredLightedList());
                    aviaryList.getItems().addAll(InfraredLightedAviariesList);
                    break;
                default:
                    break;
            }
        }
    }

    @FXML void showAnimals() {
        String name = aviaryList.getSelectionModel().selectedItemProperty().getValue();
        if (name != null) {
            switch (currentTypeAviaries) {
                case "Aquarium":
                    if (Main.db.getAviary(Main.db.arrayAquariumAviary, name) != null) {
                        animalTable.getItems().clear();
                        AquariumAviary tmp = Main.db.getAviary(Main.db.arrayAquariumAviary, name);
                        ArrayList<Waterfowl> waterfowlList = tmp.getArray();
                        if (waterfowlList!=null) {
                            for (int i = 0; i < waterfowlList.size(); i++) {
                                animalData.add(new AnimalForTable(waterfowlList.get(i)));
                            }
                            animalTable.setItems(animalData);
                        }
                    }
                    break;
                case "Open air":
                    if (Main.db.getAviary(Main.db.arrayOpenAirAviary, name) != null) {
                        animalTable.getItems().clear();
                        OpenAirAviary tmp = Main.db.getAviary(Main.db.arrayOpenAirAviary, name);
                        ArrayList<Ungulates> ungulatesList = tmp.getArray();
                        if (ungulatesList!=null) {
                            for (int i = 0; i < ungulatesList.size(); i++) {
                                animalData.add(new AnimalForTable(ungulatesList.get(i)));
                            }
                            animalTable.setItems(animalData);
                        }
                    }
                    break;
                case "Mesh":
                    if (Main.db.getAviary(Main.db.arrayMeshAviary, name) != null) {
                        animalTable.getItems().clear();
                        MeshAviary tmp = Main.db.getAviary(Main.db.arrayMeshAviary, name);
                        ArrayList<Feathered> featheredList = tmp.getArray();
                        if (featheredList!=null) {
                            for (int i = 0; i < featheredList.size(); i++) {
                                animalData.add(new AnimalForTable(featheredList.get(i)));
                            }
                            animalTable.setItems(animalData);
                        }
                    }
                    break;
                case "Infrared lighted":
                    if (Main.db.getAviary(Main.db.arrayInfraredLightedAviary, name) != null) {
                        animalTable.getItems().clear();
                        InfraredLightedAviary tmp = Main.db.getAviary(Main.db.arrayInfraredLightedAviary, name);
                        ArrayList<ColdBlooded> coldBloodedList = tmp.getArray();
                        if (coldBloodedList!=null) {
                            for (int i = 0; i < coldBloodedList.size(); i++) {
                                animalData.add(new AnimalForTable(coldBloodedList.get(i)));
                            }
                            animalTable.setItems(animalData);
                        }
                    }
                    break;
                default:
                    break;
            }
        }

    }

    @FXML
    public void initialize()
    {
        animalTableId.setCellValueFactory(new PropertyValueFactory<AnimalForTable, Integer>("Id"));
        animalTableName.setCellValueFactory(new PropertyValueFactory<AnimalForTable, String>("Name"));
        animalTableType.setCellValueFactory(new PropertyValueFactory<AnimalForTable, String>("Type"));
        animalTableWeight.setCellValueFactory(new PropertyValueFactory<AnimalForTable, Float>("Weight"));
        animalTableAge.setCellValueFactory(new PropertyValueFactory<AnimalForTable, Integer>("Age"));
        aviaryChoose.setStyle("-fx-font-weight: bold");
    }

    void openNewWindow(String path)
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(path));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

    @FXML
    void loadDB()
    {
        Main.db = loadFromFile("database.txt", Main.db);
    }

    @FXML
    void saveDB()
    {
        saveToFile("database.txt", Main.db);
    }


}
