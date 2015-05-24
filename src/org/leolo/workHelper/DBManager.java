package org.leolo.workHelper;

import java.io.File;
import java.io.IOException;
import java.sql.*;

import org.apache.commons.io.FileUtils;

public final class DBManager {
	
	public static final int CURRENT_DB_VERSION = 1;

	static{
		System.setProperty("java.io.tmpdir", "./tmp");
		File tempdir = new File("./tmp");
		try {
			FileUtils.cleanDirectory(tempdir);
			Class.forName("org.sqlite.JDBC");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private DBManager(){
	}
	
	public static Connection getConnection(String db) throws SQLException{
		Connection con = DriverManager.getConnection("jdbc:sqlite:"+db);
		con.setAutoCommit(false);
		return con;
	}
	
	public static boolean verifyDBVersion(Connection con) throws SQLException{
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM sqlite_master "
				+ "WHERE type='table' AND name='metadata';");
		rs.next();
		if(rs.getInt(1) == 0)
			return false;
		//Check DB version
		rs.close();
		rs = stmt.executeQuery("SELECT value FROM metadata "
				+ "WHERE key='version';");
		rs.next();
		int version = rs.getInt(1);
		rs.close();
		stmt.close();
		return version == CURRENT_DB_VERSION;
	}
	
	public static String getMetadata(Connection conn, String key) throws SQLException{
		String sql = "SELECT value FROM metadata WHERE key=?;";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, key);
		ResultSet rs = pstmt.executeQuery();
		String result;
		if(rs.next()){
			result = rs.getString(1);
		}else{
			result = null;
		}
		rs.close();
		pstmt.close();
		return result;
	}
	
	public static void populate(Connection con) throws SQLException{
		Statement stmt = con.createStatement();
		con.setAutoCommit(false);
		stmt.execute("CREATE TABLE metadata(key TEXT PRIMARY KEY,value TEXT NULL);");
		stmt.execute("CREATE TABLE treedata(nodeID TEXT PROMARY KEY,name TEXT NOT NULL,parent TEXT NOT NULL,note BLOB NOT NULL);");
		stmt.execute("CREATE TABLE childlist(parent TEXT,child TEXT, PRIMARY KEY(parent,child));");
		stmt.execute("INSERT INTO metadata VALUES ('version',"+CURRENT_DB_VERSION+");");
		con.commit();
		stmt.close();
	}
}
