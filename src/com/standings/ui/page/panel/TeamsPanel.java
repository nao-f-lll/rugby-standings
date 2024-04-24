package com.standings.ui.page.panel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;



import com.standings.model.Estadio;
import com.standings.model.Season;
import com.standings.model.Team;
import com.standings.ui.page.SportsDashboardPage;
import com.standings.util.FileIO;
import com.standings.util.Time;


public class TeamsPanel extends JPanel implements ActionListener {
	
	
    private static final long serialVersionUID = -538081400942327500L;
	
	private JPanel teamsPanelButton;
	private JPanel panelButton;
	
	private JPanel addTeamPanel;
	private JLabel estadioLable;
	private JLabel ciudadLable;
	private JLabel fundacionLable;
	private JButton creatTeamButton;
	private JButton updateTeamButton;
	private JButton deleteTeamButton;
	private JPanel teamTablePanel;
	private JLabel creatTeamLabel;
	private JLabel nombreLable;
	private JTextField nombreField;
	private JTextField estadioField;
	private JTextField ciudadField;
	private JButton escudoButton;
	private JLabel escudoPreviewLable;
	private String imagePath;
	private ImageIcon icon;
	private DefaultComboBoxModel<Integer> allYearFrom1800To2024;
	private JComboBox<Integer> fundacionCombo;
	private DefaultTableModel model;
	private Vector<String> columnas;
	private Vector<Vector<Object>> datosTabla;
	private JTable table;
	private JTableHeader tableHeader;
	private Dimension headerSize;
	private JScrollPane scrollPane;;
	private ArrayList<Team> allTeams;
	private FileIO<Team> fileIo;
	private final String FILE_PATH = "data/objects/teams.ser";
	private Season season;
	private JLabel playerListLabel;
	private PlayersPanel playersPanel;
	private SeasonsManagement seasonsManagementPanel;
    
    public TeamsPanel(JPanel panelButton, ArrayList<Team> allTeams) {
    	this.panelButton = panelButton;
    		
    	File file = new File(FILE_PATH);
    	fileIo = new FileIO<>(); 
    	
    	if (!file.exists() || file.length() == 0)  {
    		this.allTeams  = new ArrayList<>();
    	} else {
    		this.allTeams  = fileIo.readObject(FILE_PATH, this.allTeams);
    	}
    	
       	for (int i = 0; i < this.allTeams.size(); i++) {
    		allTeams.add(this.allTeams.get(i));
    	} 	
    	this.allTeams = allTeams;
    
    	
    	initializeTeamsPanels();
    	createTable();	
    }
    
    
    private void initializeTeamsPanels() {
    	 initializeCreatNewTeamPanel();
    	 initializeTeamTablePanel();
    }
    
  
    
    public void setPlayersManagementPanel(PlayersPanel playersPanel) {
    	this.playersPanel = playersPanel;
    }
    
