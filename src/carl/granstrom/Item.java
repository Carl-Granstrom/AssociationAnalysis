package carl.granstrom;

public class Item implements Comparable<Item>{
    private String name;
    private Long id;

    Item(String name, Long id){
        this.name = name;
        this.id = id;
    }


    public String getName(){ return this.name; }
    public Long getId(){ return this.id; }

    public int compareTo(Item item){
        return this.getName().compareTo(item.getName());
    }
}
