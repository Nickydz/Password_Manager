package application;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class HomeScreen implements Initializable{
	
	private String UserID;
	private Home_Dialog_Box dialogBox;
	
	
	
	@FXML
	private BorderPane borderPane;
	
	@FXML
	private TableView<UserEntries> table;
	
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
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		constructEntryTable();
		
	}
	

	private void constructEntryTable() {
		// TODO Auto-generated method stub
		TableColumn<UserEntries,String> accountColumn = new TableColumn("Account");
		accountColumn.setCellFactory(new PropertyValueFactory("account_name"));
		
		TableColumn<UserEntries,String> loginColumn = new TableColumn("Login");
		loginColumn.setCellFactory(new PropertyValueFactory("login_id"));
		
		TableColumn<UserEntries,String> passwordColumn = new TableColumn("Password");
		passwordColumn.setCellFactory(new PropertyValueFactory("account_name"));
		
		TableColumn<UserEntries,String> categoryColumn = new TableColumn("Account");
		categoryColumn.setCellFactory(new PropertyValueFactory("account_name"));
		
		table.setItems(getEntries());
		
	}

	private ObservableList<UserEntries> getEntries() {
		// TODO Auto-generated method stub
		ObservableList<UserEntries> userEntries = FXCollections.observableArrayList();
		UserEntries entries = new UserEntries()
		userEntries.add(.getUserEntries());
		return userEntries;
	}

	public void setUser(String userid){
		this.UserID = userid;
		dialogBox = new Home_Dialog_Box(UserID);
	}
}

