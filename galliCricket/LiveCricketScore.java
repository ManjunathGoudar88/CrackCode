package galliCricket;

class LiveCricketScore implements ScoreObserver{
	 private int runs;
	 private int wickets;
	 private float overs;
	 
	@Override
	public int totalRuns(int runs) {
		// TODO Auto-generated method stub
		this.runs=runs;
		return runs;
	}

	@Override
	public int totalWickets(int wickets) {
		// TODO Auto-generated method stub
		this.wickets=wickets;
		return wickets;
	}

	@Override
	public float totalOvers(float overs) {
		// TODO Auto-generated method stub
		this.overs=overs;
		return overs;
	}

	@Override
	public void display()  {
		System.out.println();
        System.out.println("\n Live Score :\n" + " Runs: " + runs + "\n Wickets:" + wickets + "\n Over: " + overs );
    }

}
