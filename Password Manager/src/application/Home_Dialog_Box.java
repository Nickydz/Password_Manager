package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Home_Dialog_Box {
	
	private String UserID;

	public Home_Dialog_Box(String userID) {
		// TODO Auto-generated constructor stub
		this.UserID = userID;
	}

	public void display(String function) throws Exception{
		if(function.equals("add"))
			addDialogBox();
		if(function.equals("delete"))
			deleteDialogBox();
		if(function.equals("edit"))
			editDialogBox();
		
	}

	private void editDialogBox() throws Exception{
		// TODO Auto-generated method stub
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Edit Entry");
		window.setHeight(250);
		window.setWidth(250);
		
		Parent root = FXMLLoader.load(getClass().getResource("Edit_Entry.fxml"));
		window.setScene(new Scene(root, 700, 575));
		window.showAndWait();
	}

	private void deleteDialogBox() throws IOException {
		// TODO Auto-generated method stub
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Delete Entry");
		window.setHeight(250);
		window.setWidth(250);
		
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Home_Screen.fxml")); 
		Parent root = (Parent)fxmlLoader.load(); 
        HomeScreen controller = fxmlLoader.<HomeScreen>getController();
        controller.setUser(UserID);
		window.setScene(new Scene(root, 700, 575));
		window.showAndWait();
		
		
		
		
	}

	private void addDialogBox() throws Exception {
		// TODO Auto-generated method stub
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Add Entry");
		window.setHeight(250);
		window.setWidth(250);
	
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Add_Entry.fxml")); 
		Parent root = (Parent)fxmlLoader.load(); 
        AddEntry controller = fxmlLoader.<AddEntry>getController();
        controller.setUser(UserID);
		window.setScene(new Scene(root, 700, 575));
		window.showAndWait();
		
		
		
		
		
		
	}
	
}
