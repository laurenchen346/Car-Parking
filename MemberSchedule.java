


import java.sql.Time;
import java.util.ArrayList;

public class MemberSchedule {
	
	public static final int DAYS_IN_WEEK = 7;
    private String defaultTime = "07:00:00";
	private Location pickUpLocation;
    private boolean oneTime;
	private boolean toSJSU;
    private Time arrivalTime;
	private Time departureTime;
	private String [] recurSchedule;
	
	public MemberSchedule(){
		oneTime=false;
		toSJSU = true;
		departureTime = Time.valueOf(defaultTime);
		arrivalTime = Time.valueOf(defaultTime);
		setPickUpLocation(new Location());
	}
	
	public MemberSchedule (boolean oneTime, ArrayList<String> recurSchedule, boolean toSJSU, java.sql.Time departureTime,
							java.sql.Time arrivalTime, Location location) {
		this.oneTime = oneTime;
		this.recurSchedule = recurSchedule.toArray(new String[recurSchedule.size()]);
		this.toSJSU = toSJSU;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.setPickUpLocation(location);
	}
	
    public boolean getOneTime() { 
    	return oneTime; 	
    }
    
    public String [] getRecurSchedule() {
    	return recurSchedule;
    }
    
    public boolean getToSJSU() {
    	return toSJSU;
    }
    
    public Time getDepartureTime() {
    	return departureTime;
    }
    
    public Time getArrivalTime() {
    	return arrivalTime;
    }
    
    public Location getPickUpLocation() {
		return pickUpLocation;
	}
    
    public boolean setOneTime(boolean oneTime) {
    	this.oneTime = oneTime;
    	return true;
    }
    
    public boolean setRecurSchedule (ArrayList<String> recurSchedule) {
    	this.recurSchedule = recurSchedule.toArray(new String[recurSchedule.size()]);
    	return true;
    }
    
    public boolean setToSJSU(boolean toSJSU) {
    	this.toSJSU = toSJSU;
    	return true;
    }
    
    public boolean setDepartureTime(Time departureTime) {
    	if (departureTime == null) {
    		return false;
    	}
    	this.departureTime = departureTime;
    	return true;
    }
    
    public boolean setArrivalTime (Time arrivalTime) {
    	if (arrivalTime == null) {
    		return false;
    	}
    	this.arrivalTime = arrivalTime;
    	return true;
    }

	public boolean setPickUpLocation(Location pickUpLocation) {
		if (pickUpLocation == null) {
			return false;
		}
		this.pickUpLocation = pickUpLocation;
		return true;
	}
}

