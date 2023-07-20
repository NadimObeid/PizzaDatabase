package org.pizzaCo.parser;

import org.junit.Test;
import org.pizzaCO.parser.Ingredient;
import org.pizzaCO.parser.ListOfIngredients;


import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class InventoryParserTest {
    @Test
    public void testReadFile(){
        ListOfIngredients actual = new ListOfIngredients("/inventory.csv");

        String expected = "[Cheese,Classic,8.99,12.5,Italy,No,,2-8°C,20 Apr 1984]" ;
        assertEquals(expected,actual.get(0).toString());
    }
}
