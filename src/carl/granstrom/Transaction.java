package carl.granstrom;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.LongStream;

public class Transaction {
    private long[] transaction;
    private long transactionID;
    private static long idCounter = 0l;
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
        transaction = new long[width];

        //KEEP WORKING HERE
        int counter = 0;
        for (Long itemId : transaction){
            boolean contains = false;
            long itemNr;
            do {
                itemNr = (long)random.nextInt(20) + 1;
                long finalItemNr = itemNr;
                contains = LongStream.of(transaction).anyMatch(x -> x == finalItemNr);
            } while (contains);

            transaction[counter] = itemNr;
            counter++;
        }


    }

    public long[] getTransaction(){
        return transaction;
    }

    public void printTransaction(){
        for (long itemId : transaction) {
            System.out.println(itemId);
        }
    }

}
