package master.dao.imp.coordi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import master.dao.factory.coordi.OraFactory;
import master.dao.interfaces.coordi.ResponsableDao;

public class ResponsableDaoImp implements  ResponsableDao{

	@Override
	public boolean checkLogin(String email, String password) {
	  PreparedStatement ps = null;
	  ResultSet resultat = null;
	  Connection connexion=null;
	  boolean login=false;
	  try {
		  connexion=OraFactory.getConnection();
		  ps = connexion.prepareStatement("SELECT * FROM RESPONSABLE WHERE EMAIL = ? AND password = ?");
		  ps.setString(1, email);
		  ps.setString(2, password);
	      resultat = ps.executeQuery();
	      while(resultat.next()) login=true;
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	    try {if (resultat != null) resultat.close();} catch (SQLException e) { e.printStackTrace(); }
	    try {if (ps != null) resultat.close();}		  catch (SQLException e) { e.printStackTrace(); }
	    try {if (connexion != null) resultat.close();}catch (SQLException e) { e.printStackTrace(); }
	    }
	  return login ;
	}

	@Override
	public int getById(String email) {
		  PreparedStatement ps = null;
		  ResultSet resultat = null;
		  Connection connexion=null;
		  int id=-1;
		  try {
			  connexion=OraFactory.getConnection();
			  ps = connexion.prepareStatement("SELECT ID_RESPO FROM RESPONSABLE WHERE EMAIL = ? ");
			  ps.setString(1, email);
		      resultat = ps.executeQuery();
		      if(resultat.next()) id=resultat.getInt("ID_RESPO");
		    } catch (SQLException e) {
		        e.printStackTrace();
		    } finally {
	    	  if (resultat != null) {try { resultat.close();} catch (SQLException e) { e.printStackTrace();  }}
	    	  if (ps != null) {try {ps.close();} catch (SQLException e) { e.printStackTrace();} }
	    	  if (connexion != null) {try {connexion.close();} catch (SQLException e) {e.printStackTrace();}}
		    }
		return id;
	}
}