    private void initializeCreatNewTeamPanel() {
    	 addTeamPanel = new JPanel();
         addTeamPanel.setBounds(0, 59, 634, 754);
         this.add(addTeamPanel);
         addTeamPanel.setLayout(null);
         addTeamPanel.setBackground(new Color(255, 255, 255));
         
         creatTeamLabel = new JLabel("Crear un equipo nuevo");
         creatTeamLabel.setBounds(163, 0, 316, 68);
         creatTeamLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
         addTeamPanel.add(creatTeamLabel);
         
         
         
	  
         nombreLable = new JLabel("Nombre");
         nombreLable.setBounds(289, 135, 70, 15);
         addTeamPanel.add(nombreLable);
         
         escudoButton = new JButton("Selecionar Escudo");
         escudoButton.setBounds(50, 256, 155, 25);
         addTeamPanel.add(escudoButton);
         escudoButton.addActionListener(this);
         escudoButton.setFocusable(false);
         escudoButton.setBackground(Color.LIGHT_GRAY);
         escudoButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
         escudoButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
         
         
         nombreField = new JTextField();
         nombreField.setColumns(10);
         nombreField.setBounds(403, 133, 200, 25);
         addTeamPanel.add(nombreField);
         
         estadioLable = new JLabel("Estadio");
         estadioLable.setBounds(289, 203, 70, 15);
         addTeamPanel.add(estadioLable);
         
         estadioField = new JTextField();
         estadioField.setColumns(10);
         estadioField.setBounds(403, 201, 200, 25);
         addTeamPanel.add(estadioField);
         
         ciudadLable = new JLabel("Ciudad");
         ciudadLable.setBounds(289, 280, 70, 15);
         addTeamPanel.add(ciudadLable);
         
         ciudadField = new JTextField();
         ciudadField.setColumns(10);
         ciudadField.setBounds(403, 278, 200, 25);
         addTeamPanel.add(ciudadField);
         
         fundacionLable = new JLabel("Fundación");
         fundacionLable.setBounds(289, 353, 70, 15);
         addTeamPanel.add(fundacionLable);
          
         int currentYear = 2024;
         
         allYearFrom1800To2024 = new DefaultComboBoxModel<>();

         
         for (int startYear = 1800; startYear <= currentYear; startYear++) {
       	  allYearFrom1800To2024.addElement(startYear);      	  
         }
         
         fundacionCombo = new JComboBox<>(allYearFrom1800To2024);
         fundacionCombo.setSelectedIndex(fundacionCombo.getItemCount() - 1);	
         fundacionCombo.setBounds(403, 351, 200, 25);
         addTeamPanel.add(fundacionCombo);
         fundacionCombo.setFocusable(false);
         fundacionCombo.setBackground(Color.LIGHT_GRAY);
         fundacionCombo.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
         
         creatTeamButton = new JButton("Crear");
         creatTeamButton.setBounds(100, 492, 117, 35);
         addTeamPanel.add(creatTeamButton);
         creatTeamButton.addActionListener(this); 
         creatTeamButton.setFocusable(false);
         creatTeamButton.setBackground(Color.LIGHT_GRAY);
         creatTeamButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
         creatTeamButton.setFont(new Font("Tahoma", Font.PLAIN, 15));

         
         
         updateTeamButton = new JButton("Actualizar");
         updateTeamButton.setBounds(299, 492, 117, 35);
         addTeamPanel.add(updateTeamButton);
         updateTeamButton.addActionListener(this);  
         updateTeamButton.setFocusable(false);
         updateTeamButton.setBackground(Color.LIGHT_GRAY);
         updateTeamButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
         updateTeamButton.setFont(new Font("Tahoma", Font.PLAIN, 15));

	        
         
         deleteTeamButton = new JButton("Borrar");
         deleteTeamButton.setBounds(486, 492, 117, 35);
         addTeamPanel.add(deleteTeamButton);
         deleteTeamButton.addActionListener(this);       
         deleteTeamButton.setFocusable(false);
         deleteTeamButton.setBackground(Color.LIGHT_GRAY);
         deleteTeamButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
         deleteTeamButton.setFont(new Font("Tahoma", Font.PLAIN, 15));

         
         escudoPreviewLable = new JLabel("");
         escudoPreviewLable.setBounds(50, 129, 167, 103);
         escudoPreviewLable.setHorizontalAlignment(SwingConstants.CENTER);
   		 escudoPreviewLable.setIcon(new ImageIcon(SportsDashboardPage.class.getResource("/images/escudoGenerico.png")));
         addTeamPanel.add(escudoPreviewLable);
          
         
    }
    
