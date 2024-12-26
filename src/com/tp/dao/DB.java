package com.tp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.tp.model.Etudiant;
import com.tp.model.Filiere;

public class DB {
	
	Connection conn;
	
	public DB() {
		connect();
	}
	
	
	public void connect() {
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/app", "postgres", "G0DBLEESu");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void ajouterEtudiant(Etudiant et, int num) {
		try {
			Statement st = conn.createStatement();
			Statement st2 = conn.createStatement();
			st.executeUpdate("insert into etudiant(cne, nom, prenom, adresse) values ('" + et.getCNE() + "','" + et.getNom() + "', '" + et.getPrenom() 
			+ "', '" + et.getAdresse() + "')");
			st2.executeUpdate("insert into inscris(cne, num) values ('" + et.getCNE() + "', '" + num + "')");
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void ajouterFiliere(Filiere f) {
		try {
			Statement st = conn.createStatement();
			st.executeUpdate("insert into filiere(nom, nbetudiants) values ('" + f.getNom() + "', '" + f.getNbrEtudiants() + "')");
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void inscris(String cne, int num) {
		try {
			Statement st = conn.createStatement();
			st.executeUpdate("insert into inscris(cne, num) values ('" + cne + "', " + num + ")");
			st.close();
		} catch (Exception e) {
			System.out.println("cne or num not exist.");
			e.printStackTrace();
		}
	}
	
	
	public ResultSet afficherEtudiants() {
		try {
			Statement st = conn.createStatement();
			return st.executeQuery("SELECT e.cne, e.nom, e.prenom, e.adresse, f.nom AS filiere " +
		               "FROM etudiant e " +
		               "JOIN inscris i ON e.cne = i.cne " +
		               "JOIN filiere f ON i.num = f.num");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public ResultSet afficherFilieres() {
		try {
			Statement st = conn.createStatement();
			return st.executeQuery("select * from filiere");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public ResultSet afficherInscris() {
		try {
			Statement st = conn.createStatement();
			return st.executeQuery("select * from inscris");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public ResultSet afficherNomFiliere(String cne) {
	    try {
	        Statement st = conn.createStatement();
	        return st.executeQuery("SELECT f.nom FROM filiere f, inscris i WHERE f.num = i.num AND i.cne = '" + cne + "'");
	    } catch (Exception e) {
	        System.out.println("Y a pas de resultat.");
	        e.printStackTrace();
	    }
	    return null;
	}
	
	
	public void modifierEtudiant(Etudiant et) {
		try {
			Statement st = conn.createStatement();
			st.executeUpdate(
					"update etudiant set nom = '" + et.getNom() + 
					"', prenom = '" + et.getPrenom() + 
					"', adresse = '" + et.getAdresse() + 
					"' where cne = '" + et.getCNE() + "'"
			);
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void modifierFiliere(Filiere filiere, int num) {
	    try {
	        Statement st = conn.createStatement();
	        String query = "UPDATE filiere SET nom = '" + filiere.getNom() + 
	                       "', nbetudiants = " + filiere.getNbrEtudiants() + 
	                       " WHERE num = " + num;
	        st.executeUpdate(query);
	        st.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	
	public void supprimerEtudiant(String cne) {
	    try {
	        Statement st = conn.createStatement();
	        String query = "DELETE FROM etudiant WHERE cne = '" + cne + "'";
	        st.executeUpdate(query);
	        st.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	
	public void supprimerFiliere(int num) {
	    try {
	        Statement st = conn.createStatement();
	        String query = "DELETE FROM filiere WHERE num = " + num;
	        st.executeUpdate(query);
	        st.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}


}
