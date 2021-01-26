package com.company;

import java.util.ArrayList;

public class Ingredient<date> {

    private double cost;    //The last known purchase amount.
    private double quantityOnHand;  //The amount on hand. Double so that it can be many different measurements
    private date expireDate;    //The date the ingredient will expire, also best by date.
    private date purchaseDate;  //The date the ingredient was purchased, May conflict with multiple leftovers...
    private date lastUsedDate;  /*The last time the ingredient was used in a recipe, may be used to alert other
            Warnings of such as: what is close to expiring or to show frequency of use*/
    private double minimumQuantityOnHand;   //The minimum amount that this Ingredient can be before needing to order
    private ArrayList recipesAttached;  //Linked to the Recipes that this Ingredient is used in.

    public Ingredient(double cost, date expDate, date purDate){

        this.cost = cost;
        this.expireDate = expDate;
        this.purchaseDate = purDate;

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

    public date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(date expireDate) {
        this.expireDate = expireDate;
    }

    public date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(date purchaseDate) {
        this.purchaseDate = purchaseDate;
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
