package com.company;

import java.io.IOException;

public class testing {


    public testing() {
    }

    public void allPartsTest() throws CloneNotSupportedException {
        //STARTS THE FILE MANAGER AND CREATES THE DICTIONARY
        FileManager testFileManager = new FileManager("DataSource/ingredientFile.txt");
        try {
            testFileManager.generateStringArrayList();
        } catch (IOException e) {
            e.printStackTrace();
        }
        testFileManager.createObjectArray();
        IngredientFactory testFactory = new IngredientFactory();
        testFactory.startFactory(testFileManager.getObjectArrayList());
        IngredientDictionary testDictionary = new IngredientDictionary(testFactory.getList());




        //TEST INGREDIENT TO ADD TO LIST TO BE ADDED TO FILE UPDATE
        IngredientItem testNewItem = new IngredientItem();
        testNewItem.setName("New Item Test");
        testNewItem.setType("Wet");
        testNewItem.setCost(57);
        testNewItem.setWeight(.02);
        testNewItem.setMeasurementUnit("lb");
        testNewItem.setQuantityOnHand(45.5);
        testDictionary.addIngredientToList(testNewItem);


        System.out.println("Testing the Remove Ingredient");
        //TESTS THE REMOVAL AND UPDATE OF AN INGREDIENT
        IngredientItem itemRemove = new IngredientItem(testDictionary.getIngredientItem("Test Ingredient 5"));
        testDictionary.removeIngredientFromList(itemRemove);

        System.out.println("Testing the Update Method");
        //TESTING FOR TAKING AN INGREDIENT TO MODIFY AND SEND TO UPDATE
        IngredientItem test = new IngredientItem(testDictionary.getIngredientItem("Test Ingredient 2").clone());
        test.setName("Changed Names");
        testDictionary.updateIngredientInList(test);

        FileManager fileManager = new FileManager();
        fileManager.setFileName("DataSource/ingredientFile2.txt");
        fileManager.setStringArrayList(testDictionary.convertToStringArrayList());

        try {
            fileManager.generateStringFile();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public void ingredientFactoryTest(){
        FileManager testFileManager = new FileManager("DataSource/ingredientFile.txt");
        try {
            testFileManager.generateStringArrayList();
        } catch (IOException e) {
            e.printStackTrace();
        }
        testFileManager.createObjectArray();
        IngredientFactory testFactory = new IngredientFactory();
        testFactory.startFactory(testFileManager.getObjectArrayList());
        IngredientDictionary testDictionary = new IngredientDictionary(testFactory.getList());

        IngredientItem test = new IngredientItem(testDictionary.getIngredientItem("Test Ingredient 4"));
        System.out.println(test.getName());
        System.out.println(test.getQuantityOnHand());
        IngredientItem testNewItem = new IngredientItem();
        testNewItem.setName("New Item Test");
        testNewItem.setType("Wet");
        testNewItem.setCost(57);
        testNewItem.setWeight(.02);
        testNewItem.setMeasurementUnit("lb");
        testNewItem.setQuantityOnHand(45.5);

        testDictionary.addIngredientToList(testNewItem);
        System.out.println("This is the Dictionary Printing Now");
        testDictionary.printDictionary();

        IngredientItem itemRemove = new IngredientItem(testDictionary.getIngredientItem("Test Ingredient 5"));
        testDictionary.removeIngredientFromList(itemRemove);

        IngredientItem itemUpdate = new IngredientItem(testDictionary.getIngredientItem("Test Ingredient 3"));
        itemUpdate.setQuantityOnHand(45654.5453);
        testDictionary.updateIngredientInList(itemUpdate);

        System.out.println("This is the Remove and Updated Dictionary Printing Now");
        testDictionary.printDictionary();
    }

    public void convertStringToObjectTest(){
        FileManager fileManager = new FileManager("DataSource/ingredientFile.txt");
        try {
            fileManager.generateStringArrayList();
        } catch (IOException e) {
            e.printStackTrace();
        }

        fileManager.createObjectArray();
    }
    public void readFromFileTest(){
        FileManager fileManager = new FileManager("DataSource/ingredientFile.txt");
        try {
            fileManager.generateStringArrayList();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToFileTest(){
        FileManager fileManager = new FileManager("DataSource/ingredientFile.txt");
        fileManager.printStringArrayList();
        fileManager.setFileName("DataSource/ingredientFile2.txt");
        try {
            fileManager.generateStringFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