    private void initializeTeamTablePanel() {
    	 teamTablePanel = new JPanel();
         teamTablePanel.setBounds(632, 59, 890, 754);
         this.add(teamTablePanel);
         teamTablePanel.setLayout(null);
         
         playerListLabel = new JLabel("Lista de equipos");
	     playerListLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
	     playerListLabel.setBounds(350, 10, 316, 68);
	     teamTablePanel.add(playerListLabel);
         
         
 		columnas = new Vector<String>();
 		columnas.add("Nombre");
 		columnas.add("Escudo");
 		columnas.add("Estadio");
 		columnas.add("Ciudad");
 		columnas.add("Fundación");
         
 		datosTabla = new Vector<Vector<Object>>();
    
	        model = new DefaultTableModel(datosTabla, columnas) {
	        	private static final long serialVersionUID = -7029166140539557671L;

	        	 /**
	             * Determina si una celda específica en la tabla es editable.
	             * @param row indice de fila de la celda.
	             * @param column indice de columna de la celda.
	             * @return false para indicar que la celda no es editable.
	             */
				@Override
	        	public boolean isCellEditable(int row, int column) {
	        		return false;
	        	}
	        };
	        
	        table = new JTable(model);
	        table.setRowSelectionAllowed(true);
	        table.setEnabled(true);
	        
	        ListSelectionModel selectionModel = table.getSelectionModel();
	        selectionModel.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
	        table.setCursor(new Cursor(Cursor.HAND_CURSOR));
	        
	        tableHeader = table.getTableHeader();
	        table.getTableHeader().setFont(new Font(null, 20, 20));
	        table.getTableHeader().setBackground(Color.LIGHT_GRAY);
	        
	        
			headerSize = tableHeader.getPreferredSize();
			headerSize.height = 50; 
			tableHeader.setPreferredSize(headerSize);
			tableHeader.setReorderingAllowed(false);

			DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
			centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
			table.setDefaultRenderer(Object.class, centerRenderer);
			table.setRowHeight(40);
			table.setFont(new Font(null, 20, 20));
			
			 scrollPane = new JScrollPane(table);
		     scrollPane.setBounds(113, 125, 695, 498);
		     teamTablePanel.add(scrollPane);
		     
		     
		     updateFields();

		    
    }
    

    
    private ImageIcon setIcon(String myImagePath, byte[] byteImage) {
    	if (myImagePath != null) {
    		icon = new ImageIcon(myImagePath);
    	} else {
    		icon = new ImageIcon(byteImage);
    	}
    	
    	Image tempOneImage = icon.getImage();
    	Image tempTwoImage = tempOneImage.getScaledInstance(escudoPreviewLable.getWidth(), escudoPreviewLable.getHeight(), Image.SCALE_SMOOTH);
    	icon = new ImageIcon(tempTwoImage);
    	
		return icon;  	
    }

    
    
