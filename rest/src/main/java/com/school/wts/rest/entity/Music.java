package com.school.wts.rest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Youba
 *
 */
@Entity
public class Music {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String artist;
	private String genre;
	private String fileDriveID;

	private Music() {
		super();
	}

	/**
	 * @param title
	 * @param artist
	 * @param genre
	 * @param fileDriveID
	 */
	public Music(String title, String artist, String genre, String fileDriveID) {
		this();
		this.title = title;
		this.artist = artist;
		this.genre = genre;
		this.fileDriveID = fileDriveID;
	}

	/**
	 * @param id
	 * @param title
	 * @param artist
	 * @param genre
	 * @param fileDriveID
	 */
	public Music(Long id, String title, String artist, String genre, String fileDriveID) {
		this();
		this.id = id;
		this.title = title;
		this.artist = artist;
		this.genre = genre;
		this.fileDriveID = fileDriveID;
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
	 * @return the fileDriveID
	 */
	public String getFileDriveID() {
		return fileDriveID;
	}

	/**
	 * @param filePath the fileDriveID to set
	 */
	public void setFileDriveID(String filePath) {
		this.fileDriveID = filePath;
	}

}
