/**
 * DateTimeInherit is a class that inherits the class named, DateTimeAbstract  
 */
import java.time.YearMonth;
import java.time.DayOfWeek;
import java.time.LocalDate;
public class DateTimeInherit extends DateTimeAbstract {
	public void daysOfAnyMonth(int monthOfYear, int theYear) {
		
		final int FIRST_DAY_OF_MONTH = 1;
		//Find the amount of days in a provided month
		YearMonth yearMonthObject = YearMonth.of(theYear, monthOfYear); //Use the given month and year to find the max days in a month
		int daysInMonth = yearMonthObject.lengthOfMonth();              //Store the max days in a month in variable
		
		//Now we need to pass this info to the dayOfWeek method to tell us what day the first and last day lie on
		String dayOfFirst = dayOfWeek(theYear, monthOfYear, FIRST_DAY_OF_MONTH);
		String dayOfLast = dayOfWeek(theYear, monthOfYear, daysInMonth);
		
		
		//Now print the correct statement. Months 1, 2, and 3 will need a slight different output than months 4-12	
		if(monthOfYear == 1) {
			System.out.println("In the year of " + theYear + ", for the " + monthOfYear + "st month: the first day is "
					           + dayOfFirst + " and the last day is " + dayOfLast);
		}
		else if(monthOfYear == 2) {
			System.out.println("In the year of " + theYear + ", for the " + monthOfYear + "nd month: the first day is "
			           + dayOfFirst + " and the last day is " + dayOfLast);
		}
		else if(monthOfYear == 3) {
			System.out.println("In the year of " + theYear + ", for the " + monthOfYear + "rd month: the first day is "
			           + dayOfFirst + " and the last day is " + dayOfLast);
		}
		else {
			System.out.println("In the year of " + theYear + ", for the " + monthOfYear + "th month: the first day is "
			           + dayOfFirst + " and the last day is " + dayOfLast);
		}
		return;
	}
	
	public String dayOfWeek(int year, int month, int day) { //This will calculate the specific day of the week given the calendar date
		String specificDay = "";
		LocalDate thisDay =  LocalDate.of(year, month, day);
		DayOfWeek a = thisDay.getDayOfWeek();
		int dayOfWeek = a.getValue();
        
		//This will give a string for the day of the week which will be returned to to daysOfAnyMonth
		if(dayOfWeek == 1) {
			specificDay = "MONDAY";
		}
		else if(dayOfWeek == 2) {
			specificDay = "TUESDAY";
		}
		else if(dayOfWeek == 3) {
			specificDay = "WEDNESDAY";
		}
		else if(dayOfWeek == 4) {
			specificDay = "THURSDAY";
		}
		else if(dayOfWeek == 5) {
			specificDay = "FRIDAY";
		}
		else if(dayOfWeek == 6) {
			specificDay = "SATURDAY";
		}
		else {
			specificDay = "SUNDAY";
		}
		return specificDay;
	}

	
}