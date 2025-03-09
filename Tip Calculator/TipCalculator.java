
			//Import the java fx libraries to handle the parent, scene and stage
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



			//The TipCalculator class extends the javafx Application
public class TipCalculator extends Application{
			//Overriding the start function from the Application library
	@Override
	public void start(Stage stage) throws Exception {
			//Setting the root to the fxml file that I created
		Parent root = FXMLLoader.load(getClass().getResource("TipCalculator.fxml"));
			//Setting the scene and stage
		Scene scene = new Scene(root);
		stage.setTitle("Tip Calculator");
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
			//Launching the FX
		launch(args);
	}
	
}
