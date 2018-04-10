package galliCricket;

public abstract class Player {
	private String name;
   
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	Player(String name){
        this.name = name;      
    }

    abstract void printPlayer();
}
