package visao;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class main extends Application {
	@Override
	public void start(Stage stagePrincipal) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("interface.fxml"));
        
        Scene scene = new Scene(root); 
        stagePrincipal.setScene(scene); 
        stagePrincipal.setTitle("mercadoanimes-interface"); 
        stagePrincipal.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
