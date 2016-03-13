package application;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class HomeScreen {

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
		System.out.println("lol");
		new Home_Dialog_Box().display("add");
	}
	
	@FXML
	private void onDeleteEntry(MouseEvent event) throws Exception{
		System.out.println("lol");
		new Home_Dialog_Box().display("delete");
	}
	
	@FXML
	private void onEditEntry(MouseEvent event) throws Exception{
		System.out.println("lol");
		new Home_Dialog_Box().display("edit");
	}
	
}

