package carl.granstrom;

public class ItemSupport implements Comparable<ItemSupport> {
    private Item item;
    private int support;

    ItemSupport(Item item, int support){
        this.item = item;
        this.support = support;
    }

    public Item getItem(){ return this.item; }
    public int getSupport(){ return this.support; }

    @Override
    public int compareTo(ItemSupport other) {
        return Integer.compare(this.support, other.support);
    }
}
