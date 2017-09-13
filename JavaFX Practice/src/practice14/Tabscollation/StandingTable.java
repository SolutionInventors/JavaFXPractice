/**
 * 
 */
package practice14.Tabscollation;

import javafx.beans.property.SimpleStringProperty;

/**
 * @author ChineduKnight
 *
 */
public class StandingTable {
	//converted to string
	private final SimpleStringProperty competitorName;
	private final SimpleStringProperty gamesPlayed;
	private final SimpleStringProperty wins;
	private final SimpleStringProperty draw;
	private final SimpleStringProperty loss;
	private final SimpleStringProperty goalsFor;
	private final SimpleStringProperty goalsAgainst;
	private final SimpleStringProperty goalsDiff;
	private final SimpleStringProperty points;
	//to be used when we understand better
	/*private final SimpleStringProperty competitorName;
	private final SimpleIntegerProperty gamesPlayed;
	private final SimpleIntegerProperty wins;
	private final SimpleIntegerProperty draw;
	private final SimpleIntegerProperty loss;
	private final SimpleIntegerProperty goalsFor;
	private final SimpleIntegerProperty goalsAgainst;
	private final SimpleIntegerProperty goalsDiff;
	private final SimpleIntegerProperty points;*/
	
	//not in use
	/*private final String competitorName;
	private final Integer gamesPlayed;
	private final Integer wins;
	private final Integer draw;
	private final Integer loss;
	private final Integer goalsFor;
	private final Integer goalsAgainst;
	private final Integer goalsDiff;
	private final Integer points;*/
	
	
	
	//to be used with the integers etc
	public StandingTable(String competitorName, String gamesPlayed,
			String wins, String draw, String loss,
			String goalsFor, String goalsAgainst, String goalsDiff,
			String points) {
		super();
		this.competitorName =new SimpleStringProperty (competitorName);
		this.gamesPlayed =new SimpleStringProperty( gamesPlayed);
		this.wins = new SimpleStringProperty(wins);
		this.draw = new SimpleStringProperty(draw);
		this.loss = new SimpleStringProperty(loss);
		this.goalsFor =new SimpleStringProperty( goalsFor);
		this.goalsAgainst = new SimpleStringProperty(goalsAgainst);
		this.goalsDiff = new SimpleStringProperty(goalsDiff);
		this.points =new SimpleStringProperty( points);
	}

	public String getCompetitorName() {
		return competitorName.get();
	}

	public String getGamesPlayed() {
		return gamesPlayed.get();
	}

	public String getWins() {
		return wins.get();
	}

	public String getDraw() {
		return draw.get();
	}

	public String getLoss() {
		return loss.get();
	}

	public String getGoalsFor() {
		return goalsFor.get();
	}

	public String getGoalsAgainst() {
		return goalsAgainst.get();
	}

	public String getGoalsDiff() {
		return goalsDiff.get();
	}

	public String getPoints() {
		return points.get();
	}
	
	
	
//to be used when we understand better no this string non-sense
	//to be used with the integers etc
/*		public StandingTable(String competitorName, Integer gamesPlayed,
				Integer wins, Integer draw, Integer loss,
				Integer goalsFor, Integer goalsAgainst, Integer goalsDiff,
				Integer points) {
			super();
			this.competitorName =new SimpleStringProperty (competitorName);
			this.gamesPlayed =new SimpleIntegerProperty( gamesPlayed);
			this.wins = new SimpleIntegerProperty(wins);
			this.draw = new SimpleIntegerProperty(draw);
			this.loss = new SimpleIntegerProperty(loss);
			this.goalsFor =new SimpleIntegerProperty( goalsFor);
			this.goalsAgainst = new SimpleIntegerProperty(goalsAgainst);
			this.goalsDiff = new SimpleIntegerProperty(goalsDiff);
			this.points =new SimpleIntegerProperty( points);
		}

		public String getCompetitorName() {
			return competitorName.get();
		}

		public Integer getGamesPlayed() {
			return gamesPlayed.get();
		}

		public Integer getWins() {
			return wins.get();
		}

		public Integer getDraw() {
			return draw.get();
		}

		public Integer getLoss() {
			return loss.get();
		}

		public Integer getGoalsFor() {
			return goalsFor.get();
		}

		public Integer getGoalsAgainst() {
			return goalsAgainst.get();
		}

		public Integer getGoalsDiff() {
			return goalsDiff.get();
		}

		public Integer getPoints() {
			return points.get();
		}
*/

}//end class
