package cs151ProgramAssignment1;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class MyCalender
{
    private ArrayList<Event> events = new ArrayList<Event>();

    

    public void add(Event e)
    {
        events.add(e.addName(null));
        events.add(e.addTime(null));
        
    }

    public void remove(Event e)
    {
        events.remove(e);
    }

}