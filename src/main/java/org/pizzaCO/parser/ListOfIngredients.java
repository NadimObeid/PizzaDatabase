package org.pizzaCO.parser;

import java.util.List;

public class ListOfIngredients {
    private List<Ingredient> ingredientList;
    public ListOfIngredients(String filePath){
        List<Ingredient> ingredientList = new InventoryParser(filePath).readFile().stream().map(Ingredient::new).toList();
    }

    public Ingredient get(int i) {
        return ingredientList.get(i);
    }
}
