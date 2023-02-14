package cs151ProgramAssignment1;

import java.time.LocalTime;

public class TimeInterval 
{
    private LocalTime st;
    private LocalTime et;

    //need to figure out how to accept the format
    public void addStartTime(LocalTime inStart)
    {
        st = inStart;
    }

    public void addEndTime(LocalTime inEnd)
    {
        et = inEnd;
    }
    
}
