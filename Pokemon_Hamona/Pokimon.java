
	public class Pokimon implements Comparable<Pokimon> {
	private String name;
	private int hight;
	private int weight;
	
	private int fireTemperature;
	private int thunderVoltage;
	public int compare(Object o1,Object o2){  
	    	Pokimon s1=(Pokimon)o1;  
	    	Pokimon s2=(Pokimon)o2;  
	   
	        if(s1.hight==s2.hight)  
	            return 0;  
	        else if(s1.hight>s2.hight)  
	            return 1;  
	        else 
	            return -1;  
	    } 
		
		
	public String getName() {
		return name;
	}
	public int gethight() {
		return hight;
	}
	public int getweight() {
		return weight;
	}
	public void setName(String name) {
		this.name = name; 
	}
	public void sethight(int hight) {
		this.hight = hight;
	}
	public void setweight(int weight) {
		this.weight = weight;
	}
	
	private String gotoPokeball() {
		return (" all of Pokimon go to pokeball ");
	}
	public String speak() {
		return ("all of pokimon can speak");
		
	}
	
	public void Move(String specificMove) {
		System.out.println (" pokimons can move ");
	}
	public Pokimon(String name, int hight, int weight ) {
		this.name=name;
		this.hight=hight;
		this.weight=weight;
	}
	@Override
	public int compareTo(Pokimon o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
