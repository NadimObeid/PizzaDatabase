package org.pizzaCO.parser;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Ingredient {
    private String Name;
    private String Type;
    private double Price;
    private double Weight;
    private String Origin;
    private String CanCauseAllergy;
    private String TypeOfAllergy;
    private String Temperature;
    private LocalDate ExpDate;
    private List<String> att;

    public Ingredient(String attributes) {
        List<String> att = Arrays.stream(attributes.split(",", -1)).toList();
        setName(att.get(0));
        setType(att.get(1));
        setPrice(!Objects.equals(att.get(2), "") ?Double.parseDouble(att.get(2)):0);
        setWeight(!Objects.equals(att.get(3), "") ?Double.parseDouble(att.get(3)):0);
        setOrigin(att.get(4));
        setCanCauseAllergy(att.get(5));
        setTypeOfAllergy(att.get(6));
        setTemperature(att.get(7));
        setExpDate(att.get(8));


    }



    public void setName(String name) {
        Name = !Objects.equals(name, "") ?name:"No Name";
    }

    public void setType(String type) {
        Type = !Objects.equals(type, "") ?type:"Unknown";
    }

    public void setCanCauseAllergy(String canCauseAllergy) {
        CanCauseAllergy = canCauseAllergy;
    }

    public void setPrice(double price) {
        Price = Math.max(0,price);
    }

    public void setWeight(double weight) {
        Weight = Math.max(0,weight);
    }

    public void setOrigin(String origin) {
        Origin = !Objects.equals(origin, "") ?origin:"Unknown";
    }

    public void setTypeOfAllergy(String typeOfAllergy) {
        TypeOfAllergy = !Objects.equals(typeOfAllergy, "") ?typeOfAllergy:"Unknown";
    }

    public void setTemperature(String temperature) {
        Temperature = temperature;
    }

    public void setExpDate(String expDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMM uuuu");
        ExpDate = expDate==""?LocalDate.now():LocalDate.parse(expDate,formatter);
    }

    public String getName() {
        return Name;
    }

    public String getType() {
        return Type;
    }

    public double getPrice() {
        return Price;
    }

    public double getWeight() {
        return Weight;
    }

    public String getOrigin() {
        return Origin;
    }

    public String getCanCauseAllergy() {
        return CanCauseAllergy;
    }

    public String getTypeOfAllergy() {
        return TypeOfAllergy;
    }

    public String getTemperature() {
        return Temperature;
    }

    public LocalDate getExpDate() {
        return ExpDate;
    }

    @Override
    public String toString() {
        return att.toString();
    }
}
