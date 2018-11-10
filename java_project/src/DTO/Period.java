package DTO;

public class Period {
    
    private Hall hall;
    
    private Integer iD;
    private String name;
    private String startTime;
    private String endTime;
    private String interval; // start time - end time
    private String day; //look-up table?


    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public Hall getHall() {
        return hall;
    }

    public void setID(Integer iD) {
        this.iD = iD;
    }

    public Integer getID() {
        return iD;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setInterval(String startTime,String endTime) {
        this.interval = startTime+" - "+endTime;
    }

    public String getInterval() {
        return interval;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDay() {
        return day;
    }
}
