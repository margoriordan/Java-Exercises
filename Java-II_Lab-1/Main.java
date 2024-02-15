//Margaret Riordan

package edu.cscc;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("* * * Video Game Catalog * * *");
		boolean changed = false;

		// Initialize and read in catalog from file
		VideoGameCatalog catalog = new VideoGameCatalog();
		try {
			catalog.readCatalog();
			System.out.println("Your catalog has " + catalog.getGameCount() + " video games");
		} catch (FileNotFoundException e) {
			System.out.println("Catalog is empty");
		}

		while (true) {
			System.out.print(
					"Type 'A' to Add entry, 'D' to delete entry, 'L' to List catalog, and 'Q' to quit\nEnter command: ");
			String command = input.nextLine();
			if ("a".equalsIgnoreCase(command)) {
				addEntry(catalog);
				changed = true;
			} else if ("d".equalsIgnoreCase(command)) {
				if (deleteEntry(catalog) == true) {
					changed = true;
				}
			} else if ("l".equalsIgnoreCase(command)) {
				listCatalog(catalog);
			} else if ("q".equalsIgnoreCase(command)) {
				System.out.println("Good bye");
				break;
			} else {
				System.out.println("Unknown command: " + command);
			}
		}

		if (changed)
			catalog.writeCatalog();
	}

	public static void addEntry(VideoGameCatalog catalog) {
		System.out.println("--- Add a Game to Catalog ---");
		System.out.print("Enter name of game: ");
		String name = input.nextLine().strip();

		Platform platform = getPlatform(catalog);

		Genre genre = getGenre(catalog);

		GameMode mode = getMode(catalog);

		System.out.print("Enter publisher of game: ");
		String publisher = input.nextLine().strip();

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.now();
		String dateAdded = dtf.format(localDate);

		System.out.print("Enter comment: ");
		String comment = input.nextLine().strip();
		if (comment == null || comment.isEmpty()) {
			comment = "N/A";
		}

		VideoGame game = new VideoGame(name, platform, genre, mode, publisher, dateAdded, comment);
		catalog.addEntry(game);
		System.out.println("Game: " + name + " added to catalog");
	}

	public static void listCatalog(VideoGameCatalog catalog) {
		int i = 1;
		for (VideoGame game : catalog.getCatalog()) {
			System.out.println(i + " " + game.toString());
			i++;
		}
	}

	public static boolean deleteEntry(VideoGameCatalog catalog) {
		boolean deleted = false;
		if (catalog.getGameCount() == 0) {
			System.out.println("Catalog is empty");
		} else {
			listCatalog(catalog);
			System.out.print("Enter number of entry to delete: ");
			int entrynum = input.nextInt();
			input.nextLine();
			if (catalog.deleteEntry(entrynum - 1)) {
				System.out.println("Entry " + entrynum + " deleted");
				deleted = true;
			} else {
				System.out.println("Could not delete entry " + entrynum);
			}
		}
		return deleted;
	}

	public static Platform getPlatform(VideoGameCatalog catalog) {
		Platform platform = null;
		do {
			System.out.print("Enter platform [" + catalog.listPlatforms() + "]: ");
			String instr = input.nextLine().strip().toUpperCase();
			try {
				platform = Platform.valueOf(instr);
			} catch (IllegalArgumentException ex) {
				System.out.println("Invalid platform");
			}
		} while (platform == null);
		return platform;
	}

	public static Genre getGenre(VideoGameCatalog catalog) {
		Genre genre = null;
		do {
			System.out.print("Enter genre [" + catalog.listGenres() + "]: ");
			String instr = input.nextLine().strip().toUpperCase();
			try {
				genre = Genre.valueOf(instr);
			} catch (IllegalArgumentException ex) {
				System.out.println("Invalid game genre");
			}
		} while (genre == null);
		return genre;
	}

	public static GameMode getMode(VideoGameCatalog catalog) {
		GameMode mode = null;
		do {
			System.out.print("Enter game mode [" + catalog.listModes() + "]: ");
			String instr = input.nextLine().strip().toUpperCase();
			try {
				mode = GameMode.valueOf(instr);
			} catch (IllegalArgumentException ex) {
				System.out.println("Invalid game mode");
			}
		} while (mode == null);
		return mode;
	}

}
