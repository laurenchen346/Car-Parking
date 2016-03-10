

import java.lang.reflect.Array;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 

public class CarpoolSchedule {
	private ArrayList[][] schedule = new ArrayList[4][2];
	private Carpool carpool;
	private ArrayList<Member> carpoolers;
	public  Carpool CreateCarpool()
	{
		
		Scanner arrayC = new Scanner(System.in);
		 Carpool[]RideSchedule2 = new Carpool[500];
		
		for(int i ; i<RideSchedule2.length; i++);
				 
		System.out.println("You are a " + MemberType.Passenger + " ? (Y/N) ");
		Scanner workpls = new Scanner(System.in);
		String plspls = workpls.next();
		/*boolean carpoolers;
		if(plspls.toUpperCase().equals("Y"))
			carpoolers =true;
		else
			carpoolers = false;*/
		
		
		System.out.println("Please enter start date of carpool: (Year-Month-Date");
		Scanner dateS = new Scanner(System.in);
		String dateSS = dateS.next();
		java.sql.Date startDate;
		startDate = Date.valueOf(dateSS);
		
		System.out.println("Please enter the end date of carpool: (Year-Month-Date)");
		Scanner dateE = new Scanner(System.in);
		String dateEE = dateE.next();
		java.sql.Date endDate;
		endDate = Date.valueOf(dateEE);
		// not sure how to implement this part? is it correct
		System.out.println("On what days will you be  carpooling? please enter: S/M/T/W/T/F/S" );
		Scanner DayS = new Scanner(System.in);
		String DaySS = DayS.next();
		Array[] daysOfWeek;
		/*if(DaySS.toUpperCase().equals("S,M,T,W,T,F,S"))
			daysOfWeek = true;
		else
			daysOfWeek = false;
		*/
		
		
		System.out.println("What time will you need to arrive on campus? HR:MM:SS ");
		Scanner tCampus= new Scanner(System.in);
		String ttCampus = tCampus.next();
		java.sql.Time toCampus;
		toCampus = Time.valueOf(ttCampus);
		

		System.out.println("Please specify direction (SJSU/Other): ");
		Scanner toSJ = new Scanner(System.in);
		String ttoSJ = toSJ.next();
		boolean toSJSU;
		if (ttoSJ.toUpperCase().equals("SJSU"))
			toSJSU = true;
		else
			toSJSU = false;
		
		System.out.println("What time will you need to leave campus? HR:MM");
		Scanner lCampus = new Scanner(System.in);
		String llCampus = lCampus.next();
		java.sql.Time leaveCampus;
		leaveCampus = Time.valueOf(llCampus);
		
		System.out.println("Is this one time ride(Y/N): ");
		Scanner Tone = new Scanner(System.in);
		String TTone = Tone.next();
		boolean oneTime;
		if (TTone.toUpperCase().equals("Y"))
			oneTime = true;
		else
			oneTime = false;
		
		System.out.println("Here is the matches for your carpool:" + carpoolers);
		Scanner matches = new Scanner(System.in);
		double matchesS = matches.nextDouble();
		for (int i = (int) matchesS; i<RideSchedule2.length; i++) 
			if(RideSchedule2 [i].gettoCampus() != null)
		     System.out.println(RideSchedule2 [i]);
		
		
		
				
		
		
		
		
		
		
		
		System.out.println("These are your imputed dates."); //Are they correct? (Y/N)");
		Location location;
		//cant get the line below to not have an error. 
	//	Carpool newCarpool = new Carpool(toSJSU,oneTime, []daysOfWeek,startDate,endDate,toCampus,leaveCampus, carpoolers);
		return newCarpool;
		
			
	}
		class Time12HoursValidator{
			
			  private Pattern pattern;
			  private Matcher matcher;
		 
			  private static final String TIME12HOURS_PATTERN = 
		                                "(1[012]|[1-9]):[0-5][0-9](\\s)?(?i)(am|pm)";
			  
			  public Time12HoursValidator(){
				  pattern = Pattern.compile(TIME12HOURS_PATTERN);
			  }
			  
			  /**
			   * Validate time in 12 hours format with regular expression
			   * @param time time address for validation
			   * @return true valid time fromat, false invalid time format
			   */
			  public boolean validate(final String time){		  
				  matcher = pattern.matcher(time);
				  return matcher.matches();	    	    
			  }
		}
		
	}

	
		
		
		
		
		
		
		
		
		
		
		

