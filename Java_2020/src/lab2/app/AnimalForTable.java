package lab2.app;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import lab2.animals.Animal;

public class AnimalForTable {
    private final SimpleIntegerProperty id;
    private final SimpleStringProperty name;
    private final SimpleStringProperty type;
    private final SimpleFloatProperty weight;
    private final SimpleIntegerProperty age;

    public AnimalForTable(int id, String name, String type, float weight, int age)
    {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.type = new SimpleStringProperty(type);
        this.weight = new SimpleFloatProperty(weight);
        this.age = new SimpleIntegerProperty(age);
    }

    public AnimalForTable(Animal animal)
    {
        this.id = new SimpleIntegerProperty(animal.getId());
        this.name = new SimpleStringProperty(animal.getName());
        this.type = new SimpleStringProperty(animal.getType());
        this.weight = new SimpleFloatProperty(animal.getWeight());
        this.age = new SimpleIntegerProperty(animal.getAge());
    }

    public String getName() {
        return name.get();
    }

    public String getType() {
        return type.get();
    }

    public float getWeight() {
        return weight.get();
    }

    public int getAge() {
        return age.get();
    }


    public int getId() {
        return id.get();
    }

}
