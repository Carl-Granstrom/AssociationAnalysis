package carl.granstrom;

import java.util.Random;

public class Transaction {
    private Item[] transaction;
    private Long transactionID;
    private static Long idCounter = 0l;
    private static Random random = new Random();

    Transaction(){
        idCounter++;
    }

    Transaction(boolean randomize){
        idCounter++;

        this.transactionID = idCounter;

        int width = random.nextInt(6) + random.nextInt(5) + 1;  //max transaction width of 10
        Long[] transaction = new Long[width];

        //KEEP WORKING HERE
        int counter = 0;
        for (Long itemId : transaction){
            int itemNr = random.nextInt(20) + 1;

        }


    }
}
