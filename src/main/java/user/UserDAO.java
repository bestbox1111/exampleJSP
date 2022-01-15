package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
	
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;

	
	public UserDAO() {
		try {
			String dbURL = "jdbc:mysql://localhost:3306/BBS";
			String dbID ="root";
			String dbPassword ="root";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public int login(String userID, String userPassword) {
	
		String SQL = "SELECT userPassword FROM USER WHERE userID=?";
		try {
			
			psmt = conn.prepareStatement(SQL);
			psmt.setString(1, userID);
			rs= psmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).equals(userPassword)) {
					return 1;
				}
				else { 
					return 0;
				}
				
			}
			return -1;
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return -2;
		
		
		
	}
	
	
	public int join(User user) {
		String SQL="INSERT INTO USER VALUES(?,?,?,?,?)";
		try {
			
			psmt= conn.prepareStatement(SQL);
			psmt.setString(1, user.getUserID());
			psmt.setString(2, user.getUserPassword());
			psmt.setString(3, user.getUserName());
			psmt.setString(4, user.getUserGender());
			psmt.setString(5, user.getUserEmail());
			return psmt.executeUpdate();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	
	
}
