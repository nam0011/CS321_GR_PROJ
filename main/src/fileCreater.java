package com.company;

import com.company.IngredientItem;

import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class fileCreater {

    private FileWriter file;



    private File outJSONFile;
    private final LinkedList<IngredientItem> ingredients = new LinkedList<>();
    //private IngredientItem tempItem = new IngredientItem();

    public fileCreater(){

    }

    /**
     * METHOD TO SET THE FILE TO WRITTEN TOO
     */
    public void setWriteFile(){
        System.out.println("Please enter the file name:");
        {
            try {
                file = new FileWriter(getInput());
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

}
