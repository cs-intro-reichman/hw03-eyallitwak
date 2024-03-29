/**
 * Prints the calendars of a given year.
 */
public class Calendar {
	// Starting the calendar on 1/1/1900
	static int dayOfMonth = 1;
	static int month = 1;
	static int year = 1900;
	static int dayOfWeek = 2; // 1.1.1900 was a Monday
	static int nDaysInMonth = 31; // Number of days in January

	/**
	 * Prints the calendars of a given year.
	 */
	public static void main(String args[]) {
		// Advances the date and the day-of-the-week from 1/1/1900 till 31/12 of the
		// given year, inclusive.
		// Prints each date dd/mm/yyyy in a separate line. If the day is a Sunday,
		// prints "Sunday".
		int givenYear = Integer.parseInt(args[0]);

		while (year <= givenYear && month <= 12 && dayOfMonth <= 31) {
		
			if (year == givenYear) {
				System.out.print(dayOfMonth + "/" + month + "/" + year);
				if (dayOfWeek == 1) {
					System.out.print(" Sunday");
				}
				System.out.println();	
			}
		
			advance();
		}
	}

	// Advances the date (day, month, year) and the day-of-the-week.
	// If the month changes, sets the number of days in this month.
	// Side effects: changes the static variables dayOfMonth, month, year,
	// dayOfWeek, nDaysInMonth.
	private static void advance() {
		dayOfMonth++;
		dayOfWeek++;

		if (dayOfWeek > 7) {
			dayOfWeek = 1;
		}

		if (dayOfMonth > nDaysInMonth) {
			dayOfMonth = 1;
			month++;
			nDaysInMonth = nDaysInMonth(month, year);
		}

		if (month > 12) {
			year++;
			month = 1;
			nDaysInMonth = nDaysInMonth(month, year);
		}
	}

	// Returns true if the given year is a leap year, false otherwise.
	private static boolean isLeapYear(int year) {
		boolean divBy4 = year % 4 == 0,
				divBy100 = year % 100 == 0,
				divBy400 = year % 400 == 0;
		return (divBy4 && !divBy100) || divBy400;
	}

	// Returns the number of days in the given month and year.
	// April, June, September, and November have 30 days each.
	// February has 28 days in a common year, and 29 days in a leap year.
	// All the other months have 31 days.
	private static int nDaysInMonth(int month, int year) {
		int days = 0;
		switch (month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				days = 31;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				days = 30;
				break;
			case 2:
				days = isLeapYear(year) ? 29 : 28;
				break;
			default:
				break;
		}
		return days;
	}
}