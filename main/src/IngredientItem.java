package com.company;

import java.util.Date;

/**
 * @author Cody Bracewell
 * CS321-03
 * Ingredient Item Object Class
 */
public class IngredientItem {

    //Private Variables
    private String name = "";   //What the Ingredient Item is called
    private String type = "";   //What type, Dry or wet
    private String measurementUnit = "";    //The measurement Unit Used: oz, ml, grams
    private double cost = 0.0;  //Cost per oz or ml
    private double weight = 0.0;    //Weights is how per cost, i.e. ground beef cost "$5.50 per 1lb"
    private double quantityOnHand = 0.0;    //Current stock of Ingredient.
    private Date lastUsedDate = null;

//****Decrease and Increase Weight and Quantity On Hand Methods*******/

    /**
     * Method to decrease the Weight of the Ingredient Item
     * @param sub the amount to decrease the Weight passed in
     */
    public void decreaseWeight(double sub){
        this.weight -= sub;
    }

    /**
     * Method to decrease the Quantity on Hand of the Ingredient Item
     * @param sub the amount to decrease the Quantity on Hand passed in
     */
    public void decreaseQuantityOnHand(double sub){
        this.quantityOnHand -= sub;
    }

    /**
     * Method to increase the Weight of the Ingredient Item
     * @param add the amount to increase the Weight passed in
     */
    public void increaseWeight(double add){
        this.weight += add;
    }

    /**
     * Method to increase the Quantity on Hand of the Ingredient Item
     * @param add the amount to increase the Quantity on Hand pass in
     */
    public void increaseQuantityOnHand(double add){
        this.quantityOnHand += add;
    }



//****Constructors, Getters, and Setters Below************************/
    /**
     * Constructor with no parameters
     */
    public IngredientItem(){

    }

    /**
     * Constructor with one parameter
     * @param name the name of the Ingredient Item
     */
    public IngredientItem(String name){
        this.name = name;
    }

    /**
     * Constructor with two parameters
     * @param name the name of the Ingredient Item
     * @param type the type of the Ingredient Item
     */
    public IngredientItem(String name, String type){
        this.name = name;
        this.type = type;
    }

    /**
     * Constructor with three parameters
     * @param name the name of the Ingredient Item
     * @param type the type of the Ingredient Item
     * @param measurementUnit the measurement unit of the Ingredient Item
     */
    public IngredientItem(String name, String type, String measurementUnit){
        this.name = name;
        this.type = type;
        this.measurementUnit = measurementUnit;
    }

    /**
     * Constructor with four parameters
     * @param name the name of the Ingredient Item
     * @param type the type of the Ingredient Item
     * @param measurementUnit the measurement unit of the Ingredient Item
     * @param cost the cost of the Ingredient Item
     */
    public IngredientItem(String name, String type, String measurementUnit, double cost){
        this.name = name;
        this.type = type;
        this.measurementUnit = measurementUnit;
        this.cost = cost;
    }

    /**
     * Constructor with five parameters
     * @param name the name of the Ingredient Item
     * @param type the type of the Ingredient Item
     * @param measurementUnit the measurement unit of the Ingredient Item
     * @param cost the cost of the Ingredient Item
     * @param weight the weight of the Ingredient Item
     */
    public IngredientItem(String name, String type, String measurementUnit, double cost,
                          double weight){
        this.name = name;
        this.type = type;
        this.measurementUnit = measurementUnit;
        this.cost = cost;
        this.weight = weight;
    }

    /**
     * Constructor with six parameters
     * @param name the name of the Ingredient Item
     * @param type the type of the Ingredient Item
     * @param measurementUnit the measurement unit of the Ingredient Item
     * @param cost the cost of the Ingredient Item
     * @param weight the weight of the Ingredient Item
     * @param quantityOnHand the quantity on hand of the Ingredient Item
     */
    public IngredientItem(String name, String type, String measurementUnit, double cost,
                          double weight, double quantityOnHand){
        this.name = name;
        this.type = type;
        this.measurementUnit = measurementUnit;
        this.cost = cost;
        this.weight = weight;
        this.quantityOnHand = quantityOnHand;
    }

    /**
     * Method to Get the Name of the Ingredient Item
     * @return the Ingredient Item's Name
     */
    public String getName() {
        return name;
    }

    /**
     * Method to Set the Name of the Ingredient Item
     * @param name is the Name being passed in
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method to Get the type of the Ingredient Item
     * @return the Ingredient Item's type
     */
    public String getType() {
        return type;
    }

    /**
     * Method to Set the type of the Ingredient Item
     * @param type is the type being passed in
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Method to Get the Measurement Unit of the Ingredient Item
     * @return the Ingredient Item's Measurement Unit
     */
    public String getMeasurementUnit() {
        return measurementUnit;
    }

    /**
     * Method to Set the Measurement Unit of the Ingredient Item
     * @param measurementUnit is the Measurement Unit being passed in
     */
    public void setMeasurementUnit(String measurementUnit) {
        this.measurementUnit = measurementUnit;
    }

    /**
     * Method to Get the Cost of the Ingredient Item
     * @return the Ingredient Item's Cost
     */
    public double getCost() {
        return cost;
    }

    /**
     * Method to Set the Cost of the Ingredient Item
     * @param cost is the Cost being passed in
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * Method to Get the Weight of the Ingredient Item
     * @return the Ingredient Item's Weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Method to Set the Weight of the Ingredient Item
     * @param weight is the Weight being passed in
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Method to Get the Quantity on Hand of the Ingredient Item
     * @return the Ingredient Item's Quantity on Hand Value
     */
    public double getQuantityOnHand() {
        return quantityOnHand;
    }

    /**
     * Method to Set the Quantity on Hand of the Ingredient Item
     * @param quantityOnHand is the Quantity on Hand being passed in
     */
    public void setQuantityOnHand(double quantityOnHand) {
        this.quantityOnHand = quantityOnHand;
    }

    /**
     * Method to get the Last Date the Recipe was last used
     * @return the last used date variable
     */
    public Date getLastUsedDate() {
        return lastUsedDate;
    }

    /**
     * Method to set the last used date variable
     * @param lastUsedDate the date passed in of when the recipe was last used
     */
    public void setLastUsedDate(Date lastUsedDate) {
        this.lastUsedDate = lastUsedDate;
    }


}   //End of IngredientItem
