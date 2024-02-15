package edu.cscc;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// TODO - Margaret Riordan, 24 Jan 2024, Lab 2 - Simple Web Page Generation
public class Lab02 {

	private static String pre = "<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n<title>Natural Arches"+
			"</title>\n<meta charset=\"utf-8\">\n</head>\n<body>\n"+
			"<h1>Ohio Natural Arches</h1>\n<ul>\n";
	private static String post = "</ul>\n</body>\n</html>\n";
	private static final String LI_START = "<li>";
	private static final String LI_END = "</li>\n";
	
	
	public static void main(String[] args) {
		BufferedWriter bw = null;
		File file = new File("Lab2Data.txt");
		try ( Scanner input = new Scanner(file); ) {
			bw = new BufferedWriter(new FileWriter(new File("arches.html")));
			bw.write(pre);
			input.nextLine();
			while(input.hasNext()) {
				String str = input.nextLine();
				
				// find appropriate data and assign to variables to prepare for HTML list item creation
				String[] rawDataArray = splitRawData(str);
				String name = findName(rawDataArray);
				String park = findPark(rawDataArray);
				String county = findCounty(rawDataArray);
				
				String geoCoord = findGeoCoord(rawDataArray);
				String[] geoCoordArray = makeGeoCoordArray(geoCoord);
				double [] latAndLongCoord = findLatAndLong(geoCoordArray);
				double latCoord = latAndLongCoord[0];
				double longCoord = latAndLongCoord[1];
				
				String decLat = String.format("%.4f", latCoord);
				String decLong = String.format("%.4f",longCoord);
				String linkURL = createURL(decLat, decLong);
				
				//create HTML line using variables from above
				String newListItem  = generateListItem(linkURL, name, decLat, decLong, park, county);
				
				//add HTML list item to HTML file
				String output = LI_START + newListItem + LI_END;
				
				bw.write(output);
			}
			bw.write(post);
		} catch(FileNotFoundException ex) {
			System.out.println(ex.getMessage());
		} catch (IOException ex2) {
			System.out.println(ex2.getMessage());
		}
		if (bw != null) {
			try { bw.close(); } catch (IOException e) { /* do nothing */ }
		}
		System.out.println("HTML file generated!");
	}
	
	//find appropriate values for fields
	public static String[] splitRawData (String rawData) {
		String[] rawDataArray = rawData.split(",");
		return rawDataArray;
	}
	
	public static String findName(String[] rawDataArray) {
		String name = rawDataArray[0];
		return name;
	}
	
	public static String findPark(String[] rawDataArray) {
		String park = rawDataArray[1];
		return park;
	}
	
	public static String findCounty(String[] rawDataArray) {
		String county = rawDataArray[2];
		return county;
	}
	
	public static String findGeoCoord(String[] rawDataArray) {
		String geoCoord = rawDataArray[3];
		return geoCoord;
	}
	
	//prepare geo coordinates for the calculation of longitude and latitude
	public static String[] makeGeoCoordArray(String geoCoord) {
		String[] geoCoordArray = geoCoord.split(" ");
		return geoCoordArray;
	}
	
	//find longitude and latitude and store in array
	public static double[] findLatAndLong(String[] geoCoordArray) {
		
		//declare variables for latitude
		double latDegrees = numbersOnly(geoCoordArray[0]);
		double latMinutes = numbersOnly(geoCoordArray[1]);
		double latSeconds = numbersOnly(geoCoordArray[2]);
		String latDirection = geoCoordArray[3];
		
		//declare variables for longitude
		double longDegrees = numbersOnly(geoCoordArray[4]);
		double longMinutes = numbersOnly(geoCoordArray[5]);
		double longSeconds = numbersOnly(geoCoordArray[6]);
		String longDirection = geoCoordArray[7];
		
		//calculate cardinal representation
		int latCardDir = calcCardinal(latDirection);
		int longCardDir = calcCardinal(longDirection);
		
		//calculate latitude and longitude coordinates
		double latCoord = calcCoord(latDegrees, latMinutes, latSeconds, latCardDir);
		double longCoord = calcCoord(longDegrees, longMinutes, longSeconds, longCardDir);
		
		//place coordinates into array and return array
		double[] coordArray = new double[2];
		coordArray[0] = latCoord;
		coordArray[1] = longCoord;
		
		return coordArray;
	}
	
	//calculate longitude OR latitude using geo coordinates
	public static double calcCoord(double degrees, double minutes, double seconds, int cardinal) {
		
		double coord = 
				cardinal * (degrees + (minutes/60) + (seconds/3600));
		
		return coord;
	}
	
	//find the appropriate direction as integer
	public static int calcCardinal(String direction) {
		int numDir = 1;
		if (direction.equalsIgnoreCase("W")) {
			numDir = -1;
		}
		if (direction.equalsIgnoreCase("S")) {
			numDir = -1;
		}
		return numDir;	
	}
	
	//strip non-number characters from field
	public static double numbersOnly(String field) {
		return Double.parseDouble(field.replaceAll("[^0-9.]", ""));
	}
	
	//create URL for appropriate location on google maps
	public static String createURL(String decLat, String decLong) {
		return new StringBuilder("https://www.google.com/maps/search/?api=1&query=")
				.append(decLat)
				.append(",")
				.append(decLong)
				.toString();
	}
	
	//prepare string for HTML
	public static String generateListItem(String linkURL, String name, String decLat, String decLong, String park, String county) {
		return new StringBuilder()
				.append("<a href=\"" + linkURL + "\">")
				.append(name + "</a>")
				.append(" at coordinates(" + decLat)
				.append(", " + decLong + ")")
				.append(" is located at " + park)
				.append(" in " + county + " County")
				.toString();
		
	}
	
}
