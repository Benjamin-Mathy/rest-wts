package com.school.wts.rest.dto;

/**
 * @author Youba
 *
 */
public class MusicDTO {
	private Long id;
	private String title;
	private String artist;
	private String genre;
	private String filePath;

	private MusicDTO() {
		super();
	}

	/**
	 * @param title
	 * @param artist
	 * @param genre
	 * @param filePath
	 */
	public MusicDTO(String title, String artist, String genre, String filePath) {
		this();
		this.title = title;
		this.artist = artist;
		this.genre = genre;
		this.filePath = filePath;
	}

	/**
	 * @param id
	 * @param title
	 * @param artist
	 * @param genre
	 * @param filePath
	 */
	public MusicDTO(Long id, String title, String artist, String genre, String filePath) {
		this();
		this.id = id;
		this.title = title;
		this.artist = artist;
		this.genre = genre;
		this.filePath = filePath;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
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
	 * @return the artist
	 */
	public String getArtist() {
		return artist;
	}

	/**
	 * @param artist the artist to set
	 */
	public void setArtist(String artist) {
		this.artist = artist;
	}

	/**
	 * @return the genre
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * @param genre the genre to set
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}

	/**
	 * @return the filePath
	 */
	public String getFilePath() {
		return filePath;
	}

	/**
	 * @param filePath the filePath to set
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
}