package com.company;

/**
 *@author Cody Bracewell
 * CS321-03
 * Recipe Object Class
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.ListIterator;

public class Recipe {

    private String name = "";
    private ArrayList<IngredientItem> itemsUsed = new ArrayList<>();    //A collection of the ingredients being
    //referenced in the in the recipeItems list. This will allow
    //for easier viewing to know if the recipe has all of the
    // ingredients.
    //Similar to what a report will need.
    private ArrayList<RecipeItem> recipeItems = new ArrayList<>();  //This will just be like in a recipe,
    //you will have the item name, the measurement unit, and amount.
    private double totalCost = 0.0; //The summed value of the cost of the recipe once used.
    private boolean allIngredientsAvailable;    //Boolean to tell if all the ingredients are available
    private LinkedList<IngredientItem> ingredientItemsRef = new LinkedList<>();
    private Date lastUsedDate = null;

    private String directions = "";


    /**
     * Method to convert the Recipe to a string.
     * @return String value of the combine information of the recipe
     */
    public String recipeToString(){
        String combine = "{\"Recipe Name\"" + " : " + "\"" + this.name + "\" },\n";
        combine += recipeItemsToString();
        combine += "\t{\"Recipe Directions\" : " + "\"" + this.directions + "\"" +"}\n";
        return combine;
    }

    /**
     * Private method to get the recipe items string values, combine them, and return a single string.
     * @return the combined string values of all the recipe items for the recipe.
     */
    private String recipeItemsToString(){

        String combine = "";
        for (int i = 0; i < recipeItems.size(); i++){
            combine = combine +  recipeItems.get(i).recipeItemString() + "\n";
        }// End of For Loop

        return combine;
    }

    /**
     * Method to Check the Availability of Ingredients within the recipe
     * @return a boolean value that sets the All Ingredients Available boolean variable
     */
    public boolean checkIngredientAvailability(){
        ArrayList<Boolean> available = new ArrayList<>();
        ListIterator<Boolean> itrBoolean = available.listIterator();
        ListIterator<RecipeItem> itrRecipeItems = recipeItems.listIterator();

        while(!recipeItems.isEmpty()){  //While loop to iterate over Recipe Items
            //and Compare portion amount to the Ingredients quantity on hand
            if(itrRecipeItems.hasNext()){
                if(itrRecipeItems.next().getPortionAmount() <=
                        searchIngredients(itrRecipeItems.next()).getQuantityOnHand()){
                    available.add(true);
                }   //End of if statement
                else if(itrRecipeItems.next().getPortionAmount() >=
                        searchIngredients(itrRecipeItems.next()).getQuantityOnHand()){
                    available.add(false);
                }   //End of else if statement
            }   //End of if statement
        }   //End of While Loop

        while(!available.isEmpty()){
            if(itrBoolean.hasNext()){
                if(itrBoolean.next().equals(true)){
                    continue;
                }   //End of if statement
                else if(itrBoolean.next().equals(false)){
                    System.out.println("Not Enough Available Ingredients to Complete Recipe");
                    setAllIngredientsAvailable(false);
                    return false;
                }   //End of else if statement
            }   //End of if statement
        }   //End of while loop

        setAllIngredientsAvailable(true);
        return true;
    }
    /**
     * Method to sum the cost of each ingredient to give a total cost
     * @return the summed value of all ingredient's cost
     */
    public double sumTotalCost(){
        ListIterator<IngredientItem> itr = itemsUsed.listIterator();
        double sum = 0.0;
        while(!itemsUsed.isEmpty()){
            if(itr.hasNext() && itr.next().getCost() != 0.0){
                sum += itr.next().getCost();
            }   //End of if statement
            else if(itr.next().getCost() == 0.0){
                System.out.print("No Cost found for Ingredient Item.");
            }   //End of else if statement
        }   //End of While Loop
        return sum;

    }
    /**
     * Method to add an ingredient item to the recipe
     * @param x the ingredient item to added
     */
    private void addIngredientItem(IngredientItem x){
        itemsUsed.add(x);
    }

    /**
     * Method to remove an Ingredient Item from the recipe
     * @param x the ingredient item to be removed
     */
    private void removeIngredientItem(IngredientItem x){
        for(int i = 0; i < itemsUsed.size(); i++){
            if(itemsUsed.get(i).getName().equals(x.getName())){
                itemsUsed.remove(i);
                break;
            }   //End of if statement
        }   //End of for loop
    }   //End of remove recipe item method

    /**
     * Method to add an ingredient item to the recipe
     * @param x the recipe item to added
     */
    public void addRecipeItem(RecipeItem x){
        recipeItems.add(x);
    }   //End of add recipe item method

    /**
     * Method to remove an recipe Item from the recipe
     * @param x the recipe item to be removed
     */
    public void removeRecipeItem(RecipeItem x){
        for(int i = 0; i < recipeItems.size(); i++){
            if(recipeItems.get(i).getIngredientName().equals(x.getIngredientName())){
                removeIngredientItem(searchIngredients(x));
                recipeItems.remove(i);
                break;
            }   //End of if statement
        }   //End of for loop
    }   //End of remove recipe item method

    /**
     * Method to search the Ingredient Items List reference for matching Recipe Items
     * @param x the Recipe Item being searched for
     * @return the Ingredient Item to be added to the Items Used List
     */
    private IngredientItem searchIngredients(RecipeItem x){
        ListIterator<IngredientItem> itr = ingredientItemsRef.listIterator();
        IngredientItem temp = new IngredientItem();

        while(!ingredientItemsRef.isEmpty()){

            if(itr.hasNext()){
                if(itr.next().getName().equals(x.getIngredientName())){
                    temp = itr.next();
                }
            }   //End of if statement
            else if(itr.next() == null){
                System.out.print("No Ingredient Item Found for Recipe Item.");
            }   //End of else if statement
        }   //End of While Loop
        return temp;
    }

