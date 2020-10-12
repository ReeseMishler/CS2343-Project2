import java.io.FileNotFoundException;
import java.util.ArrayList;

public class LetterAvg {
	private char avgLetter;
	private int numOfSimilarStations;
	private ArrayList<String> okStationsArr;
	private static final String DUMMY_VAR = "NRMN";
	private ArrayList<String> similarStation;
	private String output;
	
	public LetterAvg(char avgLetter) {
		this.avgLetter = avgLetter;
	}
	
	public int numberOfStationWithLetterAvg() throws FileNotFoundException {
		
		PosAvg arrayCollect = new PosAvg(DUMMY_VAR);
		okStationsArr = arrayCollect.getStnArr();
		
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
		//Setting up the output String for toString() 
		StringBuilder sb = new StringBuilder("These stations are: ");
		for(int i = 0; i < similarStation.size() - 1; ++i) {
			sb.append(similarStation.get(i) + " ");
		}
		sb.append(similarStation.get(similarStation.size()-1));
		output = sb.toString() + "\n";
		
		return output;
	}
}
