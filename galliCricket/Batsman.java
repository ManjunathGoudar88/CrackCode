package galliCricket;

public class Batsman extends Player {
	 int runsScored;
	 int numberOfBallsTocuhed;
	 int numberOfFailedBalls;
	 Bowler bowler;
	public Bowler getBowler() {
		return bowler;
	}

	public void setBowler(Bowler bowler) {
		this.bowler = bowler;
	}

	public int getRunsScored() {
		return runsScored;
	}

	public void setRunsScored(int runsScored) {
		this.runsScored = runsScored;
	}

	Batsman(String name, int numberOfFailedBalls,int numberOfBallsTocuhed,int runsScored) {
		super(name);
		// TODO Auto-generated constructor stub
        this.numberOfBallsTocuhed = numberOfBallsTocuhed;
        this.numberOfFailedBalls=numberOfFailedBalls;
        this.runsScored=runsScored;
	}
	
	void printPlayer() {    
        System.out.println(" Batting team "+getName()+" Scored " + runsScored );
    }

	public int getRuns() {		
		return runsScored;
	}

	public int getNumberOfFailedBalls() {
		return numberOfFailedBalls;
	}
	
	public int getNumberOfBallsTocuhed() {
		// TODO Auto-generated method stub
		return numberOfBallsTocuhed;
	}

}
