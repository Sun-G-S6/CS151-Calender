package cs151ProgramAssignment1;

import java.time.LocalTime;

public class Event 
{
    private string name;
    private TimeInterval ti;

    public void addName(string inName)
    {
        name = inName;
    }

    public void addTime(LocalTime inTime)
    {
        ti.addStartTime(inTime);
        ti.addEndTime(inTime);
    }
}

