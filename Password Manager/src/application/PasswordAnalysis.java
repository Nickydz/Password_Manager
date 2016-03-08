package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.EnglishSequenceData;
import org.passay.IllegalRegexRule;
import org.passay.IllegalSequenceRule;
import org.passay.LengthRule;
import org.passay.PasswordData;
import org.passay.PasswordValidator;
import org.passay.RuleResult;
import org.passay.RuleResultDetail;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;

public class PasswordAnalysis implements Initializable{


	private String Password;
	private PasswordValidator validator;
	private RuleResult result;
	private PasswordScore score;

	
	private String PWLengthText = "";
	private String NumberofNumsText = "";
	private String NumberofUpperCText = "";
	private String NumberofLowerCText = "";
	private String NumberofSymbolsText = "";
	private String NumberofCharsText = "";
	private String NumofRepeatedCharText = "";
	private String IllegalSequenceLabelText = "";
	
	
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
	private Label IllegalSequenceLabel;
	
	@FXML 
	private Text PWQualityMetrics;

	@FXML 
	private Button button;

	@FXML
	private void onChange(KeyEvent event){
		//System.out.println("lol");
		Password = PasswordInput.getText();
		System.out.println(PasswordInput.getText());
		boolean isValid = validatePassword();
		System.out.println("is password valid : " + isValid);
		checkEachValidation();
		System.out.println(score.getPasswordscore());
	}

	private void checkEachValidation() {
		// TODO Auto-generated method stub
		initializeLabels();
		ArrayList<String> listofErrors = new ArrayList<String>();
		for(RuleResultDetail msg : result.getDetails()){
			System.out.println(msg.getErrorCode());
			listofErrors.add(msg.getErrorCode());
		}
		
		score.setPasswordscore(score.getPasswordscore()*0.05);
		
		if(listofErrors.contains("TOO_SHORT")){
			PWLengthText += "-- TOO SHORT";
			score.setPasswordscore(score.getPasswordscore() - 0.05); 
		}
		else{
			score.setPasswordscore(score.getPasswordscore() + 0.1);
		}
		if(listofErrors.contains("INSUFFICIENT_UPPERCASE")){
			NumberofUpperCText += "-- uppercase insufficient";
			score.setPasswordscore(score.getPasswordscore() - 0.05); 
		}
		else{
			score.setPasswordscore(score.getPasswordscore() + 0.1);
		}
		if(listofErrors.contains("INSUFFICIENT_LOWERCASE")){
			NumberofLowerCText += "-- lower case insufficient";
			score.setPasswordscore(score.getPasswordscore() - 0.05); 
		}
		else{
			score.setPasswordscore(score.getPasswordscore() + 0.1);
		}
		if(listofErrors.contains("INSUFFICIENT_DIGIT")){
			NumberofNumsText += "--insufficient digits";
			score.setPasswordscore(score.getPasswordscore() - 0.05);
		}
		else{
			score.setPasswordscore(score.getPasswordscore() + 0.1);
		}
		if(listofErrors.contains("INSUFFICIENT_SPECIAL")){
			NumberofSymbolsText += "-- insuffcient specials";
			score.setPasswordscore(score.getPasswordscore() - 0.05);
		}
		else{
			score.setPasswordscore(score.getPasswordscore() + 0.1);
		}
		if(listofErrors.contains("INSUFFICIENT_ALPHABETICAL")){
			NumberofCharsText += "-- insuffcient characters";
			score.setPasswordscore(score.getPasswordscore() + 0.05);
		}
		else{
			score.setPasswordscore(score.getPasswordscore() + 0.1);
		}
		if(listofErrors.contains("ILLEGAL_MATCH")){
			NumofRepeatedCharText += "-- repeated charatcers not allowed";
			score.setPasswordscore(score.getPasswordscore() - 0.05);
		}
		else{
			score.setPasswordscore(score.getPasswordscore() + 0.1);
		}
		
		if(listofErrors.contains("ILLEGAL_NUMERICAL_SEQUENCE") || listofErrors.contains("ILLEGAL_ALPHABETICAL_SEQUENCE") || listofErrors.contains("ILLEGAL_QWERTY_SEQUENCE")){
			IllegalSequenceLabelText += "-- sequence of 3 not allowed";
			score.setPasswordscore(score.getPasswordscore() - 0.05);
		}
		else{
			score.setPasswordscore(score.getPasswordscore() + 0.1);
		}
		
		
		PWLength.setText(PWLengthText);
		NumberofNums.setText(NumberofNumsText);
		NumofUpperC.setText(NumberofUpperCText);
		NumofSymbols.setText(NumberofSymbolsText);
		NumofLowerC.setText(NumberofLowerCText);
		NumberofChars.setText(NumberofCharsText);
		NumofRepeatedChar.setText(NumofRepeatedCharText);
		IllegalSequenceLabel.setText(IllegalSequenceLabelText);
		
		listofErrors = null;
	}

	private void initializeLabels() {
		// TODO Auto-generated method stub
		PWLengthText = "";
		NumberofNumsText = "";
		NumberofUpperCText = "";
		NumberofLowerCText = "";
		NumberofSymbolsText = "";
		NumberofCharsText = "";
		NumofRepeatedCharText = "";
		IllegalSequenceLabelText = "";
		
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
				new CharacterRule(EnglishCharacterData.Special, 2),
				
				new CharacterRule(EnglishCharacterData.Alphabetical,2),
				
				new IllegalRegexRule("(\\w)\\1+"),
				
				new IllegalSequenceRule(EnglishSequenceData.Alphabetical,3,true),
				
				new IllegalSequenceRule(EnglishSequenceData.Numerical,3,true),
				
				new IllegalSequenceRule(EnglishSequenceData.USQwerty,3,true)

				));

	}
	
	@FXML 
	private void pbCheck(ActionEvent event){
		score.setPasswordscore(score.getPasswordscore() + 0.1);
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		Progress = new ProgressBar();
		score = new PasswordScore();
		addRules();
		score.setPasswordscore(0);
		score.numberProperty().addListener((v,oldValue,newValue) -> {
			
		});
		Progress.progressProperty().bind(score.numberProperty());
		
		
	}
	





}
