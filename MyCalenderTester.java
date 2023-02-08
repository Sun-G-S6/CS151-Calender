package cs151ProgramAssignment1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class MyCalenderTester {
	
	
	        public static void main(String [] args)
	        {
	                LocalDate cal = LocalDate.now(); // capture today
	                Scanner sc = new Scanner(System.in);
	                //System.out.print("Today: ");

	                printCalendar(cal);

	                while (sc.hasNextLine())
	                {
	                        String input = sc.nextLine();
	                        if (input.equals("p"))
	                        {
	                                cal = cal.minusMonths(1); // LocalDateTime is immutable
	                                printCalendar(cal);
	                        }
	                        else if (input.equals("n"))
	                        {
	                                cal = cal.plusMonths(1); // LocalDateTime is immutable
	                                printCalendar(cal);
	                                
	                        }
	                }
	                System.out.println("Bye!");
	        }
	        public static void printCalendar(LocalDate c)
	        {  
	            //System.out.print(c.getDayOfWeek());
	            System.out.print(" ");
	            //System.out.print(c.getDayOfMonth());
	            System.out.print(c.getMonth());
	            System.out.print(" ");
	            System.out.println(c.getYear());
	            String header = "   Sun   Mon   Tue   Wed   Thu   Fri   Sat";
	            System.out.println(header);
	            int j = c.getDayOfMonth();
	            System.out.println(j);
	            
	            j = 16%7;
	            System.out.println(j);
	            
	            // To print a calendar in a specified format. 
	            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d");
	            System.out.println("    " + formatter.format(c.minusDays(c.getDayOfMonth()-1)));
	            int i = 1;
	            while(i <= c.getMonth().minLength()) {
	            	System.out.println(" " + i + " ");
	            	i++;
	            }
	            
	            // To figure out the day of week of the 1st day of the given month
	            LocalDate x = LocalDate.of(c.getYear(), c.getMonth(), 1); 
	            System.out.println(x.lengthOfMonth() + " is the day of " + c.getMonth() + " 1."); // enum value as it is
	            System.out.println(x.getDayOfWeek().getValue() + " is an integer value corresponding "
	            		+ " to " + x.getDayOfWeek()); // int value corresponding to the enum value
	            
	        }
	        
	        

	        }
