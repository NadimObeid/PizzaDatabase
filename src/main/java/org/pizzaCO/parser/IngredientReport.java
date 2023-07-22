package org.pizzaCO.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class IngredientReport {
    private final List<Ingredient> ingredientList;
    public IngredientReport(String filePath){
         ingredientList = new InventoryParser(filePath).readFile().stream().map(Ingredient::new).toList();
    }

    public Ingredient get(int i) {
        return ingredientList.get(i);
    }
    public String getMostExpensiveIngredient(){
        ArrayList<String> names = new ArrayList<>( ingredientList.stream().collect(Collectors.toMap(
                n -> n.getPrice()/n.getWeight(), Ingredient::getName,(oldValue, newValue) -> oldValue,TreeMap::new
        )).values());
        return names.get(names.size()-1);
    }
    public String getClosestExpiryDate(){
        ArrayList<String> names = new ArrayList<>( ingredientList.stream().collect(Collectors.toMap(
                Ingredient::getExpDate, Ingredient::getName,(oldValue, newValue) -> oldValue,TreeMap::new
        )).values());
        return names.get(0);
    }
    public Double getTotalPrice(){
        return ingredientList.stream().map(Ingredient::getPrice).reduce(0.0, Double::sum);
    }
}
