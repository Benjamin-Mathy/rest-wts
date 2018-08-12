package com.school.wts.rest.dto;

import java.io.File;

/**
 * @author Youba
 *
 */
public class MusicDTO {
	private Long id;
	private String title;
	private String artist;
	private String genre;
	private String fileDriveID;
	private File file;

	private MusicDTO() {
		super();
	}

	/**
	 * @param title
	 * @param artist
	 * @param genre
	 * @param fileDriveID
	 */
	public MusicDTO(String title, String artist, String genre, String fileDriveID) {
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
	public MusicDTO(Long id, String title, String artist, String genre, String fileDriveID) {
		this();
		this.id = id;
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
	 * @param file
	 */
	public MusicDTO(Long id, String title, String artist, String genre, String fileDriveID, File file) {
		super();
		this.id = id;
		this.title = title;
		this.artist = artist;
		this.genre = genre;
		this.fileDriveID = fileDriveID;
		this.file = file;
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
	public void setFileDriveID(String fileDriveID) {
		this.fileDriveID = fileDriveID;
	}

	/**
	 * @return the file
	 */
	public File getFile() {
		return file;
	}

	/**
	 * @param file the file to set
	 */
	public void setFile(File file) {
		this.file = file;
	}

}
