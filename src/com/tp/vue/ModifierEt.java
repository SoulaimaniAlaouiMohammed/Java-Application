package com.tp.vue;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.tp.dao.DB;
import com.tp.model.Etudiant;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModifierEt extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField cne_field;
    private JTextField nom_field;
    private JTextField prenom_field;
    private JTextField adresse_field;
    private JButton modifierBtn;

    private Etudiant etudiant;

    /**
     * Constructor to receive Etudiant object
     */
    public ModifierEt(Etudiant etudiant) {
        this.etudiant = etudiant;
        initialize();
    }

    /**
     * Initialize the frame
     */
    private void initialize() {
        setTitle("Modifier Etudiant");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 684, 492);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        cne_field = new JTextField(etudiant.getCNE());
        cne_field.setBounds(197, 38, 243, 32);
        contentPane.add(cne_field);
        cne_field.setColumns(10);
        cne_field.setEnabled(false);

        nom_field = new JTextField(etudiant.getNom());
        nom_field.setBounds(197, 95, 243, 32);
        contentPane.add(nom_field);
        nom_field.setColumns(10);

        prenom_field = new JTextField(etudiant.getPrenom());
        prenom_field.setBounds(197, 149, 243, 32);
        contentPane.add(prenom_field);
        prenom_field.setColumns(10);

        adresse_field = new JTextField(etudiant.getAdresse());
        adresse_field.setBounds(197, 216, 243, 32);
        contentPane.add(adresse_field);
        adresse_field.setColumns(10);
        
        modifierBtn = new JButton("Modifier");
        modifierBtn.setBounds(197, 291, 89, 23);
        contentPane.add(modifierBtn);

        JLabel cne_label = new JLabel("CNE");
        cne_label.setFont(new Font("Tahoma", Font.PLAIN, 18));
        cne_label.setBounds(32, 56, 54, 14);
        contentPane.add(cne_label);

        JLabel nom_label = new JLabel("Nom");
        nom_label.setFont(new Font("Tahoma", Font.PLAIN, 18));
        nom_label.setBounds(32, 113, 54, 14);
        contentPane.add(nom_label);

        JLabel prenom_label = new JLabel("Prenom");
        prenom_label.setFont(new Font("Tahoma", Font.PLAIN, 18));
        prenom_label.setBounds(32, 167, 78, 14);
        contentPane.add(prenom_label);

        JLabel adresse_label = new JLabel("Adresse");
        adresse_label.setFont(new Font("Tahoma", Font.PLAIN, 18));
        adresse_label.setBounds(32, 234, 78, 14);
        contentPane.add(adresse_label);


        modifierBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				DB db = new DB();
				db.modifierEtudiant(new Etudiant(cne_field.getText(), nom_field.getText(), prenom_field.getText(), adresse_field.getText()));
				cne_field.setText("");
				nom_field.setText("");
				prenom_field.setText("");
				adresse_field.setText("");
			}
        });
        
    }
}
