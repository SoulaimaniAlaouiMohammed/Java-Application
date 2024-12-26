package com.tp.vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.tp.dao.DB;
import com.tp.model.Etudiant;
import com.tp.model.Filiere;

import javax.swing.JButton;

public class App extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table1;
	private JTable table;
	
	JButton ajouterBtn1 = new JButton();
	JButton ajouterBtn2 = new JButton();
	JButton modifierBtn1 = new JButton();
	JButton supprimerBtn1 = new JButton();
	JButton printBtn1 = new JButton();
	JButton modifierBtn2 = new JButton();
	JButton supprimerBtn2 = new JButton();
	JButton printBtn2 = new JButton();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App frame = new App();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public App() {
		setTitle("App");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 682, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel et_label = new JLabel("Etudiants");
		et_label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		et_label.setBounds(10, 11, 73, 19);
		contentPane.add(et_label);
		
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(10, 32, 646, 159);
		contentPane.add(scrollPane1);
		
		List<String[]> etData = new ArrayList<>();
		
		DB db = new DB();
		ResultSet etudResult = db.afficherEtudiants();
		
		try {
			while (etudResult.next()) {
				String cne = etudResult.getString("cne");
				String nom = etudResult.getString("nom");
				String prenom = etudResult.getString("prenom");
				String adr = etudResult.getString("adresse");
				String nomFiliere = etudResult.getString("filiere");
				etData.add(new String[] {cne, nom, prenom, adr, nomFiliere});
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String[][] etudiantsData = new String[etData.size()][5];
        etData.toArray(etudiantsData);
		
		table1 = new JTable();
		table1.setModel(new DefaultTableModel(
				etudiantsData,
			new String[] {
				"CNE", "Nom", "Prenom", "Adresse", "Filiere"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane1.setViewportView(table1);
		
		JLabel filiere_label = new JLabel("Filiere");
		filiere_label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		filiere_label.setBounds(10, 236, 73, 19);
		contentPane.add(filiere_label);
		
		ajouterBtn1 = new JButton("Ajouter");
		ajouterBtn1.setBounds(10, 202, 89, 23);
		contentPane.add(ajouterBtn1);
		
		modifierBtn1 = new JButton("Modifer");
		modifierBtn1.setBounds(130, 202, 89, 23);
		contentPane.add(modifierBtn1);
		
		supprimerBtn1 = new JButton("Supprimer");
		supprimerBtn1.setBounds(254, 202, 89, 23);
		contentPane.add(supprimerBtn1);
		
		printBtn1 = new JButton("Printer");
		printBtn1.setBounds(376, 202, 89, 23);
		contentPane.add(printBtn1);
		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(10, 257, 646, 160);
		contentPane.add(scrollPane2);
		
		
		ResultSet filiereResult = db.afficherFilieres();
		List<String[]> fData = new ArrayList<>();

		try {
		    while (filiereResult.next()) {
		        int num = filiereResult.getInt("num");
		        String nom = filiereResult.getString("nom");
		        int nbr = filiereResult.getInt("nbetudiants");
		        
		        fData.add(new String[] {String.valueOf(num), nom, String.valueOf(nbr)});
		    }
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		
		String[][] filiereData = new String[fData.size()][3];
		fData.toArray(filiereData);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
				filiereData,
			new String[] {
				"Numero", "Nom", "Nbr Etudiants"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane2.setViewportView(table);
		
		ajouterBtn2 = new JButton("Ajouter");
		ajouterBtn2.setBounds(10, 428, 89, 23);
		contentPane.add(ajouterBtn2);
		
		modifierBtn2 = new JButton("Modifier");
		modifierBtn2.setBounds(130, 428, 89, 23);
		contentPane.add(modifierBtn2);
		
		supprimerBtn2 = new JButton("Supprimer");
		supprimerBtn2.setBounds(254, 428, 89, 23);
		contentPane.add(supprimerBtn2);
		
		printBtn2 = new JButton("Printer");
		printBtn2.setBounds(376, 428, 89, 23);
		contentPane.add(printBtn2);
		
		ajouterBtn1.addActionListener(new MyEvents());
		ajouterBtn2.addActionListener(new MyEvents());
		
		modifierBtn1.addActionListener(new MyEvents());
		modifierBtn2.addActionListener(new MyEvents());
		
		supprimerBtn1.addActionListener(new MyEvents());
		supprimerBtn2.addActionListener(new MyEvents());
	}
	
	
	
	public class MyEvents implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	        if (e.getSource() == ajouterBtn1) {
	            AjouterEtud aj = new AjouterEtud();
	            aj.setVisible(true);
	        } else if (e.getSource() == ajouterBtn2) {
	            AjouterFiliere ajF = new AjouterFiliere();
	            ajF.setVisible(true);
	        } else if (e.getSource() == modifierBtn1) {
	            int row = table1.getSelectedRow();

	            String cne = (String) table1.getValueAt(row, 0);
	            String nom = (String) table1.getValueAt(row, 1);
	            String prenom = (String) table1.getValueAt(row, 2);
	            String adresse = (String) table1.getValueAt(row, 3);
	            
	            Etudiant etudiant = new Etudiant(cne, nom, prenom, adresse);
	            
	            ModifierEt modif = new ModifierEt(etudiant);
	            modif.setVisible(true);
	        } else if (e.getSource() == modifierBtn2) {
	        	
	        	int row = table.getSelectedRow();
	        	int num = (int) Integer.valueOf((String) table.getValueAt(row, 0));
	        	String nom = (String) table.getValueAt(row, 1);
	        	int nb = (int) Integer.valueOf((String) table.getValueAt(row, 2));
	        	
	        	ModifierFil modif = new ModifierFil(new Filiere(nom, nb), num);
	        	modif.setVisible(true);
	        } else if (e.getSource() == supprimerBtn1) {
	        	int row = table1.getSelectedRow();
                String cne = (String) table1.getValueAt(row, 0);
                DB db = new DB();
                db.supprimerEtudiant(cne);
                
                DefaultTableModel model = (DefaultTableModel) table1.getModel();
                model.removeRow(row);
                table1.revalidate();
                table1.repaint();
	        } else if (e.getSource() == supprimerBtn2) {
	        	int row = table.getSelectedRow();
                int num = (int) Integer.valueOf((String) table.getValueAt(row, 0));
                DB db = new DB();
                db.supprimerFiliere(num);
                
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.removeRow(row);
                table.revalidate();
                table.repaint();
	        }
	    }
	}
	
}
