package com.standings.ui.page.panel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.standings.model.Team;

public class SeasonsManagement extends JPanel implements ActionListener, ListSelectionListener{
	
	private JTextField textField;
	private JLabel teamsLabel;	
	private DefaultListModel<Team> listModel;
	private ArrayList<Team> allTeams;
    private JList<Team> teamList;
    private JLabel sectionTitle;
    private JLabel yearLabel;
    private JButton creatSeasonButton;
    
    private static final long serialVersionUID = 413951360879373732L;

	public SeasonsManagement(ArrayList<Team> allTeams) {
    	
	/*	
		
		this.allTeams = allTeams;
		
        sectionTitle = new JLabel("Crear una temporada");
        sectionTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
        sectionTitle.setBounds(232, 80, 264, 68);
        this.add(sectionTitle);
        
        textField = new JTextField();
        textField.setBounds(422, 190, 115, 45);
        this.add(textField);
        textField.setColumns(10);
        
        yearLabel = new JLabel("Año");
        yearLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        yearLabel.setBounds(192, 174, 75, 68);
        this.add(yearLabel);
        
        teamsLabel = new JLabel("Equipos");
        teamsLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        teamsLabel.setBounds(192, 287, 75, 68);
        this.add(teamsLabel);
        
        
        
        listModel = new DefaultListModel<Team>();
        
        teamList = new JList<Team>();
        teamList.setBounds(422, 287, 115, 169);
        teamList.setModel(listModel);
        teamList.addListSelectionListener(this);
        this.add(teamList);
        
        creatSeasonButton = new JButton("Crear Temporada");
        creatSeasonButton.setBounds(301, 545, 139, 28);
        this.add(creatSeasonButton);

        
        
        addTeamsToList();
        */
    }
	/*
	
	private void addTeamsToList() {
		for (Team team : allTeams) {
			listModel.addElement(team);
		}
		
	}
	*/
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
				
		
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
