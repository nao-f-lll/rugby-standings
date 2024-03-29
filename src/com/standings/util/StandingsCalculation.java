package com.standings.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.standings.model.Game;
import com.standings.model.Season;
import com.standings.model.Team;
import com.standings.model.Week;

/**
 * Clase para calcular las clasificaciones de la temporada.
 * 
 * <p>Esta clase realiza cálculos y actualizaciones en los datos de clasificación
 * de una temporada dada.</p>
 * 
 * @author SomeOne
 * @version 1
 */
public class StandingsCalculation {

	private final static String NEW_STANDINGS_TYPE = "New entry";
	private final static String EXISTING_STANDINGS_TYPE = "Exisitng entry";
	private final static int defaultLocalScore = 0;
	private final static int  defaultVisitorScore = 0;
	private final static String defaultLocalScoreString = "?";
	private final static String  defaultVisitorScoreString ="?";
	private Season season;



	
	/**
     * Constructor de la clase StandingsCalculation.
     * 
     * <p>Inicializa una instancia de StandingsCalculation con la temporada y 
     * la lista de temporadas dadas, y realiza los cálculos iniciales.</p>
     * 
     * @param season La temporada para la cual se calcularán las clasificaciones
     * @param seasons La lista de temporadas que contiene la temporada actual
     */
	public StandingsCalculation(Season season) {
		this.season = season;
		initializeTheCalculation(this.season.getTeams(),this.season.getGames(), this.season);
		
	}
	

	/**
	 * Inicializa el cálculo de las clasificaciones.
	 * 
	 * <p>Este método inicializa el cálculo de las clasificaciones con los equipos y
	 * los juegos dados de una temporada específica.</p>
	 * 
	 * @param teams La lista de equipos para la temporada
	 * @param games La lista de juegos para la temporada
	 * @param season La temporada para la cual se están calculando las clasificaciones
	 */
		
		private static void initializeTheCalculation( ArrayList<Team> teams,  ArrayList<Game> games, Season season) {
			
		
		
				games.addAll(generateMatchesDataFirstHalfPart(teams)); 
				games.addAll(generateMatchesDataSecondHalfPart(teams));
				initializeWeeks(season);
				updateStandings(teams, games);           
				sortStandings(teams);
			
	
		}
		
		

		/**
		 * Guarda los datos de la temporada en un archivo.
		 * 
		 * @param seasons La lista de temporadas a guardar.
		 */
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
		
		/**
		 * Ordena la tabla de posiciones de los equipos.
		 * 
		 * @param teams La lista de equipos a ordenar.
		 */
		
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
		 
		 	 
		 /**
		  * Actualiza la tabla de posiciones de un equipo basándose en un partido dado.
		  * 
		  * @param team El equipo cuya tabla de posiciones se actualizará.
		  * @param game El partido que afecta la tabla de posiciones del equipo.
		  * @param type El tipo de actualización: "New entry" para nuevos partidos, "Existing entry" para partidos existentes.
		  */
		 
		 public static void updateStandings(Team team, Game game, String type) {
			 updateStandingsBasedOnMatch(team, game, type);
		 }
	    
		 
		 /**
		  * Actualiza la tabla de posiciones de una liga basada en los partidos jugados.
		  *
		  * @param teams Lista de equipos en la liga.
		  * @param games Lista de partidos jugados en la liga.
		  */
		 
	    public static void updateStandings(List<Team> teams, List<Game> games) {
	     	
	    	for (Game game : games) {	
	    		 for (Team team : teams) {
	    			 updateStandingsBasedOnMatch(team, game, NEW_STANDINGS_TYPE);
	    	        }    		  		
	    	}		    
	    }
	    
	    /**
	     * Actualiza la tabla de posiciones de los equipos basándose en los resultados de un partido.
	     *
	     * @param team Equipo involucrado en el partido.
	     * @param game Información del partido.
	     * @param type Tipo de actualización (nueva entrada o entrada existente).
	     */
		         
