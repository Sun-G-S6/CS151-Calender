package cs151ProgramAssignment1;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Event {
    private String name;
    private TimeInterval ti = new TimeInterval();

    public void addName(String inName) {
        name = inName;
    }

    public void addBegDateTime(LocalDateTime inTime) {
        ti.addStartTime(inTime);
    }

    public void addEndDateTime(LocalDateTime inTime) {
        ti.addEndTime(inTime);
    }

    public String returnName() {
        return name;
    }
    
    public TimeInterval returnTime() {
        return ti;
    }
}

