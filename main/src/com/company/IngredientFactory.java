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


    public void startFactory(ArrayList<ArrayList<String>> ingredientStrings){
        for(int i = 0; i<ingredientStrings.size(); i++){
            IngredientItem temp = new IngredientItem(ingredientStrings.get(i));
            this.list.add(temp);
        }
    }
}
