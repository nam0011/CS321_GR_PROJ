package com.company;

/**
 * @author Cody Bracewell
 * CS321-03
 * Recipe Item Object Class
 */


public class RecipeItem {

    private String ingredientName = ""; //The recipe items reference to the ingredient name
    private String measurementUnit = "";    //The measurement of the recipe item
    private double portionAmount = 0.0; //The amount of the ingredient the recipe calls for


//****Constructors, Getters, and Setters Below************************/
    /**
     * Constructor with no parameters
     */
    public RecipeItem() {
    }

    /**
     * Constructor with one parameters
     * @param ingredientName ingredient name being passed in
     */
    public RecipeItem(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    /**
     * Constructor with two parameters
     * @param ingredientName ingredient name being passed in
     * @param measurementUnit measurement unit being passed in
     */
    public RecipeItem(String ingredientName, String measurementUnit) {
        this.ingredientName = ingredientName;
        this.measurementUnit = measurementUnit;
    }

    /**
     * Constructor with three parameters
     * @param ingredientName ingredient name being passed in
     * @param measurementUnit measurement unit being passed in
     * @param portionAmount portion amount being passed in
     */
    public RecipeItem(String ingredientName, String measurementUnit, double portionAmount) {
        this.ingredientName = ingredientName;
        this.measurementUnit = measurementUnit;
        this.portionAmount = portionAmount;
    }

    /**
     * Method to get the ingredient name for the recipe item
     * @return the ingredient name of the recipe item
     */
    public String getIngredientName() {
        return ingredientName;
    }

    /**
     * Method to set the ingredient name for the recipe item
     * @param ingredientName the ingredient name being passed in
     */
    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    /**
     * Method to get the measurement unit for the recipe item
     * @return the measurement unit of the recipe item
     */
    public String getMeasurementUnit() {
        return measurementUnit;
    }

    /**
     * Method to set the measurement unit for the recipe item
     * @param measurementUnit the measurement unit being passed in
     */
    public void setMeasurementUnit(String measurementUnit) {
        this.measurementUnit = measurementUnit;
    }

    /**
     * Method to get the portion amount
     * @return the portion amount of the recipe item
     */
    public double getPortionAmount() {
        return portionAmount;
    }

    /**
     * Method to set portion amount for the recipe item
     * @param portionAmount the portion amount being passed in
     */
    public void setPortionAmount(double portionAmount) {
        this.portionAmount = portionAmount;
    }
}
