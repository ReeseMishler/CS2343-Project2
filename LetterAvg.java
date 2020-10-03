import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LetterAvg {
	private char avgLetter;
	private int numOfSimilarStations;
	private ArrayList<String> okStationsArr;
	private final String meso = "Mesonet.txt";
	private ArrayList<String> similarStation;
	
	public LetterAvg(char avgLetter) {
		this.avgLetter = avgLetter;
	}
	
	public int numberOfStationWithLetterAvg() throws FileNotFoundException {
		//I think we are going to have to read through array again....
		okStationsArr = new ArrayList<String>();
		FileInputStream fileByteStream = new FileInputStream(meso);
		Scanner reader = new Scanner(fileByteStream);
		//The Station IDs until the 4th line of the document. Skip the first three lines
		reader.nextLine();
		reader.nextLine();
		reader.nextLine();
		//Read through station IDs and add each to the next element of the arraylist
		while(reader.hasNextLine()) { //Looping through each line to end of file
			//For each line, taking first grouping of characters (leading white space omitted) which will be station ID
			String currStnID = reader.next();
			okStationsArr.add(currStnID);
			reader.nextLine(); //Moving down to the next line of file
		}
		reader.close();
		
		numOfSimilarStations = 0;
		similarStation = new ArrayList<String>();
		for(int i = 0; i < okStationsArr.size(); ++i) {
			
			if(okStationsArr.get(i).charAt(0) == this.avgLetter) {
				++numOfSimilarStations;
				similarStation.add(okStationsArr.get(i)); //ADD THE STATION TO A NEW ARRAY SO THAT WE CAN USE IT TO PRINT IN TO STRING
			}
		}
		return numOfSimilarStations;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("These stations are: ");
		for(int i = 0; i < similarStation.size() - 1; ++i) {
			sb.append(similarStation.get(i) + " ");
		}
		sb.append(similarStation.get(similarStation.size()-1));
		String output = sb.toString();
		
		return output;
	}
}