	private void createTable() {				
		//filas
		datosTabla = new Vector<>();
		//Por cada objeto en el array autos
		for (int i = 0; i < allTeams.size(); i++) {
			Vector<Object> fila = new Vector<>();
			//añadimos las partes del objeto al vector

			fila.add(allTeams.get(i).getName());
			fila.add(allTeams.get(i).getEscudo());
			fila.add(allTeams.get(i).getEstadio().getName());
			fila.add(allTeams.get(i).getCiudad());
			fila.add(allTeams.get(i).getFundacion());
						
			//añades la fila al vector de vectores
			datosTabla.add(fila);
			}	
			//inicializamos el dtm de nuevo con sus datos
		   model = new DefaultTableModel(datosTabla, columnas) {
	        	private static final long serialVersionUID = -7029166140539557671L;

	        	 /**
	             * Determina si una celda específica en la tabla es editable.
	             * @param row indice de fila de la celda.
	             * @param column indice de columna de la celda.
	             * @return false para indicar que la celda no es editable.
	             */
				@Override
	        	public boolean isCellEditable(int row, int column) {
	        		return false;
	        	}
	        };
			//aplicas el modelo
			table.setModel(model);	
			
			int columnIndex = 1; 

			table.getColumnModel().getColumn(columnIndex).setCellRenderer(new DefaultTableCellRenderer() {
			    private static final long serialVersionUID = -2661844236545326544L;

			    @Override
			    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
			        if (value instanceof ImageIcon) {
			            ImageIcon logo = (ImageIcon) value;
			            JLabel label = new JLabel(logo);
			            label.setOpaque(true);
			            label.setBackground(isSelected ? table.getSelectionBackground() : table.getBackground());
			            label.setFont(new Font(null, Font.PLAIN, 12)); 
			            return label;
			        }
			        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			    }
			});
		}
	
	
	public void setSeasonsManagementPanel(SeasonsManagement seasonsManagementPanel) {
		this.seasonsManagementPanel = seasonsManagementPanel;
	}
	
    

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == escudoButton) {
    		 
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(null);
          
			FileNameExtensionFilter fileNameFilter = new FileNameExtensionFilter("Todas las imagenes", "png", "jpg", "jpeg");
			fileChooser.addChoosableFileFilter(fileNameFilter);
              
			int fileChooserState = fileChooser.showSaveDialog(null);
			if (fileChooserState == JFileChooser.APPROVE_OPTION){
				imagePath = fileChooser.getSelectedFile().getAbsolutePath();
				escudoPreviewLable.setIcon(setIcon(imagePath, null));  	
			}
           		
		} else if (e.getSource() == creatTeamButton) {
			
								
			if (!nombreField.getText().isEmpty() && !ciudadField.getText().isEmpty() && !estadioField.getText().isEmpty()) {
				String nombre = nombreField.getText();
				Estadio estadio = new Estadio(estadioField.getText());		    
				String ciudad = ciudadField.getText();
				
				ImageIcon escudo  = (ImageIcon) escudoPreviewLable.getIcon();		 
			    int fundacion = (int) fundacionCombo.getSelectedItem();
			    Team team = new Team(nombre, escudo,  ciudad, estadio, fundacion);
				
			    if (!allTeams.contains(team)) {
			    	 allTeams.add(team);		    			
						createTable();	    
						resetFields();
						saveData();
						this.playersPanel.repaintTeamsComboBoxes();
						this.seasonsManagementPanel.repaintFirstList();
						fileIo.writeToFile(Time.getCurrentTime(), "data/logs/team_logs.cvs", "Equipo añadido", nombre);
				} else {
					JOptionPane.showMessageDialog(this, "El equipo existe, inserta un equipo nuevo",  "Error", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(this, "Debes rellenar todos los campos",  "Error", JOptionPane.ERROR_MESSAGE);
			}
			
		} else if (e.getSource() == updateTeamButton) {
					
			int selectedIndex = table.getSelectedRow();
						
			if (selectedIndex == -1) {
				JOptionPane.showMessageDialog(this, "Debe seleccionar una fila para actualizar",  "Error", JOptionPane.ERROR_MESSAGE);
			} else {
			allTeams.get(selectedIndex).setName(nombreField.getText());
			allTeams.get(selectedIndex).getEstadio().setName(estadioField.getText());
			allTeams.get(selectedIndex).setCiudad(ciudadField.getText());
			allTeams.get(selectedIndex).setFundacion((int) fundacionCombo.getSelectedItem());
			allTeams.get(selectedIndex).setEscudo((ImageIcon) escudoPreviewLable.getIcon());
			fileIo.writeToFile(Time.getCurrentTime(), "data/logs/team_logs.cvs", "Equipo actualizado", allTeams.get(selectedIndex).getName());
			createTable();	    
			saveData();
			this.playersPanel.repaintTeamsComboBoxes();
			this.seasonsManagementPanel.repaintFirstList();

			}
			
		
		} else if (e.getSource() == deleteTeamButton) {
			int selectedIndex = table.getSelectedRow();
			
			if (selectedIndex == -1) {
				JOptionPane.showMessageDialog(this, "Debe seleccionar una fila para borrar",  "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				model.removeRow(selectedIndex);
				fileIo.writeToFile(Time.getCurrentTime(), "data/logs/team_logs.cvs", "Equipo borrado", allTeams.get(selectedIndex).getName());
				allTeams.remove(selectedIndex);	
				resetFields();
				saveData();
				this.playersPanel.repaintTeamsComboBoxes();
				this.seasonsManagementPanel.repaintFirstList();
			}	
			
		} 
	}
	
	private void saveData() {
		 fileIo.writeObject(FILE_PATH, allTeams);
	}
	
	private void resetFields() {
		fundacionCombo.setSelectedIndex(fundacionCombo.getItemCount() - 1);	
		nombreField.setText("");
		escudoPreviewLable.setIcon(new ImageIcon(SportsDashboardPage.class.getResource("/images/escudoGenerico.png")));
		estadioField.setText("");
		ciudadField.setText("");
	}

	private void updateFields() {
		
		ListSelectionModel selectionModel = table.getSelectionModel();
		 selectionModel.addListSelectionListener(new ListSelectionListener() {	
				@Override
	         public void valueChanged(ListSelectionEvent e) {
					 if (!e.getValueIsAdjusting() && !selectionModel.isSelectionEmpty()) {
	                	
						 int selectedRow = table.getSelectedRow();
    	 
	     			 nombreField.setText(allTeams.get(selectedRow).getName());   			  
	     			 estadioField.setText(allTeams.get(selectedRow).getEstadio().getName());	     			  
	     			 ciudadField.setText(allTeams.get(selectedRow).getCiudad());   			 
	     	   		 escudoPreviewLable.setIcon(allTeams.get(selectedRow).getEscudo());
	     			 fundacionCombo.setSelectedItem(allTeams.get(selectedRow).getFundacion());    	    		
				}
	         }
	     });
	}
}