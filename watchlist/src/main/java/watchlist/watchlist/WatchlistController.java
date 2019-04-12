package watchlist.watchlist;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class WatchlistController {

    @FXML
    private Pane primaryPane;

    @FXML
    private Label taskbar;

    @FXML
    private Label footer;

    @FXML
    private Button minimizeWindow;

    @FXML
    private Button closeWindow;

    @FXML
    private BorderPane content;

    @FXML
    private Label header;

    @FXML
    private Pane leftPane;

    @FXML
    private Pane rightPane;

    @FXML
    private Pane bottomPane;

    @FXML
    private VBox centerPane;

    @FXML
    private HBox navbar;

    @FXML
    private Label navbarHome;

    @FXML
    private Label navbarTvshows;

    @FXML
    private Label navbarMovies;

    @FXML
    private VBox pageContent;

    @FXML
    private Label tvshowTitle;

    @FXML
    private GridPane tvshowGrid;

    @FXML
    private Label movieTitle;

    @FXML
    private GridPane movieGrid;

}

