package cs151ProgramAssignment1;

import java.time.LocalTime;

public class TimeInterval 
{
    private LocaldTime st;
    private LocalTime et;

    //need to figure out how to accept the format
    //when adding new times check to make sure it doesn't conflict with other event's time
    public void addStartTime(LocalTime inStart)
    {
        st = inStart;
    }

    public void addEndTime(LocalTime inEnd)
    {
        et = inEnd;
    }
    
}
