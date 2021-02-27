package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

public class IngredientFactory {

    private LinkedList<IngredientItem> list;

    public IngredientFactory() {
        this.list = new LinkedList<>();
    }

    public LinkedList<IngredientItem> getList() {
        return list;
    }

    public LinkedList<IngredientItem> startFactory(ArrayList<String> ingredientStrings){

    }
}
