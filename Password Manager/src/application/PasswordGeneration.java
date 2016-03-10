package application;

import java.util.LinkedList;
import java.util.List;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
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

		String length = PasswordLength.getText();
		System.out.println(length);
		if(length.length() == 0){
			new AlertBox().display("Length not entered", "You must enter a length!!");
			event.consume();
		}
		else{

			boolean choiceValid = getChoices();

			if(choiceValid){
				addRules();

				String GPassword = generatePassword(length);

				Password.setText(GPassword);
			}
		}
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
			rules.add(new CharacterRule(EnglishCharacterData.Digit, 1 ));
		if(hasLowercase)
			rules.add(new CharacterRule(EnglishCharacterData.LowerCase, 1 ));
		if(hasUppercase)
			rules.add(new CharacterRule(EnglishCharacterData.UpperCase, 1));
		if(hasSpecial)
			rules.add(new CharacterRule(EnglishCharacterData.Special, 1));

	}

	private boolean getChoices() {
		// TODO Auto-generated method stub
		if(!Digits.isSelected() && !Special.isSelected() && !UpperCase.isSelected() && !LowerCase.isSelected() ){
			new AlertBox().display("no choice Selected!"," you must select atleast one choice!!!!!!!!!!");
			return false;
		}else{
			if(Digits.isSelected())
				hasDigits = true;
			if(Special.isSelected())
				hasSpecial = true;
			if(UpperCase.isSelected())
				hasUppercase = true;
			if(LowerCase.isSelected())
				hasLowercase = true;
			return true;
		}
	}

}
