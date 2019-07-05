package java8practice;

public class Item {
	public int id;
    public String itemName;
    public User owner;
	public Item(int id, String itemName, User owner) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.owner = owner;
	}	
}
