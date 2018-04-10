package galliCricket;

import java.util.ArrayList;

public class Scorecard {
 	int runs;
    int wickets;
    float overs;
    
    public int getRuns() {
		return runs;
	}

	public void setRuns(int runs) {
		this.runs = runs;
	}

	public int getWickets() {
		return wickets;
	}

	public void setWickets(int wickets) {
		this.wickets = wickets;
	}

	public float getOvers() {
		return overs;
	}

	public void setOvers(float overs) {
		this.overs = overs;
	}

	ArrayList<ScoreObserver> observerList;
    
    public Scorecard() {
        observerList = new ArrayList<ScoreObserver>();
    }
    
    public void refreshScore(Player player) {
    	if(player instanceof Batsman) {
    		Batsman batsman = ((Batsman)player);
    		int run =batsman.getRunsScored();
    		if(run==0) {
    			batsman.numberOfFailedBalls++;
    		}
    		if(batsman.numberOfFailedBalls==2) {
    			batsman.numberOfFailedBalls=0;
    			runs=runs-2;
    			Bowler bowler = batsman.getBowler();
    			bowler.setNumberOfWickets(bowler.getNumberOfWickets()+1);
    			wickets++;
    		}
    		if(run!=0 && batsman.numberOfFailedBalls==1)
    			batsman.numberOfFailedBalls=0;
    		
    		runs+=run;
    	}else {
    		Bowler bowler = (Bowler)player;
    		int wicket =bowler.getNumberOfWickets(); 
    		runs =runs-2;
    		wickets++;
    	}
    	ScoreObserver observer = observerList.get(0);
    	observer.totalOvers(overs);
    	observer.totalRuns(runs);
    	observer.totalWickets(wickets);    	
    }
    
}
