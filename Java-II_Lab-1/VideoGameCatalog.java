package edu.cscc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class VideoGameCatalog {

	private ArrayList<VideoGame> catalog;

	public static final String DATAFILE = "mygames.txt";

	public VideoGameCatalog() {
		catalog = new ArrayList<>();
	}

	public ArrayList<VideoGame> getCatalog() {
		return catalog;
	}

	public void addEntry(VideoGame game) {
		catalog.add(game);
	}

	public int getGameCount() {
		return catalog.size();
	}

	public boolean deleteEntry(int entrynum) {
		if (entrynum >= 0 && entrynum < this.getGameCount()) {
			catalog.remove(entrynum);
			return (true);
		} else {
			return false;
		}
	}

	/**
	 * Read the catalog file and populate catalog
	 * 
	 * @throws FileNotFoundException
	 */
	public void readCatalog() throws FileNotFoundException {
		// Empty out catalog
		catalog.clear();

		// Read catalog from file
		File file = new File(DATAFILE);
		try (Scanner input = new Scanner(file);) {
			while (input.hasNext()) {
				String str = input.nextLine();
				String[] gameData = str.split(",");

				String name = gameData[0];
				Platform platform = Platform.valueOf(gameData[1]);
				Genre genre = Genre.valueOf(gameData[2]);
				GameMode gameMode = GameMode.valueOf(gameData[3]);
				String publisher = gameData[4];
				String dateAdded = gameData[5];
				String comment = gameData[6];

				VideoGame game = new VideoGame(name, platform, genre, gameMode, publisher, dateAdded, comment);
				this.addEntry(game);
			}
		} catch (NumberFormatException e) {
			System.out.println("Invalid game number in data");
		} catch (IllegalArgumentException e) {
			System.out.println("Invalid Enum value in data");
		}
	}

	/**
	 * Write out catalog to catalog file
	 * 
	 * @throws FileNotFoundException
	 */
	public void writeCatalog() {

		File file = new File(DATAFILE);
		try (PrintStream output = new PrintStream(new FileOutputStream(file));) {
			if (catalog.size() > 0) {
				for (VideoGame game : catalog) {
					output.println(game.getName() + "," + 
							game.getPlatform() + "," + 
							game.getGenre() + "," + 
							game.getGameMode() + "," + 
							game.getPublisher() + "," + 
							game.getDateAdded() + "," +
							game.getComment());
				}
			} else {
				output.println();
			}
		} catch (FileNotFoundException e) {
			System.out.println("Could not write file: " + DATAFILE);
		}
	}

	// Utility methods
	public String listPlatforms() {
		String str = "";
		for (Platform p : Platform.values()) {
			str = str + " " + p;
		}
		return str.strip();
	}

	public String listGenres() {
		String str = "";
		for (Genre g : Genre.values()) {
			str = str + " " + g;
		}
		return str.strip();
	}

	public String listModes() {
		String str = "";
		for (GameMode m : GameMode.values()) {
			str = str + " " + m;
		}
		return str.strip();
	}
}
