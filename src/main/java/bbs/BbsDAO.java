package bbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BbsDAO {

	
	private Connection conn;
	
	private ResultSet rs;

	
	public BbsDAO() {
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
	
	public String getDate() {
		String SQL="SELECT NOW()";
		try {
			PreparedStatement psmt = conn.prepareStatement(SQL);
			rs= psmt.executeQuery();
			if(rs.next()) {
				return rs.getString(1);
			}
		}catch(Exception e){
			e.printStackTrace();			
		}
		return "";
	}
	
	
	
	public int getNext() {
		String SQL="SELECT bbsID FROM BBS ORDER BY bbsID DESC";
		try {
			PreparedStatement psmt = conn.prepareStatement(SQL);
			rs= psmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1) +1;
			}
			return 1;	//첫번째 게시물인경우
		}catch(Exception e){
			e.printStackTrace();			
		}
		return -1;	//데이터 베이스 오류일경우. 게시물이 -일경우인 경우는 없으니까.
	}
	
	
	
	
	
	public int write(String bbsTitle, String userID, String bbsContent) {
		String SQL="INSERT INTO BBS VALUES(?,?,?,?,?,?)";
		try {
			PreparedStatement psmt = conn.prepareStatement(SQL);
			psmt.setInt(1, getNext());
			psmt.setString(2, bbsTitle);
			psmt.setString(3, userID);
			psmt.setString(4, getDate());
			psmt.setString(5, bbsContent);
			psmt.setInt(6, 1);
			
			
			return psmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();			
		}
		return -1;	//데이터 베이스 오류일경우. 게시물이 -일경우인 경우는 없으니까.
	}
	
	
	public ArrayList<Bbs> getList(int pageNumber){
		String SQL="SELECT * FROM BBS WHERE bbsID < ? AND bbsAvailable = 1 ORDER BY bbsID DESC LIMIT 10";
		ArrayList<Bbs> list =  new ArrayList<Bbs>();
		
		
		
		try {
			PreparedStatement psmt = conn.prepareStatement(SQL);
			psmt.setInt(1, getNext()-(pageNumber-1)*10);	//1페이지에 10까지 출력되게 만드는???
			rs= psmt.executeQuery();
		
			while (rs.next()) {
				Bbs bbs = new Bbs();
				bbs.setBbsID(rs.getInt(1));
				bbs.setBbsTitle(rs.getString(2));
				bbs.setUserID(rs.getString(3));
				bbs.setBbsDate(rs.getString(4));
				bbs.setBbsContent(rs.getString(5));
				bbs.setBbsAvailable(rs.getInt(6));
				list.add(bbs);
			}
			
		}catch(Exception e){
			e.printStackTrace();			
		}
		return list;	//데이터 베이스 오류일경우. 게시물이 -일경우인 경우는 없으니까.
	}
		
		
		
		public boolean nextPage(int pageNumber) {
			String SQL="SELECT * FROM BBS WHERE bbsID < ? AND bbsAvailable = 1";
		
			
			try {
				PreparedStatement psmt = conn.prepareStatement(SQL);
				psmt.setInt(1, getNext()-(pageNumber-1)*10);	//1페이지에 10까지 출력되게 만드는???
				rs= psmt.executeQuery();
			
				if(rs.next()) {
					return true;
				}
				
			}catch(Exception e){
				e.printStackTrace();			
			}
			return false;	//데이터 베이스 오류일경우. 게시물이 -일경우인 경우는 없으니까.
		}
			
		
		
		public Bbs getBbs(int bbsID) {
			
			
			String SQL = " SELECT * FROM BBS WHERE bbsID = ?";
			
			try {
				PreparedStatement psmt = conn.prepareStatement(SQL);
				psmt.setInt(1, bbsID);
				rs= psmt.executeQuery();
			
				if (rs.next()) {
					Bbs bbs = new Bbs();
					bbs.setBbsID(rs.getInt(1));
					bbs.setBbsTitle(rs.getString(2));
					bbs.setUserID(rs.getString(3));
					bbs.setBbsDate(rs.getString(4));
					bbs.setBbsContent(rs.getString(5));
					bbs.setBbsAvailable(rs.getInt(6));
					return bbs;
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			return null;
		}
		
		
		
	
		public int update(int bbsID, String bbsTitle, String bbsContent ) {
			
			String SQL = "UPDATE BBS SET bbsTitle = ?, bbsContent = ? WHERE bbsID = ?";
			
			try {
				PreparedStatement psmt = conn.prepareStatement(SQL);
		
				psmt.setString(1, bbsTitle);
				psmt.setString(2, bbsContent);
				psmt.setInt(3, bbsID);
				return psmt.executeUpdate();
			}catch(Exception e){
				e.printStackTrace();			
			}
			return -1;	//데이터 베이스 오류일경우. 게시물이 -일경우인 경우는 없으니까.
		}
		
		
		public int delete(int bbsID) {
			
			String SQL = "UPDATE BBS SET bbsAvailable =0 WHERE bbsID = ?";
			
			try {
				PreparedStatement psmt = conn.prepareStatement(SQL);
		
				psmt.setInt(1, bbsID);
				return psmt.executeUpdate();
			}catch(Exception e){
				e.printStackTrace();			
			}
			return -1;	//데이터 베이스 오류일경우. 게시물이 -일경우인 경우는 없으니까.
		}
		
		
	
	
}
