package carl.granstrom;

import java.util.*;

public class FPTree{

    Item[] itemList;
    Transaction[] transactionList;
    long[] supportCounts;

    /**
     * Constructor for the FP-Tree.
     *
     * @param itemList          A set of all items contained in the complete set of transactions (T)
     * @param transactionList   A list of all transactions, transactions must be sorted before creating the tree
     */
    public FPTree(Item[] itemList, Transaction[] transactionList){
        Arrays.sort(itemList);
        this.itemList = itemList;
        TransactionListTest t = new TransactionListTest();
        this.transactionList = t.getTransactionlist();
        supportCounts = new long[itemList.length];          //Keeping track of total support count of the items in set T
        for (Transaction transaction : transactionList){
            for (long l : transaction.getTransaction()){
                supportCounts[(int)l - 1]++;
            }
        }
    }

    /**
     * Internal node class used to build the tree.
     * @param <Item>            The item referenced by the node.
     * TODO possibly replace item with a long to represent the item's index in the itemList instead
     */
    private class Node<Item> {
        long depth;
        ArrayList<Node<Item>> nextLevel;

    }


    /**
     * Prune low support items.
     */
    public void dropLowSupport(double supportThreshHold) throws Exception {
        if (supportThreshHold <= 0 || supportThreshHold >= 1){
            throw new Exception("please enter a value between 0 and" + " 1, exclusive");
        }

        for (int i = 0; i < itemList.length; i++){
            int numTransactions = transactionList.length;
            int numItemSupport = (int)supportCounts[i];
            if ((numItemSupport / numTransactions) < supportThreshHold ) {
                prune(i);
            }
        }
    }

    /**
     * Growing the tree.
     */
    public void growTree(){

    }

    /**
     * Prune a single item from the list.
     */
    private void prune(int i){
        itemList[i] = null;
    }

    /**
     * Print support counts for all items.
     */
    public void printSupport(){
        for (int i = 0; i < supportCounts.length; i++){
            System.out.println(supportCounts[i] + " " + itemList[i].getName());
        }
    }
}

