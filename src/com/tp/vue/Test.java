package com.tp.vue;



import java.sql.ResultSet;
import java.sql.SQLException;

import com.tp.dao.DB;
import com.tp.model.Etudiant;
import com.tp.model.Filiere;

public class Test {

	public static void main(String[] args) {
		
		DB db = new DB();
		
		Etudiant etud = new Etudiant("userr!!!", "zzzzzzzzzz", "mmm", "ggg");
		Filiere filiere = new Filiere("csssss", 100);
		
//		ResultSet result = db.afficherNomFiliere("cne123");
//		
//		try {
//			while (result.next()) {
//				String nom = result.getString("nom");
//				System.out.println("result: " + nom);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
		//db.ajouterEtudiant(etud, 1);
		
		//db.modifierEtudiant(etud);
		
		//db.supprimerEtudiant("n123");
		
	}
}
