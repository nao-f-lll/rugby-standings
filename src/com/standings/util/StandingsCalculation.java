package com.standings.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import com.standings.model.Season;
import com.standings.model.Game;
import com.standings.model.Team;
import com.standings.model.Week;

public class StandingsCalculation {

	private final static String NEW_STANDINGS_TYPE = "New entry";
	private final static String EXISTING_STANDINGS_TYPE = "Exisitng entry";
	private final static int defaultLocalScore = 0;
	private final static int  defaultVisitorScore = 0;
	 private final String FILE_PATH = "data/objects/seasons.ser";
	
	private Season season;
	private  ArrayList<Season> seasons;



	
	public StandingsCalculation(Season season, ArrayList<Season> seasons) {
		this.season = season;
		this.seasons = seasons;
		initializeTheCalculation(this.season.getTeams(),this.season.getGames(), this.season);
		
	}
	

		  //MODIFIES : teams, games
		  //EFFECTS  : generate and update the standings table data.
		
		private static void initializeTheCalculation( ArrayList<Team> teams,  ArrayList<Game> games, Season season) {
			
			games.addAll(generateMatchesDataFirstHalfPart(teams)); 
			games.addAll(generateMatchesDataSecondHalfPart(teams));
			initializeWeeks(season);
			updateStandings(teams, games);           
			sortStandings(teams);
			
			
		}
		
		
		public static  void saveSeasonData(ArrayList<Season> seasons) {
			try {
				FileOutputStream fileOut = new FileOutputStream("data/objects/seasons.ser");
				ObjectOutputStream streamOut = new ObjectOutputStream(fileOut);
				streamOut.writeObject(seasons);
				streamOut.close();
				fileOut.close();
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
		  //REQUIRES : list musn't be empty.
		  //MODIFIES : Team
		  //EFFECTS  : sort the teams based on theirs fields in this order,
		  //          (e.g wins, ties, losses, points)
		
		 public static void sortStandings(List<Team> teams) {

	            teams.sort(new Comparator<Team>() {
	                @Override
	                public int compare(Team localTeam, Team visitorTeam) {
	                    int winsDiff = visitorTeam.getWins() - localTeam.getWins();
	                    if (winsDiff != 0) {
	                        return winsDiff;
	                    }
	                    int tiesDiff = visitorTeam.getTies() - localTeam.getTies();
	                    if (tiesDiff != 0) {
	                        return tiesDiff;
	                    }
	                    int lossesDiff = localTeam.getLosses() - visitorTeam.getLosses();
	                    if (lossesDiff != 0) {
	                        return lossesDiff;
	                    }
	                    return visitorTeam.getPoints() - localTeam.getPoints();
	                }
	            });
	        }
		 
		 	 
		  //MODIFIES : Team
		  //EFFECTS  : update the fields of a team based on the given game.
		 
		 public static void updateStandings(Team team, Game game, String type) {
			 updateStandingsBasedOnMatch(team, game, type);
		 }
	    
		  //REQUIRES : list of teams and list of games musn't be null.
		  //MODIFIES : Team
		  //EFFECTS  : update the fields of a team based on the given games.
		 
	    public static void updateStandings(List<Team> teams, List<Game> games) {
	     	
	    	for (Game game : games) {	
	    		 for (Team team : teams) {
	    			 updateStandingsBasedOnMatch(team, game, NEW_STANDINGS_TYPE);
	    	        }    		  		
	    	}		    
	    }
	    
		  //MODIFIES : Team
		  //EFFECTS  : if a team is present in a game, update it's fields based on the game data.
		         
	    private static void updateStandingsBasedOnMatch(Team team, Game game, String type) {
	    	
	    	if (type.equals(NEW_STANDINGS_TYPE)) {
	    		
	    		if (team.getName().equals(game.getLocalTeam().getName())) {
	    			if (game.getLocalScore() > game.getVisitorScore()) {
	    				team.incrementWins();
	    			} else if (game.getLocalScore() < game.getVisitorScore()) {
	    				team.incrementLosses();
	    			} else {
	    				team.incrementTies();
	    			}
	    			team.setPoints(team.getPoints() + game.getLocalScore());
	    			team.incrementGamesPlayed();
	            
	    		} else if (team.getName().equals(game.getVisitorTeam().getName())) {
	    				if (game.getVisitorScore() > game.getLocalScore()) {
	    					team.incrementWins();
	    				} else if (game.getVisitorScore() < game.getLocalScore()) {
	    					team.incrementLosses();
	    				} else {
	    					team.incrementTies();
	    				}
	    				team.setPoints(team.getPoints() + game.getVisitorScore());
	    				team.incrementGamesPlayed();
	    		}
	    		
    		
	    		
	    	} else if (type.equals(EXISTING_STANDINGS_TYPE)) {
	    		
	    		boolean areOldAndNewgamesTies = game.getOldLocalScore() == game.getOldVisitorScore() && game.getLocalScore() == game.getVisitorScore();
	    		boolean areOldAndNewgamesWins = game.getOldLocalScore() > game.getOldVisitorScore() && game.getLocalScore() > game.getVisitorScore();
	    		boolean areOldAndNewgamesLose = game.getOldLocalScore() < game.getOldVisitorScore() && game.getLocalScore() < game.getVisitorScore();
	    		
	    		if (areOldAndNewgamesTies || areOldAndNewgamesWins || areOldAndNewgamesLose) {
	    			
	    			if (team.getName().equals(game.getLocalTeam().getName())) {
	    				
	    				team.setPoints(team.getPoints() - game.getOldLocalScore() + game.getLocalScore());
	    			} 
	    			if (team.getName().equals(game.getVisitorTeam().getName())) {
	    				team.setPoints(team.getPoints() - game.getOldLocalScore() + game.getLocalScore());
	    			}
	    			
	    		} else {
	    			    		
	    		
	    	    	if (game.getOldLocalScore() == game.getOldVisitorScore()) {
	    	    		if (team.getName().equals(game.getLocalTeam().getName())) {
	    	    			if (game.getLocalScore() > game.getVisitorScore()) {
	    	    				team.incrementWins();
	    	    				team.decrementTies();
	    	    			} else if (game.getLocalScore() < game.getVisitorScore()) {
	    	    				team.incrementLosses();
	    	    				team.decrementTies();
	    	    			} else {
	    	    				team.incrementTies();
	    	    			}
	    	    			team.setPoints(team.getPoints() - game.getOldLocalScore() + game.getLocalScore());
	    	    		}
	    	        
	    	    		if (team.getName().equals(game.getVisitorTeam().getName())) {
	    	    			if (game.getVisitorScore() > game.getLocalScore()) {
	    	    				team.incrementWins();
	    	    				team.decrementTies();
	    	    			} else if (game.getVisitorScore() < game.getLocalScore()) {
	    	    				team.incrementLosses();
	    	    				team.decrementTies();
	    	    			} else {
	    	    				team.incrementTies();
	    	    			}
	    	    			team.setPoints(team.getPoints() - game.getOldVisitorScore() + game.getVisitorScore());
	    	    		}
	    	    		
	    	    	} else {
	    	    		if (team.getName().equals(game.getLocalTeam().getName())) {
	    	    			if (game.getLocalScore() > game.getVisitorScore()) {
	    	    				team.incrementWins();
	    	    				team.decrementLosses();
	    	    			} else if (game.getLocalScore() < game.getVisitorScore()) {
	    	    				team.incrementLosses();
	    	    				team.decrementWins();
	    	    			} else if (game.getOldLocalScore() > game.getOldVisitorScore()){
	    	    				team.decrementWins();
	    	    				team.incrementTies();
	    	    			} else if (game.getOldLocalScore() < game.getOldVisitorScore()) {
	    	    				team.decrementLosses();
	    	    				team.incrementTies();
	    	    			} else {
	    	    				team.incrementTies();
	    	    			}
	    	    			team.setPoints(team.getPoints() - game.getOldLocalScore() + game.getLocalScore());
	    	    		}
	    	        
	    	    		if (team.getName().equals(game.getVisitorTeam().getName())) {
	    	    			if (game.getVisitorScore() > game.getLocalScore()) {
	    	    				team.incrementWins();
	    	    				team.decrementLosses();
	    	    			} else if (game.getVisitorScore() < game.getLocalScore()) {
	    	    				team.incrementLosses();
	    	    				team.decrementWins();
	    	    			
	    	    			} else if (game.getOldLocalScore() < game.getOldVisitorScore()){
	    	    				team.decrementWins();
	    	    				team.incrementTies();
	    	    			} else if (game.getOldLocalScore() > game.getOldVisitorScore()) {
	    	    				team.decrementLosses();
	    	    				team.incrementTies();
	    	    			} else {
	    	    				team.incrementTies();
	    	    			}
	    	    			team.setPoints(team.getPoints() - game.getOldVisitorScore() + game.getVisitorScore());
	    	    		}
	    	    	}	
	    	      
	    			}
	    		}
    
	    	}

	    
		  //MODIFIES : games
		  //EFFECTS  : returns the games list filled with random matches data.	
	    
	    private static List<Game> generateMatchesDataFirstHalfPart(ArrayList<Team> teams) {
	        List<Game> games = new ArrayList<>();
	        int totalWeeks = 5;
	        int gamesPerWeek = teams.size() / 2;

	        for (int weekNumber = 1; weekNumber <= totalWeeks; weekNumber++) {
	            for (int i = 0; i < gamesPerWeek; i++) {
	                Team team1 = teams.get(i);
	                Team team2 = teams.get(teams.size() - 1 - i);

	                int localScore = (int) (Math.random() * 99);
	                int visitorScore = (int) (Math.random() * 99);

	                Game game = new Game(team1, team2, localScore, visitorScore ,defaultLocalScore, defaultVisitorScore, weekNumber);
	               
	              
	                games.add(game);
	            }

	            rotateTeamsList(teams);
	        }

	        return games;
	    }

	    private static List<Game> generateMatchesDataSecondHalfPart(ArrayList<Team> teams) {
	        List<Game> games = new ArrayList<>();
	        int totalWeeks = 10;
	        int gamesPerWeek = teams.size() / 2;

	        for (int weekNumber = 6; weekNumber <= totalWeeks; weekNumber++) {
	            for (int i = 0; i < gamesPerWeek; i++) {
	                Team team1 = teams.get(i);
	                Team team2 = teams.get(teams.size() - 1 - i);

	                int localScore = (int) (Math.random() * 99);
	                int visitorScore = (int) (Math.random() * 99);

	                Game game = new Game(team2, team1, localScore, visitorScore,defaultLocalScore, defaultVisitorScore, weekNumber);
	                games.add(game);
	            }

	            rotateTeamsList(teams);
	        }

	        return games;
	    }
	    
	    
	    private static void initializeWeeks(Season season) {
	    	ArrayList<Week> weeks = new ArrayList<Week>();
	    	int indexFrom = 0;
	    	int indexTo = 3;
	    	int weeksSize = 10;
	    	for (int i = 1; i <= weeksSize; i++) {
	    			ArrayList<Game> weekGames = new ArrayList<>(season.getGames().subList(indexFrom, indexTo));
	    			Week week = new Week(i, weekGames);
		    		weeks.add(week);
		    		indexFrom+= 3;
		    		indexTo+= 3;
		    		
	    	}
	    	
	    	season.setWeeks(weeks);
	    	
	    	

	    }

	    private static void rotateTeamsList(ArrayList<Team> teams) {
	        Team temp = teams.get(teams.size() - 1);
	        teams.remove(teams.size() - 1);
	        teams.add(1, temp);
	    }

	    
}