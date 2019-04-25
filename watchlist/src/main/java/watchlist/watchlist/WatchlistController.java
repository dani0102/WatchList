package watchlist.watchlist;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;


public class WatchlistController {

    @FXML
    private MenuBar navbar_watchlist;

    @FXML
    private VBox centerPane_tvshow;

    @FXML
    private GridPane grid_movie1;

    @FXML
    private TextField search_field_movie;

    @FXML
    private Label search_label_movie;

    @FXML
    private ScrollBar scrollbar_tvshow;

    @FXML
    private VBox centerPane_movie;

    @FXML
    private GridPane grid_movie;

    @FXML
    private ScrollBar scrollbar_movie;

    @FXML
    private VBox centerPane_home;

    @FXML
    private Label tvshowTitle;

    @FXML
    private GridPane tvshowGrid;

    @FXML
    private Label movieTitle;

    @FXML
    private GridPane movieGrid;

    @FXML
    private VBox centerPane_show_profile;

    @FXML
    private Label profile_label;

    @FXML
    private ImageView profile_image;

    @FXML
    private Label label_username;

    @FXML
    private Label label_firstname;

    @FXML
    private Label label_lastname;

    @FXML
    private Label username_input;

    @FXML
    private Label firstname_input;

    @FXML
    private Label lastname_input;

    @FXML
    private Label label_email;

    @FXML
    private Label email_input;

    @FXML
    private Hyperlink link_edit_profile;

    @FXML
    private VBox centerPane_edit_profile;

    @FXML
    private Label profile_label1;

    @FXML
    private ImageView profile_image1;

    @FXML
    private Label label_username1;

    @FXML
    private Label label_firstname1;

    @FXML
    private Label label_lastname1;

    @FXML
    private Label label_email1;

    @FXML
    private Hyperlink link_delete_profile;

    @FXML
    private TextField username_text_input;

    @FXML
    private TextField firstname_text_input;

    @FXML
    private TextField lastname_text_input;

    @FXML
    private TextField email_text_input;

    @FXML
    private Button button_profile_save;

    @FXML
    private Button button_profile_cancel;

    @FXML
    private VBox centerPane_show_movie;

    @FXML
    private Label movie_title;

    @FXML
    private ImageView movie_image;

    @FXML
    private Label label_movie;

    @FXML
    private Label label_alias_title;

    @FXML
    private Label label_outcome_year;

    @FXML
    private Label label_length;

    @FXML
    private Hyperlink link_delete_movie;

    @FXML
    private TextField movie_text_input;

    @FXML
    private TextField alias_title_text_input;

    @FXML
    private TextField outcome_year_text_input;

    @FXML
    private TextField length_text_input;

    @FXML
    private Button button_movie_save;

    @FXML
    private Button button_profile_cancel1;

    @FXML
    private Label label_description;

    @FXML
    private TextArea description_text_input;

    @FXML
    private VBox centerPane_edit_movie;

    @FXML
    private Label movie_title1;

    @FXML
    private ImageView movie_image1;

    @FXML
    private Label label_movie1;

    @FXML
    private Label label_alias_title1;

    @FXML
    private Label label_outcome_year1;

    @FXML
    private Label label_length1;

    @FXML
    private Hyperlink link_delete_movie1;

    @FXML
    private Label label_description1;

    @FXML
    private Label description_input;

    @FXML
    private Label description_input1;

    @FXML
    private Label alias_title_input;

    @FXML
    private Label outcome_year_input;

    @FXML
    private Label length_input;

    @FXML
    private VBox centerPane_show_tvshow;

    @FXML
    private Label tvshow_title;

    @FXML
    private ImageView tvshow_image;

    @FXML
    private Label label_movie11;

    @FXML
    private Label label_alias_title_tv;

    @FXML
    private Label label_outcome_year_tv;

    @FXML
    private Label label_length_tv;

    @FXML
    private Hyperlink link_edit_tvshow;

    @FXML
    private Label label_description_tv;

    @FXML
    private Label description_input_tv;

    @FXML
    private Label tvshow_input;

    @FXML
    private Label alias_title_input_tv;

    @FXML
    private Label outcome_year_input_tv;

    @FXML
    private Label length_input_tv;

    @FXML
    private Label label_end_year_tv;

    @FXML
    private Label end_year_input_tv;

    @FXML
    private VBox centerPane_edit_tvshow;

    @FXML
    private Label tvshow_title_edit;

    @FXML
    private ImageView tvshow_image_edit;

    @FXML
    private Label label_tvshow;

    @FXML
    private Label label_alias_title_tvedit;

    @FXML
    private Label label_average_length_tvedit;

    @FXML
    private Label label_outcome_year_tvedit;

    @FXML
    private Label label_description_tvedit;

    @FXML
    private Label label_outcome_year_tvedit1;

    @FXML
    private Hyperlink link_delete_tvshow;

    @FXML
    private TextField tvshow_text_input;

    @FXML
    private TextField alias_title_text_input_tv;

    @FXML
    private TextField average_text_input_tv;

    @FXML
    private TextField outcome_year_text_input_tv;

    @FXML
    private Button button_tvshow_save;

    @FXML
    private Button button_profile_cancel11;

    @FXML
    private TextField end_year_text_input_tv;

    @FXML
    private VBox centerPane_login;

    @FXML
    private Label title_login;

    @FXML
    private TextField username_input_login;

    @FXML
    private PasswordField password_input_login;

    @FXML
    private Button button_login;

    @FXML
    private Button button_cancel;

    @FXML
    private Button button_login1;

    @FXML
    private VBox centerPane_signup;

    @FXML
    private Label title_login1;

    @FXML
    private TextField username_inputfield;

    @FXML
    private PasswordField firstname_inputfield;

    @FXML
    private Button button_signup;

    @FXML
    private Button button_cancel_register;

    @FXML
    private PasswordField lastname_inputfield;

    @FXML
    private PasswordField email_inputfield;

    @FXML
    private PasswordField password_inputfield;

    @FXML
    private Hyperlink link_login;

    @FXML
    private Hyperlink link_register;

    @FXML
    private Hyperlink link_logout;

    @FXML
    private Hyperlink link_profile;

    @FXML
    void loginUser(ActionEvent event) {

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
    void signupUser(ActionEvent event) {

    }

}