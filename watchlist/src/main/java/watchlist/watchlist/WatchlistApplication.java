package watchlist.watchlist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import watchlist.watchlist.movie.MovieServiceable;

@SpringBootApplication
public class WatchlistApplication extends Application {

	private MovieServiceable movieService;

	public static void main(String[] args) {
		SpringApplication.run(WatchlistApplication.class, args);
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("WatchlistView.fxml"));
		loader.setController(new WatchlistController(movieService));
		Parent root = loader.load();

		Scene scene = new Scene(root);
		// scene.getStylesheets().add(getClass().getResource("BMISettings.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.setTitle("Watchlist");
		primaryStage.show();
	}

}
