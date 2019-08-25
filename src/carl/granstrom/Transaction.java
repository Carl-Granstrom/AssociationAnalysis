package carl.granstrom;

import java.util.Random;

public class Transaction {
    private Long[] transaction;
    private Long transactionID;
    private static Long idCounter = 0l;
    private static Random random = new Random();

    Transaction(){
        idCounter++;
    }

    /**
     * TODO All this should be moved out of the class to a factory instead.
     * @param randomize
     */
    Transaction(boolean randomize){
        idCounter++;

        this.transactionID = idCounter;

        int width = random.nextInt(6) + random.nextInt(5) + 1;  //max transaction width of 10
        transaction = new Long[width];

        //KEEP WORKING HERE
        int counter = 0;
        for (Long itemId : transaction){
            long itemNr = (long)random.nextInt(20) + 1;
            transaction[counter] = itemNr;
            counter++;
        }


    }

    public void printTransaction(){
        for (Long itemId : transaction) {
            System.out.println(itemId);
        }
    }

}
