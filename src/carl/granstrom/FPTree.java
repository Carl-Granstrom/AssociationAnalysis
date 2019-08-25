package carl.granstrom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FPTree{

    Item[] itemList;
    List<Transaction> transactionList;

    /**
     * Constructor for the FP-Tree.
     *
     * @param itemList          A set of all items contained in the complete set of transactions (T)
     * @param transactionList   A list of all transactions, transactions must be sorted before creating the tree
     */
    public FPTree(Item[] itemList, List<Transaction> transactionList){
        Arrays.sort(itemList);
        this.itemList = itemList;
        this.transactionList = transactionList;
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
}

