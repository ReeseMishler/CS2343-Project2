import java.util.List;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class PosAvg {
	private ArrayList<String> okStations;
	private String givenID;
	private final String meso = "Mesonet.txt";
	private int idxOfGivenID;
	
	public PosAvg(String stID) {
		this.givenID = stID;
	}
	public int indexOfStation() throws FileNotFoundException {
		
		okStations = new ArrayList<String>();
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
			okStations.add(currStnID);
			reader.nextLine(); //Moving down to the next line of file
		}
		reader.close();
		//set a forloop, and go through each element of the list until the givenID is found
		for(int i = 0; i < okStations.size(); ++i) {
			if(givenID.compareTo(okStations.get(i)) == 0) { //Checking if the strings are equal
				idxOfGivenID = i + 1; //Adding one because list index starts at 0 instead of 1
				break; //Once idx of givenID is found, we can break out of the loop
			}
		}
		return idxOfGivenID;
	}
	
	public String[] getAverages(int idIdx) { //This will give us the Strings who's index will average out to be the index of the stID originally given
		String[] averages = new String[4];
		int idxOfOneSmaller = idIdx - 2;    //We want the idx just behind the index of the givenID. We had to add one to it so we subtract two
		int idxOfOneLarger = idIdx + 2;     //Same as previous but the one above givenID
		int idxOfTwoSmaller = idIdx - 3;    //We want the idx two behind the index of the givenID. We had to add one to it so we subtract three
		int idxOfTwoLarger = idIdx + 3;     //Same as previous but the one two above givenID
		//Now we will add the station IDs at the indices just calculated to a String array.
		averages[0] = okStations.get(idxOfOneSmaller);
		averages[1] = okStations.get(idxOfOneLarger);
		averages[2] = okStations.get(idxOfTwoSmaller);
		averages[3] = okStations.get(idxOfTwoLarger);
		//The returned array can be used within the toString() method.
		return averages;
	}
	
	@Override
	public String toString() {
		//Overridden toString() method will print information about the Stations who's indices average out to equaling
		// the indices of the givenID
		String[] stIDsThatAvg = this.getAverages(idxOfGivenID); //Get the strings that will average by calling the getAverages() method
		
		String output = "This index is average of " + stIDsThatAvg[0] + " and " + stIDsThatAvg[1] 
				        + ", " + stIDsThatAvg[2] + " and " + stIDsThatAvg[3] + ", and so on.";
		return output;
	}

}
