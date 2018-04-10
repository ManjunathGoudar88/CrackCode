package galliCricket;

public interface ScoreObserver {
	
	public int totalRuns(int runs);
	public int totalWickets(int wickets);
	public float totalOvers(float overs);
	public void display();
}
