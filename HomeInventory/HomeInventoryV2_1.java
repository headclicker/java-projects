/*
 * Ben Russell
 * 2/10/2023
 * Purpose: Add a remove, search, sort, and value method to the home inventory;
 */
import java.util.*;
import java.io.*;
public class HomeInventoryV2_1 {
    public static void main(String[] args) throws IOException{
        Scanner kbReader = new Scanner(System.in);
        boolean isRunning = true;
        ArrayList<inventoryItem> myInventory = new ArrayList<inventoryItem>();
        while(isRunning == true){
            System.out.println("\nHome Inventory V1\n 1.) Open File\n 2.) Save File\n 3.) Display Inventory\n 4.) Add Item\n 5.) Remove Item\n 6.) Search For Item\n 7.) Sort Inventory\n 8.) Value\n 9.) Quit");
            int whichFunction = kbReader.nextInt();
            kbReader.nextLine();
            while (whichFunction < 1 || whichFunction > 9){
                System.out.println("Please enter a value from 1-5");
                System.out.println("\nHome Inventory V1\n 1.) Open File\n 2.) Save File\n 3.) Display Inventory\n 4.) Add Item\n 5.) Remove Item\n 6.) Search For Item\n 7.) Sort Inventory\n 8.) Value\n 9.) Quit");
                whichFunction = kbReader.nextInt();
                kbReader.nextLine();
            }
            if(whichFunction == 1){
                openFile(myInventory, kbReader);
            }else if(whichFunction == 2){
                saveFile(myInventory, kbReader);
            }else if(whichFunction == 3){
                displayInventory(myInventory);
            }else if(whichFunction == 4){
                addItem(myInventory, kbReader);
            }else if(whichFunction == 5){
                removeItem(myInventory, kbReader);
            }else if(whichFunction == 6){
                searchArray(myInventory, kbReader);
            }else if(whichFunction == 7){
                sortArray(myInventory, kbReader);
            }else if(whichFunction == 8){
                displayValue(myInventory, kbReader);
            }
            else if(whichFunction == 9){
                System.out.println("Quit");
                isRunning = false;
            }
            
        }
        kbReader.close();
    }
    public static void openFile(ArrayList<inventoryItem> array, Scanner kbReader) throws IOException{
        System.out.println("Open file");
        System.out.println("What is the name of the file?");
        String fileName = kbReader.nextLine();
        Scanner fileReader = new Scanner(new File(fileName));
        int lineTracker = 1;
        String name = ""; 
        String type = "";
        String manufacturer = "";
        Double value = 0.0;
        while(fileReader.hasNext()){
            
            if(lineTracker == 1){
                name = fileReader.nextLine();
            }else if(lineTracker == 2){
                type = fileReader.nextLine();
            }else if(lineTracker == 3){
                manufacturer = fileReader.nextLine();
            }else if(lineTracker == 4){
                value = fileReader.nextDouble();
                fileReader.nextLine();
                array.add(new inventoryItem(name, type, manufacturer, value));
                lineTracker = 0;
            }
            
            lineTracker++;
        }
        fileReader.close();
    }
    public static void displayInventory(ArrayList<inventoryItem> array) {
        System.out.println("Display Inventory");
        for(int i = 0; i<array.size(); i++){
            System.out.println(array.get(i).toString());
        }
    }
    public static void saveFile(ArrayList<inventoryItem> array, Scanner kbReader) throws IOException{
        System.out.println("Save File");
        System.out.println("What is the name of the file?");
        String fileName = kbReader.nextLine();
        FileWriter outFile = new FileWriter(fileName);
        PrintWriter output = new PrintWriter(outFile);
        for(int i = 0; i < array.size(); i++){
            output.println(array.get(i).getName());
            output.println(array.get(i).getType());
            output.println(array.get(i).getMaunfacturer());
            output.println(array.get(i).getValue());
        }
        outFile.close();
        output.close();
    }
    public static void addItem(ArrayList<inventoryItem> array, Scanner kbReader) {
        System.out.println("Add Item");
        System.out.println("Enter the name of the object: ");
        String name = kbReader.nextLine();
        System.out.println("Enter the object's type: ");
        String type = kbReader.nextLine();
        System.out.println("Enter the object's manufacturer");
        String manufacturer = kbReader.nextLine();
        System.out.println("Enter the object's value: ");
        Double value = kbReader.nextDouble();
        kbReader.nextLine();
        array.add(new inventoryItem(name, type, manufacturer, value));
        /* array.get(array.size()).setName(name);
        array.get(array.size()).setType(type);
        array.get(array.size()).setManufacturer(manufacturer);
        array.get(array.size()).setValue(value); */
    }
    public static void removeItem(ArrayList<inventoryItem> array, Scanner kbReader) {
        System.out.println("Which item do you want to remove?");
        String removeItem = kbReader.nextLine();
        Boolean itemExists = false;
        for(int i = 0; i < array.size(); i++){
            if(array.get(i).getName().equalsIgnoreCase(removeItem)){
                array.remove(i);
                itemExists = true;
                break;
            }
        }
        if(itemExists == false){
            System.out.println("Item not found");
        }
    }
    public static void searchArray(ArrayList<inventoryItem> array, Scanner kbReader) {
        System.out.println("Which item do you want to search for?");
        String searchitem = kbReader.nextLine();
        int itemIndex = 0;
        Boolean itemExists = false;
        for(int i = 0; i < array.size(); i++){
            if(array.get(i).getName().equalsIgnoreCase(searchitem)){
                itemIndex = i;
                itemExists = true;
                break;
            }
        }
        if(itemExists == false){
            System.out.println("Item not found");
        }else{
            System.out.println(array.get(itemIndex).toString());
        }
    }
    public static void sortArray(ArrayList<inventoryItem> array, Scanner kbReader) {
        System.out.println("Would you like to sort by name or value?");
        String nameValue = kbReader.nextLine();
        while(!(nameValue.equalsIgnoreCase("name") || nameValue.equalsIgnoreCase("value"))){
            System.out.println("Would you like to sort by name or value?");
            nameValue = kbReader.nextLine();
        }
        if(nameValue.equalsIgnoreCase("name")){
            for(int i = 0; i < array.size()-1; i++){
                String min = array.get(i).getName();
                int minPos = i;
                for(int j = i; j < array.size(); j++) {
                    String compareStr = array.get(j).getName();
                    compareStr = compareStr.toLowerCase();
                    min = min.toLowerCase();
                    if(compareStr.compareTo(min) < 0){
                        min = array.get(j).getName();
                        minPos = j;
                    }
                }
                inventoryItem temp = array.get(minPos);
                array.set(minPos, array.get(i));
                array.set(i, temp);
            }
        }else if(nameValue.equalsIgnoreCase("value")){
            for(int i = 0; i < array.size()-1; i++){
                Double min = array.get(i).getValue();
                int minPos = i;
                for(int j = i; j < array.size(); j++){
                    if(array.get(j).getValue() < min){
                        min = array.get(j).getValue();
                        minPos = j;
                    }
                }
                inventoryItem temp = array.get(minPos);
                array.set(minPos, array.get(i));
                array.set(i, temp);
            }
        }
    }
    public static void displayValue(ArrayList<inventoryItem> array, Scanner kbReader){
        System.out.println("What type of items would to display the value for?");
        String itemType = kbReader.nextLine();
        Double totalValue = 0.0;
        for(int i = 0; i < array.size(); i++){
            if(array.get(i).getType().equalsIgnoreCase(itemType)){
                totalValue += array.get(i).getValue();
            }
        }
        System.out.println("The items with type " + itemType + " have a total value of $" + totalValue);
    }
}
