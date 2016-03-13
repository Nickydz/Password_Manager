package application;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class HomeScreen {
	
	private String UserID;
	private Home_Dialog_Box dialogBox;
	
	@FXML
	private BorderPane borderPane;
	
	@FXML
	private Button addEntryBT;
	
	@FXML
	private Button editEntryBT;
	
	@FXML
	private Button deleteEntryBT;
	
	@FXML
	private Button PWGenerationBT;
	
	@FXML
	private Button PWAnalysisBT;
	
	@FXML
	private Button SNotesBT;
	
	@FXML
	private Button AccSettingsBT;
	
	@FXML
	private Button SearchBTBT;
	
	@FXML
	private Button LogOutBT;
	
	@FXML
	private void onAddEntry(MouseEvent event) throws Exception{
		//System.out.println("lol");
		dialogBox.display("add");
	}
	
	@FXML
	private void onDeleteEntry(MouseEvent event) throws Exception{
		//System.out.println("lol");
		dialogBox.display("delete");
	}
	
	@FXML
	private void onEditEntry(MouseEvent event) throws Exception{
		//System.out.println("lol");
		dialogBox.display("edit");
	}
	
	@FXML
	private void onPWAnalysisClick(MouseEvent event) throws Exception{
		//System.out.println("lol");
		Stage stage = (Stage)borderPane.getScene().getWindow();
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Password_Analysis.fxml")); 
        Parent root = (Parent)fxmlLoader.load(); 
        stage.setTitle("Hello World");
        stage.setScene(new Scene(root, 700, 575));
        stage.show();
        
	}
	
	@FXML
	private void onPWGenerationClick(MouseEvent event) throws Exception{
		//System.out.println("lol");
		Stage stage = (Stage)borderPane.getScene().getWindow();
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Password_Generation.fxml")); 
        Parent root = (Parent)fxmlLoader.load(); 
        stage.setTitle("Hello World");
        stage.setScene(new Scene(root, 700, 575));
        stage.show();
        
	}
	
	public void setUser(String userid){
		this.UserID = userid;
		dialogBox = new Home_Dialog_Box(UserID);
	}
}

