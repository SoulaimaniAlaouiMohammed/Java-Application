package com.tp.vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.tp.dao.DB;
import com.tp.model.Filiere;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModifierFil extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nom_field;
	private JTextField nbEtud_field;
	
	JButton modifierBtn = new JButton();

	
	private Filiere filiere;
	private int num = 0;
	/**
	 * Create the frame.
	 */
	public ModifierFil(Filiere f, int num) {
		this.filiere = f;
		this.num = num;
		initialize();
	}
	
	
	private void initialize() {
		setTitle("Modifier Filiere");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 682, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		nom_field = new JTextField(filiere.getNom());
		nom_field.setBounds(198, 56, 252, 35);
		contentPane.add(nom_field);
		nom_field.setColumns(10);
		
		nbEtud_field = new JTextField(String.valueOf(filiere.getNbrEtudiants()));
		nbEtud_field.setColumns(10);
		nbEtud_field.setBounds(198, 139, 252, 35);
		contentPane.add(nbEtud_field);
		
		modifierBtn = new JButton("Modifier");
		modifierBtn.setBounds(198, 211, 89, 23);
		contentPane.add(modifierBtn);
		
		JLabel nom_label = new JLabel("Nom");
		nom_label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		nom_label.setBounds(51, 77, 51, 14);
		contentPane.add(nom_label);
		
		JLabel nbetud_label = new JLabel("Nb Etudiants");
		nbetud_label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		nbetud_label.setBounds(51, 160, 113, 14);
		contentPane.add(nbetud_label);

		
		modifierBtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String nom = nom_field.getText();
		        int nbEtudiants = Integer.parseInt(nbEtud_field.getText());
		        Filiere filiere = new Filiere(nom, nbEtudiants);

		        DB db = new DB();
		        db.modifierFiliere(filiere, num);
		        nom_field.setText("");
		        nbEtud_field.setText("");
		        
		    }
		});

	}

}
