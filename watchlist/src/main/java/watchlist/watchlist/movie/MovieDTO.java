package watchlist.watchlist.movie;
/**
 * This class is the DTO for the entity Movie.
 * 
 * @author Belinda Stifani
 */
public class MovieDTO {
	
	private Long movie_id;
	
	private String title;
	
	private String alias_title;
	
	private String description;
	
	private byte[] picture;
	
	private Integer outcome_year;
	
	private Integer length;

	/**
	 * @return the movie_id
	 */
	public Long getMovie_id() {
		return movie_id;
	}

	/**
	 * @param movie_id the movie_id to set
	 */
	public void setMovie_id(Long movie_id) {
		this.movie_id = movie_id;
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
	public byte[] getPicture() {
		return picture;
	}

	/**
	 * @param picture the picture to set
	 */
	public void setPicture(byte[] picture) {
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
	 * @return the length
	 */
	public Integer getLength() {
		return length;
	}

	/**
	 * @param length the length to set
	 */
	public void setLength(Integer length) {
		this.length = length;
	}
	
	
}