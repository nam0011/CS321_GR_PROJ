package com.company;

import java.util.ArrayList;

public class Ingredient<date> {

    private double cost;    //The last known purchase amount.
    private double quantityOnHand;  //The amount on hand. Double so that it can be many different measurements
    private date lastUsedDate;  /*The last time the ingredient was used in a recipe, may be used to alert other
            Warnings of such as: what is close to expiring or to show frequency of use*/
    private double minimumQuantityOnHand;   //The minimum amount that this Ingredient can be before needing to order
    private ArrayList recipesAttached;  //Linked to the Recipes that this Ingredient is used in.

    public Ingredient(double cost){

        this.cost = cost;


    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getQuantityOnHand() {
        return quantityOnHand;
    }

    public void setQuantityOnHand(double quantityOnHand) {
        this.quantityOnHand = quantityOnHand;
    }

    public date getLastUsedDate() {
        return lastUsedDate;
    }

    public void setLastUsedDate(date lastUsedDate) {
        this.lastUsedDate = lastUsedDate;
    }

    public double getMinimumQuantityOnHand() {
        return minimumQuantityOnHand;
    }

    public void setMinimumQuantityOnHand(double minimumQuantityOnHand) {
        this.minimumQuantityOnHand = minimumQuantityOnHand;
    }

    public ArrayList getRecipesAttached() {
        return recipesAttached;
    }

    public void setRecipesAttached(ArrayList recipesAttached) {
        this.recipesAttached = recipesAttached;
    }
}
