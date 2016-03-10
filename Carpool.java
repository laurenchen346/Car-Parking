








import java.io.Serializable;
import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.GregorianCalendar;
import java.sql.Date;
import java.sql.Time;



public class Carpool implements Serializable, Comparable
{
   
        
    public static final int DAYS_IN_WEEK = 7;

   
    private boolean toSJSU;
   
    private java.sql.Date startDate;
    
    private java.sql.Date endDate;
   
    private java.sql.Time toCampus;
    private java.sql.Time leaveCampus;
   
    private ArrayList<Member> carpoolers;
   
    private boolean oneTime;
    
    private boolean[] daysOfWeek;
    private Byte carpoolDays;
    private String defaultStartDate = "2011-01-01";
    private String defaultTime = "07:00:00";

  
      
    public Carpool( boolean toSJSU, boolean oneTime,boolean[] daysOfWeek,
                    java.sql.Date startDate, java.sql.Date endDate,
                    java.sql.Time toCampus, java.sql.Time leaveCampus, ArrayList<Member> carpoolers)  //Location location
    {
        this.toSJSU = toSJSU;
        this.startDate = startDate;
        this.endDate = endDate;
        this.toCampus = toCampus; 
        this.leaveCampus= leaveCampus;
        if (carpoolers != null)
            this.carpoolers = carpoolers;
        else this.carpoolers = (ArrayList<Member>) new ArrayList<Member>();
       this.oneTime = oneTime;
        this.daysOfWeek = new boolean[DAYS_IN_WEEK];
        for (int i = 0; i < DAYS_IN_WEEK; i++)
        {
            if (daysOfWeek.length > i)
                this.daysOfWeek[i] = daysOfWeek[i];
            else this.daysOfWeek[i] = false;
        }
    }


    public ArrayList<Member> getCarpoolers()
    { return carpoolers; }

    

    public boolean[] getDaysOfWeek() 
    { return daysOfWeek; }

    public Byte getCarpoolDays() 
    { return carpoolDays; }


    public String getDaysOfWeek_String()
    {
        char[] str = new char[DAYS_IN_WEEK];
        char[] days = {'S', 'M', 'T', 'W', 'T', 'F', 'S'};

        for (int i = 0; i < DAYS_IN_WEEK; i++)
            if (daysOfWeek[i])
                str[i] = days[i];
            else str[i] = '-';

        return new String(str);
    }

  
    public Byte getFrequencyFlags_Byte()
    {
        Byte flagByte = 0;

        if(this.oneTime)
            flagByte = Byte.MIN_VALUE;

        for (int i = 0; i < DAYS_IN_WEEK; i++)
            if (daysOfWeek[i])
                flagByte = (byte) (flagByte | ( 0x1 << i ));
//                flagByte = (byte) (flagByte | (int) Math.pow(2.0, (i * 1.0)));
        
        return ((Byte) flagByte);
    }
   

    public Date getEndDate() { return endDate; }

   

   // public Location getLocation() { return location; }


    public boolean getOneTime() 
    { return oneTime; }

  

    public Date getStartDate()
    { return startDate; }

   
    public Time gettoCampus()
    { return toCampus; }

   
public Time getleaveCampus() 
{return leaveCampus;}

   public boolean gettoSJSU() 
   { return toSJSU; }

    

    public boolean addCarpooler(Member buddy)
    {
        if (buddy == null)
            return false;
        carpoolers.add(buddy);
        return true;
    }

  

    public boolean setCarpoolers(ArrayList<Member> carpoolers)
    {
        if (carpoolers == null)
            return false;
        this.carpoolers.clear();
        this.carpoolers.addAll(carpoolers);
        return true;
    }

 

    public boolean setDaysOfWeek(boolean[] daysOfWeek)
    {
        if (daysOfWeek.length != DAYS_IN_WEEK)
            return false;
        for (int i = 0; i < DAYS_IN_WEEK; i++)
            this.daysOfWeek[i] = daysOfWeek[i];
        return true;
    }


    public boolean setEndDate(java.sql.Date endDate)
    {
        if (endDate == null)
            return false;
        this.endDate = endDate;
        return true;
    }
    public boolean settoCampus(java.sql.Time time)
    {
        if (time == null)
            return false;
        this.toCampus = time;
        return true;
    }
   
    public boolean setleaveCampus(java.sql.Time time)
    { 
    	if(time == null)
    		return false;
    	this.leaveCampus = time;
    	return true;
    	
			
		
    }

  

   public boolean setOneTime(boolean oneTime)
    {
       this.oneTime = oneTime;
        return true;
    }

    

    public boolean setStartDate(Date startDate)
    {
        if (startDate == null)
            return false;
        this.startDate = startDate;
        return true;
    }

   

    public boolean settoSJSU(boolean toSJSU)
    {
        this.toSJSU = toSJSU;
       return true;
    }

   
   

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

  public int  compareTo1(Object anotherCarpool) throws ClassCastException{
       if(!(anotherCarpool instanceof Carpool)) {
           throw new ClassCastException("Only carpools can be compared.");
       }
        int ranking = 0;
      Carpool carpool = (Carpool)anotherCarpool;
        if(!(this.oneTime == carpool.oneTime) ||
                !(this.toSJSU == carpool.toSJSU) ||
                !(this.toCampus.before(carpool.toCampus)))
        	 //  !(this.departureTime.after(carpool.departureTime))
        
        {
            ranking = -1;
        }
         else {
//            byte temp = (byte)((this.rideDays) & (carpool.rideDays));
            for(int i = 0; i <= DAYS_IN_WEEK; i++) {
                if(this.daysOfWeek[i] == carpool.daysOfWeek[i])
                    ranking++;
                
                System.out.println("Carpool matches:" + carpool);
            }
       }
        return ranking;
    }
    
    
}
