package watchlist.watchlist;

/**
 * Sample Skeleton for 'WatchlistView.fxml' Controller Class
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class WatchlistController {

    @FXML // fx:id="navbar_watchlist"
    private MenuBar navbar_watchlist; // Value injected by FXMLLoader

    @FXML // fx:id="navbaritem_home"
    private Menu navbaritem_home; // Value injected by FXMLLoader

    @FXML // fx:id="navbaritem_tvshow"
    private Menu navbaritem_tvshow; // Value injected by FXMLLoader

    @FXML // fx:id="navbarsubitem_showAllTv"
    private MenuItem navbarsubitem_showAllTv; // Value injected by FXMLLoader

    @FXML // fx:id="navbarsubitem_addTvShow"
    private MenuItem navbarsubitem_addTvShow; // Value injected by FXMLLoader

    @FXML // fx:id="navbaritem_movies"
    private Menu navbaritem_movies; // Value injected by FXMLLoader

    @FXML // fx:id="navbarsubitem_showAllMovies"
    private MenuItem navbarsubitem_showAllMovies; // Value injected by FXMLLoader

    @FXML // fx:id="navbarsubitem_addMovie"
    private MenuItem navbarsubitem_addMovie; // Value injected by FXMLLoader

    @FXML // fx:id="centerPane_tvshow"
    private VBox centerPane_tvshow; // Value injected by FXMLLoader

    @FXML // fx:id="tvshow_grid_tvshow"
    private GridPane tvshow_grid_tvshow; // Value injected by FXMLLoader

    @FXML // fx:id="search_field_tvshow"
    private TextField search_field_tvshow; // Value injected by FXMLLoader

    @FXML // fx:id="search_label_movie"
    private Label search_label_movie; // Value injected by FXMLLoader

    @FXML // fx:id="scrollbar_tvshow"
    private ScrollBar scrollbar_tvshow; // Value injected by FXMLLoader

    @FXML // fx:id="centerPane_movie"
    private VBox centerPane_movie; // Value injected by FXMLLoader

    @FXML // fx:id="movie_grid_movie"
    private GridPane movie_grid_movie; // Value injected by FXMLLoader

    @FXML // fx:id="search_field_movie"
    private TextField search_field_movie; // Value injected by FXMLLoader

    @FXML // fx:id="scrollbar_movie"
    private ScrollBar scrollbar_movie; // Value injected by FXMLLoader

    @FXML // fx:id="centerPane_home"
    private VBox centerPane_home; // Value injected by FXMLLoader

    @FXML // fx:id="tvshowTitle"
    private Label tvshowTitle; // Value injected by FXMLLoader

    @FXML // fx:id="tvshowGrid"
    private GridPane tvshowGrid; // Value injected by FXMLLoader

    @FXML // fx:id="movieTitle"
    private Label movieTitle; // Value injected by FXMLLoader

    @FXML // fx:id="movieGrid"
    private GridPane movieGrid; // Value injected by FXMLLoader

    @FXML // fx:id="centerPane_show_profile"
    private VBox centerPane_show_profile; // Value injected by FXMLLoader

    @FXML // fx:id="profile_label"
    private Label profile_label; // Value injected by FXMLLoader

    @FXML // fx:id="profile_image_profile"
    private ImageView profile_image_profile; // Value injected by FXMLLoader

    @FXML // fx:id="label_username"
    private Label label_username; // Value injected by FXMLLoader

    @FXML // fx:id="label_firstname"
    private Label label_firstname; // Value injected by FXMLLoader

    @FXML // fx:id="label_lastname"
    private Label label_lastname; // Value injected by FXMLLoader

    @FXML // fx:id="username_label_profile"
    private Label username_label_profile; // Value injected by FXMLLoader

    @FXML // fx:id="firstname_label_profile"
    private Label firstname_label_profile; // Value injected by FXMLLoader

    @FXML // fx:id="lastname_label_profile"
    private Label lastname_label_profile; // Value injected by FXMLLoader

    @FXML // fx:id="label_email"
    private Label label_email; // Value injected by FXMLLoader

    @FXML // fx:id="email_label_profile"
    private Label email_label_profile; // Value injected by FXMLLoader

    @FXML // fx:id="edit_link_profile"
    private Hyperlink edit_link_profile; // Value injected by FXMLLoader

    @FXML // fx:id="centerPane_edit_profile"
    private VBox centerPane_edit_profile; // Value injected by FXMLLoader

    @FXML // fx:id="profile_label1"
    private Label profile_label1; // Value injected by FXMLLoader

    @FXML // fx:id="image_profile_edit"
    private ImageView image_profile_edit; // Value injected by FXMLLoader

    @FXML // fx:id="label_username1"
    private Label label_username1; // Value injected by FXMLLoader

    @FXML // fx:id="label_firstname1"
    private Label label_firstname1; // Value injected by FXMLLoader

    @FXML // fx:id="label_lastname1"
    private Label label_lastname1; // Value injected by FXMLLoader

    @FXML // fx:id="label_email1"
    private Label label_email1; // Value injected by FXMLLoader

    @FXML // fx:id="delete_link_profile"
    private Hyperlink delete_link_profile; // Value injected by FXMLLoader

    @FXML // fx:id="username_textfield_profile"
    private TextField username_textfield_profile; // Value injected by FXMLLoader

    @FXML // fx:id="firstname_textfield_profile"
    private TextField firstname_textfield_profile; // Value injected by FXMLLoader

    @FXML // fx:id="lastname_textfield_profile"
    private TextField lastname_textfield_profile; // Value injected by FXMLLoader

    @FXML // fx:id="email_textfield_profile"
    private TextField email_textfield_profile; // Value injected by FXMLLoader

    @FXML // fx:id="save_button_profile"
    private Button save_button_profile; // Value injected by FXMLLoader

    @FXML // fx:id="cancel_button_profile"
    private Button cancel_button_profile; // Value injected by FXMLLoader

    @FXML // fx:id="centerPane_show_movie"
    private VBox centerPane_show_movie; // Value injected by FXMLLoader

    @FXML // fx:id="movie_title"
    private Label movie_title; // Value injected by FXMLLoader

    @FXML // fx:id="movie_image"
    private ImageView movie_image; // Value injected by FXMLLoader

    @FXML // fx:id="label_movie"
    private Label label_movie; // Value injected by FXMLLoader

    @FXML // fx:id="label_alias_title"
    private Label label_alias_title; // Value injected by FXMLLoader

    @FXML // fx:id="label_outcome_year"
    private Label label_outcome_year; // Value injected by FXMLLoader

    @FXML // fx:id="label_length"
    private Label label_length; // Value injected by FXMLLoader

    @FXML // fx:id="delete_link_movie"
    private Hyperlink delete_link_movie; // Value injected by FXMLLoader

    @FXML // fx:id="movie_textfield_movie"
    private TextField movie_textfield_movie; // Value injected by FXMLLoader

    @FXML // fx:id="alias_title_textfield_movie"
    private TextField alias_title_textfield_movie; // Value injected by FXMLLoader

    @FXML // fx:id="outcome_year_textfield_movie"
    private TextField outcome_year_textfield_movie; // Value injected by FXMLLoader

    @FXML // fx:id="length_textfield_movie"
    private TextField length_textfield_movie; // Value injected by FXMLLoader

    @FXML // fx:id="save_button_movie"
    private Button save_button_movie; // Value injected by FXMLLoader

    @FXML // fx:id="cancel_button_movie"
    private Button cancel_button_movie; // Value injected by FXMLLoader

    @FXML // fx:id="label_description"
    private Label label_description; // Value injected by FXMLLoader

    @FXML // fx:id="description_textarea_movie"
    private TextArea description_textarea_movie; // Value injected by FXMLLoader

    @FXML // fx:id="centerPane_edit_movie"
    private VBox centerPane_edit_movie; // Value injected by FXMLLoader

    @FXML // fx:id="movie_label_movie"
    private Label movie_label_movie; // Value injected by FXMLLoader

    @FXML // fx:id="movie_image1"
    private ImageView movie_image1; // Value injected by FXMLLoader

    @FXML // fx:id="label_movie1"
    private Label label_movie1; // Value injected by FXMLLoader

    @FXML // fx:id="label_alias_title1"
    private Label label_alias_title1; // Value injected by FXMLLoader

    @FXML // fx:id="label_outcome_year1"
    private Label label_outcome_year1; // Value injected by FXMLLoader

    @FXML // fx:id="label_length1"
    private Label label_length1; // Value injected by FXMLLoader

    @FXML // fx:id="edit_link_movie"
    private Hyperlink edit_link_movie; // Value injected by FXMLLoader

    @FXML // fx:id="label_description1"
    private Label label_description1; // Value injected by FXMLLoader

    @FXML // fx:id="description_label_viewmovie"
    private Label description_label_viewmovie; // Value injected by FXMLLoader

    @FXML // fx:id="movie_label_viewmovie"
    private Label movie_label_viewmovie; // Value injected by FXMLLoader

    @FXML // fx:id="alias_title_label_viewmovie"
    private Label alias_title_label_viewmovie; // Value injected by FXMLLoader

    @FXML // fx:id="outcome_year_label_viewmovie"
    private Label outcome_year_label_viewmovie; // Value injected by FXMLLoader

    @FXML // fx:id="length_label_viewmovie"
    private Label length_label_viewmovie; // Value injected by FXMLLoader

    @FXML // fx:id="centerPane_show_tvshow"
    private VBox centerPane_show_tvshow; // Value injected by FXMLLoader

    @FXML // fx:id="tvshow_label_tvshow"
    private Label tvshow_label_tvshow; // Value injected by FXMLLoader

    @FXML // fx:id="tvshow_image"
    private ImageView tvshow_image; // Value injected by FXMLLoader

    @FXML // fx:id="label_movie11"
    private Label label_movie11; // Value injected by FXMLLoader

    @FXML // fx:id="label_alias_title_tv"
    private Label label_alias_title_tv; // Value injected by FXMLLoader

    @FXML // fx:id="label_outcome_year_tv"
    private Label label_outcome_year_tv; // Value injected by FXMLLoader

    @FXML // fx:id="label_length_tv"
    private Label label_length_tv; // Value injected by FXMLLoader

    @FXML // fx:id="edit_link_tvshow"
    private Hyperlink edit_link_tvshow; // Value injected by FXMLLoader

    @FXML // fx:id="label_description_tv"
    private Label label_description_tv; // Value injected by FXMLLoader

    @FXML // fx:id="description_label_viewtv"
    private Label description_label_viewtv; // Value injected by FXMLLoader

    @FXML // fx:id="tvshow_label_viewtv"
    private Label tvshow_label_viewtv; // Value injected by FXMLLoader

    @FXML // fx:id="alias_title_label_viewtv"
    private Label alias_title_label_viewtv; // Value injected by FXMLLoader

    @FXML // fx:id="outcome_year_label_viewtv"
    private Label outcome_year_label_viewtv; // Value injected by FXMLLoader

    @FXML // fx:id="length_label_viewtv"
    private Label length_label_viewtv; // Value injected by FXMLLoader

    @FXML // fx:id="label_end_year_tv"
    private Label label_end_year_tv; // Value injected by FXMLLoader

    @FXML // fx:id="end_year_label_viewtv"
    private Label end_year_label_viewtv; // Value injected by FXMLLoader

    @FXML // fx:id="centerPane_edit_tvshow"
    private VBox centerPane_edit_tvshow; // Value injected by FXMLLoader

    @FXML // fx:id="tvshow_label"
    private Label tvshow_label; // Value injected by FXMLLoader

    @FXML // fx:id="tvshow_image_edit"
    private ImageView tvshow_image_edit; // Value injected by FXMLLoader

    @FXML // fx:id="label_tvshow"
    private Label label_tvshow; // Value injected by FXMLLoader

    @FXML // fx:id="label_alias_title_tvedit"
    private Label label_alias_title_tvedit; // Value injected by FXMLLoader

    @FXML // fx:id="label_average_length_tvedit"
    private Label label_average_length_tvedit; // Value injected by FXMLLoader

    @FXML // fx:id="label_outcome_year_tvedit"
    private Label label_outcome_year_tvedit; // Value injected by FXMLLoader

    @FXML // fx:id="label_description_tvedit"
    private Label label_description_tvedit; // Value injected by FXMLLoader

    @FXML // fx:id="label_outcome_year_tvedit1"
    private Label label_outcome_year_tvedit1; // Value injected by FXMLLoader

    @FXML // fx:id="delete_link_tvshow"
    private Hyperlink delete_link_tvshow; // Value injected by FXMLLoader

    @FXML // fx:id="description_textarea_tvshow"
    private TextArea description_textarea_tvshow; // Value injected by FXMLLoader

    @FXML // fx:id="tvshow_textfield_tvshow"
    private TextField tvshow_textfield_tvshow; // Value injected by FXMLLoader

    @FXML // fx:id="alias_title_textfield_tvshow"
    private TextField alias_title_textfield_tvshow; // Value injected by FXMLLoader

    @FXML // fx:id="average_textfield_tvshow"
    private TextField average_textfield_tvshow; // Value injected by FXMLLoader

    @FXML // fx:id="outcome_year_textfield_tvshow"
    private TextField outcome_year_textfield_tvshow; // Value injected by FXMLLoader

    @FXML // fx:id="save_button_tvshow"
    private Button save_button_tvshow; // Value injected by FXMLLoader

    @FXML // fx:id="cancel_button_tvshow"
    private Button cancel_button_tvshow; // Value injected by FXMLLoader

    @FXML // fx:id="end_year_textfield_tvshow"
    private TextField end_year_textfield_tvshow; // Value injected by FXMLLoader

    @FXML // fx:id="centerPane_login"
    private VBox centerPane_login; // Value injected by FXMLLoader

    @FXML // fx:id="title_login"
    private Label title_login; // Value injected by FXMLLoader

    @FXML // fx:id="username_textfield_login"
    private TextField username_textfield_login; // Value injected by FXMLLoader

    @FXML // fx:id="password_passwordfield_login"
    private PasswordField password_passwordfield_login; // Value injected by FXMLLoader

    @FXML // fx:id="button_login_login"
    private Button button_login_login; // Value injected by FXMLLoader

    @FXML // fx:id="button_cancel_login"
    private Button button_cancel_login; // Value injected by FXMLLoader

    @FXML // fx:id="button_signup_login"
    private Button button_signup_login; // Value injected by FXMLLoader

    @FXML // fx:id="centerPane_signup"
    private VBox centerPane_signup; // Value injected by FXMLLoader

    @FXML // fx:id="title_login1"
    private Label title_login1; // Value injected by FXMLLoader

    @FXML // fx:id="username_textfield_signup"
    private TextField username_textfield_signup; // Value injected by FXMLLoader

    @FXML // fx:id="firstname_textfield_signup"
    private PasswordField firstname_textfield_signup; // Value injected by FXMLLoader

    @FXML // fx:id="button_signup_signup"
    private Button button_signup_signup; // Value injected by FXMLLoader

    @FXML // fx:id="button_cancel_signup"
    private Button button_cancel_signup; // Value injected by FXMLLoader

    @FXML // fx:id="lastname_textfield_signup"
    private PasswordField lastname_textfield_signup; // Value injected by FXMLLoader

    @FXML // fx:id="email_textfield_signup"
    private PasswordField email_textfield_signup; // Value injected by FXMLLoader

    @FXML // fx:id="password_passwordfield_signup"
    private PasswordField password_passwordfield_signup; // Value injected by FXMLLoader

    @FXML // fx:id="link_login"
    private Hyperlink link_login; // Value injected by FXMLLoader

    @FXML // fx:id="link_register"
    private Hyperlink link_register; // Value injected by FXMLLoader

    @FXML // fx:id="link_logout"
    private Hyperlink link_logout; // Value injected by FXMLLoader

    @FXML // fx:id="link_profile"
    private Hyperlink link_profile; // Value injected by FXMLLoader

    @FXML
    void cancelLogin(ActionEvent event) {

    }

    @FXML
    void cancelMovie(ActionEvent event) {

    }

    @FXML
    void cancelProfile(ActionEvent event) {

    }

    @FXML
    void loginUser(ActionEvent event) {

    }

    @FXML
    void logoutProfile(ActionEvent event) {

    }

    @FXML
    void openAddMovieView(ActionEvent event) {

    }

    @FXML
    void openAddTvShowView(ActionEvent event) {

    }

    @FXML
    void openHomeView(ActionEvent event) {

    }

    @FXML
    void openLoginView(ActionEvent event) {

    }

    @FXML
    void openMovieAll(ActionEvent event) {

    }

    @FXML
    void openProfileView(ActionEvent event) {

    }

    @FXML
    void openRegisterView(ActionEvent event) {

    }

    @FXML
    void openTvShowAll(ActionEvent event) {

    }

    @FXML
    void saveMovie(ActionEvent event) {

    }

    @FXML
    void saveProfile(ActionEvent event) {

    }

    @FXML
    void saveTvShow(ActionEvent event) {

    }

    @FXML
    void searchMovie(ActionEvent event) {

    }

    @FXML
    void searchTvShow(ActionEvent event) {

    }

    @FXML
    void signupUser(ActionEvent event) {

    }

}
