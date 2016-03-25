package application;

import java.sql.SQLException;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class EditEntry{

	private String userID;
	private String entryID;
	private ObservableList<UserEntry> selectedItems;
	private UserEntry selectedEntry;

	public EditEntry() {
		// TODO Auto-generated constructor stub
	}
	
	public EditEntry(String userID) {
		// TODO Auto-generated constructor stub
		this.userID = userID;
	}

	@FXML
	private TextField accountNameField;

	@FXML
	private PasswordField passwordField;

	@FXML
	private PasswordField reconfirmPWField;

	@FXML
	private Button AddEntryBTN;

	@FXML
	private Button CancelBTN;

	@FXML
	private TextField categoryField;

	@FXML
	private TextField loginIDField;

	@FXML
	private void onEditEntryBTN(MouseEvent event) throws ClassNotFoundException, SQLException {
		String accountName = accountNameField.getText();
		String password = passwordField.getText();
		String confirmedPW = reconfirmPWField.getText();
		String category = categoryField.getText();
		String loginID = loginIDField.getText();
		
		if (password.equals(confirmedPW)) {
			Account account = new Account(userID);
			account.editEntry(accountName, category, password, loginID, entryID);
		}

	}

	private void setEntryID() {
		// TODO Auto-generated method stub
		for(UserEntry entry : selectedItems){
			selectedEntry = entry;
			this.entryID = entry.getEntry_id();
		}
	}

	public void setUser(String userid) {
		this.userID = userid;

	}

	public void setSelectedItems(ObservableList<UserEntry> selectedItems) {
		System.out.println(selectedItems);
		this.selectedItems = selectedItems;
	}
	

	public void setDataintoFields() {
		// TODO Auto-generated method stub
		setEntryID();
		accountNameField.setText(selectedEntry.getAccount_name());
		passwordField.setText(selectedEntry.getPassword());
		categoryField.setText(selectedEntry.getCategory());
		loginIDField.setText(selectedEntry.getLogin_id());
		
	}
	
}
