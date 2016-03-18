package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class AddEntry {

	
	private String UserID;
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
	private void onAddEntryBTN(MouseEvent event){
		String accountName = accountNameField.getText();
		String password = passwordField.getText();
		String confirmedPW = reconfirmPWField.getText();
		String category = categoryField.getText();
		String loginID = loginIDField.getText();
		System.out.println(UserID);
		if(password.equals(confirmedPW)){
			
		}
		
	}
	
	public void setUser(String userid){
		this.UserID = userid;
		
	}
	
	
	
}
