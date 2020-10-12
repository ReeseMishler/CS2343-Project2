public class MesoInherit extends MesoAbstract
{
	private MesoStation station;
	private static final int CHARS_IN_STN_ID = 4;
	private static final int NUM_OF_AVGS = 3;
	private char[] chars = new char[CHARS_IN_STN_ID];     //character array holding each character of a given station ID
	private int[] averages = new int[NUM_OF_AVGS];        //Int array containing the Ceiling, Floor, and average compared to DECIMAL_BOUNDARY
	private char letterAvg;
	
	public MesoInherit(MesoStation station) { //Constructor will create a 4 element char arr which holds each character of the station ID passed
		this.station = station;
		chars[0] = this.station.getStID().charAt(0);
		chars[1] = this.station.getStID().charAt(1);
		chars[2] = this.station.getStID().charAt(2);
		chars[3] = this.station.getStID().charAt(3);
	}
	
	public int[] calAverage() {                 //This method will allow us to calculate 
		int sumOfAsciiArr = 0;                  //Will hold the sum of the ASCII values of the char array
		final double DECIMAL_BOUNDARY = 0.75;   //The benchmark for whether theAvg variable will be ceiling or floor
		final int NUM_OF_CHARS = 4;             //Gauranteed amount of characters in a station ID
		int[] asciiArr = new int[NUM_OF_CHARS]; //Int array which will hold the ACSII values of the char array made in the constructor
		
		//Filling an int array with the ASCII values of that characters of the char arr created in constructor
		asciiArr[0] = (int)chars[0];
		asciiArr[1] = (int)chars[1];
		asciiArr[2] = (int)chars[2];
		asciiArr[3] = (int)chars[3];
		
		//Loop through the ASCII array and sum up all of the elements
		for(int i = 0; i<asciiArr.length; ++i) {
			sumOfAsciiArr += asciiArr[i];
		}
		
		double actAvg = sumOfAsciiArr/(float)NUM_OF_CHARS;  //The actual average when the sum of the ACSII array is divided by four
		int ceiling = (int)Math.ceil(actAvg);               //The actual average when rounded up
		int floor = (int)Math.floor(actAvg);                //The actual average when rounded down
		double fraction = actAvg - (int)actAvg;             //The value to be compared with DECIMAL_BOUNDARY (Double value minus its truncated int value)
		int theAvg = 0;
		
		if(fraction >= DECIMAL_BOUNDARY) {                 //Checking to see if the fraction value is greater or equal to 0.75
			theAvg = ceiling;                              //If it is, theAvg is equal to the ceiling
		}
		else {                                             //If not, theAvg is equal to the floor
			theAvg = floor;
		}
		
		this.averages[0] = ceiling;                   //Setting first element of averages to the ceiling value
		this.averages[1] = floor;                    //Setting second element of averages to the floor value
		this.averages[2] = theAvg;                   //Setting third element of averages to theAvg value
		
		this.letterAvg = (char)theAvg;              //Casting theAvg int value to its associated character value --MOVED THIS
		
		return averages;
	}
	
	public char letterAverage() {                  //This will give us the ACSII letter value of theAvg value calculated in calAverage method
		
		return letterAvg;                          

	}
	
}