//****Constructors, Getters, and Setters Below************************/

    /**
     * Constructor with no parameters
     */
    public Recipe() {
    }

    /**
     * Constructor with one parameter
     * @param name the name of the Recipe being passed in
     */
    public Recipe(String name) {
        this.name = name;
    }

    /**
     * Constructor with two parameters
     * @param name the name of the recipe being passed in
     * @param itemsUsed the list of ingredients used for the recipe
     */
    public Recipe(String name, ArrayList<IngredientItem> itemsUsed) {
        this.name = name;
        this.itemsUsed = itemsUsed;
    }

    /**
     * Constructor with three parameters
     * @param name the name of the recipe being passed in
     * @param itemsUsed the list of ingredients used for the recipe
     * @param recipeItems the list of ingredients and portions used for the recipe
     */
    public Recipe(String name, ArrayList<IngredientItem> itemsUsed, ArrayList<RecipeItem> recipeItems) {
        this.name = name;
        this.itemsUsed = itemsUsed;
        this.recipeItems = recipeItems;
    }

    /**
     * Constructor with four parameters
     * @param name the name of the recipe being passed in
     * @param itemsUsed the list of ingredients used for the recipe
     * @param recipeItems the list of ingredients and portions used for the recipe
     * @param totalCost the total cost of the recipe
     */
    public Recipe(String name, ArrayList<IngredientItem> itemsUsed, ArrayList<RecipeItem> recipeItems,
                  double totalCost) {
        this.name = name;
        this.itemsUsed = itemsUsed;
        this.recipeItems = recipeItems;
        this.totalCost = totalCost;
    }

    /**
     * Constructor with five parameters
     * @param name the name of the recipe being passed in
     * @param itemsUsed the list of ingredients used for the recipe
     * @param recipeItems the list of ingredients and portions used for the recipe
     * @param totalCost the total cost of the recipe
     * @param allIngredientsAvailable the truth value of all ingredient availability passed in
     */
    public Recipe(String name, ArrayList<IngredientItem> itemsUsed, ArrayList<RecipeItem> recipeItems,
                  double totalCost, boolean allIngredientsAvailable) {
        this.name = name;
        this.itemsUsed = itemsUsed;
        this.recipeItems = recipeItems;
        this.totalCost = totalCost;
        this.allIngredientsAvailable = allIngredientsAvailable;
    }

    /**
     * Constructor with six parameters
     * @param name the name of the recipe being passed in
     * @param itemsUsed the list of ingredients used for the recipe
     * @param recipeItems the list of ingredients and portions used for the recipe
     * @param totalCost the total cost of the recipe
     * @param allIngredientsAvailable the truth value of all ingredient availability passed in
     * @param ingredientItemsRef is the reference to the Ingredient Items List passed in
     */
    public Recipe(String name, ArrayList<IngredientItem> itemsUsed, ArrayList<RecipeItem> recipeItems,
                  double totalCost, boolean allIngredientsAvailable, LinkedList<IngredientItem> ingredientItemsRef) {
        this.name = name;
        this.itemsUsed = itemsUsed;
        this.recipeItems = recipeItems;
        this.totalCost = totalCost;
        this.allIngredientsAvailable = allIngredientsAvailable;
        setIngredientItemsRef(ingredientItemsRef);
    }

    /**
     * Method to get the name of the recipe
     * @return the recipe name
     */
    public String getName() {
        return name;
    }

    /**
     * Method to set the name of the recipe
     * @param name the name of the recipe being passed in
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method to get the ingredient items used array list
     * @return the array list of ingredient items used for the recipe
     */
    public ArrayList<IngredientItem> getItemsUsed() {
        return itemsUsed;
    }

    /**
     * Method to set the array list of ingredient items used for the recipe
     * @param itemsUsed the array list of ingredient items for the recipe being passed in
     */
    public void setItemsUsed(ArrayList<IngredientItem> itemsUsed) {
        this.itemsUsed = itemsUsed;
    }

    /**
     * Method to get the recipe items array list of the recipe
     * @return the array list of recipe items for the recipe
     */
    public ArrayList<RecipeItem> getRecipeItems() {
        return recipeItems;
    }

    /**
     * Method to set the array list of recipe items for the recipe
     * @param recipeItems the array list of recipe items of the recipe being passed in
     */
    public void setRecipeItems(ArrayList<RecipeItem> recipeItems) {
        this.recipeItems = recipeItems;
    }

    /**
     * Method to get the total cost of the ingredients used in the recipe
     * @return the total cost of the ingredients used in the recipe
     */
    public double getTotalCost() {
        return totalCost;
    }

    /**
     * Method to set the total cost of the ingredients used in the recipe
     * @param totalCost the total cost of the ingredients being passed in
     */
    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    /**
     * Method to check if all the ingredients are available for the recipe
     * @return truth value of true or false
     */
    public boolean isAllIngredientsAvailable() {
        return allIngredientsAvailable;
    }

    /**
     * Method to set all ingredients available to truth value of true or false
     * @param allIngredientsAvailable the truth value being passed in
     */
    public void setAllIngredientsAvailable(boolean allIngredientsAvailable) {
        this.allIngredientsAvailable = allIngredientsAvailable;
    }

    /**
     * Method to set the reference to the Ingredient Items List, inventory
     * @param ingredientItemsRef the Linked List reference being passed in
     */
    private void setIngredientItemsRef(LinkedList<IngredientItem> ingredientItemsRef) {
        this.ingredientItemsRef = ingredientItemsRef;
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

    /**
     * Method to get the Directions for the Recipe
     * @return a string value of the Recipe Directions
     */
    public String getDirections() {
        return directions;
    }

    /**
     * Method to set the Directions for the Recipe
     * @param directions string value passed to set the directions
     */
    public void setDirections(String directions) {
        this.directions = directions;
    }
}