	    private static void updateStandingsBasedOnMatch(Team team, Game game, String type) {
	    	
	    	if (type.equals(NEW_STANDINGS_TYPE)) {
	    		if (!(game.getLocalScore() == 0 && game.getVisitorScore() == 0)) {
	    		
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
	    	}
    		
	    		
	    	} else if (type.equals(EXISTING_STANDINGS_TYPE)) {
	    		
	    		boolean areOldAndNewgamesTies = game.getOldLocalScore() == game.getOldVisitorScore() && game.getLocalScore() == game.getVisitorScore();
	    		boolean areOldAndNewgamesWins = game.getOldLocalScore() > game.getOldVisitorScore() && game.getLocalScore() > game.getVisitorScore();
	    		boolean areOldAndNewgamesLose = game.getOldLocalScore() < game.getOldVisitorScore() && game.getLocalScore() < game.getVisitorScore();
	    		
	    		if (areOldAndNewgamesTies || areOldAndNewgamesWins || areOldAndNewgamesLose) {
	    			
	    			if (team.getName().equals(game.getLocalTeam().getName())) {
	    				
	    				team.setPoints(team.getPoints() - game.getOldLocalScore() + game.getLocalScore());
	    				game.setActiveForLocalTeam(true);
	    			} 
	    			if (team.getName().equals(game.getVisitorTeam().getName())) {
	    				team.setPoints(team.getPoints() - game.getOldLocalScore() + game.getLocalScore());
	    				game.setActiveForVisitorTeam(true);
	    			}
	    			
	    			if (game.getOldLocalScore() == 0 && game.getOldVisitorScore() == 0 && game.getLocalScore() ==  game.getVisitorScore()) {
    				
    						team.incrementTies();
    					
    					
	    				
    				}	
	    			
	    		} else {	
	    	    	if (game.getOldLocalScore() == game.getOldVisitorScore()) {
	    	    		if (team.getName().equals(game.getLocalTeam().getName())) {
	    	    			if (game.getLocalScore() > game.getVisitorScore()) {
	    	    				team.incrementWins();
	    	    				
	    	    				if (!(team.getTies() == 0) && game.isActive()) {
	    	    					team.decrementTies();
	    	    					
	    	    				}			
	    	    			} else if (game.getLocalScore() < game.getVisitorScore()) {
	    	    				team.incrementLosses();
	    	    				if (!(team.getTies() == 0) && game.isActive()) {
	    	    					team.decrementTies();
	    	    					
	    	    				}
	    	    			} else {
	    	    				team.incrementTies();
	    	    				
	    	    			}
	    	    			game.setActiveForLocalTeam(true);
	    	    			team.setPoints(team.getPoints() - game.getOldLocalScore() + game.getLocalScore());
	    	    		}
	    	        
	    	    		if (team.getName().equals(game.getVisitorTeam().getName())) {
	    	    			if (game.getVisitorScore() > game.getLocalScore()) {
	    	    				team.incrementWins();
	    	    				if (!(team.getTies() == 0) && game.isActive()) {
	    	    					team.decrementTies();
	    	    				
	    	    				}
	    	    			} else if (game.getVisitorScore() < game.getLocalScore()) {
	    	    				team.incrementLosses();
	    	    				if (!(team.getTies() == 0) && game.isActive()) {
	    	    					team.decrementTies();
	    	    					
	    	    				}
	    	    			} else {
	    	    				team.incrementTies();
	    	    				
	    	    			}
	    	    			
	    	    			game.setActiveForVisitorTeam(true);
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
	    	    			game.setActiveForLocalTeam(true);
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
	    	    			game.setActiveForVisitorTeam(true);
	    	    			team.setPoints(team.getPoints() - game.getOldVisitorScore() + game.getVisitorScore());
	    	    		}
	    	    	}	
	    	      
	    			}
	    		
	    		int totalGamesPlayed = team.getTies() + team.getWins() + team.getLosses();
	    		team.setGamesPlayed(totalGamesPlayed);
	    		if (game.isActiveForLocalTeam() && game.isActiveForVisitorTeam()) {
	    			game.setActive(true);
	    		
	    		}
	    	}
	    	
	    }

	    
	    /**
	     * Genera los datos de los partidos para la primera mitad de la temporada.
	     *
	     * @param teams Lista de equipos.
	     * @return Lista de partidos generados.
	     */	
	    
	    private static List<Game> generateMatchesDataFirstHalfPart(ArrayList<Team> teams) {
	        List<Game> games = new ArrayList<>();
	        int totalWeeks = 5;
	        int gamesPerWeek = teams.size() / 2;

	        for (int weekNumber = 1; weekNumber <= totalWeeks; weekNumber++) {
	            for (int i = 0; i < gamesPerWeek; i++) {
	                Team team1 = teams.get(i);
	                Team team2 = teams.get(teams.size() - 1 - i);

	               // int localScore = (int) (Math.random() * 99);
	                //int visitorScore = (int) (Math.random() * 99);

	                String localScore = "?";
	                String visitorScore = "?";
	                
	                Game game = new Game(team1, team2, localScore, visitorScore ,defaultLocalScoreString, defaultVisitorScoreString, weekNumber);
	               
	              
	                games.add(game);
	            }

	            rotateTeamsList(teams);
	        }

	        return games;
	    }

	    /**
	     * Genera los datos de los partidos para la segunda mitad de la temporada.
	     *
	     * @param teams Lista de equipos.
	     * @return Lista de partidos generados.
	     */
	    private static List<Game> generateMatchesDataSecondHalfPart(ArrayList<Team> teams) {
	        List<Game> games = new ArrayList<>();
	        int totalWeeks = 10;
	        int gamesPerWeek = teams.size() / 2;

	        for (int weekNumber = 6; weekNumber <= totalWeeks; weekNumber++) {
	            for (int i = 0; i < gamesPerWeek; i++) {
	                Team team1 = teams.get(i);
	                Team team2 = teams.get(teams.size() - 1 - i);

	              //  int localScore = (int) (Math.random() * 99);
	              //  int visitorScore = (int) (Math.random() * 99);

	                String localScore = "?";
	                String visitorScore = "?";
	                
	                Game game = new Game(team2, team1, localScore, visitorScore,defaultLocalScoreString, defaultVisitorScoreString, weekNumber);
	                games.add(game);
	            }

	            rotateTeamsList(teams);
	        }

	        return games;
	    }
	    
	    
	    /**
	     * Inicializa las semanas de la temporada con los juegos correspondientes.
	     *
	     * @param season Temporada a la que se le inicializarán las semanas.
	     */
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

	    /**
	     * Rota la lista de equipos moviendo el último equipo a la segunda posición.
	     *
	     * @param teams Lista de equipos que se rotará.
	     */
	    private static void rotateTeamsList(ArrayList<Team> teams) {
	        Team temp = teams.get(teams.size() - 1);
	        teams.remove(teams.size() - 1);
	        teams.add(1, temp);
	    }

	    
}