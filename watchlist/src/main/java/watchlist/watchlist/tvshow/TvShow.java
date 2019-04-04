package watchlist.watchlist.tvshow;

import java.awt.Image;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 * This class is the entity TvShow.
 * 
 * @author Belinda Schuehle
 */
@Entity
@Table(name = "tvshow")
public class TvShow {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long tvshow_id;
	
	@Column
	@NotBlank
	private String title;
	
	@Column
	private String alias_title;

	@Column
	@NotBlank
	private String description;
	
	@Column
<<<<<<< Updated upstream
<<<<<<< Updated upstream
	private byte[] picture;
=======
	private Image picture;
>>>>>>> Stashed changes
=======
	private Image picture;
>>>>>>> Stashed changes
	
	@Column
	private Integer outcome_year;
	
	@Column
	private Integer end_year;
	
	@Column
	private Integer average_length;

	public TvShow() {
		super();
	}

	/**
	 * @param title
	 * @param alias_title
	 * @param description
	 * @param picture
	 * @param outcome_year
	 * @param end_year
	 * @param average_length
	 */
<<<<<<< Updated upstream
<<<<<<< Updated upstream
	public TvShow(@NotBlank String title, String alias_title, @NotBlank String description, byte[] picture,
=======
	public TvShow(@NotBlank String title, String alias_title, @NotBlank String description, Image picture,
>>>>>>> Stashed changes
=======
	public TvShow(@NotBlank String title, String alias_title, @NotBlank String description, Image picture,
>>>>>>> Stashed changes
			Integer outcome_year, Integer end_year, Integer average_length) {
		super();
		this.title = title;
		this.alias_title = alias_title;
		this.description = description;
		this.picture = picture;
		this.outcome_year = outcome_year;
		this.end_year = end_year;
		this.average_length = average_length;
	}

	/**
	 * @param tvshow_id
	 * @param title
	 * @param alias_title
	 * @param description
	 * @param picture
	 * @param outcome_year
	 * @param end_year
	 * @param average_length
	 */
	public TvShow(Long tvshow_id, @NotBlank String title, String alias_title, @NotBlank String description,
<<<<<<< Updated upstream
<<<<<<< Updated upstream
			byte[] picture, Integer outcome_year, Integer end_year, Integer average_length) {
=======
			Image picture, Integer outcome_year, Integer end_year, Integer average_length) {
>>>>>>> Stashed changes
=======
			Image picture, Integer outcome_year, Integer end_year, Integer average_length) {
>>>>>>> Stashed changes
		super();
		this.tvshow_id = tvshow_id;
		this.title = title;
		this.alias_title = alias_title;
		this.description = description;
		this.picture = picture;
		this.outcome_year = outcome_year;
		this.end_year = end_year;
		this.average_length = average_length;
	}

	/**
	 * @return the tvshow_id
	 */
	public Long getTvshow_id() {
		return tvshow_id;
	}

	/**
	 * @param tvshow_id the tvshow_id to set
	 */
	public void setTvshow_id(Long tvshow_id) {
		this.tvshow_id = tvshow_id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the alias_title
	 */
	public String getAlias_title() {
		return alias_title;
	}

	/**
	 * @param alias_title the alias_title to set
	 */
	public void setAlias_title(String alias_title) {
		this.alias_title = alias_title;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the picture
	 */
<<<<<<< Updated upstream
<<<<<<< Updated upstream
	public byte[] getPicture() {
=======
	public Image getPicture() {
>>>>>>> Stashed changes
=======
	public Image getPicture() {
>>>>>>> Stashed changes
		return picture;
	}

	/**
	 * @param picture the picture to set
	 */
<<<<<<< Updated upstream
<<<<<<< Updated upstream
	public void setPicture(byte[] picture) {
=======
	public void setPicture(Image picture) {
>>>>>>> Stashed changes
=======
	public void setPicture(Image picture) {
>>>>>>> Stashed changes
		this.picture = picture;
	}

	/**
	 * @return the outcome_year
	 */
	public Integer getOutcome_year() {
		return outcome_year;
	}

	/**
	 * @param outcome_year the outcome_year to set
	 */
	public void setOutcome_year(Integer outcome_year) {
		this.outcome_year = outcome_year;
	}

	/**
	 * @return the end_year
	 */
	public Integer getEnd_year() {
		return end_year;
	}

	/**
	 * @param end_year the end_year to set
	 */
	public void setEnd_year(Integer end_year) {
		this.end_year = end_year;
	}

	/**
	 * @return the average_length
	 */
	public Integer getAverage_length() {
		return average_length;
	}

	/**
	 * @param average_length the average_length to set
	 */
	public void setAverage_length(Integer average_length) {
		this.average_length = average_length;
	}
	
	
}
