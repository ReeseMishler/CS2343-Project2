public class MesoInherit extends MesoAbstract
{
	private MesoStation station;
	private char[] chars = new char[4];
	private int[] averages = new int[3];
	
	public MesoInherit(MesoStation station) {
		this.station = station;
		chars[0] = station.getStID().charAt(0);
		chars[1] = station.getStID().charAt(1);
		chars[2] = station.getStID().charAt(2);
		chars[3] = station.getStID().charAt(3);
	}
	
	public int[] calAverage() {
		int sumOfAsciiArr = 0;
		final double DECIMAL_BOUNDARY = 0.75;
		final int NUM_OF_CHARS = 4;
		final int NUM_OF_AVGS = 3;
		int[] asciiArr = new int[NUM_OF_CHARS];
		int[] averages = new int[NUM_OF_AVGS];
		
		asciiArr[0] = (int)chars[0];
		asciiArr[1] = (int)chars[1];
		asciiArr[2] = (int)chars[2];
		asciiArr[3] = (int)chars[3];
		
		for(int i = 0; i<asciiArr.length; ++i) {
			sumOfAsciiArr += asciiArr[i];
		}
		
		double actAvg = sumOfAsciiArr/(float)NUM_OF_CHARS;
		int ceiling = (int)Math.ceil(actAvg);
		int floor = (int)Math.floor(actAvg);
		double fraction = actAvg - (int)actAvg;
		int theAvg = 0;
		
		if(fraction >= 0.75) {
			theAvg = ceiling;
		}
		else {
			theAvg = floor;
		}
		averages[0] = ceiling;
		averages[1] = floor;
		averages[2] = theAvg;
		
		return averages;
	}
	
	public char letterAverage() {
		
	}
}