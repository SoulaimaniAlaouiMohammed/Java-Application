package com.tp.vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.tp.dao.DB;
import com.tp.model.Etudiant;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class AjouterEtud extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField cne_field;
	private JTextField nom_field;
	private JTextField prenom_field;
	private JTextField adr_field;
	
	JButton ajouterBtn = new JButton();
	private JTextField filiere_field;
	private JLabel filiere_label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjouterEtud frame = new AjouterEtud();
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
	public AjouterEtud() {
		setTitle("Ajouter Etudiant");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 679, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel cne_label = new JLabel("CNE");
		cne_label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cne_label.setBounds(36, 58, 46, 22);
		contentPane.add(cne_label);
		
		JLabel nom_label = new JLabel("Nom");
		nom_label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		nom_label.setBounds(39, 115, 57, 26);
		contentPane.add(nom_label);
		
		JLabel prenom_label = new JLabel("Prenom");
		prenom_label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		prenom_label.setBounds(36, 179, 78, 26);
		contentPane.add(prenom_label);
		
		JLabel adr_label = new JLabel("Adresse");
		adr_label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		adr_label.setBounds(36, 235, 89, 22);
		contentPane.add(adr_label);
		
		cne_field = new JTextField();
		cne_field.setBounds(168, 51, 223, 29);
		contentPane.add(cne_field);
		cne_field.setColumns(10);
		
		nom_field = new JTextField();
		nom_field.setColumns(10);
		nom_field.setBounds(168, 112, 223, 29);
		contentPane.add(nom_field);
		
		prenom_field = new JTextField();
		prenom_field.setColumns(10);
		prenom_field.setBounds(168, 169, 223, 29);
		contentPane.add(prenom_field);
		
		adr_field = new JTextField();
		adr_field.setColumns(10);
		adr_field.setBounds(168, 228, 223, 29);
		contentPane.add(adr_field);
		
		ajouterBtn = new JButton("Ajouter");
		ajouterBtn.setBounds(168, 344, 89, 23);
		contentPane.add(ajouterBtn);
		
		filiere_field = new JTextField();
		filiere_field.setBounds(168, 284, 223, 26);
		contentPane.add(filiere_field);
		filiere_field.setColumns(10);
		
		filiere_label = new JLabel("Num Filiere");
		filiere_label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		filiere_label.setBounds(36, 290, 89, 22);
		contentPane.add(filiere_label);
		
		ajouterBtn.addActionListener(new Click());
	}
	
	public class Click implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == ajouterBtn) {
				String cne = cne_field.getText();
				String nom = nom_field.getText();
				String prenom = prenom_field.getText();
				String adresse = adr_field.getText();
				int num = Integer.valueOf(filiere_field.getText());
				Etudiant et = new Etudiant(cne, nom, prenom, adresse);
				DB db = new DB();
				db.ajouterEtudiant(et, num);
				cne_field.setText("");
				nom_field.setText("");
				prenom_field.setText("");
				adr_field.setText("");
				filiere_field.setText("");
			}
		}
	}
}
