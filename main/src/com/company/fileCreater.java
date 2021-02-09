package com.company;


import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class fileCreater {

    private FileWriter file;
    private final LinkedList<IngredientItem> ingredients = new LinkedList<>();
    private final LinkedList<Recipe> recipes = new LinkedList<>();
    private Recipe tempRecipe;
    private IngredientItem tempItem = new IngredientItem();

    public fileCreater(){

    }


    /**
     * METHOD TO SET THE FILE TO WRITTEN TOO
     */
    public void setWriteFile(){
        //System.out.println("Please enter the file name:");
        {
            try {
                this.file = new FileWriter("recipes.json");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Method to get a line of input from user
     * @return
     */
    private String getInput(){
        Scanner userInput = new Scanner(System.in);

        return userInput.nextLine();
    }

    /**
     * Method to run in IDE or terminal to manually build json file for later use
     */
    public void setupRecipesManually(){
        boolean finished = false;

        while(finished == false){

            tempRecipe = new Recipe();

            System.out.println("Recipe Name:");
            tempRecipe.setName(getInput());

            boolean done = false;
            while(done == false){
                RecipeItem temp = new RecipeItem();

                System.out.println("Recipe Item Name:");
                temp.setIngredientName(getInput());

                System.out.println("Portion Amount:");
                temp.setPortionAmount(Double.parseDouble(getInput()));

                System.out.println("Measurement Unit:");
                temp.setMeasurementUnit(getInput());

                tempRecipe.addRecipeItem(temp);

                System.out.println("Recipe Item Added to List");
                System.out.println("Do you have another one? y or n");
                if(getInput().equals("n")) break;
                else System.out.println("\n");
            }

            System.out.println("Enter the Directions without hitting Enter");
            tempRecipe.setDirections(getInput());

            recipes.add(tempRecipe);
            System.out.println("Recipe Added");

            System.out.println("Do you have another one? y or n");
            if(getInput().equals("n")){
                break;
            }else System.out.println("\n\n\n **********************************************************************\n");
        }
    }

    /**
     * Method to create a new file in the format for reading from in the future.
     * Will be useful with storing future entries
     * @throws IOException incase of the file having errors being written to
     */
    public void createRecipeFile(ArrayList<Recipe> x) throws IOException {
        System.out.println("I am creating the File Now");

        this.file.write("{\n" +
                "\n" +
                "\"Recipes\":[\n");

        for (int i = 0; i < x.size(); i++) {
            System.out.println(new StringBuilder().append("Adding Recipe ").
                    append(x.get(i).getName()).append(" to JSON File Next").toString());

            if(i != x.size() - 1){
                this.file.write(x.get(i).recipeToString() + ",");
            }else {
                this.file.write(x.get(i).recipeToString());
            }
            System.out.println(new StringBuilder().append("Just added ").
                    append(x.get(i).getName()).append(" to the JSON file.").toString());
        }

        this.file.write("\n\n]\n}");
        this.file.close();

    }



    /**
     * Method to run in IDE or terminal to manually build json file for later use
     */
    public void setupIngredientsManually(){
        boolean finished = false;

        IngredientItem tempItem;

        while(finished == false){

            tempItem = new IngredientItem();

            System.out.println("Ingredient Name:");
            tempItem.setName(getInput());

            System.out.println("Ingredient Type (Dry or Wet):");
            tempItem.setType(getInput());

            System.out.println("Cost (00.00):");
            tempItem.setCost(Double.parseDouble(getInput()));

            System.out.println("Weight (00.00):");
            tempItem.setWeight(Double.parseDouble(getInput()));

            System.out.println("Quantity on Hand (00.00):");
            tempItem.setQuantityOnHand(Double.parseDouble(getInput()));

            addIngredient(tempItem);
            System.out.println("Ingredient Added to List");
            System.out.println("Do you have another one? y or n");
            if(getInput().equals("n")){
                break;
            }else System.out.println("\n\n\n **********************************************************************\n");
        }
    }

    /**
     * Method to create a new file in the format for reading from in the future.
     * Will be useful with storing future entries
     * @throws IOException incase of the file having errors being written to
     */
    public void createIngredientFile() throws IOException {
        System.out.println("I am creating the File Now");
        file.write("{\n" +
                "\n" +
                "\"Ingredients\":[\n");

        ListIterator<IngredientItem> itr = ingredients.listIterator();
        IngredientItem tempItem;

        while(itr.hasNext()){
            tempItem = new IngredientItem();
            tempItem = itr.next();
            System.out.println("Adding Ingredient to Txt File Next");
            file.write(IngredientString(tempItem));
            System.out.println("Just added " + tempItem.getName() + " to the txt file.");

        }
        System.out.println("While Loop finished.");


        file.write("\n\n]}");
        file.close();
    }

    /**
     * Method to create a string that has the format of the file and the data to store
     * @param tempItem is the individual ingredient being formatted to a single string
     * @return the ingredient as a string
     */
    private String IngredientString(IngredientItem tempItem){
        String temp  = ("{\"name\" : \"" + tempItem.getName() + "\", \"type\" : \"" +
                tempItem.getType() + "\", \"cost\" : \"" +
                tempItem.getCost() + "\", \"weight\" : \"" +
                tempItem.getWeight() + "\", \"onHand\" : \"" +
                tempItem.getQuantityOnHand() + "\"},\n");

        return temp;
    }

    /**
     * method is private and used dr
     * @param x
     */
    private void addIngredient(IngredientItem x){
        ingredients.add(x);
    }

}
