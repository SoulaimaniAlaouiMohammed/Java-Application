package com.tp.vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.tp.dao.DB;
import com.tp.model.Etudiant;
import com.tp.model.Filiere;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AjouterFiliere extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nom_field;
	private JTextField nbEtud_field;
	
	JButton ajouterBtn = new JButton();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjouterFiliere frame = new AjouterFiliere();
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
	public AjouterFiliere() {
		setTitle("Ajouter Filiere");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 672, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		nom_field = new JTextField();
		nom_field.setColumns(10);
		nom_field.setBounds(188, 89, 223, 29);
		contentPane.add(nom_field);
		
		nbEtud_field = new JTextField();
		nbEtud_field.setColumns(10);
		nbEtud_field.setBounds(188, 174, 223, 29);
		contentPane.add(nbEtud_field);
		
		ajouterBtn = new JButton("Ajouter");
		ajouterBtn.setBounds(188, 248, 89, 23);
		contentPane.add(ajouterBtn);
		
		JLabel nom_label = new JLabel("Nom");
		nom_label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		nom_label.setBounds(48, 89, 60, 29);
		contentPane.add(nom_label);
		
		JLabel nbrEtud_label = new JLabel("Nbr Etudiants");
		nbrEtud_label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		nbrEtud_label.setBounds(48, 181, 117, 29);
		contentPane.add(nbrEtud_label);
		
		ajouterBtn.addActionListener(new Click());
	}
	
	
	public class Click implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == ajouterBtn) {
				String nom = nom_field.getText();
				int nb = Integer.valueOf(nbEtud_field.getText());
				Filiere f = new Filiere(nom, nb);
				DB db = new DB();
				db.ajouterFiliere(f);
				nom_field.setText("");
				nbEtud_field.setText("");
			}
		}
	}

}
