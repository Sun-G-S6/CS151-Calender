package cs151ProgramAssignment1;

import java.time.LocalTime;
import java.time.LocalDateTime;

public class TimeInterval {
    private LocalDateTime st;
    private LocalDateTime et;

    //need to figure out how to accept the format
    //when adding new times check to make sure it doesn't conflict with other event's time
    public void addStartTime(LocalDateTime inStart) {
        st = inStart;
    }

    public void addEndTime(LocalDateTime inEnd) {
        et = inEnd;
    }
    
}
