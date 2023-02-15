package cs151ProgramAssignment1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.io.File;


public class MyCalenderTester {
	
	
	        public static void main(String [] args)
	        {
	                LocalDate cal = LocalDate.now();
	                MyCalender calender;
					Event calenderEvent;
					String eventName;
					String secondLine;
					
					try 
					{
						File eventFile = new File("events.txt");
						Scanner eventScanner = new Scanner(eventFile);

						while(eventScanner.hasNextLine())
						{
							eventName = eventScanner.nextLine();
							System.out.println(eventName + "\tThis works!");
							//calenderEvent.addName(eventName);
							secondLine = eventScanner.nextLine();
							System.out.print(secondLine);

						}
						eventScanner.close();
					}
					catch(IOException e)
					{
						System.out.println("Error: File not found");
						e.printStackTrace();
					}

					/*
					 * St Patrick's Day
					 * 3/17/23 19:00 21:30
					 * 
					 * CS151 Lecture
					 * TR 9:00 10:15 1/24/23 5/23/23
					 */
					
	                

	                System.out.println("Loading is done!");

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
	        }
	        }
