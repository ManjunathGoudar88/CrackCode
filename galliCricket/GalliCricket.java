package galliCricket;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.linkedList.LinearLinkedList;

public class GalliCricket {

	public static void main(String args[]) throws Exception {
		
		
		LiveCricketScore liveScore = new LiveCricketScore();
		Scorecard scorecard = new Scorecard();
		scorecard.observerList.add(liveScore);
		
		System.out.println(" ......  Galli Cricket  ....");
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader r = new BufferedReader(input);
		int ch;
		LinearLinkedList s = new LinearLinkedList();
	
			System.out.println("Menu");
            System.out.println("1.Enter Batting Team Name.");
            String name=(String)r.readLine();
            Batsman batsman = new Batsman(name, 0, 0, 0);            
            
            System.out.println("2.Enter Bowling team Name.");
             name=(String)r.readLine();
            Bowler bowler = new Bowler(name, 0, 0,0);
            
            System.out.println("3.Enter Number of Balls Bowlled Vs Score of Batsman..!");
            int numberOfBalls=Integer.parseInt(r.readLine());            
            bowler.setNumberOfBalls(numberOfBalls);
            bowler.setBatsman(batsman);
            batsman.setBowler(bowler);
            scorecard.overs=1.0f;
            String obj;
            for(int i=0;i < numberOfBalls; i++) {
            	 	 do {
	            		 obj =r.readLine();
	                	 if(obj.length()!=1) {
	                		 System.out.println(" Inavlid Entry..! Please enter 1 letter input.");
	                		
	                	 }else {	                		
	                		 if(Character.isDigit(obj.charAt(0))){
	                    		 int score= Integer.parseInt(obj);
	    	                     batsman.setRunsScored(score);
	    	                     scorecard.refreshScore(batsman);
	                    	 }else {
	    	                    char wicket= obj.charAt(0);
	    	                    bowler.setNumberOfWickets(bowler.getNumberOfWickets()+1);
	    	                    scorecard.refreshScore(bowler);
	                    	 }
	                	 }
            	 	 }while(obj.length() > 1);
            }
         
         System.out.println("Final Score ");
         batsman.printPlayer();
         bowler.printPlayer();
         liveScore.display();
		System.out.println("......... Galli Cricket Over .............");
		
		
	}
}
