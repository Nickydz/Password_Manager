package application;

import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class PasswordAnalysis {
	
	
	Password password = new Password();

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
	private void onChange(ActionEvent event){
		 password.firstNameProperty().addListener((v,oldValue,newValue) -> 
		 
				 );
	
		
	}
	
	
	
}
