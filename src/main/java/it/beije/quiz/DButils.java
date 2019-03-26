package it.beije.quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DButils {
	
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "Beije06";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/gestionale?serverTimezone=CET";
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		
		return conn;
	}

	public static boolean findUser(String user, String password) {
		boolean utente = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset= null;

		try {
			conn = DButils.getConnection();
			
			String query = "SELECT USERNAME FROM USERS WHERE USERNAME = ? AND PASSWORD = ?";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, user);
			pstmt.setString(2, password);
			rset = pstmt.executeQuery();
			
			while (rset.next()) {
				
				String login = rset.getString("USERNAME");
				utente = true;

				System.out.println("utente " + login + " trovato!!");
			}
			
		}
		catch (SQLException se) {
			System.out.println("SQLError: " + se.getMessage() + " code: " + se.getErrorCode());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		finally {
			try {
				rset.close();
				pstmt.close();
				conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return utente;
		
	}
	
	public static boolean findUser(String user) {
		boolean utente = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset= null;

		try {
			conn = DButils.getConnection();
			
			String query = "SELECT USERNAME FROM USERS WHERE USERNAME = ?";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, user);
			rset = pstmt.executeQuery();
			
			while (rset.next()) {
				
				String login = rset.getString("USERNAME");
				utente = true;

				System.out.println("utente " + login + " trovato!!");
			}
			
		}
		catch (SQLException se) {
			System.out.println("SQLError: " + se.getMessage() + " code: " + se.getErrorCode());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		finally {
			try {
				rset.close();
				pstmt.close();
				conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return utente;
		
	}
	
	public static void addUser(String user, String password) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DButils.getConnection();
			
			 String query = " insert into users (username, password) values (?, ?)";
			 pstmt = conn.prepareStatement(query);
			 pstmt.setString (1, user);
			 pstmt.setString (2, password);
			 
			 pstmt.execute();
			
		}
		catch (SQLException se) {
			System.out.println("SQLError: " + se.getMessage() + " code: " + se.getErrorCode());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		finally {
			try {
				pstmt.close();
				conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}