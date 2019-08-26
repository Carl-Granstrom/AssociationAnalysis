package carl.granstrom;

import java.util.Arrays;
import java.util.Random;

public class TransactionListTest {

    Transaction[] transactions = new Transaction[50000];

    TransactionListTest(){
        for (int i = 0; i< 50000 ;i++){
            transactions[i] = new Transaction(true);
            Arrays.sort(transactions[i].getTransaction());
        }
    }

    public void randomPrint(){
        Random r = new Random();
        for (int i = 0; i < 10; i++){
            int randomChoice = r.nextInt(50000);
            transactions[randomChoice].printTransaction();
            System.out.println();
        }
    }

    public Transaction[] getTransactionlist(){
        return this.transactions;
    }
}
