package galliCricket;

public class Bowler extends Player{
		int numberOfWickets;
		int numberOfBalls;
		Batsman batsman;
	    Bowler(String name,  int runsScored, int numberOfBalls,int numberOfWickets){
	        super(name);	    	
			// TODO Auto-generated constructor stub
	        this.numberOfWickets= numberOfWickets;
	        this.numberOfBalls=numberOfBalls;
	    }
	    
	    
		public Batsman getBatsman() {
			return batsman;
		}


		public void setBatsman(Batsman batsman) {
			this.batsman = batsman;
		}


		public int getNumberOfBalls() {
			return numberOfBalls;
		}

		public void setNumberOfBalls(int numberOfBalls) {
			this.numberOfBalls = numberOfBalls;
		}

		public int getNumberOfWickets() {
			return numberOfWickets;
		}

		public void setNumberOfWickets(int numberOfWickets) {
			this.numberOfWickets = numberOfWickets;
		}	
		void printPlayer() {
	        System.out.println(" Bowler Team "+getName()+" took wicket " + numberOfWickets );
	    }
}
