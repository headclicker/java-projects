/*
 * Ben Russell
 * 1/31/2023
 * Purpose: Create a class for inventoryItem Objects
 */
public class inventoryItem {
    private String itemName;
    private String itemType;
    private String itemManufacturer;
    private Double itemValue;
    public inventoryItem(){
        itemName = "Unknown";
        itemType = "Unknown";
        itemManufacturer = "Unknown";
        itemValue = 0.0;
    }
    public inventoryItem(String name, String type, String manufacturer, Double  value){
        itemName = name;
        itemType = type;
        itemManufacturer = manufacturer;
        itemValue = value;
    }
    public void setName(String name){
        itemName = name;
    }
    public void setType(String type){
        itemType = type;
    }
    public void setManufacturer(String manufacturer){
        itemManufacturer = manufacturer;
    }
    public void setValue(Double value){
        itemValue = value;
    }
    public String getName(){
        return itemName;
    }
    public String getType(){
        return itemType;
    }
    public String getMaunfacturer(){
        return itemManufacturer;
    }
    public Double getValue(){
        return itemValue;
    }
    public String toString(){
        return("Name: " + itemName + "\nType: " + itemType + "\nManufacturer: " + itemManufacturer + "\nValue: " + itemValue);
    }
}
