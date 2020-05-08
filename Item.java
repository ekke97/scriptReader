public class Item {
	private String name;
	protected int cost;
	protected String category;
	protected int count;
	protected int totCost;

	public Item(String nam, int cos, String cat) {
		this.name = nam;
		this.cost = cos;
		this.category = cat;
		this.count = 0;
		this.totCost = 0;
	}

	public String toString() {
		String s = "Item: " + name + 
			", Category: " + category + 
			", Cost: $" + cost + " PU" + ", Count: " + count + ", Total Cost: $" + (count*cost);
		return s;
	}

	@Override
    public int hashCode() {
    	int hashVal = name.hashCode() + category.hashCode() * 1987;
    	
    	return hashVal;
    }
    
    public boolean equals(Object something) {
    	if (! (something instanceof Item)) {
    		return false;
    	}
    	
    	Item other = (Item) something;
    	
    	return ((name.equals(other.name)) && (category.equals(other.category)));
    }
}