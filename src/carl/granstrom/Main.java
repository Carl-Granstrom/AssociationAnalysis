package carl.granstrom;

public class Main {

    public static void main(String[] args) {
        TransactionListTest t = new TransactionListTest();
        t.randomPrint();
        ItemTestData itd = new ItemTestData();
	    System.out.println("Trying to print HashMap: ");
	    itd.printHashMapItemsList();
	    System.out.println("Printed HashMap?");
	    System.out.println();
	    FPTree fpt = new FPTree(itd.getTestData(), t.getTransactionlist());
	    System.out.println("Printing support before pruning: ");
	    fpt.printSupport();
	    System.out.println();

	    try {
	        fpt.dropLowSupport(0.274);
	    } catch (Exception e) {
	        System.out.println(e);
	    }
	    System.out.println("Printing support after pruning: ");
	    fpt.printSupport();
	    fpt.sortTransactions();
    }
}
