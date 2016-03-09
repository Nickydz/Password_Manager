package application;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class PasswordGeneration {
	
	private boolean hasDigits;
	private boolean hasLowercase;
	private boolean hasUppercase;
	private boolean hasSpecial;
	
	List<CharacterRule> rules;
	
	@FXML 
	private TextField Password;
	
	@FXML
	private CheckBox Digits;
	
	@FXML
	private CheckBox Special;
	
	@FXML
	private CheckBox UpperCase;
	
	@FXML
	private CheckBox LowerCase;
	
	@FXML 
	private Button generatePassword;
	
	@FXML 
	private TextField PasswordLength;
	
	@FXML
	private void onChange(ActionEvent event){
	String length = PasswordLength.getText();
	getChoices();
	addRules();
	String GPassword = generatePassword(length);
	Password.setText(GPassword);
	}

	private String generatePassword(String length) {
		// TODO Auto-generated method stub
		PasswordGenerator generator = new PasswordGenerator();
		String password = generator.generatePassword(Integer.parseInt(length), rules);
		return password;
	}

	private void addRules() {
		// TODO Auto-generated method stub
		
		rules = new LinkedList<CharacterRule>();
		if(hasDigits)
			rules.add(new CharacterRule(EnglishCharacterData.Digit, new Random().nextInt(3)));
		if(hasLowercase)
			rules.add(new CharacterRule(EnglishCharacterData.LowerCase, new Random().nextInt(3)));
		if(hasUppercase)
			rules.add(new CharacterRule(EnglishCharacterData.UpperCase, new Random().nextInt(3)));
		if(hasSpecial)
			rules.add(new CharacterRule(EnglishCharacterData.Special, new Random().nextInt(3)));
			
		
		
	}

	private void getChoices() {
		// TODO Auto-generated method stub
		if(Digits.isSelected())
			hasDigits = true;
		if(Special.isSelected())
			hasSpecial = true;
		if(UpperCase.isSelected())
			hasUppercase = true;
		if(LowerCase.isSelected())
			hasLowercase = true;
		
	}
	
}
