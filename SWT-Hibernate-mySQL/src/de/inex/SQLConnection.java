package de.inex;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SQLConnection {

	private boolean connected = false;
	private SessionFactory sessionFactory = null;
	private Session session = null;
	private String dbURL = "jdbc:mysql://localhost:3306/test";
	private String dbUser = "testuser";
	private String dbPwd = "testpwd";
	Statement stmt;

	public boolean isConnected() {
		return connected;
	}

	public void dbConnector() {
		sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(dbURL, dbUser, dbPwd);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		connected = session.isConnected();
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (connected) {
			System.out.println("Connection established!");
		} else {
			System.out.println("Connection Failed!");
		}
	}

	public void dbDisconnect() {
		session.close();
		sessionFactory.close();
		if (!session.isConnected()) {
			System.out.println("Connection closed!");
		} else {
			System.out.println("Error at Disconenct!");
		}
	}
	
	public void update(Testdb user) {
		Transaction tx = session.beginTransaction();
		session.update(user);
		tx.commit();
	}

	public void commit(String vorname, String nachname, String email, String telefon, String geburtsdatum) {
		Testdb user = new Testdb();
		user.setVorname(vorname);
		user.setNachname(nachname);
		user.setEmail(email);
		user.setTelefonnummer(telefon);
		user.setGeburtsdatum(geburtsdatum);
		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
	}

	public List<Testdb> checkData(String sql) throws Exception {
			List<Testdb> userList = new ArrayList<Testdb>();
		
			ResultSet rs = stmt.executeQuery(sql);
		    
		    while(rs.next()){
		    Testdb user = new Testdb();
		    user.setId(rs.getInt("Id"));
		    user.setVorname(rs.getString("Vorname"));
		    user.setNachname(rs.getString("Nachname"));
		    user.setEmail(rs.getString("Email"));
		    user.setTelefonnummer(rs.getString("Telefonnummer"));
		    user.setGeburtsdatum(rs.getString("Geburtstagsdatum"));
		    userList.add(user);
		    }
		    return userList;
	  }
}