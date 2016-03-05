package application;

import java.util.Arrays;

import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.LengthRule;
import org.passay.PasswordData;
import org.passay.PasswordValidator;
import org.passay.RuleResult;

import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;

public class PasswordAnalysis {


	private String Password;
	PasswordValidator validator;
	RuleResult result;

	@FXML 
	private TextField PasswordInput;

	@FXML 
	private ProgressBar Progress;

	@FXML 
	private Label PWComment;

	@FXML 
	private Label PWLength;

	@FXML 
	private Label NumberofChars;

	@FXML 
	private Label NumberofNums;

	@FXML 
	private Label NumofUpperC;

	@FXML 
	private Label NumofSymbols;

	@FXML 
	private Label NumofLowerC;

	@FXML 
	private Label NumofRepeatedChar;

	@FXML 
	private Text PWQualityMetrics;

	@FXML 
	private Button button;

	@FXML
	private void onChange(KeyEvent event){
		Password = PasswordInput.getText();
		addRules();
		boolean isValid = validatePassword();
		

	}

	private boolean validatePassword() {
		// TODO Auto-generated method stub
		result = validator.validate(new PasswordData(new String(Password)));
		if(result.isValid())
			return true;
		return false;
	}

	private void addRules() {
		validator = new PasswordValidator(Arrays.asList(
				// length between 8 and 16 characters
				new LengthRule(8, 16),

				// at least one upper-case character
				new CharacterRule(EnglishCharacterData.UpperCase, 2),

				// at least one lower-case character
				new CharacterRule(EnglishCharacterData.LowerCase, 2),

				// at least one digit character
				new CharacterRule(EnglishCharacterData.Digit, 2),

				// at least one symbol (special character)
				new CharacterRule(EnglishCharacterData.Special, 2)

				));
		
	}
	
	



}