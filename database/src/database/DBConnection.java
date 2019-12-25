package database;

import java.sql.*;

public class DBConnection {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/data_Con?autoReconnect=true&useSSL=false",
					"root", "Qwerty120995!");

			/* select table */
			/*
			 * pst = conn.prepareStatement("SELECT * FROM user_table"); rs =
			 * pst.executeQuery();
			 * 
			 * while(rs.next()) { System.out.print(rs.getString("username"));
			 * 
			 * System.out.println(rs.getInt("pword")); }
			 */

			/*
			 * add data to table
			 * 
			 * pst=conn.prepareStatement("INSERT INTO user_table(username,pword)values(?,?)"
			 * ); pst.setString(1,"angelo"); pst.setInt(2, 344);
			 * 
			 * pst.executeUpdate();
			 */

			/* update table */
			/*
			 * pst=conn.
			 * prepareStatement("update user_table set username = ?, pword = ? where id = ?"
			 * ); 
			 * pst.setString(1,"neil"); 
			 * pst.setInt(2, 99); 
			 * pst.setInt(3,4);
			 * pst.executeUpdate();
			 */
			
			/* delete columm row */
			/*
			 * pst=conn.prepareStatement("delete from user_table where id = 1");
			 * 
			 * pst.execute();
			 */
			
			/* select table alias */
			
			pst = conn.prepareStatement("SELECT username as user FROM user_table where id = ?");
			pst.setLong(1,2);
			
			rs =  pst.executeQuery();
			 while(rs.next()) {
				 System.out.println(rs.getString("user"));
			 }
				 
			 


		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

}