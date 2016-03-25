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
		String sql = "insert into entries(account_name,password,login_id,category,user_id) values(?,?,?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, accountName);
		preparedStatement.setString(2, Password);
		preparedStatement.setString(3, loginID);
		preparedStatement.setString(4, category);
		preparedStatement.setString(5, userID);
		preparedStatement.executeUpdate();
		dbClose();
	}

	public void deleteEntry(ArrayList<String> idListofSelectedItems) throws ClassNotFoundException, SQLException {
		for (String entryID : idListofSelectedItems) {
			dbConnect();
			String sql = "delete from entries where entry_id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, entryID);
			preparedStatement.executeUpdate();
			dbClose();
		}
	}

	public void editEntry(String accountName, String category, String Password, String loginID, String entryID)
			throws ClassNotFoundException, SQLException {
		dbConnect();
		String sql = "UPDATE entries SET account_name = ?, password = ?, login_id = ?, category = ? WHERE entry_id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, accountName);
		preparedStatement.setString(2, Password);
		preparedStatement.setString(3, loginID);
		preparedStatement.setString(4, category);
		preparedStatement.setString(5, entryID);
		preparedStatement.executeUpdate();
		dbClose();

	}

	private void dbClose() throws SQLException {
		// TODO Auto-generated method stub
		connection.close();
	}

	public ArrayList<UserEntry> getSearchEntries(String searchString) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		dbConnect();
		ArrayList<UserEntry> searchItemsList = new ArrayList<>();
		String sql = "SELECT * FROM entries WHERE account_name LIKE ? or password LIKE ? or category LIKE ? or login_id LIKE ? ";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, "%" + searchString   + "%");
		preparedStatement.setString(2,  "%" + searchString   + "%");
		preparedStatement.setString(3,  "%" + searchString   + "%");
		preparedStatement.setString(4,  "%" + searchString   + "%");
		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next()) {
			UserEntry userEntries = new UserEntry(userID);
			userEntries.setAccount_name(rs.getString("account_name"));
			userEntries.setCategory(rs.getString("category"));
			userEntries.setPassword(rs.getString("password"));
			userEntries.setLogin_id(rs.getString("login_id"));
			userEntries.setEntry_id(rs.getString("entry_id"));
			searchItemsList.add(userEntries);
		}
		dbClose();
		return searchItemsList;
	}

}
