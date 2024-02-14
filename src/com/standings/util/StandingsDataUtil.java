package com.standings.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.standings.model.RugbyTeamsNames;
import com.standings.ui.page.panel.UpdateDataPanel;

/**
 * Clase de utilidad para validar y manipular datos de clasificaciones.
 */

public class StandingsDataUtil {
    
    // delcaración de las variables
	private static final int ALL_POINTS_ARE_INVALID = 6;
	private static final int LOCAL_POINTS_ARE_INVALID = 7;
	private static final int VISITOR_POINTS_ARE_INVALID = 8;

	
	
	
	/**
     * Verifica si alguno de los campos está vacío.
     *
     * @param localClubField      Nombre del club local.
     * @param visitorClubField    Nombre del club visitante.
     * @param localClubPointsField Puntos del club local.
     * @param visitorClubPointsField Puntos del club visitante.
     * @return true si alguno de los campos está vacío; de lo contrario, false.
     */
	
    public static boolean validateStandingsDataForEmpties(String localClubField, String visitorClubField, String localClubPointsField, String visitorClubPointsField) {
       
    	return  checkFordEmptyFields(localClubField, visitorClubField, localClubPointsField, visitorClubPointsField);
    	
    }
    
       
    /**
     * Verifica si algún campo está vacío.
     *
     * @param localClubField      Nombre del club local.
     * @param visitorClubField    Nombre del club visitante.
     * @param localClubPointsField Puntos del club local.
     * @param visitorClubPointsField Puntos del club visitante.
     * @return true si algún campo está vacío; de lo contrario, false.
     */
    
    public static boolean checkFordEmptyFields(String localClubField, String visitorClubField, String localClubPointsField, String visitorClubPointsField) {
    	 
    	boolean localClubEmpty = localClubField.isEmpty();
    	 boolean visitorClubEmpty = visitorClubField.isEmpty();
    	 boolean localClubPointsEmpty = localClubPointsField.isEmpty();
    	 boolean visitorClubPointsEmpty = visitorClubPointsField.isEmpty();
    
    	if (localClubEmpty || visitorClubEmpty || localClubPointsEmpty || visitorClubPointsEmpty) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
    
   
    /**
     * Verifica si el nombre del equipo es incorrecto.
     *
     * @param localClubField   Nombre del club local.
     * @param visitorClubField Nombre del club visitante.
     * @return true si uno de los equipos tiene un nombre incorrecto; de lo contrario, false.
     */
    
    public static boolean validateStandingsDataForWrongTeamName(String localClubField, String visitorClubField) {
        
    	return  isNotValidTeamName(localClubField) || isNotValidTeamName(visitorClubField);

    }
    
    /**
     * Verifica si el nombre del equipo es incorrecto.
     *
     * @param teamName Nombre del equipo.
     * @return true si el nombre del equipo no es válido; de lo contrario, false.
     */
    
    private static boolean isNotValidTeamName(String teamName) {
    	
    	RugbyTeamsNames[] validTeams = RugbyTeamsNames.values();
    	    for (RugbyTeamsNames team : validTeams) {
    	        if (team.name().equals(teamName)) {
    	            return false;
    	        }
    	        
    	    }
    	    return true;    
    }
    
    /**
     * Verifica si ambos equipos tienen el mismo nombre.
     *
     * @param localClubField   Nombre del club local.
     * @param visitorClubField Nombre del club visitante.
     * @return true si ambos equipos tienen el mismo nombre; de lo contrario, false.
     */
    
    public static boolean validateStandingsDataForSameTeamNAme(String localClubField, String visitorClubField) {
        
    	return   isTheSameName(localClubField, visitorClubField);

    }
    
    /**
     * Verifica si ambos equipos tienen el mismo nombre.
     *
     * @param localTeamName   Nombre del equipo local.
     * @param visitorTeamName Nombre del equipo visitante.
     * @return true si ambos equipos tienen el mismo nombre; de lo contrario, false.
     */
    
    private static boolean isTheSameName(String localTeamName, String visitorTeamName) {
    	return localTeamName.equals(visitorTeamName);
    }
    

   
    
    /**
     * Valida los puntos ingresados para ambos equipos.
     *
     * @param localClubPointsField   Puntos del club local.
     * @param visitorClubPointsField Puntos del club visitante.
     * @return El número del caso basado en si los puntos son inválidos para ambos
     * 			equipos o solo para uno de ellos.
     */
    
    public static int validateStandingsDataForPoints(String localClubPointsField, String visitorClubPointsField) {
        if (!areValidPoints(localClubPointsField) && !areValidPoints(visitorClubPointsField)) {
            return ALL_POINTS_ARE_INVALID;
        } else if (!areValidPoints(localClubPointsField)) {
            return LOCAL_POINTS_ARE_INVALID;
        } else if (!areValidPoints(visitorClubPointsField)) {
            return VISITOR_POINTS_ARE_INVALID;
        }

        return 0;
    }                 
   
    /**
     * Verifica si los puntos ingresados son válidos.
     *
     * @param points Puntos ingresados.
     * @return true si los puntos son válidos; de lo contrario, false.
     */
    
    private static boolean areValidPoints(String points) {
        String regex = "^[0-9]{1,2}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(points);
        return matcher.find();
    }
    
    
    /**
     * Verifica qué casilla está seleccionada.
     *
     * @param UpdateData Panel de actualización de datos.
     */
    
    public static void checkWhichBoxIsSelected(UpdateDataPanel UpdateData) {
        boolean firstSelected = UpdateData.firstGameBox.isSelected();
        boolean secondSelected = UpdateData.secondGameBox.isSelected();
        boolean thirdSelected = UpdateData.thirdGameBox.isSelected();

        if (firstSelected) {
            UpdateData.isFirstBoxSelected = true;
            UpdateData.isSecondBoxSelected = false;
            UpdateData.isThirdBoxSelected = false;
        } else if (secondSelected) {
            UpdateData.isFirstBoxSelected = false;
            UpdateData.isSecondBoxSelected = true;
            UpdateData.isThirdBoxSelected = false;
        } else if (thirdSelected) {
            UpdateData.isFirstBoxSelected = false;
            UpdateData.isSecondBoxSelected = false;
            UpdateData.isThirdBoxSelected = true;
        }
    }

    
    //REQUIRES: UpdateDataPanel musn't be a null value.
    //MODIFIES: UpdateDataPanel
    //EFFECTS : if any box is selected increment selectedCount by  1 and return true if the selected box are more than 1;
    //			otherwise return false.
    
    public static boolean areMultipleBoxesSelected(UpdateDataPanel UpdateData) {
        int selectedCount = 0;

        if (UpdateData.firstGameBox.isSelected()) {
            selectedCount++;
        }
        
        if (UpdateData.secondGameBox.isSelected()) {
            selectedCount++;
        }
        
        if (UpdateData.thirdGameBox.isSelected()) {
            selectedCount++;
        }

        return selectedCount >= 2;
    }
    
    //REQUIRES: UpdateDataPanel musn't be a null value.
    //MODIFIES: UpdateDataPanel
    //EFFECTS : if any box is selected increment selectedCount by 1
    
    public static int checkIfNoBoxIsSelected(UpdateDataPanel UpdateData) {
        int selectedCount = 0;

        if (UpdateData.firstGameBox.isSelected()) {
            selectedCount++;
        }
        
        if (UpdateData.secondGameBox.isSelected()) {
            selectedCount++;
        }
        
        if (UpdateData.thirdGameBox.isSelected()) {
            selectedCount++;
        }

        return selectedCount;
    }
    

    
}

