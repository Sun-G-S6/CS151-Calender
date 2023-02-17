package cs151ProgramAssignment1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Scanner;
import java.io.File;


public class MyCalenderTester {
	
	
	        public static void main(String [] args)
	        {
	                LocalDate cal = LocalDate.now();
	                MyCalender calender = new MyCalender();
					Event calenderEvent = new Event();
					String eventName;
					LocalDateTime eventDateTime;
					//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm H:mm M/dd/yy M/dd/yy");
					
					try 
					{
						File eventFile = new File("events.txt");
						Scanner eventScanner = new Scanner(eventFile);
						eventScanner.useDelimiter(System.lineSeparator());

						int lineCounter = 1;

						while(eventScanner.hasNextLine())
						{
							eventName = eventScanner.nextLine();

							if(lineCounter % 2 == 1)
							{
								eventScanner.useDelimiter(System.lineSeparator());
								calenderEvent.addName(eventName);
								//System.out.println(eventName + " has been added");
							} else {
								eventScanner.useDelimiter("[^0-9]+");
								while(eventScanner.hasNextInt())
								{
									int number = eventScanner.nextInt();
									System.out.println(number + " has been added ZZZZZZZZZZZZZZZZZZZ");

								}
							}
							lineCounter++;
							//eventDetails = eventScanner.nextLine();

							//repeatChecker = eventScanner.nextLine().charAt(0);
							
							//System.out.println("Current char: " + repeatChecker);
							//if(Character.isDigit(repeatChecker))
							//{
							//	System.out.println("\t\tThis is a singular event\t");
							//	eventDetails = eventScanner.nextLine();
							//	System.out.println("\tGot the first digit: " + eventDetails);
							//}
							//else {
							//	System.out.println("\t\tThis is a repeating event\t");
							//}
							// calenderEvent.addDateTime(eventDateTime);
							// calenderEvent.addTime(eventDateTime);
							//System.out.println(eventDetails);
							//calenderEvent.addName(eventName);
						}			
							
						
						eventScanner.close();
					}
					catch(IOException e)
					{
						System.out.println("Error: File not found");
						e.printStackTrace();
					}
					
					/*	Example singular event
					 * St Patrick's Day
					 * 3/17/23 19:00 21:30
					 * 
					 * S-SUNDAY M-MONDAY T-TUESDAY W-WEDNESDAY R-THURSDAY F-FRIDAY A-SATURDAY
					 * 
					 * 	Example repeating event
					 * CS151 Lecture
					 * TR 9:00 10:15 1/24/23 5/23/23
					 */
					
	                

	                System.out.println("\n\n\n\n\n\nLoading is done!");

					printCalendar(cal);
	        }

	        public static void printCalendar(LocalDate c)
	        {  
	            System.out.print("\t" + c.getMonth());
	            System.out.print(" ");
	            System.out.println(c.getYear());
	            String header = "Sun\tMon\tTue\tWed\tThu\tFri\tSat";
	            System.out.println(header);
	           	
				LocalDate x = LocalDate.of(c.getYear(), c.getMonth(), 1);
				int i = 0;
			   	int firstDayOfMonth = x.getDayOfWeek().getValue();

	           	while( i < firstDayOfMonth ) 
				{
					System.out.print("\t");
					i++;
			  	}
				
				for( int dayCounter = 1; dayCounter <= x.lengthOfMonth(); dayCounter++ ) 
				{
					if((dayCounter + 2) % 7  == 0) {
						System.out.println();
					}
					if( dayCounter == c.getDayOfMonth()) {
						System.out.print("[" + dayCounter + "]\t");
					}
					else {
						System.out.print(dayCounter + "\t");
					}
				}
				// To print a calendar in a specified format.	E MMM d yyyy
				/*
				 * of(LocalDate date, LocalTime time)
				 * Obtains an instance of LocalDateTime from a date and time.
				 */
				LocalTime timeExample = LocalTime.of(7, 30, 0);
				LocalDateTime formatDateExample = LocalDateTime.of(c, timeExample);
				String timeColonPattern = "E H:mm M/d/y";
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern(timeColonPattern);
				System.out.println("\n\n\tFormatter in action: " + formatter.format(formatDateExample));
	        }
	        }
