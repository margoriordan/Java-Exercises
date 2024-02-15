package edu.cscc;

public class VideoGame {
	private String name;
	private Platform platform;
	private Genre genre;
	private GameMode gameMode;
	private String publisher;
	private String dateAdded;
	private String comment;
	
	public VideoGame(String name, Platform platform, Genre genre, GameMode gameMode, String publisher,
			String dateAdded, String comment) {
		super();
		this.name = name;
		this.platform = platform;
		this.genre = genre;
		this.gameMode = gameMode;
		this.publisher = publisher;
		this.dateAdded = dateAdded;
		this.comment = comment;
	}
	
	public String toString() {
		return "Name: " + name + " Platform: " + platform + " Genre: "+ genre +
				" Mode: "+gameMode +" Publisher: "+ publisher + " Date: " + dateAdded +
				" Comment: " + comment;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Platform getPlatform() {
		return platform;
	}

	public void setPlatform(Platform platform) {
		this.platform = platform;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public GameMode getGameMode() {
		return gameMode;
	}

	public void setGameMode(GameMode gameMode) {
		this.gameMode = gameMode;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(String dateAdded) {
		this.dateAdded = dateAdded;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
