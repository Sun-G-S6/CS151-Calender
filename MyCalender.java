package cs151ProgramAssignment1;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class MyCalender {
    private ArrayList<Event> events = new ArrayList<Event>();

    

    public void add(Event e) {
        events.add(e);
    }

    public void remove(Event e) {
        events.remove(e);
    }
    
    //take the inputted date & time of event and make sure it doesn't conflict with any others
    public void checkTime(Event e) {
        for (int i = 0; i < events.size(); i++) {
            if(events.get(i).returnTime());
        }
    }

}