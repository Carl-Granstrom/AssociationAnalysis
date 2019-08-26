package carl.granstrom;

public class Main {

    public static void main(String[] args) {
	TransactionListTest t = new TransactionListTest();
	t.randomPrint();
	FPTree fpt = new FPTree(new ItemTestData().getTestDataArray(), t.getTransactionlist());
	fpt.printSupport();

    }
}
