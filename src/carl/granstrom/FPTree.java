package carl.granstrom;

import java.util.*;

public class FPTree{

    private HashMap<Integer, Item> itemList;
    private Transaction[] transactionList;
    private HashMap<String, Integer> supportCounts;
    private ArrayList<ItemSupport> prunedItems;

    /**
     * Constructor for the FP-Tree.
     *
     * @param itemList          A set of all items contained in the complete set of transactions (T)
     * @param transactionList   A list of all transactions, transactions must be sorted before creating the tree
     */
    public FPTree(HashMap<Integer, Item> itemList, Transaction[] transactionList){
        this.itemList = itemList;
        TransactionListTest t = new TransactionListTest();
        this.transactionList = t.getTransactionlist();
        supportCounts = new HashMap<>(itemList.size());     //Keeping track of total support count of the items in set T

        for (int i = 0; i < itemList.size(); i++) {
            supportCounts.put(this.itemList.get(i).getName(), 0);
        }

        for (Transaction transaction : transactionList){
            for (long l : transaction.getTransaction()){
                Integer key = (int)l - 1;
                String name = this.itemList.get(key).getName();
                Integer count = supportCounts.get(name);
                supportCounts.put(name, count + 1);
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

        for (int i = 0; i < itemList.size(); i++){
            double numTransactions = transactionList.length;
            System.out.println(
                    "Number of total transactions is: " + numTransactions);

            double numItemSupport = supportCounts.get(itemList.get(i).getName());
            System.out.println(
                    "The item support count for item " + itemList.get(i).getName() + " is " + numItemSupport);

            double absSupportThreshHold = numItemSupport / numTransactions;
            System.out.println(
                    "The support for item " + itemList.get(i).getName() + " is " + (absSupportThreshHold * 100) + "%");

            if ((numItemSupport / numTransactions) < supportThreshHold ) {
                System.out.println("Pruning " + itemList.get(i).getName() + " since its support is too low.");
                prune(i);
            }
            System.out.println();
        }
    }

    /**
     * Prune a single item from the list.
     */
    private void prune(int i){
        itemList.put(i, null);
    }

    /**
     * Create a list of items sorted by support count.
     */
    public void sortTransactions(){
        prunedItems = new ArrayList<ItemSupport>();
        for (int i = 0; i < itemList.size(); i++){
            Item item = itemList.get(i);
            if (item != null){
                Item tmpItem = item;
                int tmpSupport = supportCounts.get(item.getName());
                prunedItems.add(new ItemSupport(tmpItem, tmpSupport));
            }
        }
        prunedItems.sort(ItemSupport::compareTo);
        Collections.reverse(prunedItems);
        for (ItemSupport itemSupport : prunedItems){
            System.out.println(itemSupport.getItem().getName() + " has a support of " + itemSupport.getSupport());
        }
    }

    /**
     * Growing the tree.
     */
    public void growTree(){

    }

    /**
     * Print support counts for all items.
     */
    public void printSupport(){
        for (int i = 0; i < supportCounts.size(); i++){
            String itemName;
            if (itemList.get(i) == null) {
                itemName = "<pruned>";
            } else {
                itemName = itemList.get(i).getName();
            }
            System.out.println(supportCounts.get(itemName) + " " + itemName);
        }
        System.out.println();
    }
}

