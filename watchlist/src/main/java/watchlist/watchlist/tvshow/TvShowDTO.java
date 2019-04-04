package watchlist.watchlist.tvshow;

import java.awt.Image;

/**
 * This class is the DTO for the entity TvShow.
 * 
 * @author Belinda Schuehle
 */
public class TvShowDTO {
	
	private Long tvshow_id;
	
	private String title;
	
	private String alias_title;
	
	private String description;
	
	private Image picture;
	
	private Integer outcome_year;
	
	private Integer end_year;
	
	private Integer average_length;

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
	public Image getPicture() {
		return picture;
	}

	/**
	 * @param picture the picture to set
	 */
	public void setPicture(Image picture) {
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
