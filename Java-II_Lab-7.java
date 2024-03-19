package edu.cscc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import org.json.*;

/**
 * Find out who's in space JSON library from:
 * https://github.com/stleary/JSON-java
 * 
 * @author Margaret Riordan
 *
 */
public class Main {

	public static void main(String[] args) {
		final String theURLString = "http://api.open-notify.org/astros.json";
		
		// TODO - Step 1 - read input from above URL and store in a String. Output the String to the console
		try {
			URL url = new URL(theURLString);
			URLConnection connection = url.openConnection();
			try (BufferedReader buffRead = new BufferedReader(new InputStreamReader(connection.getInputStream()))){
				String line, json = "";
				while((line = buffRead.readLine()) != null) {
					json = json + line + "\n";
				}
				String parsedString = json.replaceAll("(.{75})","$1\n");
				System.out.println(parsedString);
				
				// TODO - Step 3 - Parse the JSON object and print the list of people in orbit and where they are.
				
				JSONObject jsonObj = new JSONObject(json);
				String[] astronautsInSpace = parseJSON(jsonObj);
				
				System.out.println("There are " + astronautsInSpace.length + " people in space!" );
				
				for (String astronauts : astronautsInSpace) {
					System.out.println(astronauts);
				}
			}
			
		} catch (MalformedURLException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	// TODO - Step 2 - Using the org.json library, parse the JSON string to determine the number of people in orbit and then output that value
	
	public static String[] parseJSON(JSONObject jsonObj) {
		ArrayList<String> astronautList = new ArrayList<>();
		
		if (jsonObj != null) {
			JSONArray peopleInSpace = jsonObj.getJSONArray("people");
			for (int i = 0; i < peopleInSpace.length(); i++) {
				JSONObject astronaut = peopleInSpace.getJSONObject(i);
				String name = astronaut.getString("name");
				String craft = astronaut.getString("craft");
				
				astronautList.add(name + " is on board: " + craft);
				
			}
		}
		return astronautList.toArray(new String[1]);
	}
}
