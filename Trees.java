
/**
 * Write a description of class Trees here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Trees extends Generics {
	public static final String type = "Trees";
	public enum KeyType {combo, name, age, category};
	public static KeyType key = KeyType.combo;
	private String name;
	private int age;
	private String category;
	
	Trees(String name, int age, String category)
	{
		this.setType(type);
		this.name = name;
		this.age = age;
		this.category = category;
	}
	
	/* 
	 * toString provides output based off of this.key setting
	 */
	@Override
	public String toString() {		
		String output="";
		switch(key) {
		case name:
			output += this.name;
			break;
		case age:
			output += this.age;
			break;
		case category:
			output += this.category;
			break;
		case combo:
		default:
			output = type + ": " + this.name + ", " + this.age + ", " + this.category;
		}
		return output;
	}
	
	public static Generics[] treeData() {
		Generics[] td = { 
				new Trees("Ash", 120, "Deciduous"),
			    new Trees("Banyan", 870, "Deciduous"),
			    new Trees("Cedar", 240, "Coniferous"),
			     new Trees("Fir", 270, "Coniferous"),
			    new Trees("Larch", 230, "Deciduous Conifer"),
			    new Trees("Oak", 110, "Deciduous"),
			    new Trees("Sequoia", 2300, "Coniferous"),
			    new Trees("Sycamore", 125, "Deciduous"),
			    new Trees("Willow", 50, "Deciduous"),
		};
		return td;
	}
	
	public static void main(String[] args)
	{
		Generics[] td = treeData();
		for(int i = 0; i < td.length; i++)
			System.out.println(td[i]);
	}
}
