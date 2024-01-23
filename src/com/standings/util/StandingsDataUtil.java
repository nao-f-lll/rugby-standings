package com.standings.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.standings.model.RugbyTeamsNames;
import com.standings.ui.page.panel.UpdateDataPanel;


public class StandingsDataUtil {
    

	private static final int ALL_POINTS_ARE_INVALID = 6;
	private static final int LOCAL_POINTS_ARE_INVALID = 7;
	private static final int VISITOR_POINTS_ARE_INVALID = 8;

	
	
	
	//EFFECTS : returns true if any field is empty; otherwise false.
	
    public static boolean validateStandingsDataForEmpties(String localClubField, String visitorClubField, String localClubPointsField, String visitorClubPointsField) {
       
    	return  checkFordEmptyFields(localClubField, visitorClubField, localClubPointsField, visitorClubPointsField);
    	
    }
    
       
  //REQUIRES: fields musn't be a null value.
  //EFFECTS : returns true if any field is empty; otherwise false.
    
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
    
    
   
    //EFFECTS : returns true if one of the teams has a wrong name; otherwise false.
    
    public static boolean validateStandingsDataForWrongTeamName(String localClubField, String visitorClubField) {
        
    	return  isNotValidTeamName(localClubField) || isNotValidTeamName(visitorClubField);

    }
    
    
    //REQUIRES: field musn't be a null value.
    //EFFECTS : returns true if the given team has a wrong name; otherwise false.
    
    private static boolean isNotValidTeamName(String teamName) {
    	
    	RugbyTeamsNames[] validTeams = RugbyTeamsNames.values();
    	    for (RugbyTeamsNames team : validTeams) {
    	        if (team.name().equals(teamName)) {
    	            return false;
    	        }
    	        
    	    }
    	    return true;    
    }
    
    //EFFECTS : returns true if both teams has the same name; otherwise false.
    
    public static boolean validateStandingsDataForSameTeamNAme(String localClubField, String visitorClubField) {
        
    	return   isTheSameName(localClubField, visitorClubField);

    }
    
    //REQUIRES: fields musn't be a null value.
    //EFFECTS : returns true if both teams has the same name; otherwise false.
    
    private static boolean isTheSameName(String localTeamName, String visitorTeamName) {
    	return localTeamName.equals(visitorTeamName);
    }
    

   
    
    //EFFECTS : returns the number of the case based on if both fields has wrong data or just one of them.
    
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
    //EFFECTS : returns true if the string match the required format,
    //         (e.g has only two digits from 0 to 99); otherwise false.
    
    private static boolean areValidPoints(String points) {
        String regex = "^[0-9]{1,2}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(points);
        return matcher.find();
    }
    
    
    //REQUIRES: UpdateDataPanel musn't be a null value.
    //MODIFIES: UpdateDataPanel
    //EFFECTS : if any box is selected change it's boolean to true
    
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

