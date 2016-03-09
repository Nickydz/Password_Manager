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
import javafx.scene.input.MouseEvent;

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
	private void onChange(MouseEvent event){
		System.out.println("lol");
		String length = PasswordLength.getText();
		System.out.println("lol1");
		getChoices();
		System.out.println("lol2");
		addRules();
		System.out.println("lol3");
		String GPassword = generatePassword(length);
		System.out.println("lol4");
		System.out.println(GPassword);
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
		int numofdig = 1 +  new Random().nextInt(3);
		int numofLo =  1+ new Random().nextInt(3);
		int numofUp =  1 +	new Random().nextInt(3);
		int numofSp =  1 + new Random().nextInt(3);
		
		
		if(hasDigits)
			rules.add(new CharacterRule(EnglishCharacterData.Digit, numofdig ));
		if(hasLowercase)
			rules.add(new CharacterRule(EnglishCharacterData.LowerCase, numofLo ));
		if(hasUppercase)
			rules.add(new CharacterRule(EnglishCharacterData.UpperCase, numofUp));
		if(hasSpecial)
			rules.add(new CharacterRule(EnglishCharacterData.Special, numofSp));

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
