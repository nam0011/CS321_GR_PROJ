package com.company;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class FileManager extends Reader {

    private ArrayList<String> stringArrayList;
    private ArrayList<ArrayList<String>> objectArrayList;
    private FileReader reader;
    private FileWriter writer;
    private BufferedReader buffer;
    private String line;
    private String fileName;


    /**
     * Method to generate the Array List of Strings, Can be used for reading in file like the ingredients file
     * @throws IOException
     */
    public void generateStringArrayList() throws IOException {

        this.openFileReader();

        this.buffer = new BufferedReader(reader);

        while((this.line = this.buffer.readLine()) != null){
            stringArrayList.add(this.line);
            //System.out.println("Added String: " + this.line);
        }
        this.closeFileReader();
    }

    /**
     * Method to Generate a String File using the formatted String Array List
     * @throws IOException
     */
    public void generateStringFile() throws IOException {
        this.openFileWriter();
        ListIterator<String> itr = this.stringArrayList.listIterator();

        int count = 0;
        while(itr.hasNext()){
            //System.out.println("Adding Ingredient to Txt File Next");
            this.writer.write(itr.next());
            this.writer.write("\n");
            //System.out.println("Just added " + this.stringArrayList.get(count) + " to the txt file.");
            count++;
        }

        this.closeFileWriter();
    }

    //METHODS TO OPEN AND CLOSE FILE READER,WRITER, AND BUFFERED READER
    private void openFileReader() throws FileNotFoundException {
        if(this.fileName == null){
            System.out.println("Please Enter the File Name or File Path");
            this.fileName = this.getUserInput();
        }
        this.reader = new FileReader(this.fileName);
    }

    private void closeFileReader() throws IOException {
        this.reader.close();
        this.buffer.close();
    }

    private void openFileWriter() throws IOException {
        if(this.fileName == null){
            System.out.println("Please Enter the File Name or File Path");
            this.fileName = this.getUserInput();
        }
        this.writer = new FileWriter(this.fileName);
    }

    private void closeFileWriter() throws IOException {
        this.writer.close();
    }

    private ArrayList<String> splitInput(String objectString) {

        ArrayList<String> tokens = new ArrayList<>();

        tokens.addAll(Arrays.asList(objectString.split("[{}=',]")));

        //FOR LOOP CHECK FOR UNNECESSARY SPACE AT BEGINING OF STRING
        for(int i = 0; i < tokens.size();i++) {

            tokens.set(i, tokens.get(i).trim());
        }

        this.removeNulls(tokens);


/*        //UNCOMMENT TO TEST THAT TAKENS IS
        for(int i = 0; i < tokens.size(); i++){
            System.out.print("<" + tokens.get(i) + ">");
        }
        System.out.println("");*/

        return tokens;
    }

    private ArrayList<String> removeNulls(ArrayList<String> list){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) == ""){
                list.remove(i);
                this.removeNulls(list);
                break;
            }
        }
        return list;
    }

    public void createObjectArray(){

        objectArrayList = new ArrayList<>();
        for(int i = 0; i<this.stringArrayList.size(); i++){
            objectArrayList.add(splitInput(this.stringArrayList.get(i)));
        }
    }

    /**
     * Method to get a line of input from user
     * @return
     */
    private String getUserInput(){
        Scanner userInput = new Scanner(System.in);

        return userInput.nextLine();
    }

    /**
     * Method for Testing to Print all the Strings in the Array List
     */
    public void printStringArrayList(){
        ListIterator<String> itr = this.stringArrayList.listIterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }

    //GETTERS, SETTERS, AND CONSTRUCTORS BELOW
    public FileManager() {
    }

    /**
     * Constructor for Getting the Data from a String File
     * @param readFileName  The name of the File to Read
     */
    public FileManager(String readFileName) {
        this.fileName = readFileName;
        this.stringArrayList = new ArrayList<>();
    }

    /**
     * Constructor for Creating and Writing to Files
     * @param writeFileName  The name of the Write File
     * @param stringArrayList   The Formated String Array List to be Wrote to the File
     */
    public FileManager(String writeFileName, ArrayList<String> stringArrayList){
        this.fileName = writeFileName;
        this.stringArrayList.addAll(stringArrayList);
    }

    public ArrayList<String> getStringArrayList() {
        return this.stringArrayList;
    }

    public void setStringArrayList(ArrayList<String> stringArrayList) {
        this.stringArrayList = stringArrayList;
    }

    public ArrayList<ArrayList<String>> getObjectArrayList() {
        return objectArrayList;
    }


    public FileReader getReader() {
        return this.reader;
    }

    public void setReader(FileReader reader) {
        this.reader = reader;
    }

    public FileWriter getWriter() {
        return this.writer;
    }

    public void setWriter(FileWriter writer) {
        this.writer = writer;
    }

    public BufferedReader getBuffer() {
        return this.buffer;
    }

    public void setBuffer(BufferedReader buffer) {
        this.buffer = buffer;
    }

    public String getLine() {
        return this.line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }


    /**
     * Reads characters into a portion of an array.  This method will block
     * until some input is available, an I/O error occurs, or the end of the
     * stream is reached.
     *
     * @param cbuf Destination buffer
     * @param off  Offset at which to start storing characters
     * @param len  Maximum number of characters to read
     * @return The number of characters read, or -1 if the end of the
     * stream has been reached
     * @throws IOException               If an I/O error occurs
     * @throws IndexOutOfBoundsException If {@code off} is negative, or {@code len} is negative,
     *                                   or {@code len} is greater than {@code cbuf.length - off}
     */
    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        return 0;
    }

    /**
     * Closes the stream and releases any system resources associated with
     * it.  Once the stream has been closed, further read(), ready(),
     * mark(), reset(), or skip() invocations will throw an IOException.
     * Closing a previously closed stream has no effect.
     *
     * @throws IOException If an I/O error occurs
     */
    @Override
    public void close() throws IOException {

    }
}
