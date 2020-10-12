import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class PosAvg {
	/**
	 * Class variable declarations
	 */
	private ArrayList<String> okStations;
	private String givenID;
	private static final String meso = "Mesonet.txt";
	private int idxOfGivenID;
	private String StnOfOneSmaller;
	private String StnOfOneLarger;
	private String StnOfTwoSmaller;
	private String StnOfTwoLarger;
	
	public PosAvg(String stID) {
		this.givenID = stID;
	}
	
	public int indexOfStation() throws FileNotFoundException {
		
		okStations = this.getStnArr();
		
		//set a forloop, and go through each element of the list until the givenID is found
		for(int i = 0; i < okStations.size(); ++i) {
			if(givenID.compareTo(okStations.get(i)) == 0) { //Checking if the strings are equal
				idxOfGivenID = i + 1; //Adding one because list index starts at 0 instead of 1
				break; //Once idx of givenID is found, we can break out of the loop
			}
		}
	    
	    StnOfOneSmaller = okStations.get(idxOfGivenID - 2);
	    StnOfOneLarger = okStations.get(idxOfGivenID);
	    StnOfTwoSmaller = okStations.get(idxOfGivenID - 3);
	    StnOfTwoLarger = okStations.get(idxOfGivenID + 1);
	    
		return idxOfGivenID;
	}
	
	public ArrayList<String> getStnArr() throws FileNotFoundException{

	    this.okStations = new ArrayList<String>();
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
		
		return okStations;
	}
	
	
	@Override
	public String toString() {
		//Overridden toString() method will print information about the Stations who's indices average out to equaling
		// the indices of the givenID
		
		String output = "This index is average of " + StnOfOneSmaller + " and " + StnOfOneLarger     
				        + ", " + StnOfTwoSmaller + " and " + StnOfTwoLarger + ", and so on.";
		
		return output;
	}

}
