package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class IngredientDictionary {

    LinkedList<IngredientItem> ingredientItemLinkedList;

    public IngredientDictionary(LinkedList<IngredientItem> ingredientItemLinkedList) {
        this.ingredientItemLinkedList = ingredientItemLinkedList;
    }

    public LinkedList<IngredientItem> getIngredientItemLinkedList() {
        return ingredientItemLinkedList;
    }

    /**
     * Method allows you to get a single Ingredient Item referenced by name
     * @param ingredientName    Name of the Ingredient Item to returned
     * @return  Returns Ingredient Item Extracted from the Linked List
     */
    public IngredientItem getIngredientItem(String ingredientName){

        IngredientItem tempIngredientItem = null;
        for(int i = 0; i < this.ingredientItemLinkedList.size(); i++){
            if(this.ingredientItemLinkedList.get(i).getName().equals(ingredientName)){
                tempIngredientItem = new IngredientItem(this.ingredientItemLinkedList.get(i));
            }
        }
        return tempIngredientItem;
    }

    /**
     * Method to check if an Ingredient Already Exists in the Linked List
     * @param ingredientItem
     * @return  Boolean Value to be returned to verify the operation succeeded.
     */
    public boolean isIngredient(IngredientItem ingredientItem){
        boolean isIngredient = false;
        for(int i = 0; i < this.ingredientItemLinkedList.size(); i++){
            if(this.ingredientItemLinkedList.get(i).getName().equals(ingredientItem.getName())){
                System.out.println("Found Ingredient");
                isIngredient = true;
            }
        }
        if(isIngredient == false) System.out.println("No Ingredient Found");

        return isIngredient;
    }

    /**
     * Method to Add Ingredient Item to the List,
     * TODO add exception call for when the Ingredient Already Exists in the list
     * @param ingredientItem    The ingredient Item to be added.
     * @return  Boolean Value to be returned to verify the operation succeeded.
     */
    public boolean addIngredientToList(IngredientItem ingredientItem){
        boolean alreadyExists = isIngredient(ingredientItem);
        if(alreadyExists == true) System.out.println("For Add Ingredient");

        if(alreadyExists == false){
            this.ingredientItemLinkedList.add(ingredientItem);
            return true;
        }else {
            System.out.println("Ingredient Already Exists Check for Duplication");
            return false;
        }
    }

    /**
     * Method to Remove the Ingredient from the List
     * TODO add exception for when the Ingredient Does Not exist in the list.
     * @param ingredientItem    The ingredient Item to be removed from the list.
     * @return  Boolean Value to be returned to verify the operation succeeded.
     */
    public void removeIngredientFromList(IngredientItem ingredientItem){
        boolean exists = isIngredient(ingredientItem);

        if(exists == true) {
            for (int i = 0; i < this.ingredientItemLinkedList.size(); i++) {
                if (this.ingredientItemLinkedList.get(i).getName().equals(ingredientItem.getName())) {
                    this.ingredientItemLinkedList.remove(i);
                    System.out.println("Ingredient Should have Been Removed");
                }
            }
        }
    }

    private int getIngredientItemIndex(IngredientItem ingredientItem){
        int index = -1;
        for(int i = 0; i < this.ingredientItemLinkedList.size(); i++){
            if(this.ingredientItemLinkedList.get(i).getName().equals(ingredientItem.getName())){
                index = i;
            }
        }
        return index;
    }

    /**
     * Method to Update a Single Ingredient Item that exists in the list.
     * UPDATES BY REPLACING THE SAME INGREDIENT IN THE LIST WITH A NEW VERSION OF THE ITEM
     * @param updateItem    The Ingredient Item to be updated
     * @return  Boolean Value to be returned to verify the operation succeeded.
     */
    public boolean updateIngredientInList(IngredientItem updateItem){
        //TODO METHOD FAILING TO FIND INGREDIENT AFTER INGREDIENT SET =
        boolean isIngredient = isIngredient(updateItem);
        if(isIngredient == false)System.out.println("For Update Ingredient");

        int index = getIngredientItemIndex(updateItem);
        if(index >= 0) {
            this.ingredientItemLinkedList.set(index, updateItem);
            return true;
        }else{
            System.out.println("WHAT THE FUCK!!!");
            return false;
        }

/*        boolean completedUpdate = false;
        if(isIngredient == true){
            for(int i = 0; i < this.ingredientItemLinkedList.size();i++){

                IngredientItem tempItem = new IngredientItem(this.ingredientItemLinkedList.get(i));
                int count = 0;
                //TODO Method to add TempItem to some sort of Update Log


                if(tempItem.getName().equals(updateItem.getName())){
                    this.ingredientItemLinkedList.set(i,updateItem);
                    System.out.println("Updated Item");
                    completedUpdate = true;
                }
            }
        }
        if(completedUpdate == false){
            System.out.println("Something Wrong, No Ingredient Updated.");
        }
        return completedUpdate;*/

    }

    /**
     * Method convert Ingredient Linked List to an Array List of String Printouts
     * @return
     */
    public ArrayList<String> convertToStringArrayList(){
        ArrayList<String> stringArrayList = new ArrayList<>();
        for(int i = 0; i < this.ingredientItemLinkedList.size(); i++){
            stringArrayList.add(this.ingredientItemLinkedList.get(i).toString());
            System.out.println("Object Added to String Array List Successful");
        }
        return stringArrayList;
    }

    /**
     * Method for Testing, Prints out all Items in the Ingredient Item Linked List
     */
    public void printDictionary(){
        ListIterator<IngredientItem> itr = this.ingredientItemLinkedList.listIterator(0);
        while(itr.hasNext()){
            System.out.println(itr.next().toString());
        }
    }
}
