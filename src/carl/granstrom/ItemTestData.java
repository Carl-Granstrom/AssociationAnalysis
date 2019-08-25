package carl.granstrom;

import java.util.Arrays;

public class ItemTestData {

    Item[] testDataArray = new Item[20];

    ItemTestData(){
        testDataArray[0] = new Item("Beer", 1l);
        testDataArray[1] = new Item("Bread", 2l);
        testDataArray[2] = new Item("Candy", 3l);
        testDataArray[3] = new Item("Cat Food", 4l);
        testDataArray[4] = new Item("Diapers", 5l);
        testDataArray[5] = new Item("Dog Food", 6l);
        testDataArray[6] = new Item("Fish", 7l);
        testDataArray[7] = new Item("Fish Batter", 8l);
        testDataArray[8] = new Item("Flour", 9l);
        testDataArray[9] = new Item("Hot Dog Buns", 10l);
        testDataArray[10] = new Item("Hot Dogs", 11l);
        testDataArray[11] = new Item("Ketchup", 12l);
        testDataArray[12] = new Item("Milk", 13l);
        testDataArray[13] = new Item("Minced Beef", 14l);
        testDataArray[14] = new Item("Mustard", 15l);
        testDataArray[15] = new Item("Oysters", 16l);
        testDataArray[16] = new Item("Sugar", 17l);
        testDataArray[17] = new Item("Tomatoes", 18l);
        testDataArray[18] = new Item("Wine, Red", 19l);
        testDataArray[19] = new Item("Wine, White", 20l);
        Arrays.sort(testDataArray);
    }

    public void printItemList(){
        int counter = 0;
        for (Item item : testDataArray){
            System.out.println("Item number " + item.getId() + " is: " + item.getName());
            counter++;
        }
    }

    public static void main(String args[]){
        ItemTestData itd = new ItemTestData();
        itd.printItemList();
    }
}
