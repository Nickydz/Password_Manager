package application;

import java.io.IOException;
import java.util.Optional;

import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
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
		
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Add_Entry.fxml")); 
		Parent root = (Parent)fxmlLoader.load(); 
        AddEntry controller = fxmlLoader.<AddEntry>getController();
        controller.setUser(UserID);
		window.setScene(new Scene(root, 700, 575));
		window.showAndWait();
	}

	private void deleteDialogBox() throws IOException {
		// TODO Auto-generated method stub
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmation Dialog");
		alert.setHeaderText("Look, a Confirmation Dialog");
		alert.setContentText("Are you ok with this?");

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK){
		    ObservableList<UserEntry> selectedItems = getSelectedItems();
		} else {
		    
		}
		
	}

	private ObservableList<UserEntry> getSelectedItems() {
		// TODO Auto-generated method stub
		ObservableList<UserEntry> productSelected, allProducts;
        allProducts = table.getItems();
        productSelected = table.getSelectionModel().getSelectedItems();

        productSelected.forEach(allProducts::remove);
		return null;
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
