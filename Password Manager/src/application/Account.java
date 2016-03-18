package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Account {

	private String userID;
	private Connection connection;

	public Account(String userID) {
		// TODO Auto-generated constructor stub
		this.userID = userID;
	}

	private void dbConnect() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("org.sqlite.JDBC");
		connection = DriverManager.getConnection("jdbc:sqlite:F:\\College\\SE\\Mini Project\\Eldian.sqlite");
	}

	public ArrayList<UserEntry> getEntries() throws ClassNotFoundException, SQLException {
		dbConnect();
		ArrayList<UserEntry> entryList = new ArrayList<>();
		String sql = "Select * from entries";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			UserEntry userEntries = new UserEntry(userID);
			userEntries.setAccount_name(rs.getString("account_name"));
			userEntries.setCategory(rs.getString("category"));
			userEntries.setPassword(rs.getString("password"));
			userEntries.setLogin_id(rs.getString("login_id"));
			userEntries.setEntry_id(rs.getString("entry_id"));
			entryList.add(userEntries);
		}
		dbClose();
		return entryList;
	}

	public void AddEntry(String accountName, String category, String Password, String loginID)
			throws ClassNotFoundException, SQLException {
		dbConnect();
		String sql = "insert into entries(account_name,password,login_id,category) values(?,?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, accountName);
		preparedStatement.setString(2, Password);
		preparedStatement.setString(3, loginID);
		preparedStatement.setString(4, category);
		preparedStatement.executeUpdate();
		dbClose();
	}

	private void dbClose() throws SQLException {
		// TODO Auto-generated method stub
		connection.close();
	}
}
