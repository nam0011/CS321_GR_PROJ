package com.company;

import java.util.LinkedList;
import java.util.ListIterator;

public class IngredientDictionary {

    LinkedList<IngredientItem> ingredientItemLinkedList;

    public IngredientDictionary(LinkedList<IngredientItem> ingredientItemLinkedList) {
        this.ingredientItemLinkedList = ingredientItemLinkedList;
    }

    /**
     * Method allows you to get a single Ingredient Item referenced by name
     * @param ingredientName    Name of the Ingredient Item to returned
     * @return  Returns Ingredient Item Extracted from the Linked List
     */
    public IngredientItem getIngredientItem(String ingredientName){
        ListIterator<IngredientItem> ingredientItemListIterator = this.ingredientItemLinkedList.listIterator(0);
        IngredientItem tempItem = null;
        while(ingredientItemListIterator.hasNext()){
            if(ingredientItemListIterator.next().getName().equals(ingredientName)){
                tempItem = new IngredientItem(ingredientItemListIterator.next());
            }
        }
        return tempItem;
    }

    /**
     * Method to check if an Ingredient Already Exists in the Linked List
     * @param ingredientItem
     * @return  Boolean Value to be returned to verify the operation succeeded.
     */
    public boolean isIngredient(IngredientItem ingredientItem){
        ListIterator<IngredientItem> ingredientItemListIterator = this.ingredientItemLinkedList.listIterator(0);
        boolean isIngredient = false;
        while(ingredientItemListIterator.hasNext()){
            if(ingredientItemListIterator.next().getName().equals(ingredientItem.getName())){
                System.out.println("Found Ingredient");
                isIngredient = true;
            }
        }
        if(isIngredient == false) System.out.println("No Ingredient Found You Need to Add to List");

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
    public boolean removeIngredientFromList(IngredientItem ingredientItem){
        boolean exists = isIngredient(ingredientItem);

        if(exists == true){
            this.ingredientItemLinkedList.remove(ingredientItem);
            return true;
        }else {
            System.out.println("Ingredient Does NOT Exist Check for Add Method");
            return false;
        }
    }

    /**
     * Method to Update a Single Ingredient Item that exists in the list.
     * @param updateItem    The Ingredient Item to be updated
     * @return  Boolean Value to be returned to verify the operation succeeded.
     */
    public boolean updateIngredientInList(IngredientItem updateItem){
        boolean isIngredient = isIngredient(updateItem);
        boolean completedUpdate = false;
        if(isIngredient == true){
            ListIterator<IngredientItem> ingredientItemListIterator = this.ingredientItemLinkedList.listIterator(0);

            while(ingredientItemListIterator.hasNext()){
                if(ingredientItemListIterator.next().getName().equals(updateItem.getName())){
                    if(ingredientItemListIterator.next().getQuantityOnHand() != updateItem.getQuantityOnHand()){
                        //TODO add method for Logging Changes
                        updateItem.setQuantityOnHand(ingredientItemListIterator.next().getQuantityOnHand());
                    }
                    if(ingredientItemListIterator.next().getCost() != updateItem.getCost()){
                        //TODO add method for Logging Changes
                        updateItem.setCost(ingredientItemListIterator.next().getCost());
                    }
                    if(ingredientItemListIterator.next().getWeight() != updateItem.getWeight()){
                        //TODO add method for Logging Changes
                        updateItem.setWeight(ingredientItemListIterator.next().getWeight());
                    }
                    if(ingredientItemListIterator.next().getLastUsedDate() != updateItem.getLastUsedDate()){
                        //TODO add method for Logging Changes
                        updateItem.setLastUsedDate(ingredientItemListIterator.next().getLastUsedDate());
                    }
                    if(ingredientItemListIterator.next().getMeasurementUnit() != updateItem.getMeasurementUnit()){
                        //TODO add method for Logging Changes
                        updateItem.setMeasurementUnit(ingredientItemListIterator.next().getMeasurementUnit());
                    }
                    if(ingredientItemListIterator.next().getType() != updateItem.getType()){
                        //TODO add method for Logging Changes
                        updateItem.setType(ingredientItemListIterator.next().getType());
                    }
                    completedUpdate = true;
                    break;
                }else{
                    System.out.println("Something Wrong, Item Found then The Names did not match???");
                    completedUpdate = false;
                    break;
                }
            }
        }
        if(completedUpdate == false){
            System.out.println("Something Wrong, No Ingredient Updated.");
        }
        return completedUpdate;
    }
}
