package org.pizzaCo.parser;

import org.junit.Test;
import org.pizzaCO.parser.Ingredient;
import org.pizzaCO.parser.InventoryParser;
import org.pizzaCO.parser.IngredientReport;


import java.util.List;

import static org.junit.Assert.assertEquals;

public class InventoryParserTest {
    @Test
    public void testReadFile(){
        InventoryParser data = new InventoryParser("/dummyinventory.csv");
        List<String> actual = data.readFile();
        String expected = "Cheese,Classic,8.99,12.5,Italy,No,,2-8°C,20 Apr 1984" ;
        assertEquals(expected,actual.get(0));
    }
    @Test
    public void testListOfIngredients(){
        IngredientReport actual = new IngredientReport("/dummyinventory.csv");
        String expected = "1984-04-20" ;
        assertEquals(expected, actual.get(0).getExpDate().toString());
    }
    @Test
    public void testGetMostExpensiveIngredient(){
        IngredientReport actual = new IngredientReport("/dummyinventory.csv");
        String expected = "Shrimp;Calamari;Mussels";
        assertEquals(expected, actual.getMostExpensiveIngredient());
    }
    @Test
    public void testGetTotalPrice(){
        IngredientReport actual = new IngredientReport("/dummyinventory.csv");
        double expected = 1656.61;
        assertEquals(expected, actual.getTotalPrice(),0.0001);
    }
    @Test
    public void testGetClosestExpiryDate(){
        IngredientReport actual = new IngredientReport("/dummyinventory.csv");
        String expected = "Shrimp;Calamari;Mussels";
        assertEquals(expected, actual.getClosestExpiryDate());
    }
}
