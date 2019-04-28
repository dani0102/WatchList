package watchlist.watchlist;

import javafx.application.Application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

@SpringBootApplication
public class WatchlistApplication extends Application {

	public static void main(String[] args) {
		SpringApplication.run(WatchlistApplication.class, args);
		WatchlistController test = new WatchlistController();
		test.loadAllTvShows();
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
				
		FXMLLoader loader = new FXMLLoader(getClass().getResource("WatchlistView.fxml"));
		loader.setController(new WatchlistController());
		Parent root = loader.load();
		
		Scene scene = new Scene(root);
		//scene.getStylesheets().add(getClass().getResource("BMISettings.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.setTitle("Watchlist");
		primaryStage.show();
	}
	
}
