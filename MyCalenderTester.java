package cs151ProgramAssignment1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.io.File;


public class MyCalenderTester {
	
	public static void main(String [] args){
		LocalDate cal = LocalDate.now();
		MyCalender calender = new MyCalender();
		Event calenderEvent = new Event();
		LocalDate eventDay = LocalDate.now();
		LocalTime eventTime = LocalTime.now();
		LocalDateTime eventDateTime = LocalDateTime.now();
		String eventName, eventDetails;

		int month, startDay, endDay, year, begHour, endHour, begMins, endMins;
		int[] daysInWeek = {};
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm H:mm M/dd/yy M/dd/yy");

		try {
			File eventFile = new File("events.txt");
			Scanner eventScanner = new Scanner(eventFile);
			eventScanner.useDelimiter(System.lineSeparator());
			
			eventScanner.useDelimiter("\\n");

			while (eventScanner.hasNext()) {
				eventName = eventScanner.next();
				calenderEvent.addName(eventName);
				eventDetails = eventScanner.next();
				String[] eventDetailsArray = eventDetails.split("\\s+");

				if (eventDetailsArray.length == 3) {
					// One time event
					/*
					 * Example singular event
					 * St Patrick's Day
					 * 3/17/23 19:00 21:30
					 */

					//date
					String eventDate = eventDetailsArray[0];
					Scanner detailScanner = new Scanner(eventDate);
					detailScanner.useDelimiter("[^0-9]+");
					month = detailScanner.nextInt();
					startDay = detailScanner.nextInt();
					year = 2000 + detailScanner.nextInt();
					detailScanner.close();
					eventDay = LocalDate.of(year, month, startDay);
					// calenderEvent.addDays(eventDay.getDayOfWeek());

					// beginning time
					String startTime = eventDetailsArray[1];
					detailScanner = new Scanner(startTime);
					detailScanner.useDelimiter("[^0-9]+");
					begHour = detailScanner.nextInt();
					begMins = detailScanner.nextInt();
					detailScanner.close();
					eventTime = LocalTime.of(begHour, begMins);
					eventDateTime = LocalDateTime.of(eventDay, eventTime);
					calenderEvent.addBegDateTime(eventDateTime);

					// ending time
					String endTime = eventDetailsArray[2];
					detailScanner = new Scanner(endTime);
					detailScanner.useDelimiter("[^0-9]+");
					endHour = detailScanner.nextInt();
					endMins = detailScanner.nextInt();
					detailScanner.close();
					eventTime = LocalTime.of(endHour, endMins);
					eventDateTime = LocalDateTime.of(eventDay, eventTime);
					calenderEvent.addEndDateTime(eventDateTime);

				} else if (eventDetailsArray.length == 5) {
					// Recurring event
					/**
					 * S-SUNDAY M-MONDAY T-TUESDAY W-WEDNESDAY R-THURSDAY F-FRIDAY A-SATURDAY
					 * 7 1 2 3 4 5 6
					 * Example repeating event
					 * CS151 Lecture
					 * TR 9:00 10:15 1/24/23 5/23/23
					 * 0 1 2 3 4
					 * 
					 * 
					 * try using date of year and add 7 days to each day its repeated until the final date
					 * 
					 * 
					 * 
					 */

					// recurring days
					String days = eventDetailsArray[0];
					String[] recurringDays = days.split("");
					
					/*
					 * probably the repeating days to string and compare future ones? 
					 * idfk
					 */
					for(int i = 0; i < recurringDays.length; i++) {
						switch(recurringDays[i]) {
							case "S":
								daysInWeek[i] = 0 ;
								break;
							case "M":
								daysInWeek[i] = 1;
								break;
							case "T":
								daysInWeek[i] = 2;
								break;
							case "W":
								daysInWeek[i] = 3;
								break;
							case "R":
								daysInWeek[i] = 4;
								break;
							case "F":
								daysInWeek[i] = 5;
								break;
							case "A":
								daysInWeek[i] = 6;
								break;
						}
					// code logic here????
					
					for(int j = 0; j < recurringDays.length; j++) {
						
					}







					}
					// beginning date
					Scanner detailScanner = new Scanner(eventDetailsArray[3]);
					detailScanner.useDelimiter("[^0-9]+");
					month = detailScanner.nextInt();
					startDay = detailScanner.nextInt();
					year = 2000 + detailScanner.nextInt();
					detailScanner.close();

					// ending date
					detailScanner = new Scanner(eventDetailsArray[4]);
					detailScanner.useDelimiter("[^0-9]+");
					month = detailScanner.nextInt();
					endDay = detailScanner.nextInt();
					year = 2000 + detailScanner.nextInt();
					detailScanner.close();

					// beginning time
					detailScanner = new Scanner(eventDetailsArray[1]);
					detailScanner.useDelimiter("[^0-9]+");
					begHour = detailScanner.nextInt();
					begMins = detailScanner.nextInt();
					detailScanner.close();
					eventTime = LocalTime.of(begHour, begMins);

					// ending time
					detailScanner = new Scanner(eventDetailsArray[2]);
					detailScanner.useDelimiter("[^0-9]+");
					endHour = detailScanner.nextInt();
					endMins = detailScanner.nextInt();
					detailScanner.close();

					// Do something with the event data
				}

				/*
				 * Example singular event
				 * St Patrick's Day
				 * 3/17/23 19:00 21:30
				 * 
				 * S-SUNDAY M-MONDAY T-TUESDAY W-WEDNESDAY R-THURSDAY F-FRIDAY A-SATURDAY
				 * 
				 * Example repeating event
				 * CS151 Lecture
				 * TR 9:00 10:15 1/24/23 5/23/23
				 * 0 1 2 3 4
				 */

				
			}
			eventScanner.close();
		} catch (IOException e) {
			System.out.println("Error: File not found");
			e.printStackTrace();
		}

		System.out.println("\n\n\n\n\n\nLoading is done!");

		printCalendar(cal);
	}

	public static void printCalendar(LocalDate c) {
		System.out.print("\t" + c.getMonth());
		System.out.print(" ");
		System.out.println(c.getYear());
		String header = "Sun\tMon\tTue\tWed\tThu\tFri\tSat";
		System.out.println(header);

		LocalDate x = LocalDate.of(c.getYear(), c.getMonth(), 1);
		int i = 0;
		int firstDayOfMonth = x.getDayOfWeek().getValue();

		while (i < firstDayOfMonth) {
			System.out.print("\t");
			i++;
		}

		for (int dayCounter = 1; dayCounter <= x.lengthOfMonth(); dayCounter++) {
			if ((dayCounter + 2) % 7 == 0) {
				System.out.println();
			}
			if (dayCounter == c.getDayOfMonth()) {
				System.out.print("[" + dayCounter + "]\t");
			} else {
				System.out.print(dayCounter + "\t");
			}
		}
		// To print a calendar in a specified format. E MMM d yyyy
		/*
		 * of(LocalDate date, LocalTime time)
		 * Obtains an instance of LocalDateTime from a date and time.
		 */
		LocalTime timeExample = LocalTime.of(7, 30, 0);
		LocalDateTime formatDateExample = LocalDateTime.of(c, timeExample);
		String timeColonPattern = "E H:mm M/d/y";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(timeColonPattern);
		System.out.println("\n\n\tFormatter in action: " + formatter.format(formatDateExample));
		System.out.println(c.getDayOfWeek());
	}
}